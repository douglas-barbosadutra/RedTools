<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Nuova Mom</title>
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
	int idAziendaCliente =  (int) session.getAttribute("idAziendaCliente");
%>
</head>
<body>
	<div class="pre_contenitore">

		<p>New Mom</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/MomController/insert">

		
		Nome Utente Finale: <input type="text" size="40" maxlength="40" name="nome_utente_finale_mom" />
		<input type="hidden" name="id" value="<%=idAziendaCliente %>"/>
		<br>
		<br>
		Luogo: <input type="text" size="40" maxlength="40" name="luogo_mom" />
		<br>
		<br>
		Data: <input type="text" size="40" maxlength="40" name="data_del_giorno_mom" />
		<br>
		<br>
		Orario: <input type="text" size="40" maxlength="40" name="orario_mom" />
		<br>
		<br>
		Oggetto: <input type="text" size="40" maxlength="40" name="oggetto_mom" />
		<br>
		<br>
		Progetto: <input type="text" size="40" maxlength="40" name="progetto_mom" />
		<br>
		<br>
		Partecipanti: <input type="text" size="40" maxlength="40" name="partecipanti_mom" />
		<br>
		<br>
		Agenda: <input type="text" size="400" maxlength="400" name="testo_agenda_mom" />
		<br>
		<br>
		Azione: <input type="text" size="400" maxlength="400" name="testo_azione_mom" />
		<br>
		<br>
		Note: <input type="text" size="400" maxlength="400" name="testo_note_mom" />
		<br>
		<br>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="MomController/momManagement?id=<%=idAziendaCliente %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>