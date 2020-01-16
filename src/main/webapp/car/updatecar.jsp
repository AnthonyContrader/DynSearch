<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CarDTO" import="it.contrader.dto.EngineDTO" import="java.util.*" %>
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
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/car/getall">Cars</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CarDTO c = (CarDTO) request.getSession().getAttribute("dto");
 List<EngineDTO> listEn = (List<EngineDTO>) request.getSession().getAttribute("listEng");
%>


<form id="floatright" action="/car/update" method="post">
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
			
			<input type="hidden" name="id" value =<%=c.getId() %>>
			<button type="submit">Edit</button>
		</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>