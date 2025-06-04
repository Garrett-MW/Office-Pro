Office-Pro

CIST 2931 Advanced Project Systems Course Project

~Group Members:

Garrett Womack
Tanya Cruz
Brendan Stroud
Eleazar De Paz
Kelvin Manuel
~ Project Description

Create a Web Application used by a customer looking topurchase office supplies, and also a internal employee whose job is to process/fulfill orders placed by customers.
~ Project Requirments:

Customer:
search for products
make a purchase without creating an account
create a new customer account
update information in their customer account
Employee: 1.login 2.view list of orderes needing to be fulfilled 3.change order status from unfulfilled tp fulfilled
~ My Contributions: 1.Login Page customer/employee - employeeLogin.jsp - customerLogin.jsp - this page allows existing customers to login

2.Create Account Page customer/employee - createCustomerAccount.jsp - createEmployeeAccount.jsp - this page allows new customers to create an account

3.Display/Update Account Info customer/employee - customerUpdate.jsp - employeUpdate.jsp - pages allow customer to view account info and also change any info needed.

4.Error Page - errorPage.jsp - error page displayed if an error occurs

5.Open Orders Page - unfulfilledOrders.jsp - this page allows employees to log in and view all orders marked ad unfulfilled, this page also allows the employee to change order status

6.List of customers orders - customerOrders.jsp - allows customer who has an account to view all current and previous orders

7.CartItem.java class - this class object is an item that is placed in the cart list object.

8.CartList.java class - this class object basially acts as a cart that holds cart items added by the customer when shopping. This class allows the customer to view all items in cart whenever they are checking out.

9.addItemToCart.java - this servlet handles adding items to the cart. When the customer hits the add to cart button the servlet creates a new cart item and adds it to the customers cart list.

10.Search Product Functionality - searchResults.jsp - SearchProductsServlet.java - these two files work together to bring up products search for by the customer. The servlet takes in input in the search bar from the customer and depending on what the customer searchs it redirects to the searchResult.jsp page with the results of the search.

LogoutOutServlet.java

this servlet handles the logic of invalidating any session data and redirects the useer to the home page/index.jsp
ContinueWithNoAccount.java

this servlet creates a session for a customer continuing with no account so that when the customer is shopping around the navigation bar has limited options considering a customer with no account will not have the same functionalty as a customer with an account.
Css styling

since there were two people (Me and Tanya Cruz) mainly working on the front end there were son inconsistencies with styling so I did a major portion of styling to make all the pages more cohesive.
Piecing project together

When the group was finished, I linked together all servlets with jsps ensuring the functionality of the website was cohesive and actually functional.
