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
	AziendaClienteDTO readAziendaClienteDTO = (AziendaClienteDTO) request.getAttribute("AziendaClienteDTO");
%>
</head>

<body>
	<div align="center">

		
			<h1>Azienda <%=readAziendaClienteDTO.getDenominazioneSocieta()%></h1>

		</div>
		
<!-- 		<form method="POST" action="/AziendaClienteController/aziendaClienteManagement"> -->
 			
<%-- 			<% --%>
<!-- // 				String selected = "selected=\"selected\""; -->
<!-- // 				String adminSelected = ""; -->
<!-- // 				String boSelected = ""; -->
<!-- // 				if (updateUser.getUsertype().equals("admin")) { -->
<!-- // 					adminSelected = selected; -->
<!-- // 				} else -->
<!-- // 					boSelected = selected; -->
<%-- 			%> --%>
		

<!-- 			User type: <select style="width: 270px;" name="user_type"> -->

<%-- 				<option <%=adminSelected%> value="superuser">Super User</option> --%>
<%-- 				<option <%=boSelected%> value="user">Business owner</option> --%>


	<%-- 		</select>  --%>
<!-- 			<br> -->
<%-- 			<input type="hidden" name="user_id" value="<%=updateUtenteFinale.getId()%>" /> --%>
<!-- 			<br> -->
<div align="center">
			<br>
			<br>
			<br>
			Forma Giuridica: <%=readAziendaClienteDTO.getFormaGiuridica()%> 
			<br>
			<br>
			<br>
			Sede Legale: <%=readAziendaClienteDTO.getSedeLegale()%>
			<br>
			<br>
			<br>
			Partita Iva: <%=readAziendaClienteDTO.getPartitaIva()%>
			<br>
			<br>
			<br>
			Telefono: <%=readAziendaClienteDTO.getTelefono()%>
			<br>
			<br>
			<br>
			Email: <%=readAziendaClienteDTO.getEmail()%>
			<br>
			<br>
			<br>
			Indirizzo Unita Locale: <%=readAziendaClienteDTO.getIndirizzoUnitaLocale()%>
			<br>
			<br>
			<br>
			Attività Azienda: <%=readAziendaClienteDTO.getAttivitaAzienda()%>
			<br>
			<br>
			<br>
			Legale Rappresentante: <%=readAziendaClienteDTO.getLegaleRappresentante()%>
			<br>
			<br>
			<br>
			Nato A: <%=readAziendaClienteDTO.getNatoA()%>
			<br>
			<br>
			<br>
			Nato Il: <%=readAziendaClienteDTO.getNatoIl()%>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			
			<br>
			<br>
			<a href="/AziendaClienteController/aziendaClienteManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


	</div>
</body>
</html>