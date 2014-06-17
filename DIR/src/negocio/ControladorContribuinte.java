/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dados.Contribuinte;
import java.sql.SQLException;
import java.util.List;
import persistencia.DAOContribuinte;

/**
 *
 * @author localhost
 */
public class ControladorContribuinte {
    
    private ControladorDependente controladorDependente;
    private ControladorBem controladorBem;
    private ControladorContraCheque controladorContraCheque;
    private ControladorNF controladorNF;
    
    public ControladorContribuinte(){
        controladorDependente = new ControladorDependente();
        controladorBem = new ControladorBem();
        controladorContraCheque = new ControladorContraCheque();
        controladorNF = new ControladorNF();
    }

    public ControladorNF getControladorNF() {
        return controladorNF;
    }

    public ControladorContraCheque getControladorContraCheque() {
        return controladorContraCheque;
    }
    
    public ControladorDependente getControladorDependente(){
        return this.controladorDependente;
    }
    
    public ControladorBem getControladorBem(){
        return this.controladorBem;
    }
        
    public void insert(Contribuinte c) throws SQLException{
        
         DAOContribuinte.getInstance().insert(c);    
    }
    
    public List<Contribuinte> selectAll() throws SQLException{
       
         return DAOContribuinte.getInstance().selectAll(); 
    }
    
    public Contribuinte select(long cpf) throws SQLException{
        
        return DAOContribuinte.getInstance().select(cpf);
    }
     
    public Contribuinte selectX(long cpf) throws SQLException{
        
        return DAOContribuinte.getInstance().selectX(cpf);
    }
    
    public void update(Contribuinte c) throws SQLException{
        
        DAOContribuinte.getInstance().update(c);
    }
    
    
}
