<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CocktailDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Cocktail Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="IngredientServlet?mode=ingredientlist">Ingredients</a>
  <a  href="CarServlet?mode=carlist">Cars</a>
  <a  href="CocktailServlet?mode=cocktaillist">Cocktails</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
	@SuppressWarnings("unchecked") List<CocktailDTO> list = (List<CocktailDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Type</th>
			<th>Alcohol</th>
			<th>AVG</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (CocktailDTO c : list) {
		%>
		<tr>
			<td><a href=CocktailServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
			</a></td>
			<td><%=c.getType()%></td>
			<td><%=c.getAlcohol()%></td>
			<td><%=c.getAVG()%></td>
			<td><a href=CocktailServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CocktailServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="CocktailServlet?mode=insert" method="post">
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
    <input type="radio" id="alcohol" name="alcohol">
     <label for="alcohol">Alcohol</label>
    </div>
    <div class="col-75">
      <input type="radio" id="noalcohol" name="alcohol">
      <label for="noalcohol">NO Alcohol</label>
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
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>