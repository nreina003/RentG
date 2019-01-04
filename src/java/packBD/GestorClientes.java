/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packBD;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packModelo.Cliente;

public class GestorClientes {

    private static GestorClientes gc;
    private Connection con;
    private Statement set;
    private ResultSet rs;

    public void init(ServletConfig cfg) throws ServletException {
        String sURL = "jdbc:mysql://localhost:3306/rentg02";
        //super.init(cfg);
        String userName = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(sURL, userName, password);
            System.out.println("Se ha conectado.");
        } catch (ClassNotFoundException ex1) {
            System.out.println("No se ha conectado: " + ex1);
        } catch (IllegalAccessException ex2) {
            System.out.println("No se ha conectado: " + ex2);
        } catch (InstantiationException ex3) {
            System.out.println("No se ha conectado: " + ex3);
        } catch (SQLException ex4) {
            System.out.println("No se ha conectado:" + ex4);
        }
    }

    private GestorClientes() {
    }

    public static GestorClientes getInstance() {
        if (gc == null) {
            gc = new GestorClientes();
        }
        return gc;
    }

    public boolean buscarCliente(String pEmail) {
        ResultSet resultado;
        boolean encontrado = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT email FROM clientes WHERE email = '" + pEmail + "'");
            if (resultado.next()) {
                encontrado = true;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            c.desconectar();
        }
        return encontrado;
    }
    
    public boolean buscarRS(String pEmail) {
        ResultSet resultado;
        boolean encontrado = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT email FROM rs WHERE email = '" + pEmail + "'");
            if (resultado.next()) {
                encontrado = true;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            c.desconectar();
        }
        return encontrado;
    }

    public boolean comprobarContrasena(String pEmail, String pContrasena) {
        ResultSet resultado;
        boolean coincide = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT contraseña FROM clientes WHERE email = '" + pEmail + "' AND contraseña = '" + pContrasena + "'");

            if (resultado.next()) {
                coincide = true;
            }
            

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return coincide;
    }
    
    public boolean comprobarContrasenaRS(String pEmail, String pContrasena) {
        ResultSet resultado;
        boolean coincide = false;
        Conexion c = Conexion.getInstance();
        c.conectar();

        try {
            resultado = c.getSt().executeQuery("SELECT contraseña FROM rs WHERE email = '" + pEmail + "' AND contraseña = '" + pContrasena + "'");

            if (resultado.next()) {
                coincide = true;
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return coincide;
    }

    public String getNombre(String pEmail) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();

        String nombre = null;

        try {
            
            r = c.getSt().executeQuery("SELECT nombre FROM clientes WHERE email = '" + pEmail + "'");
            
            r.first();
            nombre = r.getString("nombre");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return nombre;
        
    }
    
    
    public String getNombreRS(String pEmail) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();

        String nombre = null;

        try {
            
            r = c.getSt().executeQuery("SELECT nombre FROM rs WHERE email = '" + pEmail + "'");
            
            r.first();
            nombre = r.getString("nombre");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return nombre;
        
    }
    
    public String getFotoRS(String pEmail) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();

        String foto = null;

        try {
            
            r = c.getSt().executeQuery("SELECT foto FROM rs WHERE email = '" + pEmail + "'");
            
            r.first();
            foto = r.getString("foto");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return foto;
        
    }
       public String getFotoCliente(String pEmail) {
        ResultSet r;
        Conexion c = Conexion.getInstance();
        c.conectar();

        String foto = null;

        try {
            
            r = c.getSt().executeQuery("SELECT foto FROM clientes WHERE email = '" + pEmail + "'");
            
            r.first();
            foto = r.getString("foto");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        
        return foto;
        
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession s = req.getSession(true);

        //Botones de navegación
        String button1 = null;
        String button2 = null;
        button1 = req.getParameter("loguearse");
        button2 = req.getParameter("realizarReserva");

        if (button1 != null) {
            req.getRequestDispatcher("inicioCliente.jsp").forward(req, res);
            System.out.println("Pulsado loguearse");
        } else if (button2 != null) {
            req.getRequestDispatcher("ReservaLogueado.jsp").forward(req, res);
            System.out.println("realizarReserva");
        } else {
            System.out.println("Error");
        }
        //Logout
        String btn = req.getParameter("Logout");
        if ("Logout".equals(btn)) {
            res.sendRedirect("loguearse.jsp");
            HttpSession session = req.getSession();
            session.invalidate();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            doPost(req, res);
        } catch (IOException e) {
        } catch (ServletException e) {
        }
    }

}