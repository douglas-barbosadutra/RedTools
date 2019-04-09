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
	int idAziendaCliente =  (int) session.getAttribute("idAziendaCliente");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Mom Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/MomController/update">
		<br>
		Mom Id: <%=updateMom.getIdMom()%>
		<input type="hidden" name="idMom" value="<%=updateMom.getIdMom()%>">
		<br>
		<br>
		Luogo: <input type="text" size="40" maxlength="40" name="luogoMom" value="<%=updateMom.getLuogoMom()%>"/>
		<br>
		<br>
		Data: <input type="text" size="40" maxlength="40" name="dataDelGiornoMom" value="<%=updateMom.getDataDelGiornoMom()%>"/>
		<br>
		<br>
		Orario: <input type="text" size="40" maxlength="40" name="orarioMom" value="<%=updateMom.getOrarioMom()%>"/>
		<br>
		<br>
		Oggetto: <input type="text" size="40" maxlength="40" name="oggettoMom" value="<%=updateMom.getOggettoMom()%>"/>
		<br>
		<br>
		Progetto: <input type="text" size="40" maxlength="40" name="progettoMom" value="<%=updateMom.getProgettoMom()%>"/>
		<br>
		<br>
		Partecipanti: <input type="text" size="40" maxlength="40" name="partecipantiMom" value="<%=updateMom.getPartecipantiMom()%>"/>
		<br>
		<br>
		Agenda: <input type="text" size="400" maxlength="400" name="testoAgendaMom" value="<%=updateMom.getTestoAgendaMom()%>"/>
		<br>
		<br>
		Azione: <input type="text" size="400" maxlength="400" name="testoAzioneMom" value="<%=updateMom.getTestoAzioneMom()%>"/>
		<br>
		<br>
		Note: <input type="text" size="400" maxlength="400" name="testoNoteMom" value="<%=updateMom.getTestoNoteMom()%>"/>
		<br>
		<br>
		<input type="SUBMIT" value="Update">
		<br>
		<br>
		<a href="momManagement?id=<%=idAziendaCliente %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>