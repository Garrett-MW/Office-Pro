
<%@page import="Business.Orders"%>
<%--
  Author: Garrett Womack / Tanya Cruz
  Date: 11/25/2024
  Time: 2:00 PM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Unfulfilled Orders</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <h1>Office Pro</h1>
        <nav>
            <ul>
                <li><a href="createAccountEmployee.jsp" class="button">Create Acct</a></li>
                <li><a href="DisplayEmployeeInfo.jsp" class="button">Account</a><li>
                <li><a href="UnfulfilledOrders" class="button">Open Orders</a><li>
                <li><a href="LogOutServlet" class="button">Log Out</a></li>
            </ul>
        </nav>
</header>

<main>
    <div class="preventOverlap">
        <h2>Orders Pending Fulfillment</h2>

        <!-- Form for updating order fulfillment status -->
        <form id="unfulfilledForm" action="OrderUpdate" method="POST">
            <table border="1">
                <thead>
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
                </tr>
                </thead>
                <tbody>
                <%-- Scriptlet to loop through the ordersList --%>
                <%
                    List<Orders> ordersList = (List<Orders>)session.getAttribute("ordersList");
                    for (Orders order : ordersList) {
                %>
                <tr>
                    <td><%= order.getOrderID() %></td>
                    <td><%= order.getCustID() %></td>
                    <td><%= order.getProdCode() %></td>
                    <td><%= order.getProdName() %></td>
                    <td><%= order.getFirstName() %></td>
                    <td><%= order.getLastName() %></td>
                    <td><%= order.getAddr() %></td>
                    <td><%= order.getEmail() %></td>
                    <td><%= order.getPhone() %></td>
                    <!-- Checkbox to mark the order as fulfilled -->
                    <td>
                        <input type="checkbox" name="fulfilledOrders" value="<%= order.getOrderID() %>">
                    </td>
                    <td><%= order.getCost() %></td>
                    <td><%= order.getQuantity() %></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
            <button type="submit" id="searchBtn">Update Fulfillment Status</button>
        </form>
    </div>
</main>

<footer>
    <p>&copy; 2024 Office Pro. All rights reserved.</p>
</footer>
</body>
</html>

