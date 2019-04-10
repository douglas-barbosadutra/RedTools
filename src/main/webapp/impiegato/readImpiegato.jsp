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
	ImpiegatoDTO readImpiegatoDTO = (ImpiegatoDTO) request.getAttribute("impiegatoDTO");
	int idDossier =  (int) session.getAttribute("idDossier");
%>
</head>

<body>
	<div align="center">

		
			<h1>Impiegato</h1>

		</div>
		
<div align="center">
			<br>
			<br>
			<br>
			<font color="blue"><b>Impiegato Id</b></font>: <br/><b><%=readImpiegatoDTO.getIdNome()%> </b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Nominativo</b></font>: <br/><b><%=readImpiegatoDTO.getNominativo()%> </b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Azienda Cliente</b></font>: <br/><b><%=readImpiegatoDTO.getAziendaCliente().getDenominazioneSocieta()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Livello</b></font>: <br/><b><%=readImpiegatoDTO.getLivello()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Qualifica</b></font>: <br/><b><%=readImpiegatoDTO.getQualifica()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Mansione</b></font>: <br/><b><%=readImpiegatoDTO.getMansione()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Titolo di studio</b></font>: <br/><b><%=readImpiegatoDTO.getTitoloDiStudio()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Costo orario</b></font>: <br/><b><%=readImpiegatoDTO.getCostoOrario()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Totale ore lavorate</b></font>: <br/><b><%=readImpiegatoDTO.getTotaleOreLavorate()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Costo Lordo Annuo</b></font>: <br/><b><%=readImpiegatoDTO.getCostoLordoAnnuo()%></b>
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
			<br>
			<a href="impiegatoManagement?id=<%=idDossier %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


	</div>
</body>
</html>