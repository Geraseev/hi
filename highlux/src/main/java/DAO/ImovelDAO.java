package DAO;

import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import telas.TelaImovel;
import javabeans.Endereco;
import javabeans.ImovelExtra;

/**
 *
 * @author lgera
 */
public class ImovelDAO {
    private Connection conecta;
    
    public ImovelDAO(){
        this.conecta = new ConnectionMod().conecta();
    }
    
    public void adicionarExtra(Endereco obj){
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void adicionarImovel(ImovelExtra obj){
        try {
            String cmdsql = "insert into imovel(valor,status) values(?,?)";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getValor());
            stmt.setString(2, obj.getStatus());
            
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Endereco> listarEndereco(){
        try  {
            List<Endereco> lista = new ArrayList<Endereco>();
            
            String cmdsql = "select * from endereco";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Endereco v = new Endereco();
                
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
    
    public List<ImovelExtra> listarExtra(){
        try  {
            List<ImovelExtra> lista = new ArrayList<ImovelExtra>();
            
            String cmdsql = "select* from imovel";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ImovelExtra v = new ImovelExtra();
                
                v.setIdimovel(rs.getInt("idmovel"));
                v.setValor(rs.getString("valor"));
                v.setStatus(rs.getString("status"));
                
                
                lista.add(v);               
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Endereco> listarEnderecoPorLog(String logradouro){
        try  {
            List<Endereco> lista = new ArrayList<Endereco>();
            
            String cmdsql = "select* from endereco where logradouro like ?";
            
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, logradouro);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Endereco v = new Endereco();
                
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
}
