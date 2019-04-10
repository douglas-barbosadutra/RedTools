<%@ include file="../header.jsp"%>
<%@page import="it.contrader.model.AziendaCliente"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%@ include file="/header.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>

body {
	background-image:
		url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
	color: white;
}
</style>

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
</head>
<%
	    DossierDTO read = (DossierDTO) request.getAttribute("ReadDossierDTO");
	    int idAziendaCliente =  (int) session.getAttribute("idAziendaCliente");
%>

</head>

<body>


		
			<h1>dossier N=<%=read.getIdDossier()%></h1>

		
		
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<font color="blue"><b>periodo di imposta</b></font>: <br/><b><%=read.getPeriodoDiImposta()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Costo dipendenti periodo di imposta</b></font>: <br/><b><%=read.getCostoDipendentiPeriodoDiImposta()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Fatturato </b></font>: <br/><b><%=read.getFatturatoPeriodoDiImposta()%></b>
			<br>
			<br>
			<br>
			<font color="blue"><b>Numero dipendenti</b></font>: <br/><b><%=read.getNumeroTotaleDipendenti()%></b>
			<br>
			<br>
			<br>
			
			<br>
			<br>
			<br>
			
			<br>
			<br>
			<a href="/dossierManagement?id=<%=idAziendaCliente%>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


	
</body>
</html>