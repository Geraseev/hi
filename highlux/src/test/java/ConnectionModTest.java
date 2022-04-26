/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.SQLException;
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
        Connection connection = cmod.conecta();
        
        assertNotEquals(null, connection);
    }
    
    @Test
    public void testConnectionException() throws SQLException {
        ConnectionMod cmod = mock(ConnectionMod.class);
        
        when(cmod.conecta()).thenThrow(new RuntimeException());
       
        assertThrows(RuntimeException.class, () -> {
            cmod.conecta();
        });
    }
    
}
