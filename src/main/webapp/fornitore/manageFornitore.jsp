<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Fornitore</title>
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
	List<FornitoreDTO> allFornitore = (List<FornitoreDTO>) request.getAttribute("allFornitoreDTO");
	int idProgetto =  (int) session.getAttribute("idProgetto");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Fornitore Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>Id Fornitore</th>
			<th>Nome Fornitore</th>
			<th>Comune Fornitore</th>
			<th>Provincia Fornitore</th>
			<th>Partita Iva Fornitore</th>
		</tr>
		
		<%
			for (FornitoreDTO fornitore : allFornitore) {
		%>
		<tr>
			<td><%=fornitore.getIdFornitore()%></td>
			<td><%=fornitore.getNomeFornitore()%></td>
			<td><%=fornitore.getComuneFornitore()%></td>
			<td><%=fornitore.getProvinciaFornitore()%></td>
			<td><%=fornitore.getPartitaIvaFornitore()%></td>
			
			<td class="center"><a href="/FornitoreController/read?readId=<%=fornitore.getIdFornitore()%>"><i class="fas fa-eye" title="Leggi dettagli" style="color:black"></i></a></td>
			<td class="center"><a href="/FornitoreController/updateRedirect?updateId=<%=fornitore.getIdFornitore()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/FornitoreController/delete?deleteId=<%=fornitore.getIdFornitore()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
			<td class="center"><a href="/FatturaController/fatturaManagement?id=<%=fornitore.getIdFornitore()%>"><i class="fas fa-file-invoice" title="Fattura" style="color:black"></i></a></td>
			
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/FornitoreController/insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Fornitore</i></a>

	<br>
	<br>
	<a href="/DossierController/dossierManagement?id=<%=idProgetto %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>