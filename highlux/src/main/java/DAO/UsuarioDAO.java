package DAO;

import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import telas.TelaGerente;
import telas.TelaUsuario;

public class UsuarioDAO {
    private Connection conecta;
    
    public UsuarioDAO() {
        this.conecta = new ConnectionMod().conecta();
    }
    
    public boolean efetuarLogin(String usuario, String senha) {        
        try{
            String cmdsql = "select * from usuario where login=? and senha=?";
            
            PreparedStatement stmt = conecta.prepareStatement (cmdsql);
            
            stmt.setString(1,usuario);
            stmt.setString(2,senha);
            
            ResultSet rs = stmt.executeQuery();
                        
            if(rs.next()) {
                int flag = rs.getInt("flag");
                if(flag == 1){
                    TelaGerente tela = new TelaGerente();
                    tela.setVisible(true);
                    return true;
                } else {
                    TelaUsuario tela = new TelaUsuario();
                    tela.setVisible(true);
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos");
                return false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean efetuarCadastro(String usuario, String telefone, String senha) {
        try{
            String selectsqluser = "select * from usuario where login=?";
            PreparedStatement stmt = conecta.prepareStatement (selectsqluser);
            stmt.setString(1,usuario);
            ResultSet rs = stmt.executeQuery();
            
            String selectsqlphone = "select * from usuario where telefone=?";
            PreparedStatement stmt2 = conecta.prepareStatement (selectsqlphone);
            stmt2.setString(1,telefone);
            ResultSet rs2 = stmt2.executeQuery();
                      
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Usuario já existe!");
                return false;
            } else if (rs2.next()){
                JOptionPane.showMessageDialog(null, "Telefone já cadastrado!");
                return false;
            } else {
                String newusersql = "insert into usuario(login,senha,telefone,flag) values (?,?,?,?)";          
                             
                PreparedStatement stmt3 = conecta.prepareStatement(newusersql);
                
                stmt3.setString(1, usuario);
                stmt3.setString(2, senha);
                stmt3.setString(3, telefone);
                stmt3.setBoolean(4, false);
                
                stmt3.executeUpdate();
                stmt3.close();
                
                
                return true;
            }
                     
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro no cadastro!");
            return false;
        }
    }
}
