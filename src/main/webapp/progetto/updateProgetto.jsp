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
	ProgettoDTO updateProgetto = (ProgettoDTO) request.getAttribute("progettoUpdate");
	int idUtenteFinale =  (Integer) request.getAttribute("id");
	final int idBO= (Integer) request.getAttribute("idBO");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Progetto Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/JspApp/ProgettoServlet?richiesta=update&idBO=<%=idBO%>">
			<input type="hidden" name="id" value="<%=idUtenteFinale %>"/>
			<br>
			Nome Progetto: <input type="text" size="40" maxlength="40" name="nomeProgetto" value="<%=updateProgetto.getNomeProgetto()%>" />
			<input type="hidden" name="idProgetto" value="<%=updateProgetto.getIdProgetto()%>">
			<br>
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/ProgettoServlet?richiesta=ProgettoManager&id=<%=idUtenteFinale %>&idBO=<%=idBO%>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>