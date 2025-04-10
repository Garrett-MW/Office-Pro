<%-- 
    Document   : searchResultsAccount
    Created on : Nov 26, 2024, 3:33:30 PM
    Author     : Garrett Womack / Tanya Cruz
--%>

<%@page import="Business.Customer"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>Office Pro | Search Results</title>
</head>

<body>
    <header>
        <%
        Customer cust = (Customer)session.getAttribute("c1");
        if(cust != null){%>
        
        <a href="products.jsp" class="logo">Office Pro</a>
        <nav>
            <ul>
                <li><a href="products.jsp" class="button">Products</a></li>
                <li><a href="cart.jsp" class="button">Checkout</a></li>
                <li><a href="customerOrders.jsp" class="button">My Orders</a></li>
                <li><a href="DisplayCustomerInfo.jsp" class="button">Account</a></li>
                <li><a href="LogOutServlet" class="button">Log Out</a></li>
            </ul>
        </nav>
        
        <%}else{%>
        
        <a href="LogOutServlet" class="logo">Office Pro</a>
        <nav>
            <ul>
                <li><a href="products.jsp" class="button">Products</a></li>
                <li><a href="cart.jsp" class="button">Checkout</a></li>
                <li><a href="createCustomerAccount.jsp" class="button">Create Account</a></li>
            </ul>
        </nav>
        
        <%}%>
        <!-- Search Form -->
        <form id="search-form" action="SearchProductsServlet" method="post">
            <input type="text" id="search-query" name="query" placeholder="Search products...">
            <button type="submit" id="searchBtn">Search</button>
        </form>
    </header>

    <section class="office-supplies">
        <h2>Search Results</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>
    <div class="preventOverlap">
    <main id="resultsContainer">
        <%
            // Get the filtered products from the request attribute
            List<Map<String, String>> filteredProducts = (List<Map<String, String>>) request.getAttribute("filteredProducts");

            if (filteredProducts != null && !filteredProducts.isEmpty()) {
                for (Map<String, String> product : filteredProducts) {
                    String name = product.get("name");
                    String image = product.get("image");
                    String price = product.get("price");
                   
                    out.println("<div id='productContainer'>");
                    out.println("<div class='product'>");
                    out.println("<img src='" + image + "' alt='" + name + "' class='product-image'>");
                    out.println("<h2 class='product-name'>" + name + "</h2>");
                    out.println("<p class='product-price'>" + price + "</p>");
                    out.println("<div class='cart-controls'>");
                    out.println("<input type='number' class='quantity' min='1' value='1'>");
                    out.println("<button type='submit' class='add-to-cart'>");
                    out.println("<img src='images/cart.jpg' alt='Add to Cart'>");
                    out.println("Add to Cart");
                    out.println("</button>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
        
                }
            } else {
                out.println("No products found matching your query.");
            }
        %>
    </main>
    </div>
    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>

    <script src="scripts.js"></script>
</body>
</html>
