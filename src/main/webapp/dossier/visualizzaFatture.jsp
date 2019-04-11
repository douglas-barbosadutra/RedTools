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
	int idProgetto =  (int) session.getAttribute("idProgetto");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Costi Esterni</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>Fornitore</th>
			<th>Data Fattura</th>
			<th>Numero Fattura</th>
			<th>Descrizione</th>
			<th>Totale Imponibile</th>
			<th>Percentuale Ammissibile</th>
			<th>Totale Ammissibile</th>

		</tr>
		
		<%
			for (FatturaDTO fattura : allFattura) {
		%>
		<tr>
			<td><%=fattura.getFornitore().getNomeFornitore()%></td>
			<td><%=fattura.getDataFattura()%></td>
			<td><%=fattura.getNumeroFattura()%></td>
			<td><%=fattura.getDescrizione()%></td>
			<td><%=fattura.getTotaleImponibile()%></td>
			<td><%=fattura.getPercentualeAmmissibile()%></td>
			<td><%=fattura.getTotaleAmmissibile()%></td>

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