<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Nuova Impiegato</title>
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
<%
	int idDossier =  (int) session.getAttribute("idDossier");
%>
</head>
<body>
	<div class="pre_contenitore">

		<p>New Impiegato</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/ImpiegatoController/insert">

		
		Nominativo: <input type="text" size="40" maxlength="40" name="nominativo" />
		<br>
		<br>
		Livello: <input type="text" size="40" maxlength="40" name="livello" />
		<br>
		<br>
		Qualifica: <input type="text" size="40" maxlength="40" name="qualifica" />
		<br>
		<br>
		Mansione: <input type="text" size="40" maxlength="40" name="mansione" />
		<br>
		<br>
		Titolo di studio: <input type="text" size="40" maxlength="40" name="titoloDiStudio" />
		<br>
		<br>
		Costo orario: <input type="text" size="40" maxlength="40" name="costoOrario" />
		<br>
		<br>
		Totale ore lavorate: <input type="text" size="40" maxlength="40" name="totaleOreLavorate" />
		<br>
		<br>
		Costo Lordo Annuo: <input type="text" size="40" maxlength="40" name="costoLordoAnnuo" />
		<br>
		<br>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="impiegatoManagement?id=<%=idDossier %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>