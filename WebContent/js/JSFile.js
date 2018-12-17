/**
 *
 * 
 */

$(document).ready(function(){
	
    
	  
	  
    $("#orderPizza").hide();
    $("#addToppingDiv").hide();
    $("#manageDiv").hide();
    $('#resultText').html('');
    
  
    
    
    
    $("#order").click(function(){
    		$("#pizzaImage").attr("src","images/pizza.gif");
        $("#orderPizza").show();
        $("#addToppingDiv").hide();
        $("#manageDiv").hide();
        $('#resultText').html('');
        /** Ajax call for fetching the onload data **/

        $.ajax({
	  	  	  url: "DataController",
	  	  	  type: "get",
	  	  	  dataType: 'text',
	  	  	  success    : function(result){
	  	  		          	  	  		  
	  	  		var $select = $('#toppings');
	  	  		$select.find('option').remove();
	  	  		$.each(JSON.parse(result), function(key, value) {
	  	  		if(value>0){	
	  	  		$select.append('<option>' + key + '</option>');
	  	  		}
	  	  		});
	  	  		  
	  			  },
	  			  error : function(jqXHR, exception){
	  				  
	  			  }
	  	    });
  	


    });
    
    $("#addTopping").click(function(){
    		$("#pizzaImage").attr("src","images/topping.gif");
        $("#addToppingDiv").show();
        $("#orderPizza").hide();
        $("#manageDiv").hide();
        $('#resultText').html('');

    });
    
    $("#manage").click(function(){
		$("#pizzaImage").attr("src","images/pizzaInventory.gif");
	    $("#addToppingDiv").hide();
	    $("#orderPizza").hide();
        $("#manageDiv").show();
        $('#resultText').html('');
        /** Ajax call for fetching the onload data **/

        $.ajax({
	  	  	  url: "DataController",
	  	  	  type: "get",
	  	  	  dataType: 'text',
	  	  	  success    : function(result){
	  	  		          	  	  		  
	  	  		var $select = $('#inventory');
	  	  		$select.find('option').remove();
	  	  		$.each(JSON.parse(result), function(key, value) {
	  	  		
	  	  		$select.append('<option>' + key + '</option>');
	  	  		
	  	  		});
	  	  		  
	  			  },
	  			  error : function(jqXHR, exception){
	  				  
	  			  }
	  	    });
  	
	    

    });
    
    
    /** Form validation Pizza Order*/
    
    $('#orderSubmit').on('click', function() {
        var valid = true,
        errorMessage = "";

        if (valid && $('#email').val() == '') {
            errorMessage += "please enter your email\n";
            valid = false;
         } 
        
        
        if (valid && $('#name').val() == '') {
           errorMessage  = "please enter your name \n";
           valid = false;
        }

        if (valid && $('#size').val() == '') {
           errorMessage += "please select pizza size\n";
           valid = false;
        }    

        if (valid && $('#crust').val() == '') {
           errorMessage += "please select your pizza crust\n";
           valid = false;
        } 

        if( !valid && errorMessage.length > 0){
           alert(errorMessage);
           return false;
        }  
        var str = "";
        
        $("#toppings").change(function() {
        
          $( "#toppings option:selected" ).each(function() {
            str += $( this ).text() + " ";
          });
        })
        .trigger( "change" );
        
        $.ajax({
        	  method: "GET",
        	  url: "OrderController",
        	  dataType: 'text',
        	  data: { email: $('#email').val(), name: $('#name').val() , size: $('#size').val(), crust: $('#crust').val(), toppings: str , info: $('#info').val()},
        	  success    : function(resultText){
        		  
        		 $('#resultText').html(resultText);
        		 $('#orderPizzaForm').trigger("reset");
        		 
        		 $.ajax({
        	  	  	  url: "DataController",
        	  	  	  type: "get",
        	  	  	  dataType: 'text',
        	  	  	  success    : function(result){
        	  	  		          	  	  		  
        	  	  		var $select = $('#toppings');
        	  	  		$select.find('option').remove();
        	  	  		$.each(JSON.parse(result), function(key, value) {
        	  	  		if(value>0){	
        	  	  		$select.append('<option>' + key + '</option>');
        	  	  		}
        	  	  		});
        	  	  		  
        	  			  },
        	  			  error : function(jqXHR, exception){
        	  				  
        	  			  }
        	  	    });
        		 
        		 
        	  },
    		  error : function(jqXHR, exception){
    			  
    		  }
        });
        
       

      });
    
    
    
    
    
    
/** Form validation Add Topping*/
    
    $('#addToppingSubmit').on('click', function() {
        var valid = true,
        errorMessage = "";

        if (valid && $('#newTopping').val() == '') {
            errorMessage += "please enter the name of new Topping\n";
            valid = false;
         } 
        
        if (valid && $('#quantity').val() == '') {
            errorMessage += "please enter the quantity of new Topping\n";
            valid = false;
         } 

        if( !valid && errorMessage.length > 0){
           alert(errorMessage);
           return false;
        }
        
        $.ajax({
      	  method: "GET",
      	  url: "ToppingController",
      	  dataType: 'text',
      	  data: { topping: $('#newTopping').val(), quantity: $('#quantity').val()},
      	  success    : function(resultText){
      		 $('#resultText').html(resultText);
      		 $('#addToppingform').trigger("reset");

  		  },
  		  error : function(jqXHR, exception){
  			  
  		  }
      });
        

        
      });
    
    
    /** Form validation update Manage Inventory*/
        
        $('#manageSubmit').on('click', function() {
            var valid = true,
            errorMessage = "";

            if (valid && $( "#inventory option:selected" ).text() == '') {
                errorMessage += "please select the Topping\n";
                valid = false;
             } 
            
            if (valid && ($('#newquantity').val() == '' || $('#newquantity').val()<=0 )) {
                errorMessage += "please enter a valid quantity for the Topping\n";
                valid = false;
             } 

            if( !valid && errorMessage.length > 0){
               alert(errorMessage);
               return false;
            }
            
            $.ajax({
          	  method: "GET",
          	  url: "InventoryController",
          	  dataType: 'text',
          	  data: { topping: $( "#inventory option:selected" ).text(), quantity: $('#newquantity').val(), submitType: "update"},
          	  success    : function(resultText){
          		 $('#resultText').html(resultText);
          		 $('#inventoryForm').trigger("reset");
      		  },
      		  error : function(jqXHR, exception){
      			  
      		  }
          });
          
      
            
          });
    
/** Form validation delete Manage Inventory*/
        
        $('#manageDeleteSubmit').on('click', function() {
            var valid = true,
            errorMessage = "";

            if (valid && $('#inventory').val() == '') {
                errorMessage += "please seletc the Topping\n";
                valid = false;
             } 
            
           
            if( !valid && errorMessage.length > 0){
               alert(errorMessage);
               return false;
            }
            
            if (confirm('Are you sure you want to delete the topping ?')) {
            	 $.ajax({
                 	  method: "GET",
                 	  url: "InventoryController",
                 	  dataType: 'text',
                 	  data: { topping: $('#inventory').val(), submitType: "delete"},
                 	  success    : function(resultText){
                 		 $('#resultText').html(resultText);
                  		 $('#inventoryForm').trigger("reset");
                  		 
                         $.ajax({
               	  	  	  url: "DataController",
               	  	  	  type: "get",
               	  	  	  dataType: 'text',
               	  	  	  success    : function(result){
               	  	  		          	  	  		  
               	  	  		var $select = $('#inventory');
               	  	  		$select.find('option').remove();
               	  	  		$.each(JSON.parse(result), function(key, value) {
               	  	  		
               	  	  		$select.append('<option>' + key + '</option>');
               	  	  		
               	  	  		});
               	  	  		  
               	  			  },
               	  			  error : function(jqXHR, exception){
               	  				  
               	  				  
               	  			  }
               	  	    });
                         
             		  },
             		  error : function(jqXHR, exception){
             			  
             		  }
                 });
            }else{
            		return false;
            }
            
          
            
          });
    
});



