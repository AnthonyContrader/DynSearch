<%@ page import="it.contrader.dto.IngredientDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Ingredient Management">
<meta name="author" content="Ali Asghari">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Ingredients Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/ingredient/getall">Ingredients</a>
		<a href="/dish/getall">Dishes</a>
		<a href="/cocktail/getall">Cocktail</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<IngredientDTO> list = (List<IngredientDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
		<tr>
			<th>Category</th>
			<th>Name</th>
			<th>Weight</th>
			<th>Calories</th>
			<th>Carbohydrates</th>
			<th>Proteins</th>
			<th>Fat</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (IngredientDTO i : list) {
		%>
		<tr>
			<td><a href="/ingredient/read?id=<%=i.getId()%>">
					<%=i.getCategory()%>
			</a></td>
			<td><%=i.getName()%></td>
			<td><%=i.getWeight()%></td>
			<td><%=i.getCal()%></td>
			<td><%=i.getCarb()%></td>
			<td><%=i.getProt()%></td>
			<td><%=i.getFat()%></td>
			<td><a href="/ingredient/preupdate?id=<%=i.getId()%>">Edit</a>
			</td>
			<td><a href="/ingredient/delete?id=<%=i.getId()%>">Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="/ingredient/insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="category">Category</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="category" placeholder="Insert Category ">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="Insert Name "> 
    </div>
  </div>
<div class="row">
    <div class="col-25">
     <label for="weight">Weight</label>
    </div>
    <div class="col-75">
      <input type="text" id="weight" name="weight" placeholder="Insert Weight "> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="cal">Calories</label>
    </div>
    <div class="col-75">
      <input type="text" id="cal" name="cal" placeholder="Insert Calories "> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="carb">Carbohydrates</label>
    </div>
    <div class="col-75">
      <input type="text" id="carb" name="carb" placeholder="Insert Carbohydrates "> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="prot">Proteins</label>
    </div>
    <div class="col-75">
      <input type="text" id="prot" name="prot" placeholder="Insert Proteins "> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="fat">Fat</label>
    </div>
    <div class="col-75">
      <input type="text" id="fat" name="fat" placeholder="Insert Fat "> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>