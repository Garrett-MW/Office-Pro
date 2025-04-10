<%-- 
    Document   : orderConfirmation
    Created on : Nov 15, 2024, 11:40:00 AM
    Author     : Tanya Cruz / Garrett Womack
--%>

<%@page import="Business.Customer"%>
<%@page import="Business.Orders"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
    <title>Order</title>
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
                <li><a href="checkout.jsp" class="button">Checkout</a></li>
                <li><a href="customerOrders.jsp" class="button">My Orders</a></li>
                <li><a href="DisplayCustomerInfo.jsp" class="button">Account</a></li>
                <li><a href="index.jsp" class="button">Log Out</a></li>
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
        <h2>Thank You!</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>
        <main>
            <main>
                <section class="confirmation">
                    <h2>Thank you for your order!</h2>
                    <p>Your order has been successfully placed.</p>
                    <%
                        Orders order = (Orders)session.getAttribute("order");
                    %>
        
                    <!-- Order Summary -->
                    <div class="order-summary">
                        <h3>Order Summary</h3>
                        <p><strong>Order ID:</strong> <%= order.getOrderID()%></p>
                        <p><strong>Customer ID:</strong> <%= order.getCustID()%></p>
                        <p><strong>Name:</strong> <%= order.getFirstName()%> <%= order.getLastName()%></p>
                        <p><strong>Email:</strong> <%= order.getEmail()%></p>
                        <p><strong>Phone:</strong> <%= order.getPhone()%></p>
                        <p><strong>Shipping Address:</strong> <%= order.getAddr()%></p>
                        <p><strong>Total Price:</strong> <%= order.getCost()%></p>
        
                        <h4><strong>Items Ordered:</strong> <%= order.getQuantity()%></h4>
 
                    </div>
        
                    <!-- Shipping Information -->
                    <div class="shipping-info">
                        <h3>Shipping Information</h3>
                        <p>Your items will be shipped to the address you provided and should arrive within 5-7 business days.</p>
                    </div>
        
                    <!-- CTA to Continue Shopping -->
                    <div class="continue-shopping">
                        <a href="products.jsp" class="button">Continue Shopping</a>
                    </div>


            
        </main>
        <footer>
            <p>&copy; 2024 Office Pro. All rights reserved.</p>
        </footer>

    
    <script src="scripts.js"></script>
</body>
</html>
