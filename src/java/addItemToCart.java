

import Business.CartItem;
import Business.CartList;
import Business.Customer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 *Class:
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Brendan Stroud
 *Date: 09-13-2024
 */

/**
 * Handles adding CartItem object to CartList.
 * @author Brendan Stroud
 */
public class addItemToCart extends HttpServlet {

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
        try{
                
            String productName = request.getParameter("prodName");
            String productPrice = request.getParameter("productPrice");
            double price = Double.parseDouble(productPrice);
            String quantityStr = request.getParameter("quantity");
            String prodCode = request.getParameter("prodCode");

            // Validate quantity
            int quantity = 1;
            if (quantityStr != null) {
                quantity = Integer.parseInt(quantityStr);
            }

            // Create a session if it doesn't exist
            HttpSession session = request.getSession(true);

            // Get the cart from the session or create a new one
            CartList cart = (CartList)session.getAttribute("cart");

            
            CartItem cartItem = new CartItem(productName, price, quantity, prodCode);
            
            // Add product to cart
            cart.addCartItem(cartItem);

            // Save the updated cart in the session
            session.setAttribute("cart", cart);
            
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            rd.forward(request, response);

        } catch(Exception e){
            System.out.println("ERROR: " + e);
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
