
import Business.Employee;
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
 * Handles updating employee information in the database.
 * @author Brendan Stroud
 */
@WebServlet(
   name = "EmployeeUpdate",
   value = {"/EmployeeUpdate"}
)
public class EmployeeUpdate extends HttpServlet {

    /**
     * initializes servlet.
     * @throws ServletException
     */
    @Override
   public void init() throws ServletException {
   }

    /**
     * Handles Post request.
     * @param request
     * @param response
     */
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) {
      response.setContentType("text/html");
      HttpSession session = request.getSession();
      Employee e1 = (Employee)session.getAttribute("e1");

      try {
         PrintWriter out = response.getWriter();

         try {
            String id = request.getParameter("employeeId");
            String pw = request.getParameter("employeePassword");
            String firstName = request.getParameter("employeeFirstName");
            String lastName = request.getParameter("employeeLastName");
            String address = request.getParameter("employeeAddress");
            String email = request.getParameter("employeeEmail");
            String phone = request.getParameter("employeePhone");
            System.out.println("Form Data: \nEmployeeID: " + id + "Password: " + pw + "Name: " + firstName + " " + lastName + "Address: " + address + "Email: " + email + "Phone: " + phone);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
            Statement statement = connection.createStatement();

            try {
               String sql = "UPDATE Employee SET passwd = '" + pw + "',firstName = '" + firstName + "',lastName = '" + lastName + "',addr = '" + address + "',email = '" + email + "',phone = '" + phone + "'WHERE id = '" + id + "'";
               System.out.println(sql);
               int n1 = statement.executeUpdate(sql);
               if (n1 == 1) {
                  System.out.println("Employee Information updated!");
               } else {
                  System.out.println("INSERT FAILED");
               }

               connection.close();
               String employeeID = e1.getId();
               e1.selectDB(employeeID);
            } catch (Exception var19) {
               System.out.println(var19);
            }

            e1.selectDB(id);
            session.setAttribute("e1", e1);
            RequestDispatcher rd = request.getRequestDispatcher("/DisplayEmployeeInfo.jsp");
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
         System.out.println("Exception in EmployeeUpdate" + String.valueOf(var21));
      }

   }

    /**
     * terminates servlet.
     */
    @Override
    public void destroy() {
   }
}
