/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Business.Employee;
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
 * Handles searching for employee associated with entered ID and ensuring the entered password 
 * matched the password in the database. If they match, the employee is put into session and logged in.
 * @author Brendan Stroud
 */
@WebServlet(name = "EmployeeLogin", value = "/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {

    /**
     * initializes servlet.
     */
    @Override
    public void init() {
        System.out.println("Servlet Initiated");
    }

    /**
     * Handles Post Request.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        String idInput = request.getParameter("empID");
        String pwInput = request.getParameter("empPass");
        System.out.println("Input ID: " + idInput + "\nInput PW: " + pwInput);

        Employee e1 = new Employee();
        e1.selectDB(idInput);

        String idDB = e1.getId();
        String pwDB = e1.getPasswd();
        System.out.println("DBID: " + idDB + "\nDBPW: " + pwDB );

        HttpSession session = request.getSession();
        session.setAttribute("e1", e1);
        session.setAttribute("employeeID", e1.getId());
        session.setAttribute("employeePW", e1.getPasswd());

        String url;
        RequestDispatcher requestDispatcher;

        if(pwDB.equals(pwInput)) {
            url = "/DisplayEmployeeInfo.jsp";
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

   