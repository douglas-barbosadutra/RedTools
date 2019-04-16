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
	FatturaDTO readFatturaDTO = (FatturaDTO) request.getAttribute("fatturaDTO");
	int idFornitore =  (int) session.getAttribute("idFornitore");
%>
</head>

<body>
	<div align="center">

		
			<h1>Fattura</h1>

		</div>
		
<div align="center">
			<br>
			<br>
			<br>
			<font color="blue"><b>Fattura Id</b></font>: <br/><b><%=readFatturaDTO.getIdFattura()%> </b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Data Fattura</b></font>: <br/><b><%=readFatturaDTO.getDataFattura()%> </b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Numero Fattura</b></font>: <br/><b><%=readFatturaDTO.getNumeroFattura()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Descrizione</b></font>: <br/><b><%=readFatturaDTO.getDescrizione()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Totale Imponibile</b></font>: <br/><b><%=readFatturaDTO.getTotaleImponibile()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Percentuale Ammissibile</b></font>: <br/><b><%=readFatturaDTO.getPercentualeAmmissibile()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Anno Di Imposta</b></font>: <br/><b><%=readFatturaDTO.getDossier().getPeriodoDiImposta()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Fornitore</b></font>: <br/><b><%=readFatturaDTO.getFornitore().getNomeFornitore()%></b>
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
			<a href="fatturaManagement?id=<%=idFornitore %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


	</div>
</body>
</html>