<%-- 
    Document   : employeeUpdate
    Created on : Nov 25, 2024, 1:58:13 PM
    Author     : Tanya Cruz / Garrett Womack / Brendan Stroud
--%>

<%@page import="Business.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>Office Supply | Update Employee Profile</title>
        <%
            Employee e1 = (Employee) session.getAttribute("e1");
            e1.display();
        %>
    </head>
    <body>
<div class="container">
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
    
    <section class="office-supplies">
        <h2>Update Account Info</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>
    
    <main>
        <div class="flex-box-container">
            <h1>Current Account Info</h1>
            <form class="updateForm" action="EmployeeUpdate" method="post">
                <div class="hiddenInfo">
                    <input type="hidden" name="employeeId" id="employeeId" value="<%=e1.getId()%>">
                    <input type="hidden" name="employeePassword" id="employeePassword" value="<%=e1.getPasswd()%>">
                </div>
                <div class="update-input">
                    <label for="firstName"><span>First and Last Name</span>:</label>
                    <input type="text" name="employeeFirstName" id="employeeFirstName" value="<%=e1.getFirstName()%>"> <input type="text" name="employeeLastName" id="employeeLastName" value="<%=e1.getLastName()%>">
                </div>
                <div class="update-input">
                    <label for="addr"><span>Address</span>:</label>
                    <input type="text" name="employeeAddress" id="employeeAddress" value="<%=e1.getAddr()%>">
                </div>
                <div class="update-input">
                    <label for="email"><span>Email</span>:</label>
                    <input type="text" name="employeeEmail" id="employeeEmail" value="<%=e1.getEmail()%>">
                </div>
                <div class="update-input">
                    <label for="phone"><span>Phone</span>:</label>
                    <input type="text" name="employeePhone" id="employeePhone" value="<%=e1.getPhone()%>">
                </div>
                <div>
                    <button id="submitUpdateBtn" type="submit">Submit Changes</button>
                </div>
            </form>
            <br>
            <hr><!-- comment -->
            <br>
    </main>
    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>
  </body>
</html>
