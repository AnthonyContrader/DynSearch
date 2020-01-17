<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DishDTO"
    import="it.contrader.dto.IngredientDTO"
    import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Dish Edit page">
<meta name="author" content="Ali Asghari">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<script src="../jQuery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/main.js?ts=<?=time()?>&quot"></script>
<script type="text/javascript" src="../js/validate.js?ts=<?=time()?>&quot"></script>
<title>Edit Dish</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/ingredient/getall">Ingredients</a>
		<a class="active" href="/dish/getall">Dishes</a>
		<a href="/cocktail/getall">Cocktail</a>
		<a href="/car/getall">Cars</a>
		<a href="/engine/getall">Engines</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
<br>
<div class="main">

<%DishDTO d = (DishDTO) request.getSession().getAttribute("dto");
	List<IngredientDTO> listIng = (List<IngredientDTO>) request.getSession().getAttribute("listAllIngr");%>

<form id="floatright " class=" formInsert" action="/dish/update" method="post">
    <div class="row">
    <div class="col-25">
     <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="Insert Name "> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="category">Category</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="category" placeholder="Insert Category ">
    </div>
  </div>
<div class="row">
    <div class="col-25">
     <label for="weight">Weight</label>
    </div>
    <div class="col-75">
      <input type="text" id="weight" name="weight" placeholder="Insert Weight "> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="cal">Calories</label>
    </div>
    <div class="col-75">
      <input type="text" id="cal" name="cal" placeholder="Insert Calories "> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="carb">Carbohydrates</label>
    </div>
    <div class="col-75">
      <input type="text" id="carb" name="carb" placeholder="Insert Carbohydrates "> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="prot">Proteins</label>
    </div>
    <div class="col-75">
      <input type="text" id="prot" name="prot" placeholder="Insert Proteins "> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="fat">Fat</label>
    </div>
    <div class="col-75">
      <input type="text" id="fat" name="fat" placeholder="Insert Fat "> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="fat">Ingredients</label>
    </div>
    <div class="col-75">
      <select id="input_ingr0" name="idingr" class="input_ingr" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr1" class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr2"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr3"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr4"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr5"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr6" class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr7" class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr8" class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr9"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr10"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr11"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr12"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr13" class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr14" class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr15" class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr16"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr17"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr18"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <select id="input_ingr19"  class="ingr hide" >
      <option value="" disabled selected class="hide">Select Ingredient</option>
      	<optgroup label="Select Ingredient">
      		<%=this.getAllIngr(listIng)%>
      	</optgroup>
      </select>
      <p id="demo" ></p>
      <div >
            <button onClick="addIngr()" type="button"  class ="add-btn btn-secondary  floatleft ">+</button>
            <button onClick ="rmvIngr()" type="button"  class="rmv-btn floatright btn-secondary hide "> - </button>
      </div>
    </div>
  </div>
  <input type="hidden" name="id" value =<%=d.getId() %>>
      <button type="submit" class="submit">Update</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>
<%!public String getAllIngr(List<IngredientDTO> list){
    	  	String x= "";
      		for (IngredientDTO i:list){
      			x=x+"<option  value='"+i.getId()+"'>"+i.getName()+ "-"+i.getId()+"</option>";
      		}
      		return x;
      	}
   		%>