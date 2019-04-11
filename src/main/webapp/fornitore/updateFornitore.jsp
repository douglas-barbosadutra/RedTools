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
	FornitoreDTO updateFornitore = (FornitoreDTO) request.getAttribute("fornitoreUpdate");
	int idDossier =  (int) session.getAttribute("idDossier");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Fornitore Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/FornitoreController/update">
		<br>
		Fornitore Id: <%=updateFornitore.getIdFornitore()%>
		<input type="hidden" name="idFornitore" value="<%=updateFornitore.getIdFornitore()%>">
		<br>
		<br>
		Nome Fornitore: <input type="text" size="40" maxlength="40" name="nomeFornitore" value="<%=updateFornitore.getNomeFornitore()%>"/>
		<br>
		<br>
		Comune: <input type="text" size="40" maxlength="40" name="comuneFornitore" value="<%=updateFornitore.getComuneFornitore()%>"/>
		<br>
		<br>
		Provincia: <input type="text" size="40" maxlength="40" name="provinciaFornitore" value="<%=updateFornitore.getProvinciaFornitore()%>"/>
		<br>
		<br>
		Partita iva: <input type="text" size="40" maxlength="40" name="partitaIvaFornitore" value="<%=updateFornitore.getPartitaIvaFornitore()%>"/>
		<br>
		<br>
		<input type="SUBMIT" value="Update">
		<br>
		<br>
		<a href="fornitoreManagement?id=<%=idDossier %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>