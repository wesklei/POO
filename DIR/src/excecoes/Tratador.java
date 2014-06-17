/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;


/**
 *
 * @author localhost
 */
public class Tratador {
    
    private String log = "";
    
    public void capturaExcecao(Exception ex){
        
        TimedException te = new TimedException(ex);        
        log = te.toString();
        
        try {
            this.escreveLog();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro o qual não pode ser tratado durante a escrita no arquivo de log.\n Detalhes: \n "+e, "Erro na gravação do log", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void escreveLog() throws FileNotFoundException, IOException{
        
        FileOutputStream fo = new FileOutputStream("log.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(fo);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(this.log);
        bw.close();     
        
    }
    
}
