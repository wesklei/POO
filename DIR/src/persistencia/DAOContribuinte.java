/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dados.Contribuinte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author localhost
 */
public class DAOContribuinte {
    private static DAOContribuinte daoCn = null;
    private Connection connection;
    
    public DAOContribuinte() throws SQLException{
        
            connection = ConnectionFactory.getConnection();  
        
    }
    
    public static DAOContribuinte getInstance() throws SQLException{
      
        if(daoCn == null){
            daoCn = new DAOContribuinte();
            return daoCn;
        }
        else
            return daoCn;     
        
    }
    
    public void insert(Contribuinte contribuinte) throws SQLException{
        String query = "INSERT INTO contribuinte(cpfContr, nomeContr, idadeContr, endContr, contaBancContr) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1,Long.parseLong(contribuinte.getCpf()));
        stmt.setString(2,contribuinte.getNome());
        stmt.setInt(3, contribuinte.getIdade());
        stmt.setString(4,contribuinte.getEndereco());     
        stmt.setLong(5,contribuinte.getContaBancaria());
        
        stmt.execute();
    }
    
    public Contribuinte selectX(long cpf) throws SQLException{
        String query = "SELECT * FROM contribuinte WHERE cpfContr = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1, cpf);
        Contribuinte c = new Contribuinte();
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();
        String nome = rs.getString("nomeContr");
        long codCpf = rs.getLong("cpfContr");
        long contaBancaria = rs.getLong("contaBancContr");
        String endereco = rs.getString("endcontr");
        int idade = rs.getInt("idadecontr");
        c.setNome(nome);
        c.setCpf(String.valueOf(cpf));                
        c.setContaBancaria(contaBancaria);
        c.setIdade(idade);        
        c.setEndereco(endereco);
      
        return c;
    }
    
    public Contribuinte select(long cpf) throws SQLException{
        String query = "SELECT * FROM contribuinte WHERE cpfContr = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1, cpf);
        Contribuinte c = new Contribuinte();
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();
        String nome = rs.getString("nomeContr");
        long codCpf = rs.getLong("cpfContr");
        long contaBancaria = rs.getLong("contaBancContr");
        String endereco = rs.getString("endcontr");
        int idade = rs.getInt("idadecontr");
        c.setNome(nome);
        c.setCpf(String.valueOf(cpf));                
        c.setContaBancaria(contaBancaria);
        c.setIdade(idade);        
        c.setEndereco(endereco);
      
        return c;
    }
    
    public List<Contribuinte> selectAll() throws SQLException{
        String query = "SELECT nomeContr, cpfContr, contaBancContr FROM contribuinte;";    
        PreparedStatement stmt = connection.prepareStatement(query);
        List<Contribuinte> linhas = new ArrayList<Contribuinte>();
        
        
        Contribuinte registroAtual;
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
                
                registroAtual = new Contribuinte();
                String nome = rs.getString("nomeContr");
                Long cpf = rs.getLong("cpfContr");
                Long contaBancaria = rs.getLong("contaBancContr");
                registroAtual.setNome(nome);
                registroAtual.setCpf(String.valueOf(cpf));                
                registroAtual.setContaBancaria(contaBancaria);
                
                linhas.add(registroAtual);
            
            }
        
        return linhas;
    }
    
    public void update(Contribuinte c) throws SQLException{
        String query = "UPDATE contribuinte SET nomeContr= ?, idadeContr= ?, endContr= ?, contaBancContr= ? WHERE cpfContr= ?;";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, c.getNome());
        stmt.setInt(2, c.getIdade());
        stmt.setString(3, c.getEndereco());
        stmt.setLong(4, c.getContaBancaria()); 
        stmt.setLong(5, Long.parseLong(c.getCpf()));
        
        stmt.execute();
    }
    
}
