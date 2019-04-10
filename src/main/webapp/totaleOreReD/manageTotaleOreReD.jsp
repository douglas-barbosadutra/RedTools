<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione TotaleOreReD</title>
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
	width: 800px;
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
	List<TotaleOreReDDTO> allTotaleOreReD = (List<TotaleOreReDDTO>) request.getAttribute("allTotaleOreReDDTO");
	int idDossier =  (int) session.getAttribute("idDossier");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Totale Ore ReD Management</p>
		

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>Id TotaleOreReD</th>
			<th>Ore R & D</th>
			<th>Anno di Imposta</th>
			<th>Impiegato</th>
		</tr>
		
		<%
			for (TotaleOreReDDTO totaleOreReD : allTotaleOreReD) {
		%>
		<tr>
			<td><%=totaleOreReD.getIdTotaleOreReD()%></td>
			<td><%=totaleOreReD.getOreLavorateRed()%></td>
			<td><%=totaleOreReD.getDossier().getPeriodoDiImposta()%></td>
			<td><%=totaleOreReD.getImpiegato().getNominativo()%></td>
			
			<td class="center"><a href="/TotaleOreReDController/read?readId=<%=totaleOreReD.getIdTotaleOreReD()%>"><i class="fas fa-eye" title="Leggi dettagli" style="color:black"></i></a></td>
			<td class="center"><a href="/TotaleOreReDController/updateRedirect?updateId=<%=totaleOreReD.getIdTotaleOreReD()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/TotaleOreReDController/delete?deleteId=<%=totaleOreReD.getIdTotaleOreReD()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/TotaleOreReDController/insertRedirect"><i class="fas fa-plus-circle fa-lg"> New TotaleOreReD</i></a>

	<br>
	<br>
	<a href="/ImpiegatoController/impiegatoManagement?id=<%=idDossier %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>