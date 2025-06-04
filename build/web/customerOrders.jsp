<%-- 
    Document   : customerOrders
    Created on : Oct 9, 2024, 3:54:29 PM
    Author     : Tanya Cruz / Garrett Womack /Brendan Stroud
--%>

<%@page import="Business.Orders"%>
<%@page import="java.util.List"%>
<%@page import="Business.OrderList"%>
<%@page import="Business.Customer"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Office Pro | Customer's Orders</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Teko:wght@300..700&display=swap" rel="stylesheet">
    <style>
        
        table{
            margin: auto;
            text-align: center;
            border: 4px solid black;
            width: 75%;
        }

        table, th, td{
            border: 2px solid black;
            background-color: white;
            padding: 0.5%;
        }

        caption{
            font-size: 30px;
            font-weight: bolder;
            color:#92221a;
        }

        #custOrdersContainer{
            margin: auto;
            box-shadow: 5px 5px 10px grey;
            border-radius: 12px;
            padding: 3%;
            width: 80%;
            background-color:#dbdbdb
        }
        
        #container{
            padding: 5%;
        }

    </style>
</head>
<body>
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
        <form id="search-form" action="SearchProductsServlet" method="post" aria-label="Search for office products">
            <input type="search" id="search-query" name="query" placeholder="Search products..."
                aria-label="Search products" required>
            <button type="submit" id="searchBtn">Search</button>
        </form>
    </header>
    
    <section class="office-supplies">
        <h2>Customers Orders</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>
    <div id="container">
        <div id="custOrdersContainer">
           <table>
                <caption>My Orders</caption>
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Product Code</th>
                    <th>Product Name</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Order Fulfilled</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr><%
                        Customer cust = (Customer)session.getAttribute("c1"); //retrieve customer from session
                        cust.getOrders();
                        OrderList OrderList = cust.getOrderList(); //retieve account list from customer object
                        List <Orders> orders = OrderList.getOrders(); //create a list of accounts and use getAccounts method to populate list
                        for(Orders order : orders){
                %><tr>
                    <td><%= order.getOrderID() %></td>
                    <td><%= order.getCustID() %></td>
                    <td><%= order.getProdCode() %></td>
                    <td><%= order.getProdName() %></td>
                    <td><%= order.getFirstName() %></td>
                    <td><%= order.getLastName() %></td>
                    <td><%= order.getAddr() %></td>
                    <td><%= order.getEmail() %></td>
                    <td><%= order.getPhone() %></td>
                    <td><%= order.getOrderDel()%></td>
                    <td><%= order.getCost() %></td>
                    <td><%= order.getQuantity() %></td>
                            </tr><%
                        }%>
           </table>
        </div>
    </div>
        <footer>
            <p>&copy; 2024 Office Pro. All rights reserved.</p>
        </footer>
</body>
</html>
