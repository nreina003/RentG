/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import packBD.Conexion;
import packModelo.Reserva;

@WebServlet(name = "SrvConsultarReservas", urlPatterns = {"/SrvConsultarReservas"})

public class SvrConsultarReservas extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
    String cad;

    public void init(ServletConfig cfg) throws ServletException {
        Conexion c = Conexion.getInstance();
        c.conectar();
    }

    public ResultSet rCliente() {
        ResultSet reservas = null;
        Conexion c = Conexion.getInstance();
        c.conectar();

        // String reservas = null;
        try {

            reservas = c.getSt().executeQuery("SELECT * FROM rentg02.reservas order by  email;");

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return reservas;
    }

    public ArrayList<Reserva> buscarReservasPorEmail() {

        ResultSet rs = null;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            String query = "SELECT * FROM rentg02.reservas order by  email";
            rs = c.getSt().executeQuery(query);

            String email;
            String matricula;
            String fechaInicio;
            String fechaFin;
            String lugar;
            String cocheRecogido;
            String CocheEntregado;
            String pagoExtra;
            String retraso;
            
            while (rs.next()) {
                email = rs.getString("email");
                matricula = rs.getString("matricula");
                fechaInicio = rs.getString("fechaInicio");
                fechaFin = rs.getString("fechaFin");
                lugar = rs.getString("lugar");
                cocheRecogido = rs.getString("cocheRecogido");
                CocheEntregado = rs.getString("CocheEntregado");
                pagoExtra = rs.getString("pagoExtra");
                retraso = rs.getString("retraso");

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

        return reservas;

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomConsulta = request.getParameter("nomConsulta");

        if (Objects.equals(nomConsulta, "fecha")) {
            response.sendRedirect("fecha.jsp");
        } else if (Objects.equals(nomConsulta, "coche")) {
            response.sendRedirect("coche.jsp");
        } else {
            response.sendRedirect("cliente.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
