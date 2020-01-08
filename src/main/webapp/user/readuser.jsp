<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="IngredientServlet?mode=ingredientlist">Ingredients</a>
  <a href="CarServlet?mode=carlist">Cars</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%UserDTO u = (UserDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Username</th>
		<th>Password</th>
		<th>Usertype</th>
	</tr>
	<tr>
		<td><%=u.getUsername()%></td>
		<td> <%=u.getPassword()%></td>
		<td> <%=u.getUsertype()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>