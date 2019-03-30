<%@ include file="/header.jsp"%>
<%!
private String convertUsertype(String userType) {
		if (userType.equals("admin"))
			return "Admin";
		else
			return "Business Owner";
	}%>

<!DOCTYPE html>
<html>
<head>
<title>MANAGE DOSSIER</title>
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
	List<DossierDTO> allDossier = (List<DossierDTO>) request.getAttribute("allDossier");
	int idUtenteFinale =  (Integer) request.getAttribute("id");
	
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Dossier Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
		    <th>idDossier</th>
			<th>costoDipendenti</th>
			<th>fatturatoPeriodoDiImposta</th>
			<th>numeroDipendenti</th>
			<th>costiAttivitaRd</th>
			<th>costiPersonaleRd</th>
		    <th>idUtenteFinale</th>
		    <th>idProgetto</th>
		    <th>periodoDiImposta</th>
		    <th>completamento</th>
		
		</tr>
		<%
			for (DossierDTO dossier : allDossier) {
		%>
		<tr>
			<td><%=dossier.getIdDossier()%></td>
			<td><%=dossier.getCostoDipendenti()%></td>
			<td><%=dossier.getFatturatoPeriodoDiImposta()%></td>
			<td><%=dossier.getNumeroDipendenti()%></td>
			<td><%=dossier.getCostiAttivitaRd()%></td>
			<td><%=dossier.getCostiPersonaleRd()%></td>
			<td><%=dossier.getIdUtentefinale()%></td>
			<td><%=dossier.getIdProgetto()%></td>
			<td><%=dossier.getPeriodoDiImposta()%></td>
			<td><%=dossier.getFilledFields()%> su <%=Const.DOSSIER_NUMERO_CAMPI %></td>
			
			<td class="center"><a href="/JspApp/DossierServlet?richiesta=updateRedirect&updateId=<%=dossier.getIdDossier()%>&id=<%=idUtenteFinale%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/DossierServlet?richiesta=delete&deleteId=<%=dossier.getIdDossier()%>&id=<%=idUtenteFinale%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/DossierServlet?richiesta=insertRedirect&id=<%=idUtenteFinale %>"><i class="fas fa-plus-circle fa-lg"> New Dossier</i></a>

	<br>
	<br>
	<a href="/JspApp/UtenteFinaleServlet?richiesta=UtenteFinaleManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>