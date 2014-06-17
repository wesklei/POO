/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dados.ContraCheque;
import java.sql.SQLException;
import java.util.List;
import persistencia.DAOContraCheque;

/**
 *
 * @author localhost
 */
public class ControladorContraCheque {
    
    public void insert(ContraCheque c, Long cpf) throws SQLException{
        DAOContraCheque.getIntance().insert(c, cpf);
    }
    
    public List<ContraCheque> selectAll(long cpf) throws SQLException{
        
        return DAOContraCheque.getIntance().selectAll(cpf);
    }
    
    public List<ContraCheque> selectAllCnpj(long cnpj) throws SQLException{
        
        return DAOContraCheque.getIntance().selectAllCnpj(cnpj);
    }
    
    public void update(ContraCheque c) throws SQLException{
        DAOContraCheque.getIntance().update(c);
    }
    
    public void delete(List<ContraCheque> cc) throws SQLException{
        DAOContraCheque.getIntance().delete(cc);
    }
}
