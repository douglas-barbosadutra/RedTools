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
	UserDTO updateUser = (UserDTO) request.getAttribute("userUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>User Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/UserController/update">

			<%
				String selected = "selected=\"selected\"";
				String adminSelected = "";
				String boSelected = "";
				if (updateUser.getRuolo().equals("superuser")) {
					adminSelected = selected;
				} else
					boSelected = selected;
			%>

			Ruolo: <select style="width: 270px;" name="user_type">

				<option <%=adminSelected%> value="superuser">Super User</option>
				<option <%=boSelected%> value="user">Business owner</option>


			</select>
			<br>
			<input type="hidden" name="user_id" value="<%=updateUser.getIdUser()%>" />
			<br>
			Username: <input type="text" size="40" maxlength="40" name="user_user" value="<%=updateUser.getUsername()%>" />
			<br>
			<br>
			Password: <input type="text" size="40" maxlength="40" name="user_pass" value="<%=updateUser.getPassword()%>" />
			<br>
			<br>
			Email: <input type="text" size="40" maxlength="40" name="user_email" value="<%=updateUser.getEmail()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update" style="width: 100px; height: 50px ">
		

			<br>
			<br>
			<a href="/UserController/userManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>