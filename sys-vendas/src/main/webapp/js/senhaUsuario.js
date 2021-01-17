$(document).ready(function(){

	//senha do usuário	
	$('input[name="repeteSenha"], input[name="senha"]').bind("input keydown ",function(){
		
		var senha = $('input[name="senha"]').val();
		var repeteSenha = $('input[name="repeteSenha"]').val();
		
		if((senha != "") && (repeteSenha != "") && (senha == repeteSenha))
		{
			$('#btnForm').empty();
				
			$('#btnForm').append("<button type='submit' id='submit' class='btn btn-success btn-lg'> Enviar </button> ");	
			$('#submit').removeAttr('checked');
			$('#imgRepeteSenha').attr('src','img/figura-ok.png');
			$('#imgRepeteSenha').attr('title','Senhas iguais');
			$('#imgSenha').attr('src','img/figura-ok.png');
			$('#imgSenha').attr('title','Senhas iguais');
			$('input[name="senha"]').css('background-color','rgba(255, 255, 255, 0)');
			$('input[name="repeteSenha"]').css('background-color','rgba(255, 255, 255, 0)');
		}	
		
		else{
			$('#btnForm').empty();
			$('#btnForm').append("<button type='submit' id='submit' class='btn btn-success btn-lg'> Enviar </button> ");	
			$('#submit').attr('disabled','disabled');
			$('#imgRepeteSenha').attr('src','img/figura-err.png');
			$('#imgRepeteSenha').attr('title','As senhas precisam ser iguais');
			$('#imgSenha').attr('src','img/figura-err.png');
			$('#imgSenha').attr('title','As senhas precisam ser iguais');
			$('input[name="senha"]').css('background-color','rgba(235, 251, 0, 0.24)');
			$('input[name="repeteSenha"]').css('background-color','rgba(235, 251, 0, 0.24)');
		
		}
		
	});
});
