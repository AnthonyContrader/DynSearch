<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.IngredientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Ingredient</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a class="active" href="IngredientServlet?mode=ingredientlist">Ingredients</a>
	<a href="CarServlet?mode=carlist">Cars</a>
	<a href="DishServlet?mode=dishlist">Dishes</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%IngredientDTO i = (IngredientDTO) request.getAttribute("dto");%>


<table>
	<tr>
		<th>Category</th>
		<th>Name</th>
		<th>Weight</th>
		<th>Calories</th>
		<th>Carbohydrates</th>
		<th>Proteins</th>
		<th>Fat</th>
		<th></th>
		<th></th>
	</tr>
	<tr>
		<td><%=i.getCategory()%></td>
		<td><%=i.getName()%></td>
		<td><%=i.getWeight()%></td>
		<td><%=i.getCal()%></td>
		<td><%=i.getCarb()%></td>
		<td><%=i.getProt()%></td>
		<td><%=i.getFat()%></td>
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