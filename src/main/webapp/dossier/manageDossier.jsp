<%@ page import="it.contrader.dto.DossierDTO" %>
<%@page import="it.contrader.model.AziendaCliente"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="it.contrader.utils.*"%>
<%@ include file="../header.jsp"%>

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
 	List<DossierDTO> allDossier = (List<DossierDTO>) request.getAttribute("allDossierDTO");
	int idAziendaCliente =  (int) session.getAttribute("idAziendaCliente");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p> Gestione Dossier </p>

	</div>
	<br>



	<br />

	<table>
		<tr>
		    <th>Id</th>
			<th>Anno Di Imposta</th>
			<th>Costo Dipendenti</th>
			<th>Fatturato</th>
			<th>Numero Totale Dipendenti</th>
		    <th>Denominazione Azienda Cliente</th>
		    <th>Completamento</th>
		   
		    
		
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
			<td><%=dossier.getAziendaClienteDTO().getDenominazioneSocieta()%></td>
			<td><%=dossier.getFilledFields()%> on <%=Const.DOSSIER_NUMERO_CAMPI%></td>
		
			
			<td class="center"><a href="/DossierController/updateRedirect?id=<%=dossier.getIdDossier()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/DossierController/delete?id=<%=dossier.getIdDossier()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		    <td class="center"><a href="/DossierController/read?id=<%=dossier.getIdDossier()%>"><i class="fas fa-eye" title="Leggi dettagli" style="color:black"></i></a></td>
		    <td class="center"><a href="/ImpiegatoController/impiegatoManagement?id=<%=dossier.getIdDossier()%>"><i class="fas fa-user-alt" title="Impiegato" style="color:black"></i></a></td>
		    <td class="center"><a href="/FornitoreController/fornitoreManagement?id=<%=dossier.getIdDossier()%>"><i class="fas fa-truck-moving" title="Fornitori" style="color:black"></i></a></td>
		    <td class="center"><a href="/DossierController/visualizzaCostiEsterni?id=<%=dossier.getIdDossier()%>"><i class="fas fa-money-check-alt" title="Costi Esterni" style="color:black"></i></a></td>
		   <td class="center"><a href="/DossierController/readPratica?id=<%=dossier.getIdDossier()%>"><i class="fas fa-table" title="Visualizza Pratica" style="color:black"></i></a></td>
			<td class="center"><a href="/DossierController/visualizzaDipendenti?id=<%=dossier.getIdDossier()%>"><i class="fas fa-address-card" title="Dettagli Dipendenti" style="color:black"></i></a></td>
			 <td class="center"><a href="/DossierController/files/mod_docTables.xlsm?id=<%=dossier.getIdDossier()%>"><i class="far fa-file-excel" title="Excel" style="color:black"></i></a></td>
		
             
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/DossierController/insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo Dossier</i></a>

	<br>
	<br>
	<a href="/ProgettoController/progettoManagement?id=<%=idAziendaCliente%>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

</body>

</html>