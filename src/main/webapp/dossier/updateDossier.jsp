<%@ include file="/header.jsp"%>
<html>
<head>
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
	color: white;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>

<%
	DossierDTO updateDossier = (DossierDTO) request.getAttribute("updateDossier");
	int idUtenteFinale =  (Integer) request.getAttribute("id");
	final int idBO= (Integer) request.getAttribute("idBO");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Dossier Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/JspApp/DossierServlet?richiesta=update&idBO=<%=idBO%>">

		Costo dipendenti: <input type="text" size="40" maxlength="40" name="costoDipendenti" value="<%=updateDossier.getCostoDipendenti() %>"/>
		<input type="hidden" name="id" value="<%=idUtenteFinale %>"/>
		<input type="hidden" name="idDossier" value="<%=updateDossier.getIdDossier() %>"/>
		<br>
		<br>
		Fatturato periodo di imposta: <input type="text" size="40" maxlength="40" name="fatturatoPeriodoDiImposta" value="<%=updateDossier.getPeriodoDiImposta() %>"/>
		<br>
		<br>
		Numero dipendenti: <input type="text" size="40" maxlength="40" name="numeroDipendenti" value="<%=updateDossier.getNumeroDipendenti() %>"/>
		<br>
		<br>
		Costi attivita' RD: <input type="text" size="40" maxlength="40" name="costiAttivitaRd" value="<%=updateDossier.getCostiAttivitaRd() %>"/>
		<br>
		<br>
		Costi personale RD: <input type="text" size="40" maxlength="40" name="costiPersonaleRd" value="<%=updateDossier.getCostiPersonaleRd() %>"/>
		<br>
		<br>
		Id progetto: <input type="text" size="40" maxlength="40" name="idProgetto" value="<%=updateDossier.getIdProgetto() %>"/>
		<br>
		<br>
		
		Periodo di imposta: <input type="text" size="40" maxlength="40" name="periodoDiImposta" value="<%=updateDossier.getPeriodoDiImposta() %>"/>
		<br>
		<br>
		<input type="SUBMIT" value="Update">
		<br>
		<br>
		<a href="/JspApp/DossierServlet?richiesta=DossierManager&id=<%=idUtenteFinale %>&idBO=<%=idBO%>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>>

		</form>

	</div>
</body>
</html>