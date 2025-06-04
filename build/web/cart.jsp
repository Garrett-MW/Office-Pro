
<%-- 
    Document   : DisplayCustomerInfo
    Author     : Tanya Cruz / Garrett Womack 
    Class      : Java 3 / Professor Enz
--%>
<%@page import="Business.CartList"%>
<%@page import="Business.CartItem"%>
<%@page import="Business.Customer"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        
    <%
    Customer customer = (Customer)session.getAttribute("c1");
    if(customer != null){%>
    
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
        
        <form id="search-form" action="SearchProductsServlet" method="post">
        <input type="text" id="search-query" name="query" placeholder="Search products...">
        <button type="submit" id="searchBtn">Search</button>
    </form>
</header>

<section class="office-supplies">
    <h2>Customer Cart</h2>
    <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
</section>

<main>
    <div class="container">
        <div class="checkoutLayout">
            <h1 style="color: #92221a;">Cart Summary</h1>
            <div class="list" id="cart-items">
                <div class="cart-item">
                    <div><h3>Product Name</h3></div>
                    <div><h3>Quantity</h3></div>
                    <div><h3>Price</h3></div>
                </div>
                
                <%
                   session = request.getSession(false);
                   if (session == null) {
                        session = request.getSession(true);
                    }
                    CartList cart = (CartList)session.getAttribute("cart");
                    if (cart == null) {
                        cart = new CartList();
                    }

                    double totalCost = 0.0;
                    String name = null;
                    List <CartItem> cartList = cart.getCartItems();
                    for(CartItem cartItem : cartList) {
                        name = cartItem.getProductName();
                        double price = cartItem.getPrice();
                        int quantity = cartItem.getQuantity();
                        String prodCode = cartItem.getProductCode();
                        totalCost += price * quantity;
                %>
                <hr>
                <div class="cart-item">
                    <div><%=name%></div>
                    <div><%=quantity%></div>
                    <div>$<%=price%></div>
                </div>
                

                <!-- Dynamically pass each product's details in hidden fields -->
                <input type="hidden" name="prodCode" value="<%=prodCode%>">
                <input type="hidden" name="prodName" value="<%=name%>">
                <input type="hidden" name="quantity" value="<%=quantity%>">
                <input type="hidden" name="price" value="<%=price%>">

                <%
                    }
                %>
                <hr>
                <div class="cart-item">
                    <div>Total Price: $<%=totalCost%></div>
                </div>
            </div>
            
            <%if(customer != null){%>
            
            <div id="checkoutContainer">
                <h1 style="color: #92221a;">Checkout</h1>
                <form id="checkoutForm" action="CreateOrder" method="post">
                        <div id="checkoutFormGrid">
                            <div class="checkoutField">
                                <label for="first-name">First Name</label>
                                <input type="text" name="first-name" value="<%= customer.getFirstName()%>">
                            </div>
                            <div class="checkoutField">
                                <label for="last-name">Last Name</label>
                                <input type="text" name="last-name" value="<%= customer.getLastName()%>">
                            </div>
                            <div class="checkoutField">
                                <label for="address">Address</label>
                                <input type="text" name="address" value="<%= customer.getAddr()%>">
                            </div>
                            <div class="checkoutField">
                                <label for="email">Email</label>
                                <input type="email" name="email" value="<%= customer.getEmail()%>">
                            </div> 
                            <div class="checkoutField">
                                <label for="phone">Phone</label>
                                <input type="tel" name="phone" value="<%= customer.getPhone()%>">
                            </div>
                           
                            <input type="hidden" name="totalCost" value="cost">
                        </div>
                        <div id="checkoutBtn">
                            <button type="submit" id="searchBtn">Submit Order</button>
                        </div>
                        <h4 id ="buttonCheckout"></h4>
                    </form>
            </div>
                            
            <%}else{%>
            
                <div id="checkoutContainer">
                <h1 style="color: #92221a;">Checkout</h1>
                <form id="checkoutForm" action="CreateOrder" method="post">
                        <div id="checkoutFormGrid">
                            <div class="checkoutField">
                                <label for="first-name">First Name</label>
                                <input type="text" name="first-name" placeholder="First Name" required>
                            </div>
                            <div class="checkoutField">
                                <label for="last-name">Last Name</label>
                                <input type="text" name="last-name" placeholder="Last Name" required>
                            </div>
                            <div class="checkoutField">
                                <label for="address">Address</label>
                                <input type="text" name="address" placeholder="Address" required>
                            </div>
                            <div class="checkoutField">
                                <label for="email">Email</label>
                                <input type="email" name="email" placeholder="Email" required>
                            </div> 
                            <div class="checkoutField">
                                <label for="phone">Phone</label>
                                <input type="tel" name="phone" placeholder="Phone" required>
                            </div>
                            
                            <input type="hidden" name="totalCost" value="cost">
                        </div>
                        <div id="checkoutBtn">
                            <button type="submit" id="searchBtn">Submit Order</button>
                        </div>
                        <h4 id ="buttonCheckout"></h4>
                </form>
                </div>
                
            <%}%>
            
        </div>
    </div>
            
</main>

<footer>
    <p>&copy; 2024 Office Pro. All rights reserved.</p>
</footer>

</body>
</html>
