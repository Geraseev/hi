/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject1;

import DAO.ImovelDAO;
import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Imovel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Luiza
 */
public class ImovelDAOTest {
    
    @Test
    public void testAdicionarImovel() {
        ImovelDAO id = new ImovelDAO();
        Imovel imovel = new Imovel("rua tal", "123", "centro", "cornelio", "parana", "500", "1", "86300000", "apto 5");
        
        /*executa cadastro com dados corretos*/
        assertEquals(true, id.adicionarImovel(imovel));
        
        /*executa cadastro com dados incorretos*/
        imovel.setLogradouro(null);
        assertEquals(false, id.adicionarImovel(imovel));
    }
    
    @Test
    public void testEditarImovel() {
        ImovelDAO id = new ImovelDAO();
        Imovel imovel = new Imovel("rua tal", "123", "centro", "cornelio", "parana", "500", "1", "86300000", "apto 5");
        
        /*executa edição com dados corretos*/
        assertEquals(true, id.editarImovel(imovel));
        
        /*executa edição com dados incorretos*/
        imovel.setLogradouro(null);
        assertEquals(false, id.editarImovel(imovel));
    }
    
    @Test
    public void testAdicionarImovelException() throws SQLException {
        /*mocka a classe ImovelDAO*/
        ImovelDAO id = mock(ImovelDAO.class);
        Imovel imovel = new Imovel("rua tal", "123", "centro", "cornelio", "parana", "500", "1", "86300000", "apto 5");
        
        /*simula um lançamento de exception*/
        when(id.adicionarImovel(any())).thenThrow(new RuntimeException());
        
        assertThrows(Exception.class, () -> {
            /*executa adição*/
            id.adicionarImovel(imovel);
        });
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
