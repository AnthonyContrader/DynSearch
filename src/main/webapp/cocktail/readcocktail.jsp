<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CocktailDTO"%>
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
	<a href="DishServlet?mode=dishlist">Dishes</a>
	<a class="active" href="CocktailServlet?mode=cocktaillist">Cocktails</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">
 <%CocktailDTO c = (CocktailDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>name</th>
		<th>type</th>
		<th>Alcohol</th>
		<th>AVG</th>
		
	</tr>
	<tr>
		<td><%=c.getName()%></td>
		<td><%=c.getType()%></td>
		<td><%=c.getAlcohol()%></td>
		<td><%=c.getAVG()%></td>
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