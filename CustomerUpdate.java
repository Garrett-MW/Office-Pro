
import Business.Customer;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 *Class:
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Brendan Stroud
 *Date: 09-13-2024
 */


/**
 * Handles updating customer information in the database.
 * @author Brendan Stroud
 */
@WebServlet(
   name = "CustomerUpdate",
   value = {"/CustomerUpdate"}
)
public class CustomerUpdate extends HttpServlet {

    /**
     * initializes servlet.
     * @throws ServletException
     */
    @Override
   public void init() throws ServletException {
   }

    /**
     * Handles Post Request.
     * @param request
     * @param response
     */
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) {
      response.setContentType("text/html");
      HttpSession session = request.getSession();
      Customer c1 = (Customer)session.getAttribute("c1");

      try {
         PrintWriter out = response.getWriter();

         try {
            String id = request.getParameter("customerId");
            String pw = request.getParameter("customerPassword");
            String firstName = request.getParameter("customerFirstName");
            String lastName = request.getParameter("customerLastName");
            String address = request.getParameter("customerAddress");
            String email = request.getParameter("customerEmail");
            String phone = request.getParameter("customerPhone");
            System.out.println("Form Data: \nCustomerID: " + id + "Password: " + pw + "Name: " + firstName + " " + lastName + "Address: " + address + "Email: " + email + "Phone: " + phone);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
            Statement statement = connection.createStatement();

            try {
               String sql = "UPDATE Customer SET passwd = '" + pw + "',firstName = '" + firstName + "',lastName = '" + lastName + "',addr = '" + address + "',email = '" + email + "',phone = '" + phone + "'WHERE custId = '" + id + "'";
               System.out.println(sql);
               int n1 = statement.executeUpdate(sql);
               if (n1 == 1) {
                  System.out.println("Customer Information updated!");
               } else {
                  System.out.println("INSERT FAILED");
               }

               connection.close();
               String customerID = c1.getCustID();
               c1.selectDB(customerID);
            } catch (Exception var19) {
               System.out.println(var19);
            }

            c1.selectDB(id);
            session.setAttribute("c1", c1);
            RequestDispatcher rd = request.getRequestDispatcher("/DisplayCustomerInfo.jsp");
            rd.forward(request, response);
         } catch (Throwable var20) {
            if (out != null) {
               try {
                  out.close();
               } catch (Throwable var18) {
                  var20.addSuppressed(var18);
               }
            }

            throw var20;
         }

         if (out != null) {
            out.close();
         }
      } catch (Exception var21) {
         System.out.println("Exception in CustomerUpdate" + String.valueOf(var21));
      }

   }

    /**
     * terminates servlet.
     */
    @Override
   public void destroy() {
   }
}
    
