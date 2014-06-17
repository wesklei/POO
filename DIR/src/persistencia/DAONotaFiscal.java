/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dados.NotaFiscal;
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
public class DAONotaFiscal {
    private static DAONotaFiscal daoNotaFiscal = null;
    private Connection connection;
    
    public DAONotaFiscal() throws SQLException{
        connection = ConnectionFactory.getConnection();
    }
    
    public static DAONotaFiscal getIntance() throws SQLException{
        
        if(daoNotaFiscal == null){
            daoNotaFiscal = new DAONotaFiscal();
            return daoNotaFiscal;
        }
        else
            return daoNotaFiscal;
    }
    
    public void insert(NotaFiscal c,Long cpf) throws SQLException{
        String query = "INSERT INTO notaFiscal(numProtNF, cnpjPJ,valorNF,cpfContr) VALUES (?, ?, ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, c.getNumProtocolo());
        stmt.setLong(2, Long.parseLong(c.getCnpj()));
        stmt.setBigDecimal(3, c.getValor());
        stmt.setLong(4, cpf);
        
        stmt.execute();
        
    }
    
    public List<NotaFiscal> selectAll(Long cpf) throws SQLException{
        String query = "SELECT numProtNF, cnpjPJ,valorNF,codnf FROM notaFiscal WHERE cpfContr = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        List<NotaFiscal> linhas = new ArrayList<NotaFiscal>();
        
        stmt.setLong(1, cpf);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            NotaFiscal nf = new NotaFiscal();
            
            int numProtNF = rs.getInt("numProtNF");
            long cnpj = rs.getLong("cnpjPJ");
            BigDecimal valor = rs.getBigDecimal("valorNF");   
            int codnf = rs.getInt("codnf");
            
            nf.setNumProtocolo(numProtNF);
            nf.setValor(valor);
            nf.setCnpj(String.valueOf(cnpj));
            nf.setCodNF(codnf);
            
            
            linhas.add(nf);
        }
        
        return linhas;
        
    }
    
        public List<NotaFiscal> selectAllCnpj(Long cnpj) throws SQLException{
        String query = "SELECT numProtNF, cnpjPJ,valorNF,codnf FROM notaFiscal WHERE cnpjpj = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        List<NotaFiscal> linhas = new ArrayList<NotaFiscal>();
        
        stmt.setLong(1, cnpj);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            NotaFiscal nf = new NotaFiscal();
            
            int numProtNF = rs.getInt("numProtNF");
            long cj = rs.getLong("cnpjPJ");
            BigDecimal valor = rs.getBigDecimal("valorNF");   
            int codnf = rs.getInt("codnf");
            
            nf.setNumProtocolo(numProtNF);
            nf.setValor(valor);
            nf.setCnpj(String.valueOf(cj));
            nf.setCodNF(codnf);
            
            
            linhas.add(nf);
        }
        
        return linhas;
        
    }
    
    public void delete(List<NotaFiscal> notas) throws SQLException{
        String query = "DELETE FROM notaFiscal WHERE codnf=?;";
        PreparedStatement stmt = connection.prepareStatement(query);
       
        Iterator it = notas.iterator();
        
        while(it.hasNext()){
            NotaFiscal nf = (NotaFiscal) it.next();
            int cod = nf.getCodNF();
            
            stmt = connection.prepareStatement(query);            
            stmt.setInt(1,cod);
            stmt.execute();
        }       
    }
    
    public void update(NotaFiscal nf) throws SQLException{
        String query = "UPDATE notaFiscal SET numProtNF=?, cnpjPJ=?, valorNF=? WHERE codnf=?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, nf.getNumProtocolo());
        stmt.setLong(2,Long.parseLong(nf.getCnpj()));
        stmt.setBigDecimal(3,nf.getValor());
        stmt.setInt(4,nf.getCodNF()); 
        
        stmt.execute();
    }
}
