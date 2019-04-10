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
	FornitoreDTO readFornitoreDTO = (FornitoreDTO) request.getAttribute("fornitoreDTO");
	int idDossier =  (int) session.getAttribute("idDossier");
%>
</head>

<body>
	<div align="center">

		
			<h1>Fornitore</h1>

		</div>
		
<div align="center">
			<br>
			<br>
			<br>
			<font color="blue"><b>Fornitore Id</b></font>: <br/><b><%=readFornitoreDTO.getIdFornitore()%> </b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Nome Fornitore</b></font>: <br/><b><%=readFornitoreDTO.getNomeFornitore()%> </b>
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
			<a href="fornitoreManagement?id=<%=idDossier %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


	</div>
</body>
</html>