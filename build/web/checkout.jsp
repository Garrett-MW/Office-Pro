<%-- 
    Document   : checkoutAutofill
    Created on : Nov 26, 2024, 2:57:27 PM
    Author     : Tanya Cruz / Garrett Womack 
--%>

<%@page import="Business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Office Pro | Checkout | Account Logged In</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
    <header>
        <%
        Customer c1 = (Customer) session.getAttribute("c1");
        if(c1 != null){%>
            
            <a href="products.jsp" class="logo">Office Pro</a>
            <nav>
                <ul>
                    <li><a href="products.jsp" class="button">Products</a></li>
                    <li><a href="checkout.jsp" class="button">Checkout</a></li>
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
                    <li><a href="checkout.jsp" class="button">Checkout</a></li>
                    <li><a href="createCustomerAccount.jsp" class="button">Create Account</a></li>
                </ul>
            </nav>
        <%}%>
        <!-- Search Form -->
        <form id="search-form" action="SearchProductsServlet" method="post" aria-label="Search for office products">
            <input type="search" id="search-query" name="query" placeholder="Search products..." aria-label="Search products" required>
            <button type="submit" id="searchBtn">Search</button>
        </form>
    </header>

    <section class="office-supplies">
        <h2>Cart Summary</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>

    <main>
        <div class="container">
            <div class="checkoutLayout">
                <div class="returnCart">
                    <a href="products.jsp" class="button">Continue Shopping</a>
                </div>

                <h1>Cart Summary</h1>

                <!-- Clear Cart Button -->
                

                <div class="list" id="cart-items">
                    <div class="cart-item">
                        <div class="item-name">Product 1</div>
                        <div class="item-quantity">
                            <button class="quantity-button" data-action="decrease">-</button>
                            <input type="number" class="quantity-input" value="1" min="1" aria-label="Quantity">
                            <button class="quantity-button" data-action="increase">+</button>
                        </div>
                        <div class="item-price">$0</div>
                        <button class="remove-button" aria-label="Remove item">Remove</button>
                    </div>
                    <!-- Add more cart items as needed -->
                </div>
                
                <div class="right">
                    
                <%
                if(c1 != null){%>
                
                    <h1>Checkout</h1>
                    <form class="form" aria-label="Checkout form">
                        <div class="group">
                            <label for="full-name">Full Name</label>
                            <input type="text" name="full-name" id="full-name" value="<%= c1.getFirstName() + c1.getLastName()%>"aria-required="true" required>
                        </div>
                        <div class="group">
                            <label for="phone">Phone Number</label>
                            <input type="tel" name="phone" id="phone" pattern="[0-9]{10}" value="<%= c1.getPhone()%>" aria-required="true" required>
                        </div>
                        <div class="group">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" value="<%= c1.getEmail()%>" aria-required="true" required>
                        </div>
                        <div class="group">
                            <label for="address">Address</label>
                            <input type="text" name="address" id="address" value="<%= c1.getAddr()%>" aria-required="true" required>
                        </div>
                        <div class="group">
                            <label for="county">County</label>
                            <select name="county" id="county" aria-required="true" required>
                                <option value="">Select County</option>
                                <option value="county1">Cobb</option>
                                <option value="county2">Cherokee</option>
                            </select>
                        </div>
                        <button type="submit"  id ="buttonCheckout" class="buttonCheckout">Submit</button>
                    </form>
                        
                    <%}else{%>
                    
                    <h1>Checkout</h1>
                    <form class="form" aria-label="Checkout form">
                        <div class="group">
                            <label for="full-name">Full Name</label>
                            <input type="text" name="full-name" id="full-name" placeholder="Full Name"aria-required="true" required>
                        </div>
                        <div class="group">
                            <label for="phone">Phone Number</label>
                            <input type="tel" name="phone" id="phone" pattern="[0-9]{10}" placeholder="(xxx)xxx-xxxx" aria-required="true" required>
                        </div>
                        <div class="group">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" placeholder="Email" aria-required="true" required>
                        </div>
                        <div class="group">
                            <label for="address">Address</label>
                            <input type="text" name="address" id="address" placeholder="Address" aria-required="true" required>
                        </div>
                        <div class="group">
                            <label for="county">County</label>
                            <select name="county" id="county" aria-required="true" required>
                                <option value="">Select County</option>
                                <option value="county1">County 1</option>
                                <option value="county2">County 2</option>
                            </select>
                        </div>
                        <button type="submit"  id ="buttonCheckout" class="buttonCheckout">Submit</button>
                    </form>
                    
                    <%}%>
                    
                    <div class="return">
                        <div class="row">
                            <div>Total Quantity</div>
                            <div class="totalQuantity">1</div>
                        </div>
                        <div class="row">
                            <div>Total Price</div>
                            <div class="totalPrice">$50</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        
    </main>

    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>

    <script src="scripts.js"></script>
</body>
</html>

