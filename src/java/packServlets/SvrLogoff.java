package packServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author docencia
 */
public class SvrLogoff extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

       
        HttpSession s = req.getSession(true);
        String email = (String)s.getAttribute("email");
        s.invalidate();
        JOptionPane.showMessageDialog(null,"Realizado con exito por "+ email +"", "RentG02", JOptionPane.WARNING_MESSAGE);
        res.sendRedirect("loguearse.jsp");
    }

}



