<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
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
	List<UserDTO> allUser = (List<UserDTO>) request.getAttribute("allUserDTO");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Gestione Utenti</p>

	</div>
	<br>



	<br />
<div align="center">
	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>Ruolo</th>
			<th>Email</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (UserDTO user : allUser) {
		%>
		<tr>
			<td><%=user.getIdUser()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=user.getRuolo()%></td>
			<td><%=user.getEmail()%></td>
			<td class="center"><a href="/UserController/updateRedirect?id=<%=user.getIdUser()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/UserController/delete?id=<%=user.getIdUser()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="/UserController/crea?"><i class="fas fa-plus-circle fa-lg" style="color:black"> New User</i></a>

	<br>
	<br>
	<a href="/HomeController/userManage"><i class="fas fa-arrow-alt-circle-left fa-lg" style="color:black"> Back</i></a>


</body>
</html>