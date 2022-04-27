package DAO;

import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javabeans.Imovel;
import javax.swing.JOptionPane;


/**
 *
 * @author lgera
 */
public class ImovelDAO {
    private Connection conecta;
    
    public ImovelDAO(){
        this.conecta = new ConnectionMod().conecta();
    }
    
    public boolean adicionarExtra(Imovel obj){
        try {
            String cmdsql = "insert into endereco(logradouro,numero,bairro,cidade,estado,cep,complemento) values(?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getLogradouro());
            stmt.setString(2, obj.getNumero());
            stmt.setString(3, obj.getBairro());
            stmt.setString(4, obj.getCidade());
            stmt.setString(5, obj.getEstado());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getComplemento());
            
            stmt.execute();
            
            stmt.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
            return false;
        }
    }
    
    public boolean adicionarImovel(Imovel obj){
        try {
            String cmdsql = "insert into imovel(valor,status,endereco_idendereco) values(?,?,?)";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getValor());
            stmt.setString(2, obj.getStatus());
            stmt.setInt(3, obj.getEndereco_idendereco());
            
            stmt.execute();
            
            stmt.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
            return false;
        }
    }
    
    public List<Imovel> listarEndereco(){
        try  {
            List<Imovel> lista = new ArrayList<Imovel>();
            
            String cmdsql = "select * from endereco";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Imovel v = new Imovel();
                
                v.setIdendereco(rs.getInt("idendereco"));
                v.setLogradouro(rs.getString("logradouro"));
                v.setNumero(rs.getString("numero"));
                v.setComplemento(rs.getString("complemento"));
                v.setBairro(rs.getString("bairro"));
                v.setCidade(rs.getString("cidade"));
                v.setEstado(rs.getString("estado"));
                v.setCep(rs.getString("cep"));
                
                
                
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
            
            String cmdsql = "select i.status, i.valor, e.logradouro, e.numero, e.bairro, e.cidade, e.estado, e.cep, e.complemento from imovel i join endereco e on i.endereco_idendereco = e.idendereco where cidade like ?";
            
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, cidade);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Imovel v = new Imovel();
                
                v.setIdendereco(rs.getInt("idendereco"));
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
            
            String cmdsql = "select * from endereco where logradouro like ?";
            
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, logradouro);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Imovel v = new Imovel();
                
                v.setIdendereco(rs.getInt("idendereco"));
                v.setLogradouro(rs.getString("logradouro"));
                v.setNumero(rs.getString("numero"));
                v.setComplemento(rs.getString("complemento"));
                v.setBairro(rs.getString("bairro"));
                v.setCidade(rs.getString("cidade"));
                v.setEstado(rs.getString("estado"));
                
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean editarEnd(Imovel obj){
        try {
            String cmdsql = "update endereco set logradouro=?, numero=?, bairro=?, cidade=?, estado=?, cep=?, complemento=? where idendereco=?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getLogradouro());
            stmt.setString(2, obj.getNumero());
            stmt.setString(3, obj.getBairro());
            stmt.setString(4, obj.getCidade());
            stmt.setString(5, obj.getEstado());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getComplemento());
            stmt.setInt(8, obj.getIdendereco());
            
            stmt.execute();
            
            stmt.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
            return false;
        }
    }
    
    public boolean editarImovel(Imovel obj){
        try {
            String cmdsql = "update imovel set status=?, valor=? where endereco_idendereco=?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getStatus());
            stmt.setString(2, obj.getValor());
            stmt.setInt(3, obj.getIdimovel());
            
            stmt.execute();
            
            stmt.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
            return false;
        }
    }
    
}
