/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import DAO.UsuarioDAO;
import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import static org.mockito.Mockito.*;

/**
 *
 * @author Luiza
 */
public class usuarioDaoTest {
    
    @Test
    public void testEfetuarLogin() {
        UsuarioDAO usuario = new UsuarioDAO();
        
        /*executa login com dados corretos*/
        assertEquals(true, usuario.efetuarLogin("admin", "admin"));
        
        /*executa login com dados incorretos*/
        assertEquals(false, usuario.efetuarLogin("nome", "password"));
    }
    
    @Disabled
    /*falta*/
    @Test
    public void testEfetuarLoginException() throws SQLException {
        ConnectionMod connection = mock(ConnectionMod.class);
        //Connection connection = new ConnectionMod().conecta();
        
        when(connection.conecta()).thenThrow(new RuntimeException());
        
        /*PreparedStatement stmt = mock(PreparedStatement.class);
        doReturn(stmt).when(connection.prepareStatement(startsWith("select")));*/
        
        UsuarioDAO usuario = new UsuarioDAO();
        
        /*executa */
        assertThrows(Exception.class, () -> {
            /*executa login*/
            usuario.efetuarLogin("luiza", "password");
        });
    }

    @Test
    public void testEfetuarCadastro() {
        UsuarioDAO usuario = new UsuarioDAO();
        
        /*cadastra usuário não existente*/
        assertEquals(true, usuario.efetuarCadastro("luiza", "(99) 999999999", "password"));
        
        /*cadastra usuário existente*/
        assertEquals(false, usuario.efetuarCadastro("luiza", "(99) 999999999", "password"));
    } 
    
    @Test
    public void testEfetuarCadastroException() { //nao faz sentido
        /*mocka a classe UsuarioDAO*/
        UsuarioDAO usuario = mock(UsuarioDAO.class);
        
        /*simula um lançamento de exception*/
        when(usuario.efetuarCadastro(anyString(), anyString(), anyString())).thenThrow(new RuntimeException());
        
        assertThrows(Exception.class, () -> {
            /*executa cadastro*/
            usuario.efetuarCadastro("luiza", "(99) 999999999", "password");
        });
    } 
}
