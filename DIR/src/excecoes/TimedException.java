/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

import java.util.Calendar;

/**
 *
 * @author localhost
 */
public class TimedException extends Exception{

    private Exception ex;
    
    public TimedException() {
    }

    public TimedException(Exception ex) {
        this.ex = ex;
    }
        

    public TimedException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "\n" + this.ex +" "+ Calendar.getInstance().getTime() + "\n";
    }
    
    

   
    
    
}
