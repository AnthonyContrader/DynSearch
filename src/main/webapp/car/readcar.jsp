<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.CarDTO" import="it.contrader.dto.EngineDTO" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Car Read">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Car</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/ingredient/getall">Ingredients</a>
		<a href="/dish/getall">Dishes</a>
		<a href="/cocktail/getall">Cocktail</a>
		<a class="active" href="/car/getall">Cars</a>
		<a href="/engine/getall">Engines</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			CarDTO c = (CarDTO) request.getSession().getAttribute("dto");
		
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Brand</th>
				<th>Model</th>
				<th>Doors</th>
				<th>Engine</th>
			</tr>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getBrand()%></td>
				<td><%=c.getModel()%></td>
				<td><%=c.getDoors()%></td>
				<td><%=c.getEngine().getId()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>