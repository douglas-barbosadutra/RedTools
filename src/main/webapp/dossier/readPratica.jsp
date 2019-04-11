<%@ include file="../header.jsp"%>
<%@page import="it.contrader.model.AziendaCliente"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">

</head>
<body>
<div class="container">

<%
	    DossierDTO read = (DossierDTO) request.getAttribute("ReadDossierDTO");
	    int idProgetto =  (int) session.getAttribute("idProgetto");
	    int idAziendaCliente =  (int) request.getAttribute("idAziendaCliente");
%>
  <h3>Bootstrap 4 table Contextual classes</h2>
 
<table class="table table-hover">
  <thead>
    <tr class="table-danger">
      <th>Month</th>
      <th>Number of Sales</th>
      <th>Amount</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row" class="table-primary">Jan</th>
      <td>105</td>
      <td>$15,000.00</td>
    </tr>
    <tr >
      <th scope="row" class="table-secondary">Feb</th>
      <td>95</td>
      <td>$12,000.00</td>
    </tr>
    <tr>
      <th scope="row">Mar</th>
      <td  class="table-success">150</td>
      <td>$20,000.00</td>
    </tr>
    <tr>
      <th scope="row">Apr</th>
      <td>50</td>
      <td  class="table-warning">$30,000.00</td>
    </tr>
    <tr>
      <th scope="row">May</th>
      <td class="table-info">80</td>
      <td>$15,000.00</td>
    </tr>
    <tr>
      <th scope="row">Jun</th>
      <td class="table-light">110</td>
      <td class="table-primary">$22,000.00</td>
    </tr>           
    <tr>
      <th scope="row">Jun</th>
      <td>110</td>
      <td class="table-dark">$22,000.00</td>
    </tr>   

    <tr>
      <th colspan="2" scope="row" class="table-success">Grand Total</th>
      
      <td class="table-danger">$114,000.00</td>
    </tr>  
     
  </tbody>
</table>



</div>
</body>
</html>

