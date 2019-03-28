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
	UtenteFinaleDTO updateUtenteFinale = (UtenteFinaleDTO) request.getAttribute("utenteFinaleUpdate");
	
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>UtenteFinale Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/JspApp/UtenteFinaleServlet?richiesta=update">
 			
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


			</select>
			<br>
			<input type="hidden" name="user_id" value="<%=updateUtenteFinale.getId()%>" />
			<br>
			DenominazioneSocieta: <input type="text" size="40" maxlength="40" name="denominazione_societa" value="<%=updateUtenteFinale.getDenominazioneSocieta()%>" />
			<br>
			<br>
			formaGiuridicaUpdate: <input type="text" size="40" maxlength="40" name="forma_giuridica" value="<%=updateUtenteFinale.getSedeLegale()%>" />
			<br>
			<br>
			SedeLegale: <input type="text" size="40" maxlength="40" name="sede_legale" value="<%=updateUtenteFinale.getSedeLegale()%>" />
			<br>
			<br>
			PartitaIva: <input type="text" size="40" maxlength="40" name="partita_iva" value="<%=updateUtenteFinale.getPartitaIva()%>" />
			<br>
			<br>
			Telefono: <input type="text" size="40" maxlength="40" name="telefono" value="<%=updateUtenteFinale.getTelefono()%>" />
			<br>
			<br>
			Email: <input type="text" size="40" maxlength="40" name="email" value="<%=updateUtenteFinale.getEmail()%>" />
			<br>
			<br>
			IndirizzoUnitaLocale: <input type="text" size="40" maxlength="40" name="indirizzoUnitaLocale" value="<%=updateUtenteFinale.getIndirizzoUnitaLocale()%>" />
			<br>
			<br>
			AttivitaAzienda: <input type="text" size="40" maxlength="40" name="attivita_azienda" value="<%=updateUtenteFinale.getAttivitaAzienda()%>" />
			<br>
			<br>
			LegaleRappresentante: <input type="text" size="40" maxlength="40" name="legale_rappresentante" value="<%=updateUtenteFinale.getLegaleRappresentante()%>" />
			<br>
			<br>
			NatoA: <input type="text" size="40" maxlength="40" name="nato_a" value="<%=updateUtenteFinale.getNatoA()%>" />
			<br>
			<br>
			NatoIl: <input type="text" size="40" maxlength="40" name="nato_il" value="<%=updateUtenteFinale.getNatoIl()%>" />
			<br>
			<br>
			IdUtente: <input type="text" size="40" maxlength="40" name="id_utente" value="<%=updateUtenteFinale.getIdUtente()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/UtenteFinaleServlet?richiesta=UtenteFinaleManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>