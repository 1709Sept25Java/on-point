<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

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

</style>

<ul>
  <li><a class="active" href="#">Home</a></li>
  <li><a href="#">About Us</a></li>
  <li><a href="#">Account</a></li>
  <li style="float:right"><a href="logout">Logout</a></li>
</ul>

<body>
	 <div id="coverphoto">
        <img id="photo" src="http://wallset.in/wp-content/uploads/2014/08/Stairway-to-Heaven-twitter.jpg">
    </div>
    <div class="row" style="margin: 15px">
        <div class="col-sm-4 col-md-4 col-lg-4" id="col1">
            <div style="text-align: center">
                <h>Weather</h>
            </div>
        </div>
        <div class="col-sm-8 col-md-8 col-lg-8" id="col2">
            <div id="my_events">
                <h>My Events</h>
            </div>
            <div id="new_events">
                <h>New Events</h>
            </div>
        </div>
    </div>
</body>
</html>