<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/vittoriostyle.css" rel="stylesheet">
<title>Edit Car</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a href="IngredientServlet?mode=ingredientlist">Ingredients</a>
	<a class="active" href="CarServlet?mode=carlist">Cars</a>
	<a href="DishServlet?mode=dishlist">Dishes</a>
	<a href="CocktailServlet?mode=cocktaillist">Cocktails</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CarDTO c = (CarDTO) request.getAttribute("dto");%>


<form id="floatleft" action="CarServlet?mode=update&id=<%=c.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="br">Brand</label>
    </div>
    <div class="col-75">
      <input type="text" id="br" name="brand" value=<%=c.getBrand()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="mod">Model</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="mod" name="model" value=<%=c.getModel()%>> 
    </div>
      </div>
      
       <div class="row">
    <div class="col-25">
      <label for="door">Doors</label>
    </div>
    <div class="col-75">
      <input type="text" id="door" name="doors" value=<%=c.getDoors()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="ec">EngineCapacity</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="ec" name="engineCapacity" value=<%=c.getEngineCapacity()%>> 
    </div>
      </div>
      
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>