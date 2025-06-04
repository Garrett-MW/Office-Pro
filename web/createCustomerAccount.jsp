<%-- 
    Document   : createCustomerAccount
    Created on : Nov 15, 2024, 11:31:38 AM
    Author     : Tanya Cruz / Garrett Womack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Office Pro | Create Customer Account</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Teko:wght@300..700&display=swap" rel="stylesheet">
        <style>
            * {
            font-family: "Teko", 'san-serif';
            }

            body {
            text-align: center;
           background-image: url("home.jpg");
           background-repeat: repeat-y;
           background-size: cover;
            }

            form {
            background-color: #E0D8D8;
            width: 90%;
            margin:auto;
            margin-bottom: 5%;
            padding: 1%;
            border-radius: 15px;
            box-shadow: 0px 5px 15px #292F36; /* add shadow to form element*/
            }

            #coName {
            font-size: 60px;
            color: #A41F13;
            }

            #coNameDiv {
            width: 60%;
            margin: auto;
            background-color: #E0D8D8;
            box-shadow: 0px 5px 15px #292F36;
            border-radius: 15px;
            }


            h1 {
            font-size: 35px;
            color: #292F36;
            }

            #headerDiv h1{
            font-size: 35px;
            }

            label {
            font-size: 25px;
            color: #292F36;
            white-space: nowrap;
            }

            #create {
            width: 20%;
            border-radius: 15px;
            margin: auto;
            background-color: #92221a;
            color: #FAF5F1;
            font-size: 20px;
            transition: background-color 0.5s ease, transform 0.5s ease;
            }

            #create:hover {
                background-color:#ab554e;
               transform: translateY(5px);
            }

            #create:active {
            background-color: black;
            color: white;
            }

            input {
            width: 50%;
            font-size: 20px;
            padding: 0.5%;
            border-radius: 15px;
            margin: auto;
            }

            input:focus {
            border: 2px solid #A41F13;
            }

            #headerDiv {
            background-color: #FAF5F1;
            width: 60%;
            border-radius: 15px;
            margin: auto;
            text-align: center;
            box-shadow: 0px 5px 15px grey;
            }

            #mainDiv {
            background-color: #FAF5F1;
            width: 80%;
            border-radius: 15px;
            margin: 2% auto;
            padding: 7%;
            box-shadow: 0px 5px 15px grey;
            display: grid;
            grid-template-columns: auto;
            row-gap: 2%;
            column-gap: 2%;
            }

            footer p{
           background-color: #333;
            color: white;
            text-align: center;
            position: fixed;
            width: 100%;
            bottom: 0;
            margin: auto;
            }
        

        

        @media screen and (max-width: 600px){
        #coName{
            font-size: 50px;
        }
         #headerDiv h1{
            font-size: 30px;
         }
         h3{
            font-size: 20px;
         }
         input{
            height: 20px;
         }
         #create{
            height: 30px;
            font-size: 20px;
         }
         #create:hover{
            transform: translateY(2px);
         }

        }
    </style>
</head>

<body>
    <div id="coNameDiv">
        <h1 id="coName">Office Pro</h1>
    </div>
    <form action="CreateAccountCustomer" method="post">
        <!-- add servlet to validate information and send to home page signed in-->
        <div id="headerDiv">
            <h1>Create Account</h1>
        </div>
        <div id="mainDiv">
            <div class="form-group">
                <label for="custID">Customer ID:</label>
                <input type="text" id="custID" name="custID" placeholder="4 digit ID" required>
            </div>

            <div class="form-group">
                <label for="passwd">Password:</label>
                <input type="password" id="passwd" name="passwd"  placeholder="4 digit PIN"required>
            </div>

            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" required>
            </div>

            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" required>
            </div>
            
            <div class="form-group">
                <label for="addr">Address:</label>
                <input type="text" id="addr" name="addr" required>
            </div>

            <div class="form-group">
                <label for="email">Email Address:</label>
                <input type="email" id="email" name="email"  placeholder="janedoe@gmail.com" required>
            </div>

            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" name="phone"  placeholder="(xxx)xxx-xxxx" required>
            </div>
        </div>
        <input type="submit" name="submit" value="Create" id="create">
    </form>
    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>

</body>
</html>
