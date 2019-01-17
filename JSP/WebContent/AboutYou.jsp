<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABOUT YOU</title>
</head>
<body>
	<h2>ABOUT YOU</h2><br>
	
	<b>NAME: </b><c:out value="${param.name }" /><br>
	<b>USERNAME: </b><c:out value="${param.user}" /><br>
	<b>EMAIL: </b><c:out value="${param.email} "/><br>
	<b>AGE: </b><c:out value="${param.age}" /><br>
	
	<% 
	Integer counter = (Integer)application.getAttribute("counter");
	if(counter==null)
		counter=1;
	else counter = counter + 1;
	application.setAttribute("counter",counter);
	%>
	
	<h4>TOTAL PAGE VISITS = <%=counter %> </h4>
</body>
</html>