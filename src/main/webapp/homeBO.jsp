<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.services.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="it.contrader.utils.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home BO</title>
<% 
UserDTO userBO = (UserDTO) session.getAttribute("utenteCollegato");
int idBO = userBO.getIdUser();
%>
</head>
<body>


	<p><h1>Welcome Business Owner n° <%=idBO%>!</h1></p>



	<a href="/AziendaClienteController/aziendaClienteManagement"><span class="fs">
			Aziende Clienti Management </span></a>
	<br>
	<br>
	<br>
	<a href="LogoutServlet" ><span class="fs">
			Logout </span></a>

</body>
</html>