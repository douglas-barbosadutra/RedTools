<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Nuova Azienda</title>
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
//int idBO =  (Integer) request.getAttribute("idBO");
%>
	<div class="pre_contenitore">

		<p>Nuova Azienda Cliente</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/AziendaClienteController/insert">

		
		<br>
		<br>
		Denominazione Societa: <input type="text" size="40" maxlength="40" name="denominazioneSocieta" />
		<br>
		<br>
		Forma Giuridica <input type="text" size="40" maxlength="40" name="formaGiuridica" />
		<br>
		<br>
		Sede Legale <input type="text" size="40" maxlength="40" name="sedeLegale" />
		<br>
		<br>
		Partita Iva <input type="text" size="40" maxlength="40" name="partitaIva" />
		<br>
		<br>
		Telefono <input type="text" size="40" maxlength="40" name="telefono" />
		<br>
		<br>
		Email <input type="text" size="40" maxlength="40" name="email" />
		<br>
		<br>
		Indirizzo Unita Locale <input type="text" size="40" maxlength="40" name="indirizzoUnitaLocale" />
		<br>
		<br>
		Attivita Azienda <input type="text" size="40" maxlength="40" name="attivitaAzienda" />
		<br>
		<br>
		Legale Rapresentante <input type="text" size="40" maxlength="40" name="legaleRappresentante" />
		<br>
		<br>
		Nato A <input type="text" size="40" maxlength="40" name="natoA" />
		<br>
		<br>
		Nato Il <input type="text" size="40" maxlength="40" name="natoIl" />
		<br>
<!-- 		<br> -->
<!-- 		Inserisci Id Business Owner <input type="text" size="40" maxlength="40" name="id_utente" /> -->

		<br> 
 		<br> 
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/AziendaClienteController/aziendaClienteManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>