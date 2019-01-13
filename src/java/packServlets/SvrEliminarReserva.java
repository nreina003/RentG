/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import packBD.Conexion;
import packServlets.SvrConsultarReservas;

/**
 *
 * @author ADMIN
 */
public class SvrEliminarReserva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
         Integer pIdr = Integer.parseInt(request.getParameter("idr"));
        if(pIdr==null){
        JOptionPane.showMessageDialog(null, "No hay ninguna reserva seleccionada", "RentG02", JOptionPane.WARNING_MESSAGE);
        response.sendRedirect("loguearse.jsp");
        }else if(SvrConsultarReservas.getInstance().eliminarReserva(pIdr)){
        JOptionPane.showMessageDialog(null, "Reserva correctamente anulada", "RentG02", JOptionPane.WARNING_MESSAGE);
        response.sendRedirect("loguearse.jsp");
        }else{
            JOptionPane.showMessageDialog(null, "Reserva no anulada", "RentG02", JOptionPane.WARNING_MESSAGE);
            response.sendRedirect("loguearse.jsp");
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
