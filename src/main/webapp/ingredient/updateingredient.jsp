<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.IngredientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Ingredient Edit page">
<meta name="author" content="Ali Asghari">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Ingredient</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  	<a href="homeadmin.jsp">Home</a> 
	<a  href="../user/getall">Users</a>
	<a class="active" href="/ingredient/getall">Ingredients</a>
	<a href="../user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%IngredientDTO i = (IngredientDTO) request.getSession().getAttribute("dto");%>

<form id="floatleft" action="/ingredient/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="category">Category</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="category" value=<%=i.getCategory()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=i.getName()%>> 
    </div>
  </div>
<div class="row">
    <div class="col-25">
     <label for="weight">Weight</label>
    </div>
    <div class="col-75">
      <input type="text" id="weight" name="weight" value=<%=i.getWeight()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="cal">Calories</label>
    </div>
    <div class="col-75">
      <input type="text" id="cal" name="cal" value=<%=i.getCal()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="carb">Carbohydrates</label>
    </div>
    <div class="col-75">
      <input type="text" id="carb" name="carb" value=<%=i.getCarb()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="prot">Proteins</label>
    </div>
    <div class="col-75">
      <input type="text" id="prot" name="prot" value=<%=i.getProt()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="fat">Fat</label>
    </div>
    <div class="col-75">
      <input type="text" id="fat" name="fat" value=<%=i.getFat()%>> 
    </div>
  </div>
  <input type="hidden" name="id" value =<%=i.getId() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>