import java.io.IOException;
import java.sql.*;
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
 *Author: Kelvin Manuel
 *Date: 09-13-2024
 */

/**
 * Handles updating order from unfulfilled to fulfilled.
 * @author Kelvin Manuel
 */
@WebServlet("/UpdateOrder")
public class OrderUpdate extends HttpServlet {

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
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String[] orderIDs = request.getParameterValues("fulfilledOrders");

        if (orderIDs != null) {
            try {
                // Database connection setup
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection con = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
                Statement stmt = con.createStatement();

                // Iterate over each selected orderID and update its fulfillment status
                for (String orderID : orderIDs) {
                    String sql = "UPDATE Order SET OrderFulfilled = true WHERE OrderID = '" + orderID + "'";
                    stmt.executeUpdate(sql);
                }

                con.close();

                // Redirect back to the list of unfulfilled orders after update
                response.sendRedirect("UnfulfilledOrders");
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * terminates servlet.
     */
    @Override
    public void destroy() {
   }
}