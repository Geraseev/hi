/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 *
 * @author Luiza
 */
public class ConnectionModTest {
    
    @Test
    public void testConnection() throws SQLException {
        ConnectionMod cmod = new ConnectionMod();
        DriverManager dm = mock(DriverManager.class);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/highlux", "root", "root");
      
        when(dm.getConnection(anyString())).thenReturn(connection);
        
        assertEquals(connection, cmod);
        
        /*assert not throw*/
    }
    
    /*
    -----connection------
    - connection
    - exception
    
    
    ConnectionMod connection = mock(ConnectionMod.class);
        
        when(connection.conecta()).thenThrow(SQLException.class);
         
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
    */
    
}
