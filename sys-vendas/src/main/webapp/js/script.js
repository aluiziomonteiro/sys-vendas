/*Envia a imagem para a div de preview*/
function previewImagem() {
	var imagem = document.querySelector('input[name=imagem]').files[0];
	var preview = document.querySelector('img');

	var reader = new FileReader();

	reader.onloadend = function() {
		preview.src = reader.result;
	}

	if (imagem) {
		reader.readAsDataURL(imagem);
	} else {
		preview.src = "";
	}
}

/* Calcula o percentual */
function calcular() {
	var n1 = parseFloat(document.getElementById('custoUnid').value.replace(".",
			""));
	var n2 = parseFloat(document.getElementById('percentual').value.replace(
			",", "."));

	var result = n1 * n2 / 100;
	document.querySelector("[name='lucro']").value = (result).toFixed(2);
	document.querySelector("[name='sugestaoVenda']").value = (result + n1)
			.toFixed(2);
}

/*Calcula o estoque do Carrinho - info-produto.jsp */
function calcularEstoque() {
	  var n1 = parseInt(document.getElementById('fieldQtdEstoque').value, 10);
	  var n2 = parseInt(document.getElementById('fieldQtdInfo').value, 10);
	 
	  document.querySelector("[name='result']").value = ((n1 - n2));
}

// Funcao: MascaraMoeda
// Sinopse: Mascara de preenchimento de moeda
// Parametro:
// objTextBox : Objeto (TextBox)
// SeparadorMilesimo : Caracter separador de milésimos
// SeparadorDecimal : Caracter separador de decimais
// e : Evento
// Retorno: Booleano
// Autor: Gabriel Fróes - www.codigofonte.com.br
// -----------------------------------------------------

function MascaraMoeda(objTextBox, SeparadorMilesimo, SeparadorDecimal, e) {
	var sep = 0;
	var key = '';
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13)
		return true;
	key = String.fromCharCode(whichCode); // Valor para o código da Chave
	if (strCheck.indexOf(key) == -1)
		return false; // Chave inválida
	len = objTextBox.value.length;
	for (i = 0; i < len; i++)
		if ((objTextBox.value.charAt(i) != '0')
				&& (objTextBox.value.charAt(i) != SeparadorDecimal))
			break;
	aux = '';
	for (; i < len; i++)
		if (strCheck.indexOf(objTextBox.value.charAt(i)) != -1)
			aux += objTextBox.value.charAt(i);
	aux += key;
	len = aux.length;
	if (len == 0)
		objTextBox.value = '';
	if (len == 1)
		objTextBox.value = '0' + SeparadorDecimal + '0' + aux;
	if (len == 2)
		objTextBox.value = '0' + SeparadorDecimal + aux;
	if (len > 2) {
		aux2 = '';
		for (j = 0, i = len - 3; i >= 0; i--) {
			if (j == 3) {
				aux2 += SeparadorMilesimo;
				j = 0;
			}
			aux2 += aux.charAt(i);
			j++;
		}
		objTextBox.value = '';
		len2 = aux2.length;
		for (i = len2 - 1; i >= 0; i--)
			objTextBox.value += aux2.charAt(i);
		objTextBox.value += SeparadorDecimal + aux.substr(len - 2, len);
	}
	return false;
}


/*Calcula o desconto no Carrinho - orcamento.jsp */

	function calcularDescontos() {
		var n1 = parseFloat(document.querySelector("[name='subTotalOrcamento']").value.replace(",",
				"."));
		var n2 = parseFloat(document.querySelector("[name='descontos']").value.replace(
				",", "."));

		var desconto = n1 * n2 / 100;
		var total = n1 - desconto;
		var parcelas = 0;
		
		document.querySelector("[name='totalOrcamento']").value = (total).toFixed(2);
		document.querySelector("[name='valorDesconto']").value = (desconto).toFixed(2);
	
		//zera o select
		document.querySelector("[name='parcelas']").value = (parcelas);
		$("#tbodyParcelas").empty();
		$("#divEfetivarVenda").empty();
		$("#theadParcelas").empty();
	}


	/*Calcula o percentual de variação entre subtotal e o desconto  - orcamento.jsp */

	function calcularDescontosRs() {
		var v1 = parseFloat(document.querySelector("[name='subTotalOrcamento']").value.replace(",",
				"."));
		var v2 = parseFloat(document.querySelector("[name='valorDesconto']").value.replace(
				",", "."));

		var descontos = 100 + ((v2 -  v1)/v1 * 100);
		var total = (v1 -  v2);
		var parcelas = 0;
		
		document.querySelector("[name='descontos']").value = (descontos).toFixed(2);
		document.querySelector("[name='totalOrcamento']").value = (total).toFixed(2);
		
		//zera o select
		document.querySelector("[name='parcelas']").value = (parcelas);
		$("#tbodyParcelas").empty();
		$("#divEfetivarVenda").empty();
		$("#theadParcelas").empty();
	}
	
	/*Ocultar "btnEfetivarVenda" contra double click - orcamento.jsp */
	function ocultarBtnEfetivarVenda() {
		$("#btnEfetivarVenda")
			.hide()
			.fadeIn(50000);
			$("#divEfetivarVenda").append("<label>Processando...</label>");
	}
	
	/*Ocultar "btnEfetivarPagamento" contra double click - info-orcamento.jsp */
	function ocultarBtnEfetivarVenda() {
		$("#divSalvaPagamentos").empty();
		$("#divSalvaPagamentos").append("<label>aguarde...</label>");
	}
	

	/*Link de carregar o dashboard*/
	$(document).ready(function(){
		$("#btnIndex").click(function(){
			$('#login_form').submit();
		});
	});



