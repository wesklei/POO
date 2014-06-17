/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dados.Bem;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author localhost
 */
public class DAOBem {
    private static DAOBem daoBem = null;
    private Connection connection;
    
    public DAOBem() throws SQLException{
        connection = ConnectionFactory.getConnection();
    }
    
    public static DAOBem getIntance() throws SQLException{
        
        if(daoBem == null){
            daoBem = new DAOBem();
            return daoBem;
        }
        else
            return daoBem;
    }
    
    public void insert(Bem bem,Long cpf) throws SQLException{
        String query = "INSERT INTO bem(cpfContr, nomeBem, tipoBem, valorBem) VALUES ( ?, ?, ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setLong(1, cpf);
        stmt.setString(2, bem.getNome());
        stmt.setString(3,bem.getTipo());
        stmt.setBigDecimal(4,bem.getValor());
        
        stmt.execute();
        
    }
    
    public void delete(List<Bem> bem) throws SQLException{
        String query = "DELETE FROM bem WHERE codBem=?";
        PreparedStatement stmt = connection.prepareStatement(query);
       
        Iterator it = bem.iterator();
        
        while(it.hasNext()){
            Bem b = (Bem) it.next();
            int cod = b.getCodBem();
            
            stmt = connection.prepareStatement(query);            
            stmt.setLong(1,cod);
            stmt.execute();
        }        
        
    }
    
    //nao usa
    public void select(){
        
    }
    
    public List<Bem> selectAll(Long cpfContribuinte) throws SQLException{
        String query = "SELECT codbem, nomeBem, tipoBem, valorBem FROM bem WHERE cpfContr = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        List<Bem> linhas = new ArrayList<Bem>();
        
        stmt.setLong(1, cpfContribuinte);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            Bem b = new Bem();
            
            int codbem = rs.getInt("codbem");
            BigDecimal valor = rs.getBigDecimal("valorBem");
            String nome = rs.getString("nomeBem");
            String tipoBem = rs.getString("tipoBem");      
            
            b.setCodBem(codbem);
            b.setValor(valor);
            b.setNome(nome);
            b.setTipo(tipoBem);
            linhas.add(b);
        }
        
        return linhas;
        
    }
    
    public void update(Bem bem) throws SQLException{
        String query = "UPDATE bem SET nomeBem= ?, tipoBem= ?, valorBem= ? WHERE codbem= ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, bem.getNome());
        stmt.setString(2,bem.getTipo());
        stmt.setBigDecimal(3,bem.getValor());
        stmt.setInt(4,bem.getCodBem());       
        
        stmt.execute();
    }
    
}
