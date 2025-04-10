
import Business.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 *Author: Garrett Womack
 *Date: 09-13-2024
 */

/**
 * Handles Searching products and putting the filtered product into session
 * @author garrett
 */
@WebServlet(urlPatterns = {"/SearchProductsServlet"})
public class SearchProductsServlet extends HttpServlet {

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
        
        String query = request.getParameter("query");

        // Create a list of products
        List<Map<String, String>> allProducts = new ArrayList<>();
        allProducts.add(createProduct("Calculator", "images/caculater.jpg", "$12.00"));
        allProducts.add(createProduct("Computer", "images/computer.jpg", "$450.00"));
        allProducts.add(createProduct("Laptop", "images/laptop.jpg", "$800.00"));
        allProducts.add(createProduct("Paper", "images/paper.jpeg", "$2.34"));
        allProducts.add(createProduct("Sharpies", "images/sharpies.jpg", "$11.50"));
        allProducts.add(createProduct("Sticky Notes", "images/Sticknotes.jpg", "$13.50"));
        allProducts.add(createProduct("Tape", "images/Tape.jpg", "$3.50"));

        List<Map<String, String>> filteredProducts = new ArrayList<>();
        for (Map<String, String> product : allProducts) {
            if (product.get("name").toLowerCase().contains(query.toLowerCase())) {
                filteredProducts.add(product);
            }
        }

        // Set the filtered products as an attribute in the request
        request.setAttribute("filteredProducts", filteredProducts);
        
        request.getRequestDispatcher("/searchResults.jsp").forward(request, response);

        // Forward to JSP for rendering
    }

    // Helper function to create product data
    private Map<String, String> createProduct(String name, String image, String price) {
        Map<String, String> product = new HashMap<>();
        product.put("name", name);
        product.put("image", image);
        product.put("price", price);
        return product;
    }
 

   
    /**
     * Handles Get Request.
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
     * Handles Post request.
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
    }

}
