<%@ page import="it.contrader.dto.CarDTO" import="it.contrader.dto.EngineDTO"  import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Car Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Car Manager</title>

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
	<div class="main">
		<%
		
		@SuppressWarnings("unchecked") List<CarDTO> list = (List<CarDTO>) request.getSession().getAttribute("list");

		 List<EngineDTO> listEn = (List<EngineDTO>) request.getSession().getAttribute("listEng");
		
		%>

		<br>

		<table>
			<tr>
				<th>Brand</th>
				<th>Model</th>
				<th>Doors</th>
				<th>Engine</th>
				<th></th>
			</tr>
			<%
				for (CarDTO c : list){
					
					
			%>
			<tr>
				<td><a href="/car/read?id=<%=c.getId()%>"> <%=c.getBrand()%>
				</a></td>
				<td><%=c.getModel()%></td>
				<td><%=c.getDoors()%></td>
				<td><%=c.getEngine().getName()%></td>
				
				<td><a href="/car/preupdate?id=<%=c.getId()%>">Edit</a></td>


				<td><a href="/car/delete?id=<%=c.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			
			%>
		</table>



		<form id="floatright" action="/car/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="br">Brand</label>
				</div>
				<div class="col-75">
					<input type="text" id="br" name="brand"
						placeholder="Insert Brand">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="mod">Model</label>
				</div>
				<div class="col-75">
					<input type="text" id="mod" name="model"
						placeholder="Insert Model">
				</div>
			</div>
						
			<div class="row">
				<div class="col-25">
					<label for="dor">Doors</label>
				</div>
				<div class="col-75">
					<input type="text" id="dor" name="doors"
						placeholder="Insert doors number">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="eg">Engine</label>
				</div>
				<div class="col-75">
				
			<select name= "idEngine">
					<% for(EngineDTO e : listEn){%>
				<option value="<%=e.getId()%>"><%=e.getName()%></option>
						<% }%>
            </select>
				</div>
			</div>
			
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>