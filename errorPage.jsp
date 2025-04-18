<%-- 
    Document   : errorPage
    Created on : Nov 15, 2024, 11:37:16 AM
    Author     : Tanya Cruz / arrett Womack
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
    <title>Office Pro | Error Page</title>
    <style>
        
        #coNameDiv{
            text-align:center;
            margin: auto;
            width: 60%;
            background-color: #E0D8D8;
            box-shadow: 0px 5px 15px #292F36;
            border-radius: 15px;
        }
        #coName{
            font-size: 60px;
            color: #A41F13;
        }
        #container{
            width: 70%;
            margin: auto;
            box-shadow: 0px 5px 15px #292F36;
            padding: 2%;
            background-color: #E0D8D8;
            border-radius: 15px;;
        }
        #errMsg{
            margin: auto;
            width:70%;
            box-shadow: 0px 5px 15px grey;
            background-color: #FAF5F1;
            border-radius: 15px;
            padding: 2%;
        }
        body{
             text-align: center;
             background-image: url("home.jpg");
             background-repeat: repeat-y;
            background-size: cover;
        }
        h3{
            font-size: 30px;
        }
        button{
            width: 25%;
            font-size: 20px;
            background-color: #92221a;
            color: white;
            border-radius: 12px;
            transition: background-color 0.3s ease;
        }
        button:hover{
           background-color:#ab554e;
            transform: translateY(5px);
        }
         button:active{
            background-color: black;
            color: white;
        }
        * {
            font-family: 'Teko', 'san-serif';
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
    </style>
</head>
<body>
    <div id="coNameDiv">
        <h1 id="coName">Office Pro</h1>
    </div>
    <div id="container">
        <div id="errMsg">
            <h3>An Error Occurred!!</h3>
           
            <a href="index.jsp"><button>Home</button></a><!--add link to home page-->
        </div>
    </div>
    <footer>
        <p>&copy; 2024 Office Pro. All rights reserved.</p>
    </footer>
</body>
</html>
