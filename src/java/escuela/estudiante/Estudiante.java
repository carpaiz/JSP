/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class Estudiante extends Persona {
    private Conexion clsConectar;
    private String carne;
    private int idEstudiante;
    PreparedStatement parametro;
    
    public void setidEstudiante(int pridEstudiante){idEstudiante=pridEstudiante;}
    public int getidEstudiante(){return idEstudiante;} 
     
    public void setCarne(String prCarne){carne=prCarne;}
    public String getCarne(){return carne;}
    
 public List<List<String>> listaTipoSangre(){
    List<List<String>> lista = new ArrayList<List<String>>();
        lista.add(new ArrayList<String>());
        lista.add(new ArrayList<String>());
              try{
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
           String query;
           query = "Select idTipoSangre,TipoSangre from TiposSangre" ;
           ResultSet consulta =  clsConectar.conexionBd.createStatement().executeQuery(query);
           lista.get(0).add("0");
           lista.get(1).add("<< Elija >>");
                  
           while (consulta.next())
                    { 
                        
                        lista.get(0).add(consulta.getString("idtipoSangre"));
                        lista.get(1).add(consulta.getString("tipoSangre"));
                    }
              clsConectar.cerrarConexion();
              
           }
                 
        catch(SQLException ex)
            {
                  clsConectar.cerrarConexion();
                  System.out.println(ex.getMessage());
                  lista.get(0).add("0");
                  lista.get(1).add("<< Elija >>");
            }
           return lista;

    }


  public DefaultTableModel llenarEstudiante(){
      DefaultTableModel tblModelo= new DefaultTableModel();
           try
            {
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
           
           String query;
           query = "Select Estudiantes.idEstudiante as id, Estudiantes.Carne, Estudiantes.Nombre, Estudiantes.Apellido, Estudiantes.Direccion, Estudiantes.Telefono, Estudiantes.Correo,  " +
                   "TiposSangre.tipoSangre , Estudiantes.FechaNacimiento as FechaNacimiento,TiposSangre.idTipoSangre FROM         Estudiantes INNER JOIN TiposSangre ON Estudiantes.idTipoSangre = TiposSangre.idTipoSangre order by Estudiantes.idEstudiante desc";
            ResultSet consulta =  clsConectar.conexionBd.createStatement().executeQuery(query);
            
            String encabezado [] = {"id","Carne","Nombre","Apellido","Direccion","Telefono","Correo","TipoSangre","FechaNacimiento","idTipoSangre"};
            
            tblModelo.setColumnIdentifiers(encabezado);
            
            String datos[]= new String[10];      
            while (consulta.next())
                    {           
                      datos[0] = consulta.getString("id");
                      datos[1] = consulta.getString("Carne");
                      datos[2] = consulta.getString("Nombre");
                      datos[3] = consulta.getString("Apellido");
                      datos[4] = consulta.getString("Direccion");
                      datos[5] = consulta.getString("Telefono");
                      datos[6] = consulta.getString("Correo");
                      datos[7] = consulta.getString("tipoSangre");
                      datos[8] = consulta.getString("FechaNacimiento");
                      datos[9] = consulta.getString("idTipoSangre");
                      tblModelo.addRow(datos);
                    }
              clsConectar.cerrarConexion();
              
              return  tblModelo;            
                 }
                 
        catch(SQLException ex)
            {
                  clsConectar.cerrarConexion();
                    System.out.println(ex.getMessage());
                    return  tblModelo;
            }
      }
   
public int ingresar(){
    int retorno =0;
            try{
                
                
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
           String query;
           query = "INSERT INTO Estudiantes(Carne,Nombre,Apellido,Direccion,Telefono,Correo,idTipoSangre,FechaNacimiento) " +
                                            "Values(?,?,?,?,?,?,?,?)";
           parametro = (PreparedStatement) clsConectar.conexionBd.prepareStatement(query);
           
           parametro.setString(1, getCarne());
           parametro.setString(2, getNombre());
           parametro.setString(3, getApellido());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getCorreo());
           parametro.setInt(7, getTipoSangre());
           parametro.setString(8, getFechaNacimiento());
           int executar =  parametro.executeUpdate();
             clsConectar.cerrarConexion();
         
             retorno = executar;

            }
        catch(SQLException ex)
            {
                  clsConectar.cerrarConexion();
                  System.out.println(ex.getMessage());
                  retorno = 0;
            }
        
           return retorno;
        }   
 public int Modificar(){
     int retorno =0;
            try{
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
           String query;
           query = "update Estudiantes set Carne = ?,Nombre= ?,Apellido= ?,Direccion= ?,Telefono= ?,Correo= ?,idTipoSangre= ?,FechaNacimiento= ? " +
                                            "where idEstudiante=?";
           parametro = (PreparedStatement) clsConectar.conexionBd.prepareStatement(query);
           
           parametro.setString(1, getCarne());
           parametro.setString(2, getNombre());
           parametro.setString(3, getApellido());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getCorreo());
           parametro.setInt(7, getTipoSangre());
           parametro.setString(8, getFechaNacimiento());
           parametro.setInt(9, getidEstudiante());
                  
           int executar =  parametro.executeUpdate();
             clsConectar.cerrarConexion();
         
         retorno = executar;

            }
        catch(SQLException ex)
            {
                  clsConectar.cerrarConexion();
                  System.out.println(ex.getMessage());
                  retorno = 0;
            }
        
           return retorno;
        }
  public int Eliminar(){
       int retorno =0;
            try{
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
                      String query;
           query = "delete from  Estudiantes where idEstudiante=? " ;                                 
           parametro = (PreparedStatement) clsConectar.conexionBd.prepareStatement(query);
           parametro.setInt(1, getidEstudiante());
           

           int executar =  parametro.executeUpdate();
           clsConectar.cerrarConexion();
         
           
             retorno = executar;

            }
        catch(SQLException ex)
            {
                  clsConectar.cerrarConexion();
                  System.out.println(ex.getMessage());
                  retorno = 0;
            }
        
           return retorno;
           
           
        }
  
   
}
