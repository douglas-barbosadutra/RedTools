<%@page import="it.contrader.model.AziendaCliente"%>
<%@ include file="../header.jsp"%>
<%!
private String convertUsertype(String userType) {
		if (userType.equals("superuser"))
			return "Super User";
		else
			return "Business Owner";
	}%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
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
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>

.pre_contenitore {
	width: 700px;
	margin: auto;
	height: 50px;
	border: 1px solid;
	border-radius: 40px 40px 40px 40px;
	background-color: rgba(41, 173, 123, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: #9f00ff;;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>
</head>
<%
	List<AziendaClienteDTO> allAziendeClienti = (List<AziendaClienteDTO>) request.getAttribute("allAziendaClienteDTO");
	
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Utente Finale Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID Azienda</th>
			<th>Società</th>
			<th>Forma Giuridica</th>
			<th>Sede Legale</th>
			<th>Partita Iva</th>
			<th>Telefono</th>
			<th>Email</th>
			<th>Indirizzo Unita Locale</th>
			<th>Attività Azienda</th>
			<th>Legale Rappresentante</th>
			<th>nato A</th>
			<th>nato il</th>
			<th>Completamento Campi Aziendali</th>
		</tr>
		
		
		
		<%
			for (AziendaClienteDTO aziendaCliente : allAziendeClienti) {
		%>
		<tr>
			<td><%=aziendaCliente.getIdAziendaCliente()%></td>
			<td><%=aziendaCliente.getDenominazioneSocieta()%></td>
			<td><%=aziendaCliente.getFormaGiuridica()%></td>
			<td><%=aziendaCliente.getSedeLegale()%></td>
			<td><%=aziendaCliente.getPartitaIva()%></td>
			<td><%=aziendaCliente.getTelefono()%></td>
			<td><%=aziendaCliente.getEmail()%></td>
			<td><%=aziendaCliente.indirizzoUnitaLocale%></td>
			<td><%=aziendaCliente.attivitaAzienda%></td>
			<td><%=aziendaCliente.legaleRappresentante%></td>
			<td><%=aziendaCliente.natoA%></td>
			<td><%=aziendaCliente.natoIl%></td>
			<td><%=aziendaCliente.getFilledFields()%> on <%=Const.UTENTE_FINALE_NUMERO_CAMPI %></td>
			
			<td class="center"><a href="/ProgettoController/progettoManagement"><i class="fas fa-clipboard" title="Progetto"></i></a></td>
			<td class="center"><a href="/DossierController/dossierManagement"><i class="fas fa-book" title="Dossier"></i></a></td>
			<td class="center"><a href="/MomController/momManagement"><i class="fas fa-pencil-alt" title="Mom"></i></a></td>
			<td class="center"><a href="/AziendaClienteController/updateRedirect"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/AziendaClienteController/delete"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/AziendaClienteController/insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuova Azienda Cliente</i></a>

	<br>
	<br>
	<a href="/HomeController/BoManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>