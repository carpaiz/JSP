
package escuela.estudiante.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Estudiante extends HttpServlet {

   
    protected void accion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            escuela.estudiante.Estudiante clsEstudiante = new escuela.estudiante.Estudiante();
            
            clsEstudiante.setidEstudiante(Integer.parseInt(request.getParameter("txtid")));
            clsEstudiante.setCarne(request.getParameter("txtCarne"));
            clsEstudiante.setNombre(request.getParameter("txtNombres"));
            clsEstudiante.setApellido(request.getParameter("txtApellidos"));
            clsEstudiante.setDireccion(request.getParameter("txtDireccion"));
            clsEstudiante.setTelefono(request.getParameter("txtTelefono"));
            clsEstudiante.setCorreo(request.getParameter("txtCorreo"));
            clsEstudiante.setTipoSangre(Integer.parseInt(request.getParameter("dropSangre")));
            clsEstudiante.setFechaNacimiento(request.getParameter("txtFNacimiento"));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Estudiante</title>");            
            
            out.println("</head>");
            out.println("<body>");
            
            if (request.getParameter("btnAgregar") != null)
            {
                
                if (clsEstudiante.ingresar()>0){
                response.sendRedirect("index.jsp");
                 }
            else{
                out.println("<h1>Error...</h1>");
                out.println("<a href='index.jsp'></a>");
                }
            }
            if (request.getParameter("btnModificar") !=null)
            {
                if (clsEstudiante.Modificar() >0){
                response.sendRedirect("index.jsp");
                 }
            else{
                out.println("<h1>Error...</h1>");
                out.println("<a href='index.jsp'></a>");
                }
            }
            if (request.getParameter("btnEliminar") !=null){
                 if (clsEstudiante.Eliminar()>0){
                response.sendRedirect("index.jsp");
                 }
            else{
                out.println("<h1>Error...</h1>");
                out.println("<a href='index.jsp'></a>");
                }
            }
            
           
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        accion(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        accion(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
