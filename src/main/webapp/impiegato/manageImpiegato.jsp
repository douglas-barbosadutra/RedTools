<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Impiegato</title>
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
	List<ImpiegatoDTO> allImpiegato = (List<ImpiegatoDTO>) request.getAttribute("allImpiegatoDTO");
	int idProgetto =  (int) session.getAttribute("idProgetto");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Impiegato Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>Id Impiegato</th>
			<th>Nominativo</th>
			<th>Azienda Cliente</th>
			<th>Livello</th>
			<th>Qualifica</th>
			<th>Mansione</th>
			<th>Titolo di studio</th>
			<th>Costo Orario</th>
			<th>Totale ore lavorate</th>
			<th>Costo Lordo Annuo</th>
		</tr>
		
		<%
			for (ImpiegatoDTO impiegato : allImpiegato) {
		%>
		<tr>
			<td><%=impiegato.getIdNome()%></td>
			<td><%=impiegato.getNominativo()%></td>
			<td><%=impiegato.getAziendaCliente().getDenominazioneSocieta()%></td>
			<td><%=impiegato.getLivello()%></td>
			<td><%=impiegato.getQualifica()%></td>
			<td><%=impiegato.getMansione()%></td>
			<td><%=impiegato.getTitoloDiStudio()%></td>
			<td><%=impiegato.getCostoOrario()%></td>
			<td><%=impiegato.getTotaleOreLavorate()%></td>
			<td><%=impiegato.getCostoLordoAnnuo()%></td>
			
			<td class="center"><a href="/ImpiegatoController/read?readId=<%=impiegato.getIdNome()%>"><i class="fas fa-eye" title="Leggi dettagli" style="color:black"></i></a></td>
			<td class="center"><a href="/ImpiegatoController/updateRedirect?updateId=<%=impiegato.getIdNome()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/ImpiegatoController/delete?deleteId=<%=impiegato.getIdNome()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
			<td class="center"><a href="/TotaleOreReDController/totaleOreReDManagement?id=<%=impiegato.getIdNome()%>"><i class="fas fa-clock" title="Ore R e D" style="color:black"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/ImpiegatoController/insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Impiegato</i></a>

	<br>
	<br>
	<a href="/DossierController/dossierManagement?id=<%=idProgetto %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>