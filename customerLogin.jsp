<%-- 
    Document   : customerLogin
    Created on : Nov 15, 2024, 11:34:28 AM
    Author     : Tanya Cruz / Garrett Womack /Brendan Stroud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Teko:wght@300..700&display=swap" rel="stylesheet">
    <title>Office Pro | Customer Login</title>
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
            height: 100%;
            width : 80%;
            margin: auto;
            margin-bottom: 5%;
            padding: 2%;
            border-radius: 15px;
            box-shadow: 10px 5px 5px #292F36;
        }

        #coName {
            font-size: 60px;
            color: #A41F13;
        }

        #coNameDiv {
            width: 60%;
            margin: auto;
            background-color: #E0D8D8;
            box-shadow: 5px 5px 5px #292F36;
            border-radius: 15px;
        }


        h1 {
            font-size: 35px;
            color: #292F36;
        }

        h3 {
            font-size: 25px;
            color: #292F36;
            margin: 5% 30% 0% 0%;
        }

        #login {
            width: 20%;
            border-radius: 15px;
            margin: 2%;
            background-color: #92221a;
            color: #FAF5F1;
            font-size: 20px;
            transition: background-color 0.5s ease, transform 0.5s ease;
        }

        #login:hover {
            background-color:#ab554e;
            transform: translateY(5px);
        }

        #login:active {
            background-color: black;
            color: white;
        }

        input {
            width: 50%;
            border-radius: 15px;
            font-size: 20px;
        }

        input:focus {
            border: 5px solid #A41F13;
        }

        #div1 {
            background-color: #FAF5F1;
            width: 60%;
            border-radius: 15px;
            margin: auto;
            text-align: center;
            box-shadow: 5px 5px 5px grey;
        }

        #div2 {
            background-color: #FAF5F1;
            width: 75%;
            border-radius: 15px;
            margin: auto;
            box-shadow: 5px 5px 5px grey;
        }

        #user {
            padding-top: 5%;
        }

        footer p{
            color: #A41F13;
            position: fixed;
            bottom: 0;
            background-color: #333;
            color: white;
            margin: auto;
            width: 100%;
        }

        @media screen and (max-width: 870px) {

            form {
                display: flex;
            }

            #coName {
                font-size: 50px;
            }

            #coNameDiv {
                width: 80%;
            }

            #div1 {
                height: 18%;
                width: 100%;
            }

            #div2 {
                margin: 0% 2%;
            }

            h1 {
                font-size: 35px;
                padding-top: 20px;
            }

            h3 {
                font-size: 25px;
            }

            input {
                height: 50%;
                width: 70%;
            }

            #login {
                height: 100%;
                width: 40%;
                font-size: 15px;
            }
        }

        @media screen and (max-width: 460px) {
            h1 {
                font-size: 25px;
                padding-top: 20px;
            }

            h3 {
                font-size: 15px;
            }
        }
    </style>
</head>

<body>
    <div id="coNameDiv">
        <h1 id="coName">Office Pro</h1>
    </div>
    <form action="CustomerLogin" method="post"> <!--Add servlet-->
        <div id="div1">
            <h1>Customer Login</h1>
        </div>
        <div id="div2">
            <h3 id="user">Username:</h3>
            <input type="text" name="custID" id="username">
            <h3>Password:</h3>
            <input type="text" name="custPass" id="password">
            <br>
            <input type="submit" id="login" value="Log In"></input>
        </div>
    </form>
    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>
</body>
</html>
