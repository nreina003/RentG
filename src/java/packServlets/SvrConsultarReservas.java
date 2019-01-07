/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packServlets;

import java.io.IOException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import packBD.Conexion;
import packBD.GestorReservas;
import packModelo.Reserva;

@WebServlet(name = "SrvConsultarReservas", urlPatterns = {"/SrvConsultarReservas"})

public class SvrConsultarReservas extends HttpServlet {

    private static SvrConsultarReservas cr;
    private static int id = 0;
    private Connection con;
    private Statement set;
    private ResultSet rs;
    String cad;
    public String matri;

    public void init(ServletConfig cfg) throws ServletException {
        Conexion c = Conexion.getInstance();
        c.conectar();
    }

    public static SvrConsultarReservas getInstance() {

        if (cr == null) {

            cr = new SvrConsultarReservas();
        }
        return cr;
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
            String query = "SELECT * FROM reservas order by email";
            rs = c.getSt().executeQuery("SELECT * FROM reservas  order by email");
            Integer idReservas;
            String email;
            String matricula;
            String fechaInicio;
            String fechaFin;
            String lugar;
            String cocheRecogido;
            String cocheEntregado;
            String pagoExtra;
            String retraso;

            while (rs.next()) {
                System.out.println("añadir");
                idReservas = rs.getInt("idReservas");
                email = rs.getString("email");
                matricula = rs.getString("matricula");
                fechaInicio = rs.getString("fechaInicio");
                fechaFin = rs.getString("fechaFin");
                lugar = rs.getString("lugar");
                cocheRecogido = rs.getString("cocheRecogido");
                cocheEntregado = rs.getString("CocheEntregado");
                pagoExtra = rs.getString("pagoExtra");
                retraso = rs.getString("retraso");

                reservas.add(new Reserva(idReservas, email, matricula, fechaInicio, fechaFin, lugar, cocheRecogido, cocheEntregado, pagoExtra, retraso));

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        System.out.println(reservas);
        return reservas;
    }

    public ArrayList<Reserva> buscarReservasPorCoche(String pMatric) {

        ResultSet rs = null;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            System.out.println(pMatric);
            String query = "SELECT * FROM reservas where matricula ='" + pMatric + "'";
            rs = c.getSt().executeQuery("SELECT * FROM reservas  where matricula ='" + pMatric + "'");
            Integer idReservas;
            String email;
            String matricula;
            String fechaInicio;
            String fechaFin;
            String lugar;
            String cocheRecogido;
            String cocheEntregado;
            String pagoExtra;
            String retraso;

            while (rs.next()) {
                System.out.println("añadir");
                idReservas = rs.getInt("idReservas");
                email = rs.getString("email");
                matricula = rs.getString("matricula");
                fechaInicio = rs.getString("fechaInicio");
                fechaFin = rs.getString("fechaFin");
                lugar = rs.getString("lugar");
                cocheRecogido = rs.getString("cocheRecogido");
                cocheEntregado = rs.getString("CocheEntregado");
                pagoExtra = rs.getString("pagoExtra");
                retraso = rs.getString("retraso");

                reservas.add(new Reserva(idReservas, email, matricula, fechaInicio, fechaFin, lugar, cocheRecogido, cocheEntregado, pagoExtra, retraso));

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        System.out.println(reservas);
        return reservas;
    }

    public ArrayList<Reserva> buscarReservasPendientes(String pEmail) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            String query = "SELECT * FROM reservas where email='" + pEmail + "'";
            r = c.getSt().executeQuery(query);
            Calendar cal = Calendar.getInstance();
            System.out.println(query);
            ZoneId z = ZoneId.of("Europe/Paris");
            LocalDate pHoy = LocalDate.now(z);

            int hh = cal.get(Calendar.HOUR_OF_DAY);
            int min = cal.get(Calendar.MINUTE);

            Date ppHoy = java.sql.Date.valueOf(pHoy);
            Time pHoyHora = new Time(hh, min, 00);

            Date pFecha;
            Time pTiempo;
            while (r.next()) {
                pFecha = r.getDate("fechaCita");
                pTiempo = r.getTime("horaCita");

                if ((pFecha.equals(ppHoy) && pTiempo.after(pHoyHora)) || pFecha.after(ppHoy)) {
                    Integer idReserva = r.getInt("idReserva");
                    String email = r.getString("email");
                    String matricula = r.getString("matricula");
                    String fechaInicio = r.getString("fechaInicio");
                    String fechaFin = r.getString("fechaFin");
                    String lugar = r.getString("lugar");
                    String cocheRecogido = r.getString("cocheRecogido");
                    String cocheEntregado = r.getString("cocheEntregado");
                    String pagoExtra = r.getString("cocheEntregado");
                    String retraso = r.getString("retraso");

                    reservas.add(new Reserva(idReserva, email, matricula, fechaInicio, fechaFin, lugar, cocheRecogido, cocheEntregado, pagoExtra, retraso));
                }
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return reservas;
    }

    public boolean eliminarReserva(String pEmail, String pIdReserva) {
        Conexion c = Conexion.getInstance();
        c.conectar();
        boolean eliminada = false;
        try {
            Statement sentencia = Conexion.getInstance().getSt(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            String query = "DELETE FROM reservas WHERE email = '" + pEmail + "' AND idReservas= '" + pIdReserva + "'";
            sentencia.executeUpdate(query);
            eliminada = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestorReservas.class.getName()).log(Level.SEVERE, null, ex);
            eliminada = false;
        }
        return eliminada;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomConsulta = request.getParameter("nomConsulta");
        String matri = request.getParameter("matri");
                                        System.out.println("jkjfkdjfshfhkjdhfjkhdjfs");

                                System.out.println(matri);

        if (Objects.equals(nomConsulta, "fecha")) {
            response.sendRedirect("fecha.jsp");
        } else if (Objects.equals(nomConsulta, "coche")) {
          
           request.setAttribute("matri", matri);
           
           request.getRequestDispatcher("coche.jsp").forward(request, response);
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
