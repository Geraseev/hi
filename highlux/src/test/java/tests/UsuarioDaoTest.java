package tests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import DAO.UsuarioDAO;
import collections.ConnectionMod;
import java.sql.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

/**
 *
 * @author Luiza
 */
public class UsuarioDaoTest {
    static Connection connection;
    
    @BeforeEach
    public void bf() throws SQLException{
        connection = new ConnectionMod().conecta();
        
        String delete = "delete from usuario";
        PreparedStatement stmt = connection.prepareStatement(delete);
        stmt.executeUpdate(delete);
    }
    
    @Test
    public void testEfetuarCadastro() throws SQLException {
        UsuarioDAO usuario = new UsuarioDAO();
        
        String login = "luiza";
        String senha = "schons";
        String telefone = "(88) 888888888";
        
        /*cadastra usuário não existente*/
        assertEquals(true, usuario.efetuarCadastro(login, telefone, senha));
        
        /*consulta cadastro efetuado*/
        String select = "select * from usuario where login=? and senha=? and telefone=?";
        PreparedStatement stmt = connection.prepareStatement(select);
        
        stmt.setString(1, login);
        stmt.setString(2, senha);
        stmt.setString(3, telefone);
        
        ResultSet rs = stmt.executeQuery();
        rs.next();

        /*realiza asserções confirmando que os dados foram adicionados ao banco corretamente*/
        assertEquals(login, rs.getString("login"));
        assertEquals(senha, rs.getString("senha"));
        assertEquals(telefone, rs.getString("telefone"));
    }
    
    @Test
    public void testErroCadastroChaveNula() throws SQLException {
        UsuarioDAO usuario = new UsuarioDAO();
        
        String login = null; //chave primária não pode ser nula
        String senha = "schons";
        String telefone = "(88) 888888888";
        
        /*tenta cadastrar usuário com pk nula*/
        assertEquals(false, usuario.efetuarCadastro(login, telefone, senha));
        
        /*consulta se cadastro foi ou não efetuado*/
        String select = "select * from usuario where login=? and senha=? and telefone=?";
        PreparedStatement stmt = connection.prepareStatement(select);
        
        stmt.setString(1, login);
        stmt.setString(2, senha);
        stmt.setString(3, telefone);
        
        ResultSet rs = stmt.executeQuery();
        
        /*realiza asserção confirmando que o resultset é vazio e o cadastro não foi efetuado*/
        assertFalse(rs.next());
    }
    
    @Test
    public void testErroCadastroUsuarioExistente() throws SQLException {
        UsuarioDAO usuario = new UsuarioDAO();
        
        /*efetua cadastro com usuario luiza*/
        
        usuario.efetuarCadastro("luiza", "(89) 123456789", "123456");
        
        String login = "luiza";
        String senha = "schons";
        String telefone = "(88) 888888888";
        
        /*tentativa de caadastro com usuário existente*/
        assertEquals(false, usuario.efetuarCadastro(login, telefone, senha));
        
        /*consulta tentativa de cadastro*/
        String select = "select * from usuario where login=?";
        PreparedStatement stmt = connection.prepareStatement(select);
        
        stmt.setString(1, login);
        
        ResultSet rs = stmt.executeQuery();
        
        /*realiza asserção confirmando que o usuário já existe*/
        assertEquals(login, rs.getString("login"));
        assertEquals(senha, rs.getString("senha"));
        assertEquals(telefone, rs.getString("telefone"));
    }
    
    @Test
    public void testErroCadastroTelefoneExistente() throws SQLException {
        UsuarioDAO usuario = new UsuarioDAO();
        
        /*efetua cadastro com usuario luiza*/
        
        usuario.efetuarCadastro("lulu", "(89) 123456789", "123456");
        
        String login = "luiza";
        String senha = "schons";
        String telefone = "(89) 123456789";
        
        /*tentativa de caadastro com telefone existente*/
        assertEquals(false, usuario.efetuarCadastro(login, telefone, senha));
        
        /*consulta tentativa de cadastro*/
        String select = "select * from usuario where telefone=?";
        PreparedStatement stmt = connection.prepareStatement(select);
        
        stmt.setString(1, telefone);
        
        ResultSet rs = stmt.executeQuery();
        
        /*realiza asserção confirmando que o telefone já existe*/
        assertEquals(telefone, rs.getString("telefone"));
        assertEquals(login, rs.getString("login"));
        assertEquals(senha, rs.getString("senha"));
    }
    
    @Test //entradas: string usuario, string senha
    public void testEfetuarLogin() throws SQLException {
        UsuarioDAO usuario = new UsuarioDAO();
        
        String login = "luiza";
        String senha = "schons";
        String telefone = "(88) 888888888";
        
        /*cadastra usuário*/
        assertEquals(true, usuario.efetuarCadastro(login, telefone, senha));
        
        /*executa login*/
        assertEquals(true, usuario.efetuarLogin(login, senha));
        
        /*executa login com dados incorretos*/
        assertEquals(false, usuario.efetuarLogin("nome", "password"));
    }
}
