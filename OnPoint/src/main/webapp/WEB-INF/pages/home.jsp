<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/weather-icons/2.0.9/css/weather-icons.min.css" />
</head>
<style>
	#col1 {
		width: 100%;
		height: 650px;
		border-right: 1.5px solid #808080;
	}
	
	#col2 {
		width: 100%;
		height: 650px;
	}
	
	#photo {
		width: 100%;
		height: 350px;
	}
	
	h {
	
		font-size: 26px;
		font-family: Georgia;
	}
	
	#my_events {
		height: 450px;
	}
	
	#new_events {
		height: 200px;
	}
	
	ul {
    list-style-type: none;
    margin: -10px;
    padding: 10px;
    overflow: hidden;
    background-color: #333;
	}
	
	li {
	    float: left;
	}
	
	li a {
	    display: block;
	    color: white;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none;
	}
	
	li a:hover:not(.active) {
	    background-color: #111;
	}
	
	.active {
	    background-color: #4CAF50;
	}
<<<<<<< HEAD
	
	div.hide {
	  display: none;
	}
	
	.weather_icons{
		font-size: 50px;
		color: #BA55D3; 
		padding: 10px;
	
	}
	
	span {
		color: #808080;
	}
	
=======

>>>>>>> 7ce6aadbb6bf72719096f01412aabb4da7347028
</style>

<ul>
  <li><a class="active" href="#">Home</a></li>
  <li><a href="#">About Us</a></li>
  <li><a href="#">Account</a></li>
  <li style="float:right"><a href="logout">Logout</a></li>
</ul>

<body>
	 <div id="coverphoto">
        <img id="photo" src="http://colorfully.eu/wp-content/uploads/2012/07/beautiful-purple-sky-facebook-cver.jpg">
    </div>
    <div class="row" style="margin: 15px">
        <div class="col-sm-3 col-md-3 col-lg-3" id="col1">
            <div style="text-align: center">
                <h>Weather</h>
            </div>
<<<<<<< HEAD
            <div id="weather_info" style="text-align: center">
            	
            	<div class="weather_icons">
	            	<div class="wi wi-hail hail hide"></div>
					<div class="wi wi-day-sunny clear hide"></div>
					<div class="wi wi-rain rain hide"></div>
					<div class="wi wi-snow snow hide"></div>
					<div class="wi wi-thunderstorm thunderstorm hide"></div>
					<div class="wi wi-day-cloudy clouds hide"></div>
				</div>
				
            	<p id="message"></p>
            	<p><span id="date"></span> <span id="time"></span></p>
            	<p>Latitude: <span id="lat"></span></p>
            	<p>Longitude: <span id="lon"></span></p>
            	<p>Location: <span id="city"></span><span id="country"></span></p>
            	<p>Current Temperature: <span id="temp"></span><span id=tempunit></span></p>
            	<p>Low: <span id="low"></span></p>
            	<p>High: <span id="high"></span></p>
              	<p>Current Weather: <span id="current"></span></p>
              
            </div>
=======
>>>>>>> 7ce6aadbb6bf72719096f01412aabb4da7347028
        </div>
        <div class="col-sm-9 col-md-9 col-lg-9" id="col2">
            <div id="my_events">
                <h>My Events</h>
            </div>
            <div id="new_events">
                <h>New Events</h>
            </div>
        </div>
    </div>
<<<<<<< HEAD
    <script>
    
   	 	var lat = document.getElementById("lat");
		var lon = document.getElementById("lon");
		var message = document.getElementById("message");
		
		var latitude;
		var longitude;
		
		var api = "https://fcc-weather-api.glitch.me/api/current?";
    	var unit = 'F';
    	var tempInC;
		
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
    	    lat.innerHTML = latitude + "°";
    	    lon.innerHTML = longitude + "°";
    	    
    	    var urlString = api+"lat=" + lati + "&" + "lon=" + longi;
    	    console.log(urlString);
    		sendAJAX(urlString, getWeather);

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
    	
    	
    	function sendAJAX(url, func){
    		var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HttpRequest");
    		
    		xhr.onreadystatechange = function(){
    			if(this.readyState == 4 && this.status == 200){
    				func(this);
    			}
    		};
    		
    		xhr.open("GET", url);
    		xhr.send();
    	}
    	
    	function getWeather(xhr){
    		
    		var info = JSON.parse(xhr.responseText);
    		document.getElementById("city").innerHTML = info.name + ", ";
    		document.getElementById("country").innerHTML = info.sys.country;
    		tempInC = ((Math.round(info.main.temp * 10) / 10) + 32) * 9 / 5;
    		document.getElementById("temp").innerHTML = tempInC +  " " + String.fromCharCode(176);
			document.getElementById("tempunit").innerHTML = unit;
			document.getElementById("low").innerHTML = ((Math.round(info.main.temp_min * 10) / 10) + 32) * 9 / 5 + " " + String.fromCharCode(176)+ unit;
			document.getElementById("high").innerHTML = ((Math.round(info.main.temp_max * 10) / 10) + 32) * 9 / 5 + " " + String.fromCharCode(176) + unit;
			document.getElementById("current").innerHTML = info.weather[0].main;
    		IconGenerator(info.weather[0].main);
    	}
    	function IconGenerator(desc) {
    		  var desc = desc.toLowerCase()
    		  switch (desc) {
    		    case 'clear':
    		      addIcon(desc)
    		      break;
    		    case 'rain':
    		      addIcon(desc)
    		      break;
    		    case 'snow':
    		      addIcon(desc)
    		      break;
    		    case 'hail':
    		      addIcon(desc)
    		      break;
    		    case 'thunderstorm':
    		      addIcon(desc)
    		      break;
    		    case 'clouds':
    		      addIcon(desc)
    		      break;
    		    default:
    		    	var x = document.getElementsByClassName("clear");
    		  		x[0].classList.remove('hide');
    		  }
    		}

    		function addIcon(desc) {
    			var x = document.getElementsByClassName(desc);
    			x[0].classList.remove('hide');
    			
    		}
 		
    </script>
=======
>>>>>>> 7ce6aadbb6bf72719096f01412aabb4da7347028
</body>
</html>