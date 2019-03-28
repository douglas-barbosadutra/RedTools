<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Nuovo Dossier</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
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
	int idUtenteFinale =  (Integer) request.getAttribute("id");
%>
</head>
<body>
	<div class="pre_contenitore">

		<p>New Dossier</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/DossierServlet?richiesta=insert">

		
		Costo dipendneti: <input type="text" size="40" maxlength="40" name="costoDipendenti" />
		<input type="hidden" name="id" value="<%=idUtenteFinale %>"/>
		<br>
		<br>
		Fatturato periodo di imposta: <input type="text" size="40" maxlength="40" name="fatturatoPeriodoDiImposta" />
		<br>
		<br>
		Numero dipendenti: <input type="text" size="40" maxlength="40" name="numeroDipendenti" />
		<br>
		<br>
		Costi attivita' RD: <input type="text" size="40" maxlength="40" name="costiAttivitaRd" />
		<br>
		<br>
		Costi personale RD: <input type="text" size="40" maxlength="40" name="costiPersonaleRd" />
		<br>
		<br>
		Id utente finale: <input type="text" size="40" maxlength="40" name="idUtentefinale" />
		<br>
		<br>
		Id progetto: <input type="text" size="40" maxlength="40" name="idProgetto" />
		<br>
		<br>
		Id dossier: <input type="text" size="40" maxlength="40" name="idDossier" />
		<br>
		<br>
		Periodo di imposta: <input type="text" size="40" maxlength="40" name="periodoDiImposta" />
		<br>
		<br>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/DossierServlet?richiesta=DossierManager&id=<%=idUtenteFinale %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>