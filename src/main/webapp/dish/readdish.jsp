<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DishDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/vittoriostyle.css" rel="stylesheet">
<title>Dish User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
 	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a href="IngredientServlet?mode=ingredientlist">Ingredients</a>
	<a href="CarServlet?mode=carlist">Cars</a>
	<a class="active" href="DishServlet?mode=dishlist">Dishes</a>
	<a href="CocktailServlet?mode=cocktaillist">Cocktails</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%DishDTO u = (DishDTO) request.getAttribute("dto");%>

<table>
	<tr> 
		<th>Name</th>
		<th>Cal</th>
		<th>Carb</th>
		<th>Fat</th>
		<th>Prot</th>
		<th>Category</th>
		<th>Weight</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td> <%=u.getCal()%></td>
		<td> <%=u.getCarb()%></td>
		<td> <%=u.getFat()%></td>
		<td> <%=u.getProt()%></td>
		<td> <%=u.getCategory()%></td>
		<td> <%=u.getWeight()%></td>
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
