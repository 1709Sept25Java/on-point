<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    
    #event-box {
        background-color: #F8F8FF;
        margin: 0 auto;
        height: 300px;
        width: 250px;
        border: 1.5px solid #696969;
        border-radius: 12px;
        padding-top: 15px;
        margin-top: 10px;
    }
    
    input {
        padding: 5px;
        margin-bottom: 5px;
        width: 200px;
    }
    
    #event_button {
        width: 150px;
        margin-top: 5px;
    }
    
    form {
        padding-top: 15px;
    }
    
    #number {
        margin-left: -4px;
    }
    
    #event {
        font-size: 20px;
        border-bottom: 1px solid #808080;
        width: 250px;
        padding-bottom: 5px;
        font-family: Lucida;
        color: #808080;
    }
    
    #description {
    	margin-left: 5px;
    }
    
</style>

<body>
<div id="center" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <h id="logo">On<sub>&#9675</sub></h>
    <!-- 
    private String event_date;
	private String event_time;
	private String location;
	private String description;
     -->
    
    <div id="event-box">
        <div id="event">
            <h>New Event</h>
        </div>
        <form:form id="eventForm" modelAttribute="event" action="eventProcess" method="post">
                <tr>
                        <td></td>
                        <td>
                            <form:input type="date" path="date" name="date" id="date" placeholder="date"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <form:input type="time" path="time" name="time" id="time" placeholder="time"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <form:input path="location" name="location" id="location" placeholder="Location"/>
                        </td>
                    </tr>
                     <tr>
                        <td></td>
                        <td>
                            <form:input path="description" name="description" id="description" placeholder="Description"/>
                        </td>
                    </tr>
                    <tr>
                        <br>
                        <td></td>
                        <td align="center">
                            <form:button id="event_button" name="event">Create Event</form:button>
                        </td>
                    </tr>
        </form:form>
    </div>
</div>
</body>
</html>