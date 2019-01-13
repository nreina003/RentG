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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import packModelo.Reserva;
import java.text.SimpleDateFormat;


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

    
    
    
    
}
