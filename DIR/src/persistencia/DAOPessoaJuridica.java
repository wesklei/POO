/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dados.PessoaJuridica;
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
public class DAOPessoaJuridica {
    private static DAOPessoaJuridica daoPJ = null;
    private Connection connection;
    
    public DAOPessoaJuridica() throws SQLException{
        
            connection = ConnectionFactory.getConnection(); 
        
    }
    
    public static DAOPessoaJuridica getInstance() throws SQLException{
      
        if(daoPJ == null){
            daoPJ = new DAOPessoaJuridica();
            return daoPJ;
        }
        else
            return daoPJ;     
        
    }
    
    public void insert(PessoaJuridica pessoaJuridica) throws SQLException{
        
        String query = "INSERT INTO pessoaJuridica(cnpjPJ, nomePJ, endPJ, numFuncPJ) VALUES (?, ?, ?, ?);";
            
            PreparedStatement stmt = connection.prepareStatement(query);
            
            stmt.setLong(1, Long.parseLong(pessoaJuridica.getCnpj()));
            stmt.setString(2, pessoaJuridica.getNomePJ());
            stmt.setString(3, pessoaJuridica.getEndereco());
            stmt.setInt(4, pessoaJuridica.getNumFuncionarios());
            
            stmt.execute();
        
    }
    
    public List<PessoaJuridica> selectAll() throws SQLException{
        String query = "SELECT nomePJ, cnpjPJ, endPJ FROM pessoaJuridica;";        
        PreparedStatement stmt = connection.prepareStatement(query);
        List<PessoaJuridica> linhas = new ArrayList<PessoaJuridica>();
        PessoaJuridica registroAtual;
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
                
                registroAtual = new PessoaJuridica();
                String nome = rs.getString("nomepj");
                Long cnpj = rs.getLong("cnpjpj");
                String endereco = rs.getString("endpj");
                registroAtual.setNomePJ(nome);
                registroAtual.setCnpj(String.valueOf(cnpj));                
                registroAtual.setEndereco(endereco);
                
                linhas.add(registroAtual);
            
            }
        
        stmt.close();        
        return linhas;
    }
    
    public PessoaJuridica select(long cnpj) throws SQLException{
        String query = "SELECT * FROM pessoaJuridica WHERE cnpjPJ=?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1, cnpj);
        PessoaJuridica pj = new PessoaJuridica();
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();
        String nome = rs.getString("nomepj");
        long cnpjpj = rs.getLong("cnpjpj");
        int numfunc = rs.getInt("numfuncpj");
        String endereco = rs.getString("endpj");
        pj.setNomePJ(nome);
        pj.setCnpj(String.valueOf(cnpjpj));                
        pj.setNumFuncionarios(numfunc);
        pj.setEndereco(endereco);
        
        return pj;
    }
    
        public PessoaJuridica selectX(long cnpj) throws SQLException{
        String query = "SELECT * FROM pessoaJuridica WHERE cnpjPJ=?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1, cnpj);
        PessoaJuridica pj = new PessoaJuridica();
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();
        String nome = rs.getString("nomepj");
        long cnpjpj = rs.getLong("cnpjpj");
        int numfunc = rs.getInt("numfuncpj");
        String endereco = rs.getString("endpj");
        pj.setNomePJ(nome);
        pj.setCnpj(String.valueOf(cnpjpj));                
        pj.setNumFuncionarios(numfunc);
        pj.setEndereco(endereco);
        
        return pj;
    }
    
    public void delete(List<PessoaJuridica> excluir) throws SQLException{
        
        String query1 = "DELETE FROM notaFiscal WHERE cnpjPJ=?;";
        String query2 = "DELETE FROM contraCheque WHERE cnpjPJ=?;";
        String query3 = "DELETE FROM pessoaJuridica WHERE cnpjPJ=?;";     
        PreparedStatement stmt = null;
        
        Iterator it = excluir.iterator();
        
        while(it.hasNext()){
            PessoaJuridica pj = (PessoaJuridica) it.next();
            long cnpj = Long.parseLong(pj.getCnpj());
            
            //deleta todas as notasfiscais com o cnpj
            stmt = connection.prepareStatement(query1);            
            stmt.setLong(1,cnpj);
            stmt.execute();
            
            //deleta todas os contracheques com o cnpj
            stmt = connection.prepareStatement(query2);            
            stmt.setLong(1,cnpj);
            stmt.execute();
            
            //deleta todas as pessoas juridicas com o cnpj
            stmt = connection.prepareStatement(query3);            
            stmt.setLong(1,cnpj);
            stmt.execute();
        }
        
    }
    
    public void update(PessoaJuridica pj) throws SQLException{
        String query = "UPDATE pessoaJuridica SET nomePJ= ?, endPJ= ?, numFuncPJ= ? WHERE cnpjPJ= ?;";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, pj.getNomePJ());
        stmt.setString(2, pj.getEndereco());
        stmt.setInt(3, pj.getNumFuncionarios());
        stmt.setLong(4, Long.parseLong(pj.getCnpj()));
        
        stmt.execute();
    }
}
