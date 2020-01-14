<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CocktailDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Cocktail Edit page">
<meta name="author" content="Stefano Mazzeo">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Cocktail</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/ingredient/getall">Ingredients</a>
		<a href="/dish/getall">Dishes</a>
		<a class="active" href="/cocktail/getall">Cocktail</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
<br>
<div class="main">

<%CocktailDTO u = (CocktailDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/cocktail/update" method="post">
 <div class="row">
				<div class="col-25">
					<label for="name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="cocktail" name="name"
						placeholder="inserisci il nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Type</label>
				</div>
				<div class="col-75">
					<input type="text" id="type" name="type"
						placeholder="inserisci il tipo ">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="isAlcohol">E' alcolica?</label>
				</div>
				<div class="col-75">
					<select id="type" name="isAlcohol">
						<option value="0">si</option>
						<option value="1">no</option>

					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="AVG">Gradazione</label>
				</div>
				<div class="col-75">
					<input type="text" id="AVG" name="AVG"
						placeholder="inserisci la gradazione alcolica ">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="alcohol">Gradazione</label>
				</div>
				<div class="col-75">
					<input type="text" id="alcohol" name="alcohol"
						placeholder=" alcolica ">
				</div>
			</div>
    	<input type="hidden" name="id" value =<%=u.getId() %>>

      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>