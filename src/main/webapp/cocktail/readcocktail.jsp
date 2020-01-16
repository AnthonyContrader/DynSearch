<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.CocktailDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Cocktail Read">
<meta name="author" content="Stefano Mazzeo">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Cocktail</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/ingredient/getall">Ingredients</a>
		<a href="/dish/getall">Dishes</a>
		<a class="active" href="/cocktail/getall">Cocktail</a>
		<a href="/car/getall">Cars</a>
		<a href="/engine/getall">Engines</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			CocktailDTO u = (CocktailDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Name</th>
				<th>Password</th>
				<th>Type</th>
				<th>isAlcohol</th>
				<th>AVG</th>
				<th>alcohol</th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><%=u.getType()%></td>
				<td><%=u.isIsAlcohol()%></td>
				<td><%=u.getAlcohol()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>