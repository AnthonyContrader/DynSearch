<%@ page import="it.contrader.dto.CocktailDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Cocktail Management">
<meta name="author" content="Stefano Mazzeo">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Cocktail Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/ingredient/getall">Ingredients</a>
		<a href="/dish/getall">Dishes</a>
		<a class="active" href="/cocktail/getall">Cocktail</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<CocktailDTO> list = (List<CocktailDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Password</th>
				<th>Type</th>
				<th>isAlcohol</th>
				<th>AVG</th>
				<th>alcohol</th>
			</tr>
			<%
				for (CocktailDTO u : list) {
			%>
			<tr>
				<td><a href="/cocktail/read?id=<%=u.getId()%>"> <%=u.getName()%>
				</a></td>
				<td><%=u.getType()%></td>
				<td><%=u.isIsAlcohol()%></td>
				<td><%=u.getAVG()%></td>
				<td><%=u.getAlcohol()%></td>
				<td><a href="/cocktail/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/cocktail/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/cocktail/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="cocktail" name="name"
						placeholder="inserisci il nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Type</label>
				</div>
				<div class="col-75">
					<input type="text" id="type" name="type"
						placeholder="inserisci il tipo ">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="isAlcohol">E' alcolica?</label>
				</div>
				<div class="col-75">
					<select id="type" name="isAlcohol">
						<option value="0">si</option>
						<option value="1">no</option>

					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="AVG">Gradazione</label>
				</div>
				<div class="col-75">
					<input type="text" id="AVG" name="AVG"
						placeholder="inserisci la gradazione alcolica ">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="alcohol">Gradazione</label>
				</div>
				<div class="col-75">
					<input type="text" id="alcohol" name="alcohol"
						placeholder=" alcolica ">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>