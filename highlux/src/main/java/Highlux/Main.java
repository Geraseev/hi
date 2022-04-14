package Highlux;

import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        //testando conexão
        try{
            JOptionPane.showMessageDialog(null, "Testando conexão");
            Connection con = new collections.ConnectionMod().conecta();
            JOptionPane.showMessageDialog(null, "Conectado");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro" + e);
        }
    }
    
}
