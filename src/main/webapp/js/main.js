function hide(id) {
    if (document.getElementById) {
        if (document.getElementById(id).style.display === 'block') {
            document.getElementById(id).style.display = 'none';

        }
    }
function view(id) {
    if (document.getElementById)  {
        if (document.getElementById(id).style.display === 'none') {
            document.getElementById(id).style.display = 'block';

        } else {}
    }
}
function addIngr() {
    let ingr=$(".input_ingr");
    let memssd=$(".input_ssd").last().val();
    if(mem <=5 ) {
        if (memssd !== "Seleziona SSD" && memssd !== ""){
            $(".addIngr").html(" <select  class='input_ingr' id='ingr"  + $(".input_ingr").length +"' onfocusout=\"check_ingr()\">" +
	            		"			<option>Seleziona SSD</option> <option class='dropdown-divider'></option> " +
	            		"			<option>Prova</option> <option>Prova 1</option> " +
            		"</select> <div class=\"addIngr\"></div>");
            $(".addIngr").first().removeClass("addIngr");
            $(".input_ingr").css('border-color','#5385c1');
        }
        else{
            $(".input_ingr").last().css('border-color','rgb(185, 74, 72)');
        }
    }
}