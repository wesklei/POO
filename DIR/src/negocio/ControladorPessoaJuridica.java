/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dados.PessoaJuridica;
import java.sql.SQLException;

import java.util.List;
import persistencia.DAOPessoaJuridica;

/**
 *
 * @author localhost
 */
public class ControladorPessoaJuridica {
    private ControladorContraCheque controladorContraCheque;
    private ControladorNF controladorNF;
    
    public ControladorPessoaJuridica(){
        controladorContraCheque = new ControladorContraCheque();
        controladorNF = new ControladorNF();
    }

    public ControladorContraCheque getControladorContraCheque() {
        return controladorContraCheque;
    }

    public ControladorNF getControladorNF() {
        return controladorNF;
    }
    
    public void insert(PessoaJuridica pj) throws SQLException{
        
        DAOPessoaJuridica.getInstance().insert(pj); 
    }
    
    public List<PessoaJuridica> selectAll() throws SQLException{
        
        return DAOPessoaJuridica.getInstance().selectAll();         
    }
    
    public PessoaJuridica select(long cnpj) throws SQLException{
        return DAOPessoaJuridica.getInstance().select(cnpj);
    }
     
    public PessoaJuridica selectX(long cnpj) throws SQLException{
        return DAOPessoaJuridica.getInstance().selectX(cnpj);
    }
    
    public void delete(List<PessoaJuridica> excluir) throws SQLException{
       
        DAOPessoaJuridica.getInstance().delete(excluir);        
    }
    
    public void update(PessoaJuridica pj) throws SQLException{
        
        DAOPessoaJuridica.getInstance().update(pj);
    }
}
