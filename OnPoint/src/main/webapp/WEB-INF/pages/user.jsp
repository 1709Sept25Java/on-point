<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>
<p id="location">${ sessionScope.location }</p>
<p id="id">${ sessionScope.id }</p>
<p id="role">${ sessionScope.role }</p>
<p id="role">${ sessionScope.phone }</p>
<p id="latitude">${ sessionScope.latitude}</p>
<p id="longitude">${ sessionScope.longitude}</p>
</body>
</html>