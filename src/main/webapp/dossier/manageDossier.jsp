<%@ include file="/header.jsp"%>
<%@ page import="it.contrader.dto.DossierDTO" %>

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
 List<DossierDTO> allDossier = (List<DossierDTO) request.getAttribute("allDossierDTO");

%>
</head>
<body>

	<div class="pre_contenitore">

		<p> Gestione Dossier </p>

	</div>
	<br>



	<br />
<div align="center">
	<table>
		<tr>
		    <th>Id</th>
			<th>Anno Di Imposta</th>
			<th>Costo Dipendenti</th>
			<th>Fatturato</th>
			<th>Numero Totale Dipendenti</th>
			<th>IdProgetto</th>
		    <th>idAziendaCliente</th>
		    <th>Update</th>
		    <th>Delete</th>
		    <th>Completamento</th>
		    <th>Costi esterni</th>
		    <th>Esercizio</th>
		    <th>Word</th>
		    
		
		</tr>
		<%
			for (DossierDTO dossier : allDossier) {
		%>
		<tr>
			<td><%=dossier.getIdDossier()%></td>
			<td><%=dossier.getPeriodoDiImposta()%></td>
			<td><%=dossier.getCostoDipendentiPeriodoDiImposta()%></td>
			<td><%=dossier.getFatturatoPeriodoDiImposta()%></td>
			<td><%=dossier.getNumeroTotaleDipendenti()%></td>
			<td><%=dossier.getIdProgetto()%></td>
			<td><%=dossier.geIdAziendaCliente()%></td>
			<td><%=dossier.getFilledFields()%> on <%=Const.DOSSIER_NUMERO_CAMPI%></td>
			
			<td class="center"><a href="/DossierController/updateRedirect?id =<%=dossier.getIdDossier()%>&idAzienda=<%=idAziendaCliente%>&idBO=<%=idBO%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/DossierController/delete&deleteId=<%=dossier.getIdDossier()%>&idAzinda=<%=idAziendaCliente%>&idBO=<%=idBO%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
			<td class="center"><a href="/NUOVO PERCORSO1"><i class="fas fa-clipboard" title="1"></i></a></td>
			<td class="center"><a href="NUOVOPERCORSO2"><i class="fas fa-clipboard" title="2"></i></a></td>
			<td class="center"><a href="NUOVOPERCORSE 3"><i class="fas fa-clipboard" title="3"></i></a></td>
             //
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/DossierController/insertRedirect?&idAzienda=<%=idAziendaCliente %>&idBO=<%=idBO%>"><i class="fas fa-plus-circle fa-lg"> Nuovo Dossier</i></a>

	<br>
	<br>
	<a href="/HomeController/dossierManage><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>