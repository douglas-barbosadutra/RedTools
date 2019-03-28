<%@ include file="../header.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
/*contenitore in cima dove c' scritto "Login"*/
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
	MomDTO updateMom = (MomDTO) request.getAttribute("momUpdate");
	int idUtenteFinale =  (Integer) request.getAttribute("id");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Mom Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/JspApp/MomServlet?richiesta=update">
			<input type="hidden" name="id" value="<%=idUtenteFinale %>"/>
			<br>
			Nome Utente Finale: <input type="text" size="40" maxlength="40" name="nome_utente_finale_mom" />
		<input type="hidden" name="id" value="<%=idUtenteFinale %>"/>
		<br>
		<br>
		Luogo: <input type="text" size="40" maxlength="40" name="luogo_mom" value="<%=updateMom.getLuogo_mom()%>"/>
		<br>
		<br>
		Data: <input type="text" size="40" maxlength="40" name="data_del_giorno_mom" value="<%=updateMom.getData_del_giorno_mom()%>"/>
		<br>
		<br>
		Orario: <input type="text" size="40" maxlength="40" name="orario_mom" value="<%=updateMom.getOrario_mom()%>"/>
		<br>
		<br>
		Oggetto: <input type="text" size="40" maxlength="40" name="oggetto_mom" value="<%=updateMom.getOggetto_mom()%>"/>
		<br>
		<br>
		Progetto: <input type="text" size="40" maxlength="40" name="progetto_mom" value="<%=updateMom.getProgetto_mom()%>"/>
		<br>
		<br>
		Partecipanti: <input type="text" size="40" maxlength="40" name="partecipanti_mom" value="<%=updateMom.getPartecipanti_mom()%>"/>
		<br>
		<br>
		Agenda: <input type="text" size="400" maxlength="400" name="testo_agenda_mom" value="<%=updateMom.getTesto_agenda_mom()%>"/>
		<br>
		<br>
		Azione: <input type="text" size="400" maxlength="400" name="testo_azione_mom" value="<%=updateMom.getTesto_azione_mom()%>"/>
		<br>
		<br>
		Note: <input type="text" size="400" maxlength="400" name="testo_note_mom" value="<%=updateMom.getTesto_note_mom()%>"/>
		<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/MomServlet?richiesta=MomManager&id=<%=idUtenteFinale %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>