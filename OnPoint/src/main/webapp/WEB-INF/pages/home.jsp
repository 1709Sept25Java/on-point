<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/weather-icons/2.0.9/css/weather-icons.min.css" />

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
</head>
<style>
	#col1 {
		width: 100%;
		height: 550px;
		border-right: 1.5px solid #808080;
	}
	
	#col2 {
		width: 100%;
		height: 550px;
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
		height: 400px;
		
	}
	
	#new_events {
		height: 100px;
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
	
	div.hide {
	  display: none;
	}
	
	.weather_icons{
		font-size: 80px;
		color: #BA55D3; 
		padding: 10px;
		margin-top: 20px;
	
	}
	
	span {
		color: #808080;
	}
	
	.button {
      display: inline-block;
      border-radius: 6px;
      background-color: #D8BFD8;
      border: none;
      color: white;
      text-align: center;
      font-size: 14px;
      padding: 5px;
      width: 130px;
      transition: all 0.5s;
      cursor: pointer;
      margin: 5px;
  }
  
  .button span {
    cursor: pointer;
    display: inline-block;
    position: relative;
    transition: 0.5s;
  }
  
  .button span:after {
    content: '\00bb';
    position: absolute;
    opacity: 0;
    top: 0;
    right: -20px;
    transition: 0.5s;
  }
  
  .button:hover span {
    padding-right: 25px;
  }
  
  .button:hover span:after {
    opacity: 1;
    right: 0;
  }
</style>

<ul>
  <li><a class="active" href="home">Home</a></li>
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

            <div id="weather_info" style="text-align: center">
            	
            	<div class="weather_icons">
	            	<div class="wi wi-hail hail hide"></div>
					<div class="wi wi-day-sunny clear hide"></div>
					<div class="wi wi-rain rain hide"></div>
					<div class="wi wi-snow snow hide"></div>
					<div class="wi wi-thunderstorm thunderstorm hide"></div>
					<div class="wi wi-day-cloudy clouds haze hide"></div>
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
        </div>
        <div class="col-sm-9 col-md-9 col-lg-9" id="col2">
            <div id="my_events">
            	<div style="border-bottom: 1.5px solid #808080; width: 100%">
                	<h>My Events</h>
                </div>
                <table class="table table-hover">
				  <thead>
				    <tr>
				      <th scope="col">ID</th>
				      <th scope="col">Date</th>
				      <th scope="col">Time</th>
				      <th scope="col">Location</th>
				      <th scope="col">Description</th>
				    </tr>
				  </thead>
				  <tbody id="allEvents">
				   
				  </tbody>
				</table>
            </div>
            <div style="height: 50px">
            	<a href="delete" style="float:right"><button class="button"><span style="color: white">Delete</span></button></a>
            </div>
            <div id="new_events">
                <div style="border-bottom: 1.5px solid #808080; width: 100%">
                	<h>New Event</h>
                </div>
                <div style="margin-top: 15px">
	                <h style="font-size: 18px; color: #808080">Create Single Time Event: <a href="event"><button class="button"><span style="color: white">Create</span></button></a>
	                <span style="margin-left: 200px">Create Recurring Event: <a href="recurring"><button class="button"><span style="color: white">Create</span></button></a></span></span></h>
            	</div>
            </div>
        </div>
    </div>
    
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
    		sendAJAX("http://ec2-18-221-67-229.us-east-2.compute.amazonaws.com:8080/OnPoint/allEvents", getEvents);
    		
    		
    		
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
    	
    	function getWeather(xhr){
    		
    		var info = JSON.parse(xhr.responseText);
    		document.getElementById("city").innerHTML = info.name + ", ";
    		document.getElementById("country").innerHTML = info.sys.country;
    		tempInC = (Math.round(info.main.temp * 10) / 10) * 9 / 5 + 32;
    		document.getElementById("temp").innerHTML = tempInC +  " " + String.fromCharCode(176);
			document.getElementById("tempunit").innerHTML = unit;
			document.getElementById("low").innerHTML = (Math.round(info.main.temp_min * 10) / 10) * 9 / 5 + 32 + " " + String.fromCharCode(176)+ unit;
			document.getElementById("high").innerHTML = (Math.round(info.main.temp_max * 10) / 10) * 9 / 5 + 32 + " " + String.fromCharCode(176) + unit;
			document.getElementById("current").innerHTML = info.weather[0].main;
    		IconGenerator(info.weather[0].main);
    		
    		var value = info.weather[0].main;
    		
    		
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
    		    case 'haze':
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
 		function getEvents(xhr){
 			var all = JSON.parse(xhr.responseText);
 			var table = document.getElementById("allEvents");
 			var i;
 			console.log("got data");
 			console.log(all);
 			for(i = 0; i < all.length; i++){
 				table.innerHTML +=  
 				"<tr><td>"+all[i].e_id+
 				"</td><td>"+all[i].event_date+
 				"</td><td>"+all[i].event_time+
 				"</td><td>"+all[i].location+
 				"</td><td>"+all[i].description+
 				"</td></tr>";
 			}
 		}
    </script>
</body>
</html>