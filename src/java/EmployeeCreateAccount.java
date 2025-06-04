
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
import java.sql.PreparedStatement;

/*
 *Class:
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Brendan Stroud
 *Date: 09-13-2024
 */

/**
 * Handles creating employee object and inserting it into employees table.
 * @author Brendan Stroud
 */
@WebServlet(
   name = "EmployeeCreateAccount",
   value = {"/EmployeeCreateAccount"}
)
public class EmployeeCreateAccount extends HttpServlet {
    
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
      if (e1 == null) {
         e1 = new Employee();
      }

      try {
         PrintWriter out = response.getWriter();

         try {
            String empID = request.getParameter("empID");
            String passwd = request.getParameter("passwd");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String addr = request.getParameter("addr");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            e1.setId(empID);
            e1.setPasswd(passwd);
            e1.setFirstName(firstName);
            e1.setLastName(lastName);
            e1.setEmail(email);
            e1.setPhone(phone);
            e1.setAddr(addr);
            System.out.println(empID + " " + passwd + " " + firstName + " " + lastName + "\n");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");

            try {
               String sql = "INSERT INTO Employee(id, passwd, firstName, lastName, email, phone, addr) Values(?,?,?,?,?,?,?)";
               PreparedStatement pStmt = connection.prepareStatement(sql);
               System.out.println("SQL: " + sql);
               pStmt.setString(1, empID);
               pStmt.setString(2, passwd);
               pStmt.setString(3, firstName);
               pStmt.setString(4, lastName);
               pStmt.setString(5, email);
               pStmt.setString(6, phone);
               pStmt.setString(7, addr);
               int n = pStmt.executeUpdate();
               if (n == 1) {
                  System.out.println("INSERT Successful!");
                  session.setAttribute("e1", e1);
                  RequestDispatcher rd = request.getRequestDispatcher("/DisplayEmployeeInfo.jsp");
                  rd.forward(request, response);
               } else {
                  System.out.println("INSERT FAILED!");
                  RequestDispatcher rd = request.getRequestDispatcher("/errorPage.jsp");
                  rd.forward(request, response);
               }

               connection.close();
            } catch (Exception var18) {
               System.out.println("Exception during SQL insert: " + String.valueOf(var18));
            }

         } catch (Throwable var19) {
            if (out != null) {
               try {
                  out.close();
               } catch (Throwable var17) {
                  var19.addSuppressed(var17);
               }
            }

            throw var19;
         }

         if (out != null) {
            out.close();
         }
      } catch (Exception var20) {
         System.out.println("Exception in Account Creation: " + String.valueOf(var20));
      }

   }
   
    /**
     * Terminates servlet.
     */
    @Override
    public void destroy() {
       
    }
}
