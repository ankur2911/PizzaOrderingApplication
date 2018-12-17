<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Pizza Order Application</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="js/JSFile.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    .row.content {height: 1000px}
    
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<div class="container-fluid">
  <div class="row content">
  
  
    <div class="col-sm-2 sidenav">
      
    </div>

    <div class="col-sm-8">
      
      <h2>Pizza Ordering Application</h2> <img id="pizzaImage" src="images/pizzaHome.gif" style="width: 25%; float: right"/>
      <hr>
      
      <br/>
      
      <button type="button" class="btn btn-success" id="order">Order Pizza (User)</button>
      
      <button type="button" class="btn btn-success" id="addTopping">Add Toppings (Admin)</button>
      
      <button type="button" class="btn btn-success" id="manage">Manage Inventory (Admin)</button>
      
      
      <br/>
      <hr>
      
      <!-- Form to be visible if you click on Order Pizza -->
      
      <div id="orderPizza" style="width: 70%;display:none ">
      
      <h4>Please fill this form to place the order</h4>
      <br/>
			<form id="orderPizzaForm">
			  <div class="form-group">
			    <label for="email">Email address</label>
			    <input type="email" class="form-control" id="email" placeholder="Enter email">
			  </div>
			  <div class="form-group">
			    <label for="name">Name</label>
			    <input type="text" class="form-control" id="name" placeholder="Name">
			  </div>
			  
			  
			  <div class="form-group">
			    <label for="size">Size of Pizza</label>
			    <select class="form-control" id="size">
			      <option>small</option>
			      <option>medium</option>
			      <option>large Filled</option>
		
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <label for="crust">Type of Crust</label>
			    <select class="form-control" id="crust">
			      <option>Thin</option>
			      <option>Normal</option>
			      <option>Cheese Filled</option>
		
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="toppings">Type of Toppings (+ $1 each)</label>
			    <select multiple="multiple" class="form-control" id="toppings">
			
			    <option></option>
			
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="info">Extra Information</label>
			    <textarea class="form-control" id="info" rows="2"></textarea>
			  </div>
			 
			 
			  <button id="orderSubmit" type="button" class="btn btn-primary">Order</button>
			</form>
			      
      
      </div>
      
      <!-- End of form -->
      
	  <!-- Add a Topping  -->
	  
	  <div id="addToppingDiv" style="width: 70%;display:none">
	  
	  <form id="addToppingform">
			  <div class="form-group" >
			    <label for="newTopping">Enter the Topping to add</label>
			    <input type="text" class="form-control" id="newTopping" placeholder="Enter Topping">
			  </div>
			
			 <div class="form-group" >
			    <label for="quantity">Enter the quantity of Topping </label>
			    <input type="number" class="form-control" id="quantity" placeholder="Enter quantity">
			  </div>
			  
			  <button id="addToppingSubmit" type="button" class="btn btn-primary">Add</button>
	  </form>
	  
	  </div>
       <!-- End of form -->
       
       
       <!-- Manage Inventory  -->
	  
	  <div id="manageDiv" style="width: 70%;display:none">
	  
	  <form id="inventoryForm">
			  <div class="form-group" >
			    <label for="toppingName">Topping Name</label>
		
			   <select class="form-control" id="inventory">
		       
			    <option></option>
			  
		      </select>
			  </div>
			
				<div class="form-group" >
			    <label for="newquantity">Enter the new quantity of Topping </label>
			    <input type="number" class="form-control" id="newquantity" placeholder="Enter new quantity">
			  </div>
			  
			  <button id="manageSubmit" type="button" class="btn btn-primary">Update</button>
			  <button id="manageDeleteSubmit" type="button" class="btn btn-primary">Delete Topping</button>
	  </form>
	  
	  </div>
       <!-- End of form -->
       <br/>
       <div id="resultText"></div>
      
    </div>
    
     <div class="col-sm-2 sidenav">
      
    </div>
    
  </div>
</div>


</body>
</html>
