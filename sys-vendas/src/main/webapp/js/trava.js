
$(document).ready(function(){
	$(function(){
		$('#chkToggle').bootstrapToggle({
			on: 'Cancelar',
			off: 'Editar',
			onstyle:'outline-dark',
			offstyle:'outline-danger',
			size:'medium',
			width:'100',
			height: '49'
	});});
	 

		  
	var t = document.querySelector("input[name=hiddenTotalParcelas]").value;
	var elemento;
	//Detecta mudanças no toggle
	$('input[name=trava]').change(function () {
		var checado = $(this).prop('checked');	
		console.log("Total de parcelas: "+t);
		
		//checa o estado
		if($('input[name=trava]').is(":checked") == true){
			
			//troca inputs por checkbox
			for(var i = 1; i <= t; i++){
				
				
				//pega o valor do input
				var valorStatus = $("input[name='inputStatus["+i+"]']").val();
				console.log("Valor da parcelas"+i+":"+valorStatus);
				
				//descobre o pai do input
				elemento = $("input[name='inputStatus["+i+"]']").parents("td");
				elemento.empty();
						
				//adiciona o checkbox no pai

				elemento.append("<div class='check-radio'><input type='checkbox' name='checkBoxPagar["+i+"]'/></div>");
				
				//ajusta o status do checkbox
				if(valorStatus == "QUITADO"){
					$("input[name='checkBoxPagar["+i+"]']").attr('checked','checked');
					
				} else if(valorStatus != "QUITADO"){
					$("input[name='checkBoxPagar["+i+"]']").removeAttr('checked');	
					
				}
			}
			//elemento.append("<link href='bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css' rel='stylesheet'>");	
			elemento.append("<script src='bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js'></script>");	
			elemento.append("<script src='jquery/js/jquery-1.9.1.min.js'></script>");
		}
		
		//Adiciona botão submit
		$("#divSalvaPagamentos").prepend("<button type='submit' id='asd' name='asd' onClick='ocultarBtnEfetivarPagamento()' class='btn btn-success btn-lg'> <i class='fa fa-money' > </i> Registrar Pagamento </button> ");
		$("#divSalvaPagamentos").append("<link href='bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css' rel='stylesheet'>");	
		$("#divSalvaPagamentos").append("<script src='bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js'></script>");	
		$("#divSalvaPagamentos").append("<script src='jquery/js/jquery-1.9.1.min.js'></script>");
		//cancela a edição
		if ($('input[name=trava]').is(":checked") == false){
			location.reload();
			$("#divSalvaPagamentos").empty();
			$("#divSalvaPagamentos").text("aguarde...");
		}	
		
	});	
});