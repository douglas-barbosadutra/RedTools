<%@ include file="/header.jsp"%>
<%@ page import="it.contrader.dto.*"%>
<html>
<head>
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
	color: white;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>

<%

    DossierDTO updateDossier = (DossierDTO) request.getAttribute("dossierUpdate");
    int idProgetto =  (int) session.getAttribute("idProgetto");

%>
<script>

function checkFilled() {
	var inputVal = document.getElementsByClassName("subEmail");
    //alert(inputVal);
    for(var i = 0; i < inputVal.length; i++) {
        
         if (inputVal[i].value == "" || inputVal[i].value == "0" || inputVal[i].value == "0.0") {
          inputVal[i].style.backgroundColor = "";
         }
        else{
           inputVal[i].style.backgroundColor = "yellow";
         }
     }
    
}
 
checkFilled();
</script> 
</head>

<body onload="checkFilled()">
	<div class="center">

		<div class="pre_contenitore">

			<p>Dossier Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/DossierController/update?dossierId=<%=updateDossier.getIdDossier()%>">

		Anno Di Imposta: <input class="subEmail" onchange="checkFilled();" type="text" size="40" maxlength="40" name="periodoDiImposta" value="<%=updateDossier.getPeriodoDiImposta()%>">
		
		<br>
		<br>
		Costo Dipendenti: <input class="subEmail" onchange="checkFilled();" type="text" size="40" maxlength="40" name="costoDipendentiPeriodoDiImposta" value="<%=updateDossier.getCostoDipendentiPeriodoDiImposta()%>">
		<br>
		<br>
		fatturato: <input class="subEmail" onchange="checkFilled();" type="text" size="40" maxlength="40" name="fatturatoPeriodoDiImposta" value="<%=updateDossier.getFatturatoPeriodoDiImposta()%>">
		<br>
		<br>
		Numero Totale Dipendenti: <input class="subEmail" onchange="checkFilled();" type="text" size="40" maxlength="40" name="numeroTotaleDipendenti" value="<%=updateDossier.getNumeroTotaleDipendenti()%>">
		<br>
		<br>

		<br>
		<br>
		<input type="SUBMIT" value="Update">
		<br>
		<br>
		<a href="dossierManagement?id=<%=idProgetto %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>