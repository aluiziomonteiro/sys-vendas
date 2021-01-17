$(document).ready(function(){

	//pessoa
	var pessoa = $('#pessoa1').val();
	
	if(pessoa == "FISICA"){
		$('#pessoa1').attr('checked','checked');
	}else{
		$('#pessoa2').attr('checked','checked');
	}
	
	//sexo
	var sexo = $('#sexo1').val();
	
	if(sexo == "M"){
		$('#sexo1').attr('checked','checked');
	}else{
		$('#sexo2').attr('checked','checked');
	}
	
	//situação
	var situacao = $('#situacao1').val();
	
	if(situacao == "ATIVO"){
		$('#situacao1').attr('checked','checked');
	}else{
		$('#situacao2').attr('checked','checked');
	}
});
