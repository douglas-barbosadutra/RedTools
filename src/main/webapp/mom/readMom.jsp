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
	MomDTO readMomDTO = (MomDTO) request.getAttribute("momDTO");
int idAziendaCliente =  (int) session.getAttribute("idAziendaCliente");
%>
</head>

<body>
	<div align="center">

		
			<h1>Mom <%=readMomDTO.getProgettoMom()%></h1>

		</div>
		
<div align="center">
			<br>
			<br>
			<br>
			<font color="blue"><b>Mom Id</b></font>: <br/><b><%=readMomDTO.getIdMom()%> </b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Luogo</b></font>: <br/><b><%=readMomDTO.getLuogoMom()%> </b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Data</b></font>: <br/><b><%=readMomDTO.getDataDelGiornoMom()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Orario</b></font>: <br/><b><%=readMomDTO.getOrarioMom()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Oggetto</b></font>: <br/><b><%=readMomDTO.getOggettoMom()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Progetto</b></font>: <br/><b><%=readMomDTO.getProgettoMom()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Partecipanti</b></font>: <br/><b><%=readMomDTO.getPartecipantiMom()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Agenda</b></font>: <br/><b><%=readMomDTO.getTestoAgendaMom()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Azione</b></font>: <br/><b><%=readMomDTO.getTestoAzioneMom()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Note</b></font>: <br/><b><%=readMomDTO.getTestoNoteMom()%></b>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			
			<br>
			<br>
			<a href="momManagement?id=<%=idAziendaCliente %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


	</div>
</body>
</html>