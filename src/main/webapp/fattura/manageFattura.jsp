<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Fattura</title>
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
	List<FatturaDTO> allFattura = (List<FatturaDTO>) request.getAttribute("allFatturaDTO");
	int idDossier =  (int) session.getAttribute("idDossier");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Fattura Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>Id Fattura</th>
			<th>Data Fattura/th>
			<th>Numero Fattura/th>
			<th>Descrizione</th>
			<th>Totale Imponibile</th>
			<th>Percentuale Ammissibile</th>
			<th>Anno Di Imposta</th>
			<th>Fornitore</th>

		</tr>
		
		<%
			for (FatturaDTO fattura : allFattura) {
		%>
		<tr>
			<td><%=fattura.getIdFattura()%></td>
			<td><%=fattura.getDataFattura()%></td>
			<td><%=fattura.getNumeroFattura()%></td>
			<td><%=fattura.getDescrizione()%></td>
			<td><%=fattura.getTotaleImponibile()%>></td>
			<td><%=fattura.getPercentualeAmmissibile()%></td>
			<td><%=fattura.getDossier().getPeriodoDiImposta()%></td>
			<td><%=fattura.getFornitore().getNomeFornitore()%></td>
			
			<td class="center"><a href="/FatturaController/read?readId=<%=fattura.getIdFattura()%>"><i class="fas fa-eye" title="Leggi dettagli" style="color:black"></i></a></td>
			<td class="center"><a href="/FatturaController/updateRedirect?updateId=<%=fattura.getIdFattura()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/FatturaController/delete?deleteId=<%=fattura.getIdFattura()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/FatturaController/insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Fattura</i></a>

	<br>
	<br>
	<a href="/FornitoreController/fornitoreManagement?id=<%=idDossier %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>