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
	AziendaClienteDTO aziendaClienteUpdateDTO = (AziendaClienteDTO) request.getAttribute("AziendaClienteUpdateDTO");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Azienda Cliente Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/AziendaClienteController/update">
 			
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
			<br>
			<input type="hidden" name="id" value="<%=aziendaClienteUpdateDTO.getIdAziendaCliente()%>" />
			<br>
			Denominazione Società: <input type="text" size="40" maxlength="40" name="DenominazioneSocieta" value="<%=aziendaClienteUpdateDTO.getDenominazioneSocieta()%>" />
			<br>
			<br>
			<br>
			<br>
			Forma Giuridica: <input type="text" size="40" maxlength="40" name="FormaGiuridica" value="<%=aziendaClienteUpdateDTO.getFormaGiuridica()%>" />
			<br>
			<br>
			<br>
			<br>
			Sede Legale: <input type="text" size="40" maxlength="40" name="SedeLegale" value="<%=aziendaClienteUpdateDTO.getSedeLegale()%>" />
			<br>
			<br>
			<br>
			<br>
			PartitaIva: <input type="text" size="40" maxlength="40" name="PartitaIva" value="<%=aziendaClienteUpdateDTO.getPartitaIva()%>" />
			<br>
			<br>
			<br>
			<br>
			Telefono: <input type="text" size="40" maxlength="40" name="telefono" value="<%=aziendaClienteUpdateDTO.getTelefono()%>" />
			<br>
			<br>
			<br>
			<br>
			Email: <input type="text" size="40" maxlength="40" name="email" value="<%=aziendaClienteUpdateDTO.getEmail()%>" />
			<br>
			<br>
			<br>
			<br>
			Indirizzo Unità Locale: <input type="text" size="40" maxlength="40" name="indirizzoUnitaLocale" value="<%=aziendaClienteUpdateDTO.getIndirizzoUnitaLocale()%>" />
			<br>
			<br>
			<br>
			<br>
			Attività Azienda: <input type="text" size="40" maxlength="40" name="AttivitaAzienda" value="<%=aziendaClienteUpdateDTO.getAttivitaAzienda()%>" />
			<br>
			<br>
			<br>
			<br>
			Legale Rappresentante: <input type="text" size="40" maxlength="40" name="LegaleRappresentante" value="<%=aziendaClienteUpdateDTO.getLegaleRappresentante()%>" />
			<br>
			<br>
			<br>
			<br>
			Nato A: <input type="text" size="40" maxlength="40" name="NatoA" value="<%=aziendaClienteUpdateDTO.getNatoA()%>" />
			<br>
			<br>
			<br>
			<br>
			Nato Il: <input type="text" size="40" maxlength="40" name="NatoIl" value="<%=aziendaClienteUpdateDTO.getNatoIl()%>" />
			<br>
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/AziendaClienteController/aziendaClienteManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>