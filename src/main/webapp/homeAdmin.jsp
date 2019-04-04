<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.service.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
</head>
<body>


	<p>Welcome!</p>



	<a href="UserServlet?richiesta=UserManager"><span class="fs">
			User Management </span></a>
	<br>
	<br>
	<br>
	<a href="LogoutServlet" ><span class="fs">
			Logout </span></a>

</body>
</html>