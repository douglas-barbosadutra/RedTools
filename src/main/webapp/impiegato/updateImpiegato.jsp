<%@ include file="../header.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
/*contenitore in cima dove c' scritto "Login"*/
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
	ImpiegatoDTO updateImpiegato = (ImpiegatoDTO) request.getAttribute("impiegatoUpdate");
    int idDossier =  (int) session.getAttribute("idDossier");
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

			<p>Impiegato Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/ImpiegatoController/update">
		<br>
		Impiegato Id: <%=updateImpiegato.getIdNome()%>
		<input type="hidden" name="idImpiegato" value="<%=updateImpiegato.getIdNome()%>">
		<br>
		<br>
		Nominativo: <input type="text" size="40" maxlength="40" name="nominativo" value="<%=updateImpiegato.getNominativo()%>""/>
		<br>
		<br>
		Livello: <input type="text" size="40" maxlength="40" name="livello" value="<%=updateImpiegato.getLivello()%>"/>
		<br>
		<br>
		Qualifica: <input type="text" size="40" maxlength="40" name="qualifica" value="<%=updateImpiegato.getQualifica()%>"/>
		<br>
		<br>
		Mansione: <input type="text" size="40" maxlength="40" name="mansione" value="<%=updateImpiegato.getMansione()%>"/>
		<br>
		<br>
		Titolo di studio: <input type="text" size="40" maxlength="40" name="titoloDiStudio" value="<%=updateImpiegato.getTitoloDiStudio()%>"/>
		<br>
		<br>
		Costo orario: <input type="text" size="40" maxlength="40" name="costoOrario" value="<%=updateImpiegato.getCostoOrario()%>"/>
		<br>
		<br>
		Totale ore lavorate: <input type="text" size="40" maxlength="40" name="totaleOreLavorate" value="<%=updateImpiegato.getTotaleOreLavorate()%>"/>
		<br>
		<br>
		Costo Lordo Annuo: <input type="text" size="40" maxlength="40" name="costoLordoAnnuo" value="<%=updateImpiegato.getCostoLordoAnnuo()%>"/>
		<br>
		<br>
		<input type="SUBMIT" value="Update">
		<br>
		<br>
		<a href="impiegatoManagement?id=<%=idDossier %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>