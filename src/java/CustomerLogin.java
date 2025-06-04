/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Business.CartList;
import Business.Customer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * Handles searching customer with given ID and ensuring the entered password and 
 * password stored in the database match. If they match the customer is put into session and 
 * logged in.
 * @author Brendan Stroud
 */
@WebServlet(name = "CustomerLogin", value = "/CustomerLogin")
public class CustomerLogin extends HttpServlet {

    /**
     * initializes servlet.
     */
    @Override
    public void init() {
        System.out.println("Servlet Initiated");
    }

    /**
     * Handles Post request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String idInput = request.getParameter("custID");
        String pwInput = request.getParameter("custPass");
        System.out.println("Input ID: " + idInput + "\nInput Password: " + pwInput);

        Customer c1 = new Customer();
        c1.selectDB(idInput);

        String idDB = c1.getCustID();
        String pwDB = c1.getPasswd();
        System.out.println("Database ID: " + idDB + "\nDatabase Password: " + pwDB );

        HttpSession session = request.getSession();
        session.setAttribute("c1", c1);
        session.setAttribute("customerId", c1.getCustID());
        session.setAttribute("customerPassword", c1.getPasswd());

        String url;
        RequestDispatcher requestDispatcher;

        if(pwDB.equals(pwInput)) {
            CartList cart = c1.getCartList();
            session.setAttribute("cart", cart);
            url = "/DisplayCustomerInfo.jsp";
            requestDispatcher = request.getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
        } else {
            url = "/errorPage.jsp";
            requestDispatcher = request.getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
        }
    }

    /**
     * terminates servlet.
     */
    @Override
    public void destroy() {
       
    }
}

