<%@ include file="/header.jsp"%>
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
	int idUtenteFinale =  (Integer) request.getAttribute("id");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Dossier Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/JspApp/DossierServlet?richiesta=update">

			<%
				String selected = "selected=\"selected\"";
				String adminSelected = "";
				String boSelected = "";
				if (updateDossier.getupdateDossier().equals("admin")) {
					adminSelected = selected;
				} else
					boSelected = selected;
			%>

			User type: <select style="width: 270px;" name="user_type">

				<option <%=adminSelected%> value="admin">Admin</option>
				<option <%=boSelected%> value="bo">Business owner</option>


			</select>
			<br>
			<input type="hidden" name="user_id" value="<%=updateUser.getId()%>" />
			<br>
			Username: <input type="text" size="40" maxlength="40" name="user_user" value="<%=updateUser.getUsername()%>" />
			<br>
			<br>
			Password: <input type="text" size="40" maxlength="40" name="user_pass" value="<%=updateUser.getPassword()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/DossierServlet?richiesta=MomManager&id=<%=idUtenteFinale %>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>