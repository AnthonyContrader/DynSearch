<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read car</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a  href="IngredientServlet?mode=ingredientlist">Ingredients</a>
  <a class="active" href="CarServlet?mode=carlist">Cars</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">
<%CarDTO c = (CarDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>brand</th>
		<th>model</th>
		<th>doors</th>
		<th>engineCapacity</th>
		
	</tr>
	<tr>
		<td><%=c.getBrand()%></td>
		<td> <%=c.getModel()%></td>
		<td> <%=c.getDoors()%></td>
		<td> <%=c.getEngineCapacity()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>

