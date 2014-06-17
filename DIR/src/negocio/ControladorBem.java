/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dados.Bem;
import java.sql.SQLException;
import java.util.List;
import persistencia.DAOBem;

/**
 *
 * @author localhost
 */
public class ControladorBem {
    
    public void insert(Bem bem,Long cpf) throws SQLException{
        
        DAOBem.getIntance().insert(bem, cpf);
    }
    
    public List<Bem> selectAll(Long cpfContribuinte) throws SQLException{
        
        return DAOBem.getIntance().selectAll(cpfContribuinte);
    }
    
    public void delete(List<Bem> bem) throws SQLException{
        DAOBem.getIntance().delete(bem);
    }
    
    public void update(Bem bem) throws SQLException{
        DAOBem.getIntance().update(bem);
    }
    
}
