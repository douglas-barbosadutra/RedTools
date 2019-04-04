<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.service.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home BO</title>
<% 
int idBO =  (Integer) request.getAttribute("idBO");
%>
</head>
<body>


	<p>Welcome!</p>



	<a href="UtenteFinaleServlet?richiesta=UtenteFinaleManager&idBO=<%=idBO%>"><span class="fs">
			Utente Finale Management </span></a>
	<br>
	<br>
	<br>
	<a href="LogoutServlet" ><span class="fs">
			Logout </span></a>

</body>
</html>