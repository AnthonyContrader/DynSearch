<%@ page import="it.contrader.dto.EngineDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Engine Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Engine Manager</title>

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
	<div class="main">
		<%
		@SuppressWarnings("unchecked") List<EngineDTO> list = (List<EngineDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Horsepower</th>
				<th>Capacity</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (EngineDTO e : list) {
			%>
			<tr>
				<td><a href="/engine/read?id=<%=e.getId()%>"> <%=e.getName()%>
				</a></td>
				<td><%=e.getHorsepower()%></td>
				<td><%=e.getCapacity()%></td>
				
				<td><a href="/engine/preupdate?id=<%=e.getId()%>">Edit</a></td>


				<td><a href="/engine/delete?id=<%=e.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/engine/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="nam">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="nam" name="name"
						placeholder="Insert Name">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="hore">Horsepower</label>
				</div>
				<div class="col-75">
					<input type="text" id="hore" name="horsepower"
						placeholder="Insert horsepower">
				</div>
			</div>
						
			<div class="row">
				<div class="col-25">
					<label for="ca">Capacity</label>
				</div>
				<div class="col-75">
					<input type="text" id="ca" name="capacity"
						placeholder="Insert capacity">
				</div>
			</div>
		
			
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>