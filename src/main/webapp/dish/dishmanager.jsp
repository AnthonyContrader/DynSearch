<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.DishDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/vittoriostyle.css" rel="stylesheet">
<title> Dish Manager </title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a href="IngredientServlet?mode=ingredientlist">Ingredients</a>
	<a href="CarServlet?mode=carlist">Cars</a>
	<a class="active" href="DishServlet?mode=dishlist">Dishes</a>
	<a href="CocktailServlet?mode=cocktaillist">Cocktails</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>


<div class="main">
	<%
		List<DishDTO> list = (List<DishDTO>) request.getAttribute("list");
	%>
	
	
	<br>

	<table>
		<tr>
			
			<th>Name</th>
			<th>Cal</th>
			<th>Carb</th>
			<th>Fat</th>
			<th>Prot</th>
			<th>Category</th>
			<th>Weight</th>
			
		</tr>
		<%
			for (DishDTO u : list) {
		%>
		<tr>
			<td><a href=DishServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getName()%>
			</a></td>
			<td><%=u.getCal()%></td>
			<td><%=u.getCarb()%></td>
			<td><%=u.getFat()%></td>
			<td><%=u.getProt()%></td>
			<td><%=u.getCategory()%></td>
			<td><%=u.getWeight()%></td>
			<td><a href=DishServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=DishServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

<br>
</div>

<div>
<form id="floatright" action="DishServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="dish" name="name" placeholder="Insert name of dish">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Cal</label>
    </div>
    <div class="col-75">
      <input type="text" id="cal" name="cal" placeholder="insert calories"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="carb">Carb </label>
    </div>
    <div class="col-75">
      <input type="text" id="carb" name="carb" placeholder="insert carbohydrate"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="fat">Fat</label>
    </div>
    <div class="col-75">
      <input type="text" id="fat" name="fat" placeholder="insert fat"> 
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
     <label for="pass">Prot</label>
    </div>
    <div class="col-75">
      <input type="text" id="prot" name="prot" placeholder="insert protein"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="pass">Category</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="category" placeholder="insert category"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="pass">Weight</label>
    </div>
    <div class="col-75">
      <input type="text" id="weight" name="weight" placeholder="insert weight"> 
    </div>
  </div>
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>