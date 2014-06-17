/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.mascara;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author localhost
 */
public class MascaraCnpj {
     
    /** 
     * Simbolos especificos do cpf 
     */      
     public static String mascaraCpf(String cpf) throws ParseException{  
         
         MaskFormatter formatador = new MaskFormatter("##.###.###/####-##"); 
         formatador.setValueContainsLiteralCharacters(false);
         
         return formatador.valueToString(cpf);
    }
}
