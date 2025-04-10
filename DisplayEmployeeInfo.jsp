<%-- 
    <%-- 
    Document   : DisplayCustomerInfo
    Author     : Garrett Womack / Tanya Cruz
    Class      : Java 3 / Professor Enz
--%>

<%@page import="Business.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Office Pro | Employee Info</title>
    <link rel="stylesheet" href="styles.css">
    <%
        Employee employee = (Employee) session.getAttribute("e1");
        employee.display();
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
        <h2>Account Info</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>
    <main>
        <div class="flex-container">
            <h1>Login Successful!</h1>
        <!-- Display patient info & update button -->
           
                <div class="flex-box">
                    <div><span>ID</span>: <%=employee.getId()%></div>
                    <div><span>Name</span>: <%=employee.getFirstName()%> <%=employee.getLastName()%></div>
                    <div><span>Email</span>: <%=employee.getEmail()%></div>
                    <div><span>Address</span>: <%=employee.getAddr()%></div>
                    <div><span>Phone No</span>: <%=employee.getPhone()%></div>
                    <div class="spaceBetween"></div>
                    <div>
                        <button name="goToUpdateBtn" id="goToUpdateBtn" onclick="window.location.href = 'employeeUpdate.jsp';">Update Info</button>
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