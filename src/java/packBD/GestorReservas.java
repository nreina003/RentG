/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packBD;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import packModelo.Reserva;

/**
 *
 * @author Grupo 05
 */
public class GestorReservas {

    private static GestorReservas gr;
    private static int id = 0;

    private GestorReservas() {

    }

    public static GestorReservas getInstance() {

        if (gr == null) {

            gr = new GestorReservas();
        }
        return gr;
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
                idReservas =rs.getInt("idReservas");
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
System.out.println( reservas);
        return reservas;
    }
    
    
    
     public ArrayList<Reserva> buscarReservasPorCoche() {

        ResultSet rs = null;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        try {
//            String query = "SELECT * FROM reservas order by matricula where matricula ='" + matri + "'";
//            rs = c.getSt().executeQuery("SELECT * FROM reservas order by matricula where matricula ='" + matri + "'");
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
                idReservas =rs.getInt("idReservas");
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
System.out.println( reservas);
        return reservas;
    }
    /*
    public ArrayList<Reserva> buscarReservasPorEmailDelCliente(pEmail) {

        ResultSet rs = null;
        Conexion c = Conexion.getInstance();
        c.conectar();
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        try {
            String query =("SELECT * FROM reservas email='" + pEmail + "'");
            rs = c.getSt().executeQuery("SELECT * FROM reservas email='" + pEmail + "'");

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
                System.out.println("añadir");
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
*/

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

                    reservas.add(new Reserva (idReserva,email, matricula, fechaInicio, fechaFin, lugar, cocheRecogido, cocheEntregado, pagoExtra, retraso));
                }
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return reservas;
    }
   public boolean eliminarReserva (String pEmail, String pIdReserva){
        Conexion c = Conexion.getInstance();
        c.conectar();
        boolean eliminada = false;
        try {
        Statement sentencia =  Conexion.getInstance().getSt(ResultSet.TYPE_SCROLL_SENSITIVE,             
                                           ResultSet.CONCUR_UPDATABLE);        
        
            String query = "DELETE FROM reservas WHERE email = '" +pEmail+ "' AND idReservas= '" +pIdReserva + "'";
            sentencia.executeUpdate(query);
            eliminada = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(GestorReservas.class.getName()).log(Level.SEVERE, null, ex);
            eliminada = false;
        }
        return eliminada;
    }
}
