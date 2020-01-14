<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Car Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Car</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/car/getall">Cars</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CarDTO c = (CarDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/car/update" method="post">
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
      <label for="dor">Doors</label>
    </div>
    <div class="col-75">
      <input type="text" id="dor" name="doors" value=<%=c.getDoors()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="eg">EngineCapacity</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="eg" name="engineCapacity" value=<%=c.getEngineCapacity()%>> 
    </div>
  </div>
  <input type="hidden" name="id" value =<%=c.getId() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>