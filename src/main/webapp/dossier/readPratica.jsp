<%@ include file="../header.jsp"%>
<%@page import="it.contrader.model.AziendaCliente"%>
<%@page import="it.contrader.model.Progetto"%>
<%@page import="it.contrader.model.Impiegato"%>

<%@ page import="javax.servlet.http.HttpSession"%>


<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 60%;
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
     AziendaClienteDTO readAziendaCliente = (AziendaClienteDTO) request.getAttribute("ReadAziendaCliente");
     DossierDTO readDossierDTO  = (DossierDTO) request.getAttribute("ReadDossierDTO");
     ProgettoDTO progetto = (ProgettoDTO) request.getAttribute("ReadProgetto");
     int idProgetto = (int) progetto.getIdProgetto();
	
%>

<body>

<center>
<table >
  
  <tr><td colspan=2, bgcolor="#c0c0c0"><font color = "black"><b>PRATICA<b></font></td></tr>
  
  <tr>
     <th>Anagrafica</th>
    <th>Dati inseriti</th>
  </tr>
  
  <tr>
    <td>Denominazione società</td>
    <td><%=readAziendaCliente.getDenominazioneSocieta() %></td>
  </tr>
  
  <tr>
    <td>Forma giuridica</td>
    <td><%=readAziendaCliente.getFormaGiuridica() %></td>
  </tr>
  
  <tr>
    <td>Indirizzo sede legale</td>
    <td><%=readAziendaCliente.getSedeLegale()%></td>
  </tr>
  <tr>
    <td>p.IVA</td>
    <td><%=readAziendaCliente.getPartitaIva()%></td>
  </tr>
  <tr>
    <td>Telefono</td>
    <td><%=readAziendaCliente.getTelefono()%></td>
  </tr>
  <tr>
    <td>Mail</td>
    <td><%=readAziendaCliente.getEmail()%></td>
  </tr>
  <tr>
    <td>indirizzo unità locale</td>
    <td><%=readAziendaCliente.getIndirizzoUnitaLocale()%></td>
  </tr>
  <tr>
    <td>Attività svolta dall'impresa</td>
    <td><%=readAziendaCliente.getAttivitaAzienda()%></td>
  </tr>
  <tr>
    <td>Legale rappresentante</td>
    <td><%=readAziendaCliente.getLegaleRappresentante()%></td>
  </tr>
  <tr>
    <td>nato il</td>
    <td><%=readAziendaCliente.getNatoIl()%></td>
  </tr>
  <tr>
    <td>nato a</td>
    <td><%=readAziendaCliente.getNatoA()%></td>
  </tr>
  <tr>
    <td>Costi personale</td>
    <td><%=readDossierDTO.getCostoDipendentiPeriodoDiImposta()%></td>
  </tr>
  <tr>
    <td>Fatturato</td>
    <td><%=readDossierDTO.getFatturatoPeriodoDiImposta() %></td>
  </tr>
  <tr>
    <td>Numero Dipendenti</td>
    <td><%=readDossierDTO.getNumeroTotaleDipendenti() %></td>
  </tr>
  
  <tr>
    <td>Costi totali R&S</td>
    <td><%=readDossierDTO.getTotaleCostiReD()%></td>
  </tr>
  <tr>
    <td>Costi personale R&S</td>
    <td><%=readDossierDTO.getCostiPersonaleReD()%></td>
  </tr>
  <tr>
  <tr>
     <th>Progetto ricerca</th>
    <th>Dati inseriti</th>
  </tr>
    <td>Titoli Progetti R&S</td>
    <td><%=progetto.getTitoloProgetto() %></td>
  </tr>
  <tr>
    <td>Dettagli Progetti R&S</td>
    <td><%=progetto.getDettagliProgetto() %></td>
  </tr>
  <tr>
    <td>coordinate DIIN</td>
    <td><%=progetto.getCoordinateDIIN() %></td>
  </tr>
</table>
</center>
<br>
	<br>
<a href="dossierManagement?id=<%=idProgetto %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
</body>