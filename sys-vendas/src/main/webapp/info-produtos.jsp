<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/script.js"></script>
<title>Buscar Produtos</title>
</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>
	</div>
	
<div id="container">
  <form action="agregar-carrinho.jsp" method="post">	
	<fieldset class="campo">
	<legend>${produto.nome} <span>${produto.volume}</span></legend>
	
		<div class="esquerda">

			<img class="miniaturaProdutoInf" src="./carregadorImagem?id=${produto.id}" />
			<label>R$ </label> 
			<input type="text" value="${produto.sugestaoVenda}" id="redInputInfo" size="10">
			<input type="hidden" name="sugestaoVenda" value="${produto.sugestaoVenda}" />	
		
		</div>
		
		<div class="direita">

			<div class="btnForm">
				<div class="divQtdInfo">
					<label>Quatidade disponível:</label>
					
					<input id="redInputInfo" name="result" type="text" value="${produto.estoque.qtdDisponivel}" size="5">
					<input type="hidden" id="fieldQtdEstoque" value="${produto.estoque.qtdDisponivel}" />
				</div>
				
				<fieldset class="campo">
				<legend><span>Adicionar ao Carrinho</span></legend>
				
				<div class="divCarrinho"><br />
					<div class="esquerdaValor">
						<label>Quantidade: </label>
						<input type="number" name="qtdProduto" value="0" id="fieldQtdInfo" onmouseup="calcularEstoque()" class="form-control" required="required" min="1" max="${produto.estoque.qtdDisponivel}">
					</div>
					
				    <div class="centroValor"> 	
				     	<button type="submit" name="idProduto" value="${produto.id}"  class="btn btn-success"> <i class="fa fa-cart-plus" aria-hidden="true"></i> Add</button>
						<input type="hidden" name="nomeProduto" value="${produto.nome}">
					</div>	
				</div>
				
				</fieldset>
			</div>
		</div>
		
	</fieldset>
	<fieldset class="campo">
	<legend>Detalhes:</legend>
	
		<div class="esquerda">
			<br />  nome
			<label>Nome:</label> <span class="nome">${produto.nome} </span><br />
			<label>Descrição:</label> ${produto.descricao}<br />
			<label>Indicação:</label> ${produto.indicacao}<br />
			<label>Custo: R$</label> <span class="valores">${produto.custoUnid}</span><br />
			<label>Lucro: R$</label> <span class="valores">${produto.lucro}</span><br />
			<label>Percentual de lucro:</label> ${produto.percentual}%<br />
			<input type="hidden" value="${produto.custoUnid}" name="custo">
		</div>
		
		<div class="direita">
						
		</div>
	</fieldset>
	
	</form>
</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>