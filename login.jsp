<%-- 
    Document   : login
    Created on : Nov 15, 2024, 11:39:31 AM
    Author     : garrett Womack /Tanya Cruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Teko:wght@300..700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Office Pro | Login</title>
    <style>
        *{
             font-family: "Teko", 'san-serif';
        }
        body {
           text-align: center;
           background-image: url("home.jpg");
           background-repeat: repeat-y;
           background-size: cover;
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

        #mainDiv{
            margin: auto;
            width: 70%;
            background-color: #FAF5F1;
            border-radius: 15px;
            box-shadow: 5px 5px 5px grey;
            padding: 1%;
        }

        #container{
            margin: auto;
            width: 80%;
            background-color: #E0D8D8;
            padding: 1%;
            border-radius: 15px;
            box-shadow: 5px 5px 5px #292F36;
            margin-bottom: 5%;
        }

        h3 {
            font-size: 35px;
            color: #292F36;
        }

        button{
            width: 50%;
            border-radius: 15px;
            margin: 1%;
            padding: 1%;
            background-color: #92221a;
            color: #FAF5F1;
            font-size: 20px;
            transition: background-color 0.5s ease, transform 0.5s ease;
        }

        button:hover{
            background-color:#ab554e;
            transform: translateY(5px);
        }

        button:active{
            background-color: black;
            color: white;
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

        @media screen and (max-width: 750px){
            
            #coName{
                font-size:60px;
            }

            h3{
                font-size: 35px;
            }

            button{
                height: 40px;
                width: 40%;
                font-size: 15px;
                transform: translateY(2px);
            }
        }

        @media screen and (max-width: 592px){
            #coName{
                font-size:50px;
            }
            h3{
                font-size: 25px;
            }
            button{
                font-size: 12px;
                height: 30px;
                width: 35%;
                border-radius: 10px;
            }
        }

    </style>
</head>
<body>
    <div id="coNameDiv">
        <h1 id="coName">Office Pro</h1>
    </div>
    <div id="container">
        <h3>Make a selection</h3>
        <div id="mainDiv">
            <a href="customerLogin.jsp"><button>Customer Login</button></a>
            <a href="employeeLogin.jsp"><button>Employee Login</button></a>
        </div>
    </div>
    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>
</body>
</html>
