(jQuery)(function() {
	 let error_ingr = false;
	 $(".input_ingr").last().focusout(function() {
		 check_ingr();
	       
	    });
	 
	 function check_ingr() {
	        let ca = $(".input_ingr").last().val();
	        if(ca === "" || ca === null) {
	            $(".input_ingr").last().css('border-color','rgb(185, 74, 72)');
	            error_ingr = true;
	        }
	        else {
	            $(".input_ingr").css('border-color','#5385c1');
	            error_ingr = false;
	        }
	    }
	 $( ".formInsert" ).on("click", function() {
		 check_ingr();
		 if(error_ingr){
			 $(".input_ingr").last().css('border-color','rgb(185, 74, 72)');
			 return false;
		 }else{
			 return true;
		 }
	 });
});
function addIngr() {
    let ingr=$(".input_ingr").length;
    
    let ingrlast=$(".input_ingr").last().val();
    if(ingr==20 && ingrlast !== null){
    	$(".add-btn").addClass("hide" );
    }else{
    	$(".add-btn").removeClass("hide" );
    }
    if (ingrlast !== null  ){
        $(".ingr").first().addClass("input_ingr show" );
        $(".ingr").first().removeClass("ingr hide");
        $(".input_ingr").css('border-color','#5385c1');
        $(".input_ingr").last().attr("name","idingr");
        $(".rmv-btn").addClass("show" );
        $(".rmv-btn").removeClass("hide" );
     }else{
        $(".input_ingr").last().css('border-color','rgb(185, 74, 72)');
        
     }
}
function rmvIngr() {
    let ingr=$(".input_ingr").length;
    
    if(ingr >1){
        $(".input_ingr").last().addClass("ingr hide" );
        $(".ingr").first().removeClass("input_ingr show");
        $(".ingr").first().removeAttr("name");
        $(".add-btn").removeClass("hide" );
        $(".add-btn").addClass("show" );
    }else if(ingr<=1){
    	$(".rmv-btn").addClass("hide" );
    	 $(".rmv-btn").removeClass("show" );
    }
}
