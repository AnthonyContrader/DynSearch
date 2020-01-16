<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.EngineDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Engine Read">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Engine</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/ingredient/getall">Ingredients</a>
		<a href="/dish/getall">Dishes</a>
		<a href="/cocktail/getall">Cocktail</a>
		<a href="/car/getall">Cars</a>
		<a class="active" href="/engine/getall">Engines</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			EngineDTO e = (EngineDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Horsepower</th>
				<th>Capacity</th>
				
			</tr>
			<tr>
				<td><%=e.getId()%></td>
				<td><%=e.getName()%></td>
				<td><%=e.getHorsepower()%></td>
				<td><%=e.getCapacity()%></td>
				
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>