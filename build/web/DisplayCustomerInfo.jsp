<%-- 
    Document   : DisplayCustomerInfo
    Author     : Garrett Womack / Tanya Cruz 
    Class      : Java 3 / Professor Enz
--%>

<%@page import="Business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Office Pro | Customer Info</title>
    <link rel="stylesheet" href="styles.css">
    <%
        Customer customer = (Customer) session.getAttribute("c1");
        customer.display();
    %>
</head>
<body>
<div class="container">
    <header>
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

        <!-- Search Form -->
        <form id="search-form" action="SearchProductsServlet" method="post" aria-label="Search for office products">
            <input type="search" id="search-query" name="query" placeholder="Search products..." aria-label="Search products" required>
            <button type="submit" id="searchBtn">Search</button>
        </form>
    </header>
    
    <section class="office-supplies">
        <h2>Account Info</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>
    <main>
        <div class="flex-container">
            <h1>Login Successful!</h1>
        <!-- Display patient info & update button -->
              <div class="flex-box">
                    <div><h3>Customer Information: </h3></div>
                    <div><span>ID</span>: <%=customer.getCustID()%></div>
                    <div><span>Name</span>: <%=customer.getFirstName()%> <%=customer.getLastName()%></div>
                    <div><span>Address</span>: <%=customer.getAddr()%></div>
                    <div><span>Email</span>: <%=customer.getEmail()%></div>
                    <div><span>Phone</span>: <%=customer.getPhone()%></div>
                    <div>
                        <button name="goToUpdateBtn" id="goToUpdateBtn" onclick="window.location.href = 'customerUpdate.jsp';">Update Info</button>
                    </div>
                </div>
    
            <br>
            <hr>
            <br>
         
        </div> 
        </div>
    </main>
    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>
  </body>
</html>
