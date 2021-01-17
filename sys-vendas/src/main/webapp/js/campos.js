
$(document).ready(function(){

	$('select[name=parcelas]').change(function () {
		
		var valor = $('input[name="totalOrcamento"]').val();
		
		// Obtém a data/hora atual
		var data = new Date();
		var qtdParcela = $('select[name=parcelas]').val();
		var valParcela = (valor / qtdParcela).toFixed(2);;
		
		//Calcula o resto com retorno decimal
		var resto = (valor - (valParcela * qtdParcela)).toFixed(2);
		
		// clean inputs
		$("#tbodyParcelas").empty();
		$("#divEfetivarVenda").empty();
		$("#theadParcelas").empty();
			
		//gera inputs
		for(var i = 1; i <= qtdParcela; i++){
				
			// Guarda cada pedaço em uma variável
			var dia = data.getDate();           
			var mes = data.getMonth()+1;          // 0-11 (zero=janeiro)
			var fullAno = data.getFullYear();       
			
			//ajusta o mes para 2 caracteres
			var fullMes = ("00" + mes).slice(-2);
			
			//ajusta o dia para 2 caracteres
			var fullDia = ("00" + dia).slice(-2);
			
			if(i == qtdParcela){
				valParcela = (parseFloat(valParcela)+parseFloat(resto)).toFixed(2);
			}
			
			// concatena
			var stringData =  fullAno + '-' + fullMes + '-' + fullDia;
			
			$("#tbodyParcelas").append("<tr>");			
			$("#tbodyParcelas").append("<td> <b>"+i+"&deg; parcela:  </b>"," <input id='inputValorParcela' class='form-control' name='parcelaValor["+i+"]' value="+valParcela+" readonly='readonly'> </td>");
			$("#tbodyParcelas").append("<td> <input type='date' id='fieldsMedio' class='form-control' name='parcelaData["+i+"]' value="+stringData+"> </td> ");
			
			//Checkbox de pagamento
			$("#tbodyParcelas").append("<td id='tdPagar'> <div class='check-radio'><input type='checkbox'  name='checkBoxPagar["+i+"]'></div> </td>");
						
			//Marca a primeira parcela como paga
			if (i == 1){
				$("[name='checkBoxPagar[1]']").attr('checked','checked');
			}
			
			$("#tbodyParcelas").append("</tr>");
			$("#parcelaValor").prepend("<br /><br />");
			
			// Ajusta data 
			data.setDate(data.getDate() + 30);
			
			var saida = $('#parcelaValor').index(i);
			console.log(saida);		
		}

		if (qtdParcela > 0){
			$("#divEfetivarVenda").append(" <button type='submit' id='btnEfetivarVenda' name='idProduto' onClick='ocultarBtnEfetivarVenda()' class='btn btn-success btn-lg'> <i class='fa fa-money' > </i> &nbsp;Efetivar Venda&nbsp; </button> ")
			.css('font-size','24');
			
			$("#theadParcelas").append(
					"<tr>",
						"<th scope='row'>  </th>",
						"<th>Valor</th>",
						"<th>Vencimento</th>",
						"<th>Status</th>",
					"</tr>");
		}
		
		$("#divEfetivarVenda").append("<link href='bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css' rel='stylesheet'>");	
		$("#divEfetivarVenda").append("<script src='bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js'></script>");
		$("#tbodyParcelas").append("<script type='text/javascript' src='js/script.js'></script>");
		$("#tbodyParcelas").append("<link href='bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css' rel='stylesheet'>");	
		$("#tbodyParcelas").append("<script src='bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js'></script>");
    });
});
