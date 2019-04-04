<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo utente</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
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
</head>
<body>
	<div class="pre_contenitore">

		<p>New User</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/UserController/creaUser">

		Ruolo: <select style="width: 275px;" name="ruolo">
			<option value="superuser">Super User</option>
			<option value="user">Business Owner</option>
		</select>
		<br>
		<br>
		<br>
		Username: <input type="text" size="40" maxlength="40" name="username" />
		<br>
		<br>
		<br>
		Password: <input type="text" size="40" maxlength="40" name="password" />
		<br>
		<br>
		<br>
		Email: <input type="text" size="40" maxlength="40" name="email" />
		<br>
		<br>
		<br>
		<input type="SUBMIT" value="Add" style="width: 100px; height: 50px ">
		<br>
		<br>
		<a href="/UserController/userManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>