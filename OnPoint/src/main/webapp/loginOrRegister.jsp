<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login or Register</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	
</head>

<style>
    body {
        background-image: url("http://data.freehdw.com/lines-abstract-background-point-scheme-background-free.jpg");
        background-size: 100%;
    }
    
    #center {
        margin: 0 auto;
        text-align: center;
        padding-top: 100px;
    }
    
    sub {
        font-size: 40px;
    }
    
    #logo {
        font-size: 80px; 
        color: white; 
        font-family: Courier;
    }
    
    #login-box {
        background-color: #F8F8FF;
        margin: 0 auto;
        text-align: center;
        height: 220px;
        width: 250px;
        border: 1.5px solid #696969;
        border-radius: 12px;
        padding-top: 15px;
        margin-top: 10px;
    }
    
    input {
        padding: 5px;
        margin: 5px;
    }
    
    form {
        padding-top: 15px;
    }
    
    a {
        color: grey;
    }
    
    #login{
    	width: 150px;
        margin-top: 5px;
        padding: 5px;
    }
    
    #password {
    	margin-left: 8px;
    }
    
    .button {
	    display: block;
	    width: 120px;
	    height: 40px;
	    padding: 8px;
	    background: #5F9EA0;
	    text-align: center;
	    border-radius: 5px;
	    color: white;
	    margin: 18px auto;
	    font-family: Courier;
	}
</style>

<body>
<div id="center" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <h id="logo">On<sub>&#9675</sub></h>
    
    <div id="login-box">
        <a class="button" href="login">Login</a>
        <p style="padding: 5px; font-family: Courier">OR</p>
        <a class="button" href="register">Register</a>
    </div>
</div>
</body>
</html>