

import Business.CartList;
import Business.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 *Class: CIST2931 Advanced Systems Project
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Garrett Womack
 *Date: 12/8/2024
 */

/**
 * Used for customers that continue with no account. Creates a new cartList object and puts 
 * it into session for later access.
 * @author garrett
 */
public class ContinueWithNoAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        try{
            
            Customer cust = new Customer();
            CartList cart = new CartList();
            HttpSession session = request.getSession();
            session.setAttribute("noAccount", cust);
            session.setAttribute("cart", cart);
            
            RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
            rd.forward(request, response);
            
            
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    /**
     * Handles Get request.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles Post request.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Displays servlet info.
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
