<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.IngredientDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Ingredient Read">
<meta name="author" content="Ali Asghari">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Ingredient User</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/ingredient/getall">Ingredients</a>
		<a href="/dish/getall">Dishes</a>
		<a href="/cocktail/getall">Cocktail</a>
		<a href="/car/getall">Cars</a>
		<a href="/engine/getall">Engines</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
		IngredientDTO i = (IngredientDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				
				<th>Category</th>
				<th>Name</th>
				<th>Weight</th>
				<th>Calories</th>
				<th>Carbohydrates</th>
				<th>Proteins</th>
				<th>Fat</th>
			</tr>
			<tr>
				<td><%=i.getId()%></td>
				<td><%=i.getCategory()%></td>
				<td><%=i.getName()%></td>
				<td><%=i.getWeight()%></td>
				<td><%=i.getCal()%></td>
				<td><%=i.getCarb()%></td>
				<td><%=i.getProt()%></td>
				<td><%=i.getFat()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>