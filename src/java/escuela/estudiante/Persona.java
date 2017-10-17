/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.estudiante;

/**
 *
 * @author Administrador
 */
abstract class Persona {
   private String nombre,apellido,direccion,telefono,correo;
   private int tipoSangre;
   private String fechaNacimiento;

   
 public void setNombre(String prNombre) {nombre=prNombre;}
 public String getNombre(){return nombre;}
 
 public void setApellido(String prApellido){apellido=prApellido;}
 public String getApellido(){return apellido;}
  
 public void setDireccion(String prDireccion){direccion=prDireccion;}
 public String getDireccion(){return direccion;}
 
 public void setTelefono(String prTelefono){telefono=prTelefono;}
 public String getTelefono(){return telefono;}
 
public void setCorreo(String prCorreo){correo=prCorreo;}
public String getCorreo(){return correo;}
 
 public void setFechaNacimiento(String prFechaNacimiento){fechaNacimiento=prFechaNacimiento;}
 public String getFechaNacimiento(){return fechaNacimiento;}
 
public void setTipoSangre(int prTipoSangre){tipoSangre=prTipoSangre;}
public int getTipoSangre(){return tipoSangre;}
 

}