/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dados.NotaFiscal;
import java.sql.SQLException;
import java.util.List;
import persistencia.DAONotaFiscal;

/**
 *
 * @author localhost
 */
public class ControladorNF {
    
    public void insert(NotaFiscal nf, Long cpf) throws SQLException{
        
        DAONotaFiscal.getIntance().insert(nf, cpf);
    }
    
    public List<NotaFiscal> selectAll(Long cpf) throws SQLException{
        
        return DAONotaFiscal.getIntance().selectAll(cpf);
    }
    
    public List<NotaFiscal> selectAllCnpj(Long cnpj) throws SQLException{
            
        return DAONotaFiscal.getIntance().selectAllCnpj(cnpj);
    }
    
    public void delete(List<NotaFiscal> notas) throws SQLException{
        
        DAONotaFiscal.getIntance().delete(notas);
    }
    
    public void update(NotaFiscal nf) throws SQLException{
            
        DAONotaFiscal.getIntance().update(nf);
    }
    
}
