import Business.Orders;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
 * Handles retrieving all unfulfilled orders from orders table and putting them into session.
 * @author Brendan Stroud
 */
@WebServlet("/UnfulfilledOrders")
public class UnfulfilledOrders extends HttpServlet {

    /**
     * initializes servlet.
     * @throws ServletException
     */
    @Override
   public void init() throws ServletException {
   }
    
    /**
     * Handles Get Request.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Orders> ordersList = new ArrayList<>();  // Create an empty list to store the orders

        try {
            // Database connection setup
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
            Statement stmt = con.createStatement();

            // SQL query to pull orders where OrderFulfilled is false (unfulfilled orders)
            String sql = "SELECT * FROM Order WHERE OrderFulfilled = false";
            ResultSet rs = stmt.executeQuery(sql);

            // Loop through the result set and add each unfulfilled order to the list
            while (rs.next()) {
                String orderID = rs.getString("OrderID");
                String custID = rs.getString("CustID");
                String prodCode = rs.getString("prodCode");
                String prodName = rs.getString("prodName");
                boolean orderDel = rs.getBoolean("OrderFulfilled");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String addr = rs.getString("addr");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int quantity = rs.getInt("quantity");
                double cost = rs.getDouble("cost");

                // Create a new Orders object with all fields
                Orders order = new Orders(orderID, custID, prodCode, prodName, orderDel, firstName, lastName, addr, email, phone, quantity, cost);

                // Add the order to the list
                ordersList.add(order);
            }

            con.close();  // Close the database connection
        } catch (Exception e) {
            e.printStackTrace();  // Handle any exceptions
        }
        
        HttpSession session = request.getSession();
        // Set the orders list as a request attribute
        session.setAttribute("ordersList", ordersList);

        // Forward the request to the JSP page to display the unfulfilled orders
        RequestDispatcher dispatcher = request.getRequestDispatcher("unfulfilledOrders.jsp");
        dispatcher.forward(request, response);
    }
    
    /**
     * terminates servlet.
     */
    @Override
    public void destroy() {
   }
}