<%@ page import="it.contrader.dto.IngredientDTO" import="java.util.*"%>
<%@ page import="it.contrader.dto.DishDTO"%>
	
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Dish Read">
<meta name="author" content="Ali Asghari">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Dish</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/ingredient/getall">Ingredients</a>
		<a class="active" href="/dish/getall">Dishes</a>
		<a href="/cocktail/getall">Cocktail</a>
		<a href="/car/getall">Cars</a>
		<a href="/engine/getall">Engines</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			DishDTO d = (DishDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Weight</th>
				<th>Calories</th>
				<th>Carbohydrates</th>
				<th>Proteins</th>
				<th>Fat</th>
				<th>Ingredients</th>
			</tr>
			<%
		List<IngredientDTO> listAllIng;
				listAllIng = null;
				listAllIng = (List<IngredientDTO>) request.getSession().getAttribute("listIngredients"+d.getId());
				
				%>
			<tr>
				<td><%=d.getId()%></td>
				<td><%=d.getName()%></td>
				<td><%=d.getCategory()%></td>
				<td><%=d.getWeight()%></td>
				<td><%=d.getCal()%></td>
				<td><%=d.getCarb()%></td>
				<td><%=d.getProt()%></td>
				<td><%=d.getFat()%></td>
				<td><ul>			
				<%for (IngredientDTO i : listAllIng) {%>
					<li><%=i.getName()%></li>
				<%
				}
				%>
				</ul>
				</td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>