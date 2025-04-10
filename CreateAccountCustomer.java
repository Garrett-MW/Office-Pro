
import Business.CartList;
import Business.Customer;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
/*
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Brendan Stroud
 *Date: 09-13-2024
 */

/**
 * Handles creating customer object and inserting it into customers table.
 * @author Brendan Stroud
 */
@WebServlet(name = "CreateAccountCustomer",value = {"/CreateAccountCustomer"})
public class CreateAccountCustomer extends HttpServlet {
    
    /**
     * intializes servlet.
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
      Customer c1 = (Customer)session.getAttribute("c1");
      if (c1 == null) {
         c1 = new Customer();
      }

      try {
         PrintWriter out = response.getWriter();

         try {
            String custID = request.getParameter("custID");
            String passwd = request.getParameter("passwd");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String addr = request.getParameter("addr");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            c1.setCustID(custID);
            c1.setPasswd(passwd);
            c1.setFirstName(firstName);
            c1.setLastName(lastName);
            c1.setAddr(addr);
            c1.setEmail(email);
            c1.setPhone(phone);
            System.out.println(custID + " " + passwd + " " + firstName + " " + lastName);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            try {
               Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");

               try {
                  String sql = "INSERT INTO Customer(CustId, passwd, firstName, lastName, addr, email, Phone) Values(?,?,?,?,?,?,?)";

                  try {
                     PreparedStatement pStmt = connection.prepareStatement(sql);

                     try {
                        pStmt.setString(1, custID);
                        pStmt.setString(2, passwd);
                        pStmt.setString(3, firstName);
                        pStmt.setString(4, lastName);
                        pStmt.setString(5, addr);
                        pStmt.setString(6, email);
                        pStmt.setString(7, phone);
                        int n = pStmt.executeUpdate();
                        if (n == 1) {
                           System.out.println("INSERT Successful!");
                           CartList cart = new CartList();
                           session.setAttribute("cart", cart);
                           session.setAttribute("c1", c1);
                            RequestDispatcher rd = request.getRequestDispatcher("/DisplayCustomerInfo.jsp");
                            rd.forward(request, response);
                        } else {
                           System.out.println("INSERT FAILED!");
                           RequestDispatcher rd = request.getRequestDispatcher("/errorPage.jsp");
                           rd.forward(request, response);
                        }
                     } catch (Throwable var21) {
                        if (pStmt != null) {
                           try {
                              pStmt.close();
                           } catch (Throwable var20) {
                              var21.addSuppressed(var20);
                           }
                        }

                        throw var21;
                     }

                     if (pStmt != null) {
                        pStmt.close();
                     }
                  } catch (Exception var22) {
                     System.out.println("Error during SQL insert: " + String.valueOf(var22));
                  }
               } catch (Throwable var23) {
                  if (connection != null) {
                     try {
                        connection.close();
                     } catch (Throwable var19) {
                        var23.addSuppressed(var19);
                     }
                  }

                  throw var23;
               }

               if (connection != null) {
                  connection.close();
               }
            } catch (Exception var24) {
               System.out.println("Database connection error: " + String.valueOf(var24));
            }

            
         } catch (Throwable var25) {
            if (out != null) {
               try {
                  out.close();
               } catch (Throwable var18) {
                  var25.addSuppressed(var18);
               }
            }

            throw var25;
         }

         if (out != null) {
            out.close();
         }
      } catch (Exception var26) {
         System.out.println("Exception during account creation: " + String.valueOf(var26));
      }

   }

    /**
     * terminates servlet.
     */
    @Override
   public void destroy() {
   }
}
