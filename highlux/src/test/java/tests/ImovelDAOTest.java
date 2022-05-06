/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import DAO.ImovelDAO;
import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Imovel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Luiza
 */
public class ImovelDAOTest {
    static Connection connection;
    
    @BeforeEach
    public void bf() throws SQLException{
        connection = new ConnectionMod().conecta();
        
        String delete = "delete from imovel";
        PreparedStatement stmt = connection.prepareStatement(delete);
        stmt.executeUpdate(delete);
    }

    
    @Test
    public void testAdicionarImovel() throws SQLException {
        ImovelDAO id = new ImovelDAO();
        
        int idimovel = 1;
        String logradouro = "rua tal";
        String numero = "123";
        String bairro = "centro";
        String cidade = "cornelio";
        String estado = "parana";
        String cep = "86300000";
        String complemento = "apto 5";
        String valor = "500";
        String status = "disponível";
        
        Imovel imovel = new Imovel(idimovel,logradouro,numero,bairro,cidade,estado,valor,status,cep,complemento);
        
        /*executa cadastro com dados corretos*/
        assertEquals(true, id.adicionarImovel(imovel));
        
        /*consulta cadastro efetuado*/
        String select = "select * from usuario where logradouro=? and numero=? and bairro=? and cidade=? and estado=? and valor=? and cep=? and complemento=?";
        PreparedStatement stmt = connection.prepareStatement(select);
        
        stmt.setString(1, logradouro);
        stmt.setString(2, numero);
        stmt.setString(3, bairro);
        stmt.setString(4, cidade);
        stmt.setString(5, estado);
        stmt.setString(6, valor);
        stmt.setString(7, cep);
        stmt.setString(8, complemento);
        
        ResultSet rs = stmt.executeQuery();
        rs.next();

        /*realiza asserções confirmando que os dados foram adicionados ao banco corretamente*/
        assertEquals(logradouro, rs.getString("logradouro"));
        assertEquals(numero, rs.getString("numero"));
        assertEquals(bairro, rs.getString("bairro"));
        assertEquals(cidade, rs.getString("cidade"));
        assertEquals(estado, rs.getString("estado"));
        assertEquals(valor, rs.getString("valor"));
        assertEquals(cep, rs.getString("cep"));
        assertEquals(complemento, rs.getString("complemento"));
    }
    
    @Test
    public void testEditarImovel() throws SQLException {
        ImovelDAO id = new ImovelDAO();
        
        int idimovel = 1;
        String logradouro = "rua tal";
        String numero = "123";
        String bairro = "centro";
        String cidade = "cornelio";
        String estado = "parana";
        String cep = "86300000";
        String complemento = "apto 5";
        String valor = "500";
        String status = "disponível";
        
        Imovel imovel = new Imovel(idimovel,logradouro,numero,bairro,cidade,estado,valor,status,cep,complemento);
        
        /*executa cadastro*/
        assertEquals(true, id.adicionarImovel(imovel));
        
        /*---------------------------*/
        logradouro = "rua outra";
        numero = "456";
        bairro = "zona sul";
        cidade = "floripa";
        estado = "santa catarina";
        cep = "89900000";
        complemento = "apto 1";
        valor = "1000";
        status = "indisponível";
        
        Imovel imoveleditado = new Imovel(idimovel,logradouro,numero,bairro,cidade,estado,valor,status,cep,complemento);
        
        /*executa edição*/
        assertEquals(true, id.editarImovel(imoveleditado));
        
        /*executa edição com dados incorretos*/
        imovel.setLogradouro(null);
        assertEquals(false, id.editarImovel(imovel));
        
        /*consulta edição efetuada*/
        String select = "select * from usuario where logradouro=? and numero=? and bairro=? and cidade=? and estado=? and valor=? and cep=? and complemento=?";
        PreparedStatement stmt = connection.prepareStatement(select);
        
        stmt.setString(1, logradouro);
        stmt.setString(2, numero);
        stmt.setString(3, bairro);
        stmt.setString(4, cidade);
        stmt.setString(5, estado);
        stmt.setString(6, valor);
        stmt.setString(7, cep);
        stmt.setString(8, complemento);
        
        ResultSet rs = stmt.executeQuery();
        rs.next();

        /*realiza asserções confirmando que os dados foram adicionados ao banco corretamente*/
        assertEquals(logradouro, rs.getString("logradouro"));
        assertEquals(numero, rs.getString("numero"));
        assertEquals(bairro, rs.getString("bairro"));
        assertEquals(cidade, rs.getString("cidade"));
        assertEquals(estado, rs.getString("estado"));
        assertEquals(valor, rs.getString("valor"));
        assertEquals(cep, rs.getString("cep"));
        assertEquals(complemento, rs.getString("complemento"));
    }
    
    @Test
    public void testListaImovel() {
        ImovelDAO id = new ImovelDAO();
        List<Imovel> lista = new ArrayList<Imovel>();
        
        /*executa ListarImovel*/
        lista = id.listarImovel();
        
        assertNotEquals(0, lista.size());
    }
    
    @Test
    public void testListaImovelCidade() {
        ImovelDAO id = new ImovelDAO();
        List<Imovel> lista = new ArrayList<Imovel>();
        
        /*executa ListarImovel*/
        lista = id.listarEnderecoPorCid("cornelio");
        
        for(Imovel imovel : lista){
            assertEquals("cornelio", imovel.getCidade());
        }
    }
    
    @Test
    public void testListaImovelLogradouro() {
        ImovelDAO id = new ImovelDAO();
        List<Imovel> lista = new ArrayList<Imovel>();
        
        /*executa ListarImovel*/
        lista = id.listarEnderecoPorCid("rua tal");
        
        for(Imovel imovel : lista){
            assertEquals("rua tal", imovel.getCidade());
        }
    }   
    
    
}
