/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dados.Dependente;
import java.sql.SQLException;
import java.util.List;
import persistencia.DAODependente;

/**
 *
 * @author localhost
 */
public class ControladorDependente {
    
    public void insert(Dependente d,Long cpf) throws SQLException{
         DAODependente.getInstance().insert(d,cpf);    
    }
    
    public void update(Dependente d) throws SQLException{
        DAODependente.getInstance().update(d);
    }
    
    public void delete(List<Dependente> d) throws SQLException{
        DAODependente.getInstance().delete(d);
    }
    
    public List<Dependente> selectAll(Long cpf) throws SQLException{
        return DAODependente.getInstance().selectAll(cpf);
    }
    
}
