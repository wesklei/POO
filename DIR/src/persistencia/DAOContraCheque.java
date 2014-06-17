/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dados.ContraCheque;
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
public class DAOContraCheque {
    private static DAOContraCheque daoContraCheque = null;
    private Connection connection;
    
    public DAOContraCheque() throws SQLException{
        connection = ConnectionFactory.getConnection();
    }
    
    public static DAOContraCheque getIntance() throws SQLException{
        
        if(daoContraCheque == null){
            daoContraCheque = new DAOContraCheque();
            return daoContraCheque;
        }
        else
            return daoContraCheque;
    }
    
    public void insert(ContraCheque c,Long cpf) throws SQLException{
        String query = "INSERT INTO contraCheque(numProtCC, cnpjPJ,valorCC,cpfContr) VALUES (?, ?, ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, c.getNumProtocolo());
        stmt.setLong(2, Long.parseLong(c.getCnpj()));
        stmt.setBigDecimal(3, c.getValor());
        stmt.setLong(4, cpf);
        
        stmt.execute();
        
    }
    
    public void delete(List<ContraCheque> cc) throws SQLException{
        String query = "DELETE FROM contraCheque WHERE codcc=?;";
        PreparedStatement stmt = connection.prepareStatement(query);
       
        Iterator it = cc.iterator();
        
        while(it.hasNext()){
            ContraCheque c = (ContraCheque) it.next();
            int cod = c.getCodCC();
            
            stmt = connection.prepareStatement(query);            
            stmt.setInt(1,cod);
            stmt.execute();
        }       
    }
    
    public void select(){
        
    }
    
    public List<ContraCheque> selectAll(Long cpf) throws SQLException{
        String query = "SELECT numProtCC, cnpjPJ,valorCC, codCC FROM contraCheque WHERE cpfContr = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        List<ContraCheque> linhas = new ArrayList<ContraCheque>();
        
        stmt.setLong(1, cpf);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            ContraCheque c = new ContraCheque();
            
            int numProtCC = rs.getInt("numProtCC");
            long cnpj = rs.getLong("cnpjPJ");
            BigDecimal valor = rs.getBigDecimal("valorCC");   
            int codCC = rs.getInt("codCC");
            
            c.setNumProtocolo(numProtCC);
            c.setValor(valor);
            c.setCnpj(String.valueOf(cnpj));
            c.setCodCC(codCC);
            
            
            linhas.add(c);
        }
        
        return linhas;
        
    }
    
    public List<ContraCheque> selectAllCnpj(Long cnpj) throws SQLException{
        String query = "SELECT numProtCC, cnpjPJ,valorCC, codCC FROM contraCheque WHERE cnpjpj = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        List<ContraCheque> linhas = new ArrayList<ContraCheque>();
        
        stmt.setLong(1, cnpj);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            ContraCheque c = new ContraCheque();
            
            int numProtCC = rs.getInt("numProtCC");
            long cj = rs.getLong("cnpjPJ");
            BigDecimal valor = rs.getBigDecimal("valorCC");   
            int codCC = rs.getInt("codCC");
            
            c.setNumProtocolo(numProtCC);
            c.setValor(valor);
            c.setCnpj(String.valueOf(cj));
            c.setCodCC(codCC);
            
            
            linhas.add(c);
        }
        
        return linhas;
        
    }
    
    
    
    public void update(ContraCheque c) throws SQLException{
        String query = "UPDATE contraCheque SET numProtCC=?, cnpjPJ=?, valorCC=? WHERE codcc=?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, c.getNumProtocolo());
        stmt.setLong(2,Long.parseLong(c.getCnpj()));
        stmt.setBigDecimal(3,c.getValor());
        stmt.setInt(4,c.getCodCC()); 
        
        stmt.execute();
    }
}
