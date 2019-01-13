package packServlets;

import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import packBD.*;

@WebServlet(name = "SrvLoguearse", urlPatterns = {"/SrvLoguearse"})
public class SrvLoguearse extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
    String cad;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        Conexion c = Conexion.getInstance();
        c.conectar();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        try {
            
            String email = request.getParameter("email");
            String contrasena = request.getParameter("contrasena");
           

            boolean encontrado = GestorClientes.getInstance().buscarCliente(email);
            boolean encontradoRS = GestorClientes.getInstance().buscarRS(email);
            boolean encontradoContraCliente = GestorClientes.getInstance().comprobarContrasena(email, contrasena);
            boolean encontradoContraRS = GestorClientes.getInstance().comprobarContrasenaRS(email, contrasena);

            if (!encontrado && !encontradoRS) {
                System.out.println("No encontrado en ninguna tabla");
                try {
                        //out = response.getWriter();
                        JOptionPane.showMessageDialog(null, "Email incorrecto", "RentG", JOptionPane.WARNING_MESSAGE);
                        response.sendRedirect("loguearse.jsp");
                    } catch (IOException e) {
                        System.out.println("Se ha producido una IOException");
                        response.sendRedirect("loguearse.jsp");
                    }

            } else if (!encontrado && encontradoRS) {
                System.out.println("encontrado en tabla rs");
                if (encontradoContraRS) {
                    response.sendRedirect("responsableO.jsp");
                } else {
                    try {
                        //out = response.getWriter();
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "RentG", JOptionPane.WARNING_MESSAGE);
                        response.sendRedirect("loguearse.jsp");
                    } catch (IOException e) {
                        System.out.println("Se ha producido una IOException");
                        response.sendRedirect("loguearse.jsp");
                    }
                }

            } else {

                System.out.println("encontrado en tabla cliente");
                if (encontradoContraCliente) {
                    response.sendRedirect("inicioCliente.jsp");
                } else {
                    try {
                        //out = response.getWriter();
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "RentG", JOptionPane.WARNING_MESSAGE);
                        response.sendRedirect("loguearse.jsp");
                    } catch (IOException e) {
                        System.out.println("Se ha producido una IOException");
                        response.sendRedirect("loguearse.jsp");
                    }
                }

            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Formato de email incorrecto", "RentG", JOptionPane.WARNING_MESSAGE);
            response.sendRedirect("loguearse.jsp");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nombre = (String) req.getParameter("NombreUsuario");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Vector listado = (Vector) req.getSession().getAttribute("listado");
        if (listado == null) {
            listado = new Vector();
        }

        out.println("<html>");
        out.println("<head><title>Servlets y Sesiones</title></head>");
        out.println("<body>");
        if (nombre != null) {
            out.println("<br>Hola " + nombre + "<br>");
            listado.addElement(nombre);
        }

        req.getSession().setAttribute("listado", listado);
        out.println("<br>");
      
        for (int i = 0; i < listado.size(); i++) {
            out.println("<br>" + (String) listado.elementAt(i));
        }
        out.println("<center><a href=\"Formulario.html\">VOLVER</a></center>");

        out.println("</body></html>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession(true);
        String email = (String) request.getParameter("email");
        s.setAttribute("email", email);
        /* s.setAttribute("pEmail", request.getParameter("email"));*/
        String contrasena = (String) request.getParameter("contrasena");
        s.setAttribute("contrasena", contrasena);

        //seguir o dejar
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SrvLoguearse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
