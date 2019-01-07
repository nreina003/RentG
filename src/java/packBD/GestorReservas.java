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

    
}
