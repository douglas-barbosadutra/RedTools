<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Fattura</title>
<style>
table {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 80%;
  text-align: center;
table-layout: fixed;
}

/* th:empty, td:empty {  */
/* background: yellow; */
/* height: 25px; */
/*  } */
 
tr:nth-child(even){background-color: #f2f2f2;}

tr:hover {
background-color: #ddd;}

th {
	border: 1px solid black;
	padding-top: 8px;
	padding-bottom: 8px;
	background-color: #008080;
	color: white;
	height: 30px;
}

td{
  border: 1px solid black;
  padding: 8px;
  height: 25px;
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

		</div>
	
  <center>
	<table>
	
	<tr><td colspan=7, bgcolor="#c0c0c0"><font color = "black"><b>COSTI ESTERNI<b></font></td></tr>
		
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
		
			if (allFattura.size()>0 && allFattura.get(0) != null) {
		%>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>

		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		    <td>Totale extramuros</td>
			<td><%=allFattura.get(0).getDossier().getTotaleAmmissibile()%></td>

		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>Numero Fornitori</td>
			<td><%=allFattura.get(0).getDossier().getNumeroFornitori()%></td>

		</tr>
		
		<%
			}
		%>
		
	</table>
 </center>
	<br>
	<br>
	<a href="dossierManagement?id=<%=idProgetto %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>