/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dados.Dependente;
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
public class DAODependente {
    private static DAODependente daoDependente = null;
    private Connection connection;
    
    public DAODependente() throws SQLException{
        connection = ConnectionFactory.getConnection();
    }
    
    public static DAODependente getInstance() throws SQLException{
        if(daoDependente == null){
            daoDependente = new DAODependente();
            return daoDependente;
        }
        else
            return daoDependente;
    }
    
        public void insert(Dependente dependente,Long cpf) throws SQLException{
        String query = "INSERT INTO dependente(cpfContr,  cpfDep, nomeDep, idadeDep, endDep) VALUES (?, ?, ?, ?, ?);";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setLong(1, cpf);
        stmt.setLong(2, Long.valueOf(dependente.getCpf()));
        stmt.setString(3, dependente.getNome());
        stmt.setInt(4, dependente.getIdade());
        stmt.setString(5, dependente.getEndereco());
        
        stmt.execute();
        
        stmt.close();
        
    }
    
    public void delete(List<Dependente> d) throws SQLException{
        String query = "DELETE FROM dependente WHERE cpfDep=?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        Iterator it = d.iterator();
        
        while(it.hasNext()){
            Dependente dep = (Dependente) it.next();
            long cpf = Long.parseLong(dep.getCpf());
            
            stmt = connection.prepareStatement(query);            
            stmt.setLong(1,cpf);
            stmt.execute();
        }        
        
    }
    
   /* nao usei
     * public void select(){
        
    }*/
    
    public List<Dependente> selectAll(Long cpfContribuinte) throws SQLException{
        String query = "SELECT cpfDep, nomeDep, idadeDep, endDep FROM dependente WHERE cpfContr = ?;";
        List<Dependente> linhas = new ArrayList<Dependente>();
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setLong(1, cpfContribuinte);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            Dependente d = new Dependente();
            
            Long cpfDep = rs.getLong("cpfDep");
            String nome = rs.getString("nomeDep");
            int idade = rs.getInt("idadeDep");
            String end = rs.getString("endDep");
            
            d.setCpf(String.valueOf(cpfDep));
            d.setNome(nome);
            d.setIdade(idade);
            d.setEndereco(end);
            
            linhas.add(d);
        }
        
        return linhas;
    }
    
    public void update(Dependente d) throws SQLException{
        String query = "UPDATE dependente SET nomeDep= ?, idadeDep= ?, endDep= ? WHERE cpfdep= ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, d.getNome());
        stmt.setInt(2, d.getIdade());
        stmt.setString(3, d.getEndereco());
        stmt.setLong(4, Long.parseLong(d.getCpf()));        
        
        stmt.execute();
        
    }
    
}
