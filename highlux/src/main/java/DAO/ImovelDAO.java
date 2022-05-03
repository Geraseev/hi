package DAO;

import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javabeans.Imovel;
import javax.swing.JOptionPane;

public class ImovelDAO {
    private Connection conecta;
    
    public ImovelDAO(){
        this.conecta = new ConnectionMod().conecta();
    }
    
    public boolean adicionarImovel(Imovel obj){
        try {
            String cmdsql = "insert into imovel(logradouro,numero,bairro,cidade,estado,cep,complemento,valor,status) values(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getLogradouro());
            stmt.setString(2, obj.getNumero());
            stmt.setString(3, obj.getBairro());
            stmt.setString(4, obj.getCidade());
            stmt.setString(5, obj.getEstado());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getComplemento());
            stmt.setString(8, obj.getValor());
            stmt.setString(9, obj.getStatus());
            
            stmt.execute();
            
            stmt.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return false;
        }
    }
    
    public List<Imovel> listarImovel(){
        try  {
            List<Imovel> lista = new ArrayList<Imovel>();
            
            String cmdsql = "select * from imovel";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Imovel v = new Imovel();
                
                v.setIdimovel(rs.getInt("idimovel"));
                v.setLogradouro(rs.getString("logradouro"));
                v.setNumero(rs.getString("numero"));
                v.setComplemento(rs.getString("complemento"));
                v.setBairro(rs.getString("bairro"));
                v.setCidade(rs.getString("cidade"));
                v.setEstado(rs.getString("estado"));
                v.setCep(rs.getString("cep"));
                v.setValor(rs.getString("valor"));
                v.setStatus(rs.getString("status"));
                
                
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    
    public List<Imovel> listarEnderecoPorCid(String cidade){
        try  {
            List<Imovel> lista = new ArrayList<Imovel>();
            
            String cmdsql = "select * from imovel where cidade like ?";
            
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, cidade);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Imovel v = new Imovel();
                
                v.setIdimovel(rs.getInt("idimovel"));
                v.setLogradouro(rs.getString("logradouro"));
                v.setNumero(rs.getString("numero"));
                v.setComplemento(rs.getString("complemento"));
                v.setBairro(rs.getString("bairro"));
                v.setCidade(rs.getString("cidade"));
                v.setEstado(rs.getString("estado"));
                v.setValor(rs.getString("valor"));
                v.setStatus(rs.getString("status"));
                
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Imovel> listarEnderecoPorLog(String logradouro){
        try  {
            List<Imovel> lista = new ArrayList<Imovel>();
            
            String cmdsql = "select * from imovel where logradouro like ?";
            
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, logradouro);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Imovel v = new Imovel();
                
                v.setIdimovel(rs.getInt("idimovel"));
                v.setLogradouro(rs.getString("logradouro"));
                v.setNumero(rs.getString("numero"));
                v.setComplemento(rs.getString("complemento"));
                v.setBairro(rs.getString("bairro"));
                v.setCidade(rs.getString("cidade"));
                v.setEstado(rs.getString("estado"));
                v.setValor(rs.getString("valor"));
                v.setStatus(rs.getString("status"));
                
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean editarImovel(Imovel obj){
        try {
            String cmdsql = "update imovel set logradouro=?, numero=?, bairro=?, cidade=?, estado=?, complemento=?, status=?, valor=? where idimovel=?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getLogradouro());
            stmt.setString(2, obj.getNumero());
            stmt.setString(3, obj.getBairro());
            stmt.setString(4, obj.getCidade());
            stmt.setString(5, obj.getEstado());
            stmt.setString(6, obj.getComplemento());
            stmt.setString(7, obj.getStatus());
            stmt.setString(8, obj.getValor());
            stmt.setInt(9, obj.getIdimovel());
            
            stmt.execute();
            
            stmt.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return false;
        }
    }
    
    
}
