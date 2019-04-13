<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Mom</title>
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
	color: orange;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>
</head>
<%
	List<MomDTO> allMom = (List<MomDTO>) request.getAttribute("allMomDTO");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Mom Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>Id Mom</th>
			<th>Denominazione Azienda</th>
			<th>Partita Iva</th>
			<th>Luogo</th>
			<th>Data</th>
			<th>Orario</th>
			<th>Oggetto</th>
			<th>Progetto</th>
			<th>Partecipanti</th>
			
		</tr>
		
		<%
			for (MomDTO mom : allMom) {
		%>
		<tr>
			<td><%=mom.getIdMom()%></td>
			<td><%=mom.getAziendaCliente().getDenominazioneSocieta()%></td>
			<td><%=mom.getAziendaCliente().getPartitaIva()%></td>
			<td><%=mom.getLuogoMom()%></td>
			<td><%=mom.getDataDelGiornoMom()%></td>
			<td><%=mom.getOrarioMom()%></td>
			<td><%=mom.getOggettoMom()%></td>
			<td><%=mom.getProgettoMom()%></td>
			<td><%=mom.getPartecipantiMom()%></td>
		
			
			<td class="center"><a href="/MomController/read?readId=<%=mom.getIdMom()%>"><i class="fas fa-eye" title="Leggi dettagli" style="color:black"></i></a></td>
			<td class="center"><a href="/MomController/updateRedirect?updateId=<%=mom.getIdMom()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/MomController/delete?deleteId=<%=mom.getIdMom()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/MomController/insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Mom</i></a>

	<br>
	<br>
	<a href="/AziendaClienteController/aziendaClienteManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>