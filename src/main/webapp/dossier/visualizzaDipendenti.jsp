<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Dipendenti</title>
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
	padding-bottom: 10px;
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
	List<TotaleOreReDDTO> allTotaleOreReD = (List<TotaleOreReDDTO>) request.getAttribute("allTotaleOreReD");
	int idProgetto =  (int) session.getAttribute("idProgetto");
%>
</head>
<body>

	<div class="pre_contenitore">

		

	</div>
	
  <center>
	<table>
	
	<tr><td colspan=10, bgcolor="#c0c0c0"><font color = "black"><b>DIPENDENTI<b></font></td></tr>
	
		<tr>
		
			<th><multicol width=?> Nominativo</multicol></th>
			<th>Livello</th>
			<th>Qualifica</th>
			<th>Mansione</th>
			<th>Titolo di studio</th>
			<th>Totale ore ReD</th>
			<th>Costo Orario</th>
			<th>Totale costi ReD</th>
			
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
			
			<td><%=totaleOreReD.getImpiegato().getTotaleOreLavorate()%></td>
			<td><%=totaleOreReD.getImpiegato().getCostoLordoAnnuo()%></td>
			
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