<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>OnPoint - Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<Script src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular.min.js"></Script>
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
</style>

<body>
<div id="center" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <h id="logo">On<sub>&#9675</sub></h>
    
    <div id="login-box">
        <form:form id="loginForm" modelAttribute="login" action="homepage" method="post">
                	<tr>
                		<td></td>
                        <td>
                            <form:input path="username" name="username" id="username" placeholder="Username"/>
                        </td>
                    </tr>
                    <tr>
                    	<td></td>
                        <td>
                            <form:password path="password" name="password" id="password" placeholder="Password"/>
                        </td>
                    </tr>
                    <tr>
                    	<br>
                    	<td></td>
                        <td align="center">
                            <form:button id="login" name="login">Login</form:button>
                        </td>
                    </tr>
                    <br>
        </form:form>
        	<p style="color: red; margin-top: 6px; font-family: Courier; font-size: 14px">${message}</p>
    </div>
</div>
	<script>
	var lat = document.getElementById("lat");
	var lon = document.getElementById("lon");
	var message = document.getElementById("message");
	
	var latitude;
	var longitude;
	
	var api = "https://fcc-weather-api.glitch.me/api/current?";
	
	var lati;
	var longi;
	
	window.onload = getLocation();
	
	function getLocation() {
	    if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(showPosition, showError);
	    } else { 
	        message.innerHTML = "Geolocation not supported by browser.";
	    }
	}
	
	function showPosition(position) {
		lati = position.coords.latitude;
		longi = position.coords.longitude;
		
		latitude = position.coords.latitude.toString().substring(0,6);
    	longitude = position.coords.longitude.toString().substring(0,7);
	    
	    var urlString = api+"lat=" + lati + "&" + "lon=" + longi;
	    console.log(urlString);
	    
	    update();

	}
	
	function update(){
		var location = [{"latitude": latitude},{"longitude": longitude}];
		console.log(location);
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/OnPoint/user",
			data: JSON.stringify(location),
			dataType: "json",
			success: function(data){
                $("sessionScope.location").html(data);
            }
		});
	}
	function showError(error) {
	    switch(error.code) {
	        case error.PERMISSION_DENIED:
	            x.innerHTML = "User denied the request for Geolocation."
	            break;
	        case error.POSITION_UNAVAILABLE:
	            x.innerHTML = "Location information is unavailable."
	            break;
	        case error.TIMEOUT:
	            x.innerHTML = "The request to get user location timed out."
	            break;
	        case error.UNKNOWN_ERROR:
	            x.innerHTML = "An unknown error occurred."
	            break;
	    }
	}
	</script>
</body>
</html>