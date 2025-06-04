document.addEventListener('DOMContentLoaded', function () {
    setupCartButtons();
    setupSearchForm();
    updateCartSummary();
});

function setupCartButtons() {
    document.querySelectorAll('.add-to-cart').forEach(button => {
        button.addEventListener('click', handleAddToCart);
    });
    document.querySelectorAll('.remove-button').forEach(button => {
        button.addEventListener('click', handleRemoveFromCart);
    });
}

function setupSearchForm() {
    document.getElementById('search-form').addEventListener('submit', handleSearch);
}

function handleSearch(event) {
    event.preventDefault();
    const query = document.getElementById('search-query').value.toLowerCase();
    document.querySelectorAll('.product').forEach(product => {
        const productName = product.querySelector('.product-name').textContent.toLowerCase();
        product.style.display = productName.includes(query) ? '' : 'none'; // Show or hide product
    });
}

function handleAddToCart(event) {
    const button = event.target.closest('.add-to-cart');
    const productElement = button.closest('.product');

    const productName = productElement.querySelector('.product-name').textContent;
    const productPrice = parseFloat(productElement.querySelector('.product-price').textContent.replace('$', ''));
    const productQuantity = parseInt(productElement.querySelector('.quantity').value, 10);

    addToCart({ name: productName, price: productPrice, quantity: productQuantity });
}

function addToCart(product) {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const existingProduct = cart.find(item => item.name === product.name);

    if (existingProduct) {
        existingProduct.quantity += product.quantity;
    } else {
        cart.push(product);
    }

    localStorage.setItem('cart', JSON.stringify(cart));
    alert(`${product.name} has been added to the cart!`);
    updateCartSummary(); // Update cart on the page
}

function handleRemoveFromCart(event) {
    const button = event.target.closest('.remove-button');
    const cartItemElement = button.closest('.cart-item');
    const productName = cartItemElement.querySelector('.name').textContent;

    removeFromCart(productName);
    updateCartSummary();
}

function removeFromCart(productName) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart = cart.filter(item => item.name !== productName);
    localStorage.setItem('cart', JSON.stringify(cart));
}

function updateCartSummary() {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const cartSummary = document.querySelector('.list');
    const totalQuantityElement = document.querySelector('.totalQuantity');
    const totalPriceElement = document.querySelector('.totalPrice');

    let totalQuantity = 0;
    let totalPrice = 0;

    cartSummary.innerHTML = '';

    cart.forEach(item => {
        const itemElement = document.createElement('div');
        itemElement.classList.add('cart-item');
        itemElement.innerHTML = `
            <div class="info">
                <img src="images/${item.name.toLowerCase()}.jpg" alt="${item.name}" class="item-image">
                <div class="name">${item.name}</div>
                <div class="price">$${item.price.toFixed(2)}</div>
                <div class="quantity">
                    <button class="quantity-button" data-action="decrease">-</button>
                    <input type="number" class="quantity-input" value="${item.quantity}" min="1" aria-label="Quantity">
                    <button class="quantity-button" data-action="increase">+</button>
                </div>
                <button class="remove-button" aria-label="Remove item">Remove</button>
            </div>
        `;
        cartSummary.appendChild(itemElement);

        totalQuantity += item.quantity;
        totalPrice += item.price * item.quantity;
    });

    totalQuantityElement.textContent = totalQuantity;
    totalPriceElement.textContent = `$${totalPrice.toFixed(2)}`;

    document.querySelector('.list').addEventListener('click', (event) => {
        if (event.target.classList.contains('quantity-button')) {
            const action = event.target.dataset.action;
            const quantityInput = event.target.closest('.cart-item').querySelector('.quantity-input');
            let quantity = parseInt(quantityInput.value, 10);

            if (action === 'increase') {
                quantity += 1;
            } else if (action === 'decrease' && quantity > 1) {
                quantity -= 1;
            }

            quantityInput.value = quantity;
            updateTotals();
        }

        if (event.target.classList.contains('remove-button')) {
            handleRemoveFromCart(event);
        }
    });
}

function updateTotals() {
    let totalQuantity = 0;
    let totalPrice = 0;

    document.querySelectorAll('.cart-item').forEach(item => {
        const itemPrice = parseFloat(item.querySelector('.price').textContent.replace('$', ''));
        const quantity = parseInt(item.querySelector('.quantity-input').value, 10);

        totalQuantity += quantity;
        totalPrice += itemPrice * quantity;
    });

    document.querySelector('.totalQuantity').textContent = totalQuantity;
    document.querySelector('.totalPrice').textContent = `$${totalPrice.toFixed(2)}`;
}

function searchProducts() {
    // Get the value from the search input
    const query = document.getElementById("search-query").value.toLowerCase();

    // Get all product elements
    const products = document.querySelectorAll(".product");

    // Loop through each product and check if the name matches the query
    products.forEach(product => {
        const productName = product.querySelector(".product-name").textContent.toLowerCase();

        // If the product name includes the query, display it, otherwise hide it
        if (productName.includes(query)) {
            product.style.display = "block";  // Show the product
        } else {
            product.style.display = "none";  // Hide the product
        }
    });
}

const searchBtn = document.querySelector("#searchBtn");
searchBtn.addEventListener("onclick", searchProducts);