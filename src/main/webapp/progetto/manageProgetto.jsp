<%@page import="it.contrader.model.AziendaCliente"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="it.contrader.utils.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../header.jsp"%>



<!DOCTYPE html>
<html>
<head>
<title>Gestione Progetti</title>
<style>
body {
	background-image:
		url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
	color: white;
}
</style>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>

.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 40px 40px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: orange;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>
</head>
<%
	List<ProgettoDTO> allProgetto = (List<ProgettoDTO>) request.getAttribute("allProgettoDTO");
	
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Gestione Progetti</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID </th>
			<th>Titolo </th>
			<th>Dettagli </th>
			<th>Coordinate DIIN</th>	
		</tr>
		<%
			for (ProgettoDTO progetto : allProgetto) {
		%>
		<tr>
			<td><%=progetto.getIdProgetto()%></td>
			<td><%=progetto.getTitoloProgetto()%></td>
			<td><%=progetto.getDettagliProgetto()%></td>
			<td><%=progetto.getCoordinateDIIN()%></td>
			
			<td class="center"><a href="/DossierController/dossierManagement?id=<%=progetto.getIdProgetto()%>"><i class="fas fa-book" title="Dossier" style="color:black"></i></a></td>
			<td class="center"><a href="/ProgettoController/read?idProgettoRead=<%=progetto.getIdProgetto()%>"><i class="fas fa-eye" title="Leggi dettagli" style="color:white"></i></a></td>
			<td class="center"><a href="/ProgettoController/updateRedirect?idProgettoUpdate=<%=progetto.getIdProgetto()%>"><i class="fas fa-edit" title="Update" style="color:white"></i></a></td>
			<td class="center"><a href="/ProgettoController/delete?idProgettoDelete=<%=progetto.getIdProgetto()%>"><i class="fas fa-trash-alt" title="Delete" style="color:white"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/ProgettoController/insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo Progetto</i></a>

	<br>
	<br>
	<a href="/AziendaClienteController/aziendaClienteManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>