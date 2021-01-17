$(document).ready(function(){

	//pessoa
	var pessoa = $('#pessoa1').val();
	
	if(pessoa == "FISICA"){
		$('#pessoa1').attr('checked','checked');
	}else{
		$('#pessoa2').attr('checked','checked');
	}
});
