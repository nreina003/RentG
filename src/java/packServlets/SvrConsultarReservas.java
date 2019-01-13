
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
import java.util.logging.Level;
import java.util.logging.Logger;
import packBD.Conexion;

import packModelo.Reserva;

@WebServlet(name = "SrvConsultarReservas", urlPatterns = {"/SrvConsultarReservas"})

public class SvrConsultarReservas extends HttpServlet {
//estas 2

    private static SvrConsultarReservas cr;
    private static int id = 0;
    private Connection con;
    private Statement set;
    private ResultSet rs;
    String cad;
    public String matri;
//matri nuevo

    public void init(ServletConfig cfg) throws ServletException {
        Conexion c = Conexion.getInstance();
        c.conectar();
    }
//este

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

    public ArrayList<Reserva> buscarReservasPorEmailCliente(String pEmail) {

        ResultSet rs = null;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            String query = "SELECT * FROM reservas where email ='" + pEmail + "'";
            rs = c.getSt().executeQuery(query);
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

    public ArrayList<Reserva> buscarReservasPorCocheCliente(String pMatric, String pEmail) {

        ResultSet rs = null;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            String query = "SELECT * FROM reservas  where matricula ='" + pMatric + "' AND email ='" + pEmail + "'";
            rs = c.getSt().executeQuery("SELECT * FROM reservas  WHERE matricula ='" + pMatric + "' AND email ='" + pEmail + "'");
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
    public ArrayList<Reserva> buscarReservasPorFecha(String pFecha) {

        ResultSet rs = null;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            System.out.println(pFecha);
            String query = "SELECT * FROM reservas where fechaInicio ='" + pFecha + "'";
            rs = c.getSt().executeQuery("SELECT * FROM reservas  where fechaInicio ='" + pFecha + "'");
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

    public ArrayList<Reserva> buscarReservasPorFechaCliente(String pFecha, String pEmail) {

        ResultSet rs = null;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            String query = "SELECT * FROM reservas  where fechaInicio ='" + pFecha + "' AND email ='" + pEmail + "'";
            rs = c.getSt().executeQuery("SELECT * FROM reservas  WHERE fechaInicio ='" + pFecha + "' AND email ='" + pEmail + "'");
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

    public boolean eliminarReserva(Integer pIdr) {
        Conexion c = Conexion.getInstance();
        c.conectar();
        boolean eliminada = false;
        try {
            Statement sentencia = Conexion.getInstance().getSt(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            String query = "DELETE FROM reservas WHERE idReservas= '" + pIdr + "'";
            sentencia.executeUpdate(query);
            eliminada = true;
        } catch (SQLException ex) {
            Logger.getLogger(SvrConsultarReservas.class.getName()).log(Level.SEVERE, null, ex);
            eliminada = false;
        }
        return eliminada;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomConsulta = request.getParameter("nomConsulta");
        String nomConsultaCliente = request.getParameter("nomConsultaCliente");
        String matri = request.getParameter("matri");

        System.out.println(matri);

        if (Objects.equals(nomConsulta, "fecha")) {
            request.getRequestDispatcher("fecha.jsp").forward(request, response);
        } else if (Objects.equals(nomConsulta, "coche")) {
            request.setAttribute("matri", matri);
            request.getRequestDispatcher("coche.jsp").forward(request, response);
        } else if (Objects.equals(nomConsulta, "cliente")) {
            response.sendRedirect("cliente.jsp");
        } else if (Objects.equals(nomConsultaCliente, "fechaCliente")) {
            request.getRequestDispatcher("fechaCliente.jsp").forward(request, response);
        } else if (Objects.equals(nomConsultaCliente, "cocheCliente")) {
            request.getRequestDispatcher("cocheCliente.jsp").forward(request, response);
        } else if (Objects.equals(nomConsultaCliente, "clienteCliente")) {
            response.sendRedirect("clienteCliente.jsp");
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
