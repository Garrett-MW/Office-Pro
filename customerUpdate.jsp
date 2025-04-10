<%-- 
    Document   : customerUpdate
    Created on : Nov 25, 2024, 1:49:39 PM
    Author     : Tanya Cruz / Garrett Womack /Brendan Stroud
--%>

<%@page import="Business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Office Supply | Update Customer Profile</title>
        <link rel="stylesheet" href="styles.css">

        <%
            Customer c1 = (Customer) session.getAttribute("c1");
            c1.display();
        %>
    </head>
    <body>
<div class="container">
    <header>
        <h1>Office Pro</h1>
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
        <form id="search-form" action="SearchProductsServlet" method="get" aria-label="Search for office products">
            <input type="search" id="search-query" name="query" placeholder="Search products..." aria-label="Search products" required>
            <button type="submit" id="searchBtn">Search</button>
        </form>
    </header>
    
    <section class="office-supplies">
        <h2>Update Account Info</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>
    
    <main>
        <div class="flex-box-container">
             <h1>Current Account Info</h1>
            <form class="updateForm" action="CustomerUpdate" method="post">
                <div class="hiddenInfo">
                    <input type="hidden" name="customerId" id="patientId" value="<%=c1.getCustID()%>">
                    <input type="hidden" name="customerPassword" id="customerPassword" value="<%=c1.getPasswd()%>">
                </div>
                <div class="update-input">
                    <label for="firstName"><span>First and Last Name</span>:</label>
                    <input type="text" name="customerFirstName" id="customerFirstName" value="<%=c1.getFirstName()%>"> <input type="text" name="customerLastName" id="customerLastName" value="<%=c1.getLastName()%>">
                </div>
                <div class="update-input">
                    <label for="addr"><span>Address</span>:</label>
                    <input type="text" name="customerAddress" id="customerAddress" value="<%=c1.getAddr()%>">
                </div>
                <div class="update-input">
                     <label for="email"><span>Email</span>:</label>
                    <input type="text" name="customerEmail" id="customerEmail" value="<%=c1.getEmail()%>">
                </div>
                <div class="update-input">
                    <label for="phone"><span>Phone</span>:</label>
                    <input type="text" name="customerPhone" id="customerPhone" value="<%=c1.getPhone()%>">
                </div>
                <div>
                    <button id="submitUpdateBtn" type="submit">Submit Changes</button>
                </div>
            </form>
            <br>
            <hr>
            <br>
    </main>
    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>
  </body>
</html>
