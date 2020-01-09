<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CocktailDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/vittoriostyle.css" rel="stylesheet">
<title>Edit Cocktail</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a href="IngredientServlet?mode=ingredientlist">Ingredients</a>
	<a href="CarServlet?mode=carlist">Cars</a>
	<a href="DishServlet?mode=dishlist">Dishes</a>
	<a class="active" href="CocktailServlet?mode=cocktaillist">Cocktails</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CocktailDTO c = (CocktailDTO) request.getAttribute("dto");%>


<form id="floatleft" action="CocktailServlet?mode=update&id=<%=c.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="category">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="Insert Name ">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="type">Type</label>
    </div>
    <div class="col-75">
      <input type="text" id="type" name="type" placeholder="Insert Type "> 
    </div>
  </div>
<div class="row">
    <div class="col-25">
    <input type="radio" id="alcohol" name="alcohol" value= "1">
     <label class="labelleft" for="alcohol">Alcohol</label>
    </div>
    <div class="col-75">
      <input type="radio" id="noalcohol" name="alcohol" value ="0">
      <label class="labelright" for="noalcohol">NO Alcohol</label>
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="cal">AVG</label>
    </div>
    <div class="col-75">
      <input type="text" id="avg" name="avg" placeholder="Insert AVG "> 
    </div>
  </div>
      <button type="submit" >Update</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>