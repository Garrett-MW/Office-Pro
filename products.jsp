<%-- 
    Document   : products
    Created on : Nov 15, 2024, 11:40:58 AM
    Author     : Tanya Cruz /Garrett Womack
--%>

<%@page import="Business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>Office Pro | Products</title>
</head>

<body>
    <header> 
        <%Customer cust = (Customer)session.getAttribute("c1");
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
        
        <%} else{%>
        
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
        <h2>Office Supplies</h2>
        <img src="images/supplies.jpg" alt="Office Supplies" class="supplies-image">
    </section>

    <main class="productsContainer">
    <!-- Product 1: Calculator -->
    <form action="addItemToCart" method="post">
        <article class="product">
            <img src="images/caculater.jpg" alt="Calculator" class="product-image">
            <h2 class="product-name">Calculator</h2>
            <p class="product-price">$12.00</p>
            <div class="cart-controls">
                <input type="number" name="quantity" class="quantity" min="1" value="1">
                <input type="hidden" name="prodName" value="Calculator">
                <input type="hidden" name="productPrice" value="12.00">
                <input type="hidden" name="prodCode" value="P114">
                <button type="submit" class="add-to-cart">
                    <img src="images/cart.jpg" alt="Add to Cart">
                    Add to Cart
                </button>
            </div>
        </article>
    </form>

    <!-- Product 2: Desk Computer -->
    <form action="addItemToCart" method="post">
        <article class="product">
            <img src="images/computer.jpg" alt="Desk Computer" class="product-image">
            <h2 class="product-name">Computer</h2>
            <p class="product-price">$450.00</p>
            <div class="cart-controls">
                <input type="number" name="quantity" class="quantity" min="1" value="1">
                <input type="hidden" name="prodName" value="Computer">
                <input type="hidden" name="productPrice" value="450.00">
                <input type="hidden" name="prodCode" value="P119">
                <button type="submit" class="add-to-cart">
                    <img src="images/cart.jpg" alt="Add to Cart">
                    Add to Cart
                </button>
            </div>
        </article>
    </form>

    <!-- Product 3: Laptop -->
    <form action="addItemToCart" method="post">
        <article class="product">
            <img src="images/laptop.jpg" alt="Laptop" class="product-image">
            <h2 class="product-name">Laptop</h2>
            <p class="product-price">$800.00</p>
            <div class="cart-controls">
                <input type="number" name="quantity" class="quantity" min="1" value="1">
                <input type="hidden" name="prodName" value="Laptop">
                <input type="hidden" name="productPrice" value="800.00">
                <input type="hidden" name="prodCode" value="P122">
                <button type="submit" class="add-to-cart">
                    <img src="images/cart.jpg" alt="Add to Cart">
                    Add to Cart
                </button>
            </div>
        </article>
    </form>

    <!-- Product 4: Paper -->
    <form action="addItemToCart" method="post">
        <article class="product">
            <img src="images/paper.jpeg" alt="Paper" class="product-image">
            <h2 class="product-name">Paper</h2>
            <p class="product-price">$2.34</p>
            <div class="cart-controls">
                <input type="number" name="quantity" class="quantity" min="1" value="1">
                <input type="hidden" name="prodName" value="Paper">
                <input type="hidden" name="productPrice" value="2.34">
                <input type="hidden" name="prodCode" value="P321">
                <button type="submit" class="add-to-cart">
                    <img src="images/cart.jpg" alt="Add to Cart">
                    Add to Cart
                </button>
            </div>
        </article>
    </form>

    <!-- Product 5: Sharpies -->
    <form action="addItemToCart" method="post">
        <article class="product">
            <img src="images/sharpies.jpg" alt="Sharpies" class="product-image">
            <h2 class="product-name">Sharpies</h2>
            <p class="product-price">$11.50</p>
            <div class="cart-controls">
                <input type="number" name="quantity" class="quantity" min="1" value="1">
                <input type="hidden" name="prodName" value="Sharpies">
                <input type="hidden" name="productPrice" value="11.50">
                <input type="hidden" name="prodCode" value="P650">
                <button type="submit" class="add-to-cart">
                    <img src="images/cart.jpg" alt="Add to Cart">
                    Add to Cart
                </button>
            </div>
        </article>
    </form>

    <!-- Product 6: Sticky Notes -->
    <form action="addItemToCart" method="post">
        <article class="product">
            <img src="images/Sticknotes.jpg" alt="Sticky Notes" class="product-image">
            <h2 class="product-name">Post-it Notes</h2>
            <p class="product-price">$13.50</p>
            <div class="cart-controls">
                <input type="number" name="quantity" class="quantity" min="1" value="1">
                <input type="hidden" name="prodName" value="Post-it Notes">
                <input type="hidden" name="productPrice" value="13.50">
                <input type="hidden" name="prodCode" value="P660">
                <button type="submit" class="add-to-cart">
                    <img src="images/cart.jpg" alt="Add to Cart">
                    Add to Cart
                </button>
            </div>
        </article>
    </form>

    <!-- Product 7: Tape -->
    <form action="addItemToCart" method="post">
        <article class="product">
            <img src="images/Tape.jpg" alt="Tape" class="product-image">
            <h2 class="product-name">Tape</h2>
            <p class="product-price">$3.50</p>
            <div class="cart-controls">
                <input type="number" name="quantity" class="quantity" min="1" value="1">
                <input type="hidden" name="prodName" value="Tape">
                <input type="hidden" name="productPrice" value="3.50">
                <input type="hidden" name="prodCode" value="P780">
                <button type="submit" class="add-to-cart">
                    <img src="images/cart.jpg" alt="Add to Cart">
                    Add to Cart
                </button>
            </div>
        </article>
    </form>
</main>

<footer>
    <p>&copy; 2024 Office Pro. All rights reserved.</p>
</footer>

<script src="scripts.js"></script>
</body>
</html>