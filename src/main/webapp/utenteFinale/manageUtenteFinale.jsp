<%@page import="it.contrader.model.UtenteFinale"%>
<%@ include file="../header.jsp"%>
<%!
private String convertUsertype(String userType) {
		if (userType.equals("superuser"))
			return "Super User";
		else
			return "Business Owner";
	}%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
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
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>

.pre_contenitore {
	width: 700px;
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
	List<UtenteFinaleDTO> allUtenteFinale = (List<UtenteFinaleDTO>) request.getAttribute("allUtenteFinale");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Utente Finale Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>denomninazioneSocieta</th>
			<th>formaGiuridica</th>
			<th>sedeLegale</th>
			<th>partitaIva</th>
			<th>telefono</th>
			<th>email</th>
		</tr>
		<%
			for (UtenteFinaleDTO utenteFinale : allUtenteFinale) {
		%>
		<tr>
			<td><%=utenteFinale.getId()%></td>
			<td><%=utenteFinale.getDenominazioneSocieta()%></td>
			<td><%=utenteFinale.getFormaGiuridica()%></td>
			<td><%=utenteFinale.getSedeLegale()%></td>
			<td><%=utenteFinale.getPartitaIva()%></td>
			<td><%=utenteFinale.getTelefono()%></td>
			<td><%=utenteFinale.getEmail()%></td>
			<td class="center"><a href="/JspApp/ProgettoServlet?richiesta=progetto&id=<%=utenteFinale.getId()%>"><i class="fas fa-clipboard" title="Progetto"></i></a></td>
			<td class="center"><a href="/JspApp/DossierServlet?richiesta=dossier&id=<%=utenteFinale.getId()%>"><i class="fas fa-book" title="Dossier"></i></a></td>
			<td class="center"><a href="/JspApp/MomServlet?richiesta=mom&id=<%=utenteFinale.getId()%>"><i class="fas fa-pencil-alt" title="Mom"></i></a></td>
			<td class="center"><a href="/JspApp/UtenteFinaleServlet?richiesta=updateRedirect&id=<%=utenteFinale.getId()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/UserServlet?richiesta=delete&id=<%=utenteFinale.getId()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/UtenteFinaleServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New User</i></a>

	<br>
	<br>
	<a href="/JspApp/UtenteFinaleServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>