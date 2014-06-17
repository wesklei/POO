/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author localhost
 */
public class ConnectionFactory {
    public static Connection connection = null;
    
    //trata sqlException com o tratador de excecoes
    public static Connection getConnection() throws SQLException{
        if (connection == null) {
            connection = DriverManager.getConnection("jbdc:postgresql://localhost:5432/dir",
                                                     "localhost", "udesc");
        }
        return connection;
    }
        

}

