<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Inserisci nuovo utente</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
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


</head>
<body>
<%
int idBO =  (Integer) request.getAttribute("idBO");
%>
	<div class="pre_contenitore">

		<p>New UtenteFinale</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/UtenteFinaleServlet?richiesta=insert&idBO=<%=idBO%>">

		
		<br>
		<br>
		DenominazioneSocieta: <input type="text" size="40" maxlength="40" name="denominazione_societa" />
		<br>
		<br>
		FormaGiuridica <input type="text" size="40" maxlength="40" name="forma_giuridica" />
		<br>
		<br>
		SedeLegale <input type="text" size="40" maxlength="40" name="sede_legale" />
		<br>
		<br>
		PartitaIva <input type="text" size="40" maxlength="40" name="partita_iva" />
		<br>
		<br>
		Telefono <input type="text" size="40" maxlength="40" name="telefono" />
		<br>
		<br>
		email <input type="text" size="40" maxlength="40" name="email" />
		<br>
		<br>
		IndirizzoUnitaLocale <input type="text" size="40" maxlength="40" name="indirizzoUnitaLocale" />
		<br>
		<br>
		AttivitaAzienda <input type="text" size="40" maxlength="40" name="attivita_azienda" />
		<br>
		<br>
		LegaleRapresentante <input type="text" size="40" maxlength="40" name="legale_rappresentante" />
		<br>
		<br>
		NatoA <input type="text" size="40" maxlength="40" name="nato_a" />
		<br>
		<br>
		NatoIl <input type="text" size="40" maxlength="40" name="nato_il" />
		<br>
		<br>
		IdUtente <input type="text" size="40" maxlength="40" name="id_utente" />
		<br>
		<br>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/UtenteFinaleServlet?richiesta=UtenteFinaleManager&idBO=<%=idBO%>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>