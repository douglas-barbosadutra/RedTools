<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Dipendenti</title>
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
	List<TotaleOreReDDTO> allTotaleOreReD = (List<TotaleOreReDDTO>) request.getAttribute("allTotaleOreReD");
	int idProgetto =  (int) session.getAttribute("idProgetto");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Dipendenti</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
		
			<th>Nominativo</th>
			<th>Livello</th>
			<th>Qualifica</th>
			<th>Mansione</th>
			<th>Titolo di studio</th>
			<th>Totale ore ReD</th>
			<th>Costo Orario</th>
			<th>Totale costi ReD</th>
			<th></th>
			<th>Totale ore lavorate</th>
			<th>Costo Lordo Annuo</th>
			
		</tr>
		
		<%
			for (TotaleOreReDDTO totaleOreReD : allTotaleOreReD) {
		%>
		<tr>
		
			<td><%=totaleOreReD.getImpiegato().getNominativo()%></td>
			<td><%=totaleOreReD.getImpiegato().getLivello()%></td>
			<td><%=totaleOreReD.getImpiegato().getQualifica()%></td>
			<td><%=totaleOreReD.getImpiegato().getMansione()%></td>
			<td><%=totaleOreReD.getImpiegato().getTitoloDiStudio()%></td>
			<td><%=totaleOreReD.getOreLavorateRed()%></td>
			<td><%=totaleOreReD.getImpiegato().getCostoOrario()%></td>
			<td><%=totaleOreReD.getTotaleCostiReD()%></td>
			<td></td>
			<td><%=totaleOreReD.getImpiegato().getTotaleOreLavorate()%></td>
			<td><%=totaleOreReD.getImpiegato().getCostoLordoAnnuo()%></td>
			
		</tr>
		<%
			}
		%>
	</table>
	
	<br>
	<br>
	<a href="dossierManagement?id=<%=idProgetto %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>