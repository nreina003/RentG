/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import packBD.Conexion;
import packBD.GestorRegistrarse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SvrRegistrarse", urlPatterns = {"/SvrRegistrarse"})
public class SvrRegistrarse extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
    String cad;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        Conexion c = Conexion.getInstance();
        c.conectar();
    }

    public boolean comprobarCliente(String pEmail, String pMovil, String pDni) {
        ResultSet resultado;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT email,movil,dni FROM clientes WHERE email = '" + pEmail + "' OR movil='" + pMovil + "' OR dni = '" + pDni + "' ");

            if (resultado.next()) {
                return true;
            }
            
            System.err.println(resultado.next());
            resultado = c.getSt().executeQuery("SELECT email,movil,dni FROM rs WHERE email = '" + pEmail + "' OR movil='" + pMovil + "' OR dni = '" + pDni + "' ");

            if (resultado.next()) {
                return true;
            }
            System.err.println(resultado.next());
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return false;
    }

    public void registrarClientes(String pNombre, String pEmail, String pMovil, String pDni, String pContraseña, String pFoto) {

        boolean insertada = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            Statement sentencia = Conexion.getInstance().getSt(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String query = "INSERT INTO clientes (email, contraseña, nombre, dni, movil, foto) VALUES ('"
                    + pEmail + "','" + pContraseña + "','" + pNombre + "','" + pDni + "','" + pMovil + "','" + pFoto + "')";
            sentencia.executeUpdate(query);
            insertada = true;

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        System.err.println("usuario ya registrado" + insertada);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        try {
            System.out.println("aqui 11");
            String email = request.getParameter("email");
            String contrasena = request.getParameter("contrasena");
            String nombre = request.getParameter("nombre");
            String dni = request.getParameter("dni");
            String movil = request.getParameter("movil");
            String foto = request.getParameter("foto");

            boolean encontrado = comprobarCliente(email, movil, dni);

            if (encontrado) {
                response.setContentType("text/html");
                System.out.println("aqui 2");
                // PrintWriter out = null;

                JOptionPane.showMessageDialog(null, "ya estas registrado", "RentG", JOptionPane.WARNING_MESSAGE);
                response.sendRedirect("registrarse.jsp");

            } else {
                System.out.println("aqui 3");

                registrarClientes(nombre, email, movil, dni, contrasena, foto);
                response.sendRedirect("loguearse.jsp");

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
        out.println("Contigo, hoy me han visitado:<br>");
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
        s.setAttribute("pEmail", request.getParameter("email"));
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
