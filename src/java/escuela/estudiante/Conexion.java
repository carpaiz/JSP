/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.estudiante;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author latitude
 */
public class Conexion {
    public Connection conexionBd;
    
    private final String sgdb = "mysql";
    private final String servidor="localhost"; 
    private final String puerto=":3306";
    private final String bd = "dbEscuela";
    private final String urlConexion = "jdbc:"+sgdb +"://"+servidor+puerto+"/"+bd; //mysql
    private final String usuario = "IsEscuela";
    private final String contra = "escuela2016";
    private final String jdbc="com.mysql.jdbc.Driver";
    
    public void abrirConexion()
    {
        try
        {
        Class.forName(jdbc);
        conexionBd= DriverManager.getConnection(urlConexion,usuario,contra);
        
        }
        catch(Exception ex)
        {
         
        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Conexion :(",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void cerrarConexion()
    {
        try {
            conexionBd.close();
            }
            catch(Exception ex)
        {        
        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Conexion",JOptionPane.ERROR_MESSAGE);
        }

    }
    }

