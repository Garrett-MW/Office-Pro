
import Business.CartItem;
import Business.CartList;
import Business.Customer;
import Business.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 *Term: Fall 2024
 *Instructor: Ron Enz
 *Description: OfficeSupplyProject
 *Author: Brendan Stroud
 *Date: 09-13-2024
 */

/**
 * Handles creating order object and inserting it into orders table.
 * @author Brendan Stroud
 */
@WebServlet(name = "CreateOrder", value = "/CreateOrder")
public class CreateOrder extends HttpServlet {
    
    /**
     * intializes servlet
     * @throws ServletException
     */
    @Override
public void init() throws ServletException {
   }

    /**
     * Handles Post request.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(); // Create a session if it doesn't exist
        CartList cartList = (CartList)session.getAttribute("cart");
        if (cartList == null) {
            cartList = new CartList();
        }

        // Retrieve user data from form
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String addr = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Calculate total cost based on cart
        double totalCost = 0.0;
        List<CartItem> cart = cartList.getCartItems();
        for (CartItem cartItem : cart) {
            double price = cartItem.getPrice();
            int quantity = cartItem.getQuantity();
            totalCost += price * quantity;
        }

        // Create the order object
        Orders order = new Orders();

        // Generate unique OrderID and CustID
        String orderID = UUID.randomUUID().toString();
        orderID = orderID.substring(24);  //shorten string 
        
        Customer cust = (Customer)session.getAttribute("c1"); //retrieve customer from session 
        String custID = "";
        if(cust != null){
            custID = cust.getCustID(); //if customer is logged in use thir custID
        } else{
            custID = UUID.randomUUID().toString(); //create random CustID if customer is not logged in
            custID = custID.substring(24); //shorten string
        }
        

        try (PrintWriter out = response.getWriter()) {
        // Database connection and insertion
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");

        // Iterate through the cart and insert each product into the Order table
            for (CartItem cartItem : cart) {
                String prodCode = cartItem.getProductCode();
                String prodName = cartItem.getProductName();
                int quantity = cartItem.getQuantity();
                double price = cartItem.getPrice();
                double itemCost = price * quantity;

        // Insert into the Order table
                String sql = "INSERT INTO Order (OrderID, CustID, prodCode, prodName, Quantity, Cost, firstName, lastName, addr, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pStmt = connection.prepareStatement(sql);
                pStmt.setString(1, orderID);
                pStmt.setString(2, custID);
                pStmt.setString(3, prodCode);
                pStmt.setString(4, prodName);
                pStmt.setInt(5, quantity);
                pStmt.setDouble(6, itemCost);
                pStmt.setString(7, firstName);
                pStmt.setString(8, lastName);
                pStmt.setString(9, addr);
                pStmt.setString(10, email);
                pStmt.setString(11, phone);
                
                order.setCost(itemCost);
                order.setQuantity(quantity);
                order.setFirstName(firstName);
                order.setLastName(lastName);
                order.setCustID(custID);
                order.setAddr(addr);
                order.setEmail(email);
                order.setPhone(phone);
                order.setOrderID(orderID);

        // Execute the insert query
                int n = pStmt.executeUpdate();
                if (n == 1) {
                    System.out.println("INSERT Successful for product: " + prodName);
                    session.setAttribute("order", order);
                    
                 // Forward to the confirmation page
                    RequestDispatcher rd = request.getRequestDispatcher("/orderConfirmation.jsp");
                    rd.forward(request, response);
                } else {
                    System.out.println("INSERT FAILED for product: " + prodName);
                }
                connection.close();
            }
            
        } catch (Exception e) {
            System.out.println("Exception during SQL insert: " + e);
        } 
        
    }

    /**
     * terminates servlet
     */
    @Override
    public void destroy() {
   }

}