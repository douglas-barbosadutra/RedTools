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
	FatturaDTO updateFattura = (FatturaDTO) request.getAttribute("fatturaUpdate");
	int idFornitore =  (int) session.getAttribute("idFornitore");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Fattura Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/FatturaController/update">
		<br>
		Fattura Id: <%=updateFattura.getIdFattura()%>
		<br>
		<br>
		Anno Di Imposta: <%=updateFattura.getDossier().getPeriodoDiImposta()%>
		<br>
		<br>
		Fornitore: <%=updateFattura.getFornitore().getNomeFornitore()%>
		<br>
		<br>
		<input type="hidden" name="idFattura" value="<%=updateFattura.getIdFattura()%>">
		<br>
		<br>
		Data Fattura: <input type="text" size="40" maxlength="40" name="dataFattura" value="<%=updateFattura.getDataFattura()%>"/>
		<br>
		<br>
		Numero Fattura: <input type="text" size="40" maxlength="40" name="numeroFattura" value="<%=updateFattura.getNumeroFattura()%>"/>
		<br>
		<br>
		Descrizione: <input type="text" size="40" maxlength="40" name="descrizione" value="<%=updateFattura.getDescrizione()%>"/>
		<br>
		<br>
		Totale Imponibile: <input type="text" size="40" maxlength="40" name="totaleImponibile" value="<%=updateFattura.getTotaleImponibile()%>"/>
		<br>
		<br>
		Percentuale Ammissibile: <input type="text" size="40" maxlength="40" name="percentualeAmmissibile" value="<%=updateFattura.getPercentualeAmmissibile()%>"/>
		<br>
		<br>
		<input type="SUBMIT" value="Update">
		<br>
		<br>
		<a href="fatturaManagement?id=<%=idFornitore %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>