<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EngineDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Engine Edit page">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Engine</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
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

<%EngineDTO e = (EngineDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/engine/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nam">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="nam" name="name" value=<%=e.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="hore">Horsepower</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="hore" name="horsepower" value=<%=e.getHorsepower()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="ca">Capacity</label>
    </div>
    <div class="col-75">
      <input type="text" id="ca" name="capacity" value=<%=e.getCapacity()%>>
    </div>
  </div>
  
  <input type="hidden" name="id" value =<%=e.getId() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>