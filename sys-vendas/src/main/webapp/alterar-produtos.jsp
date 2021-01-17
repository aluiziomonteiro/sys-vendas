<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="categoriaDao" class="br.com.aluizio.sysvendas.dao.CategoriaDao"/>
<jsp:useBean id="fornecedorDao" class="br.com.aluizio.sysvendas.dao.FornecedorDao"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Produto</title>
<link rel="stylesheet" href="css/style.css">

<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/script.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
</head>
<body>
	<div class="principal">
		<div class="page-header">
			<h1>Alterar Produto</h1>
		</div>

<form action="alterar-produto.jsp" method="post" class="md-form" enctype="multipart/form-data">

    
<fieldset class="campo">
	<legend>Dados do Produto</legend>
    
	<div class="esquerda">
	 <div id=""> 
		<div >	      
  			<input type="file" class=" btn btn-primary"  name="imagem" id="imagem" onchange="previewImagem()" value="${produto.imagem}"/>
    	</div>
        <img class="preview" src="carregadorImagem?id=${produto.id} "/>
   	 </div>	
		<div class="esquerda">
			<div class="caixa">
				<label for="fornecedorId"  >Fornecedor:</label> 
				
   				<select name="fornecedorId" id="selectDeProdutos" class="form-control" required="required">
						<option value="0">SELECIONE</option>
						<c:forEach var="fornecedor" items="${fornecedorDao.list}">
							<option value="${fornecedor.id}">${fornecedor.nome}</option>
						</c:forEach>
						<option selected>${produto.fornecedor.nome}</option>
					</select>
					
   				<span class="input-group-btn">
					<a id="linkSelect" href="cadastrar-fornecedor.jsp">&#10010; Novo Fornecedor</a>
				</span>
			</div>
		</div>
                 
			<div class="direita">
			
				<div class="caixa">
					<label for="cat" >Categoria:</label> 
					<select name="cat" id="selectDeProdutos" class="form-control" required="required">
						<option value="0">SELECIONE</option>
						<c:forEach var="lista" items="${categoriaDao.list}">
							<option value="${lista.nome}">${lista.nome}</option>
						</c:forEach>
						<option selected>${produto.categoria.nome}</option>
					</select>
			
					<span class="input-group-btn">
						<a id="linkSelect" href="cadastrar-categoria.jsp">&#10010; Nova Categoria</a>
					</span>					
				</div>
			</div>		
			</div>

			<div class="direita">
			<div class="caixa">
				<label for="nome">Nome:</label> 
				<input id="fieldComum" type="text" name="nome" value="${produto.nome}" size="40" class="form-control" required="required" >

				<label for="descricao">Descrição:</label> 
				<input id="fieldComum" type="text" name="descricao" value="${produto.descricao}" size="40" class="form-control" >
			
				<label for="indicacao">Indicação:</label>
				<input id="fieldComum" type="text" name="indicacao" value="${produto.indicacao}" size="40" class="form-control"> 
				
				<label for="volume" >Volume:</label> 
				<input id="fieldComum" type="text" name="volume" value="${produto.volume}" size="30" class="form-control" >

				<div class="esquerda">					
					<label for="qtdDisponivel">Quantidade Disponível:</label> 

					<input type="text" name="qtdDisponivel" id="fieldsMedio"
					value="${produto.estoque.qtdDisponivel}" 
					disabled="disabled" class="form-control"  >
			
					<label for="qtdMinima"  >Limite Mínimo:</label> <input type="text" name="qtdMinima" 
					value="${produto.estoque.qtdMinima}" id="fieldsMedio"
					class="form-control"  required="required"> 
					
					<label for="qtdAdicional" id="labelsProdutosValor">Adicionar Quantidade:</label> 
					<input type="text" name="qtdAdicional" class="form-control" required="required" 
					id="fieldsValor">
						
					<input type="hidden" name="qtdEntrada" value="${produto.estoque.qtdEntrada}">
						
				</div>

				<div class="esquerda">
					<label for="custoUnid" id="labelsProdutosValor">Custo
					Unitário:</label> <input id="fieldsValor" type="text" name="custoUnid" 
					value="${produto.custoUnid}" size="30"
					class="form-control" required="required">
				</div>
				<div class="direita">
					<label for="sugestaoVenda"
					id="labelsProdutosValor">Valor de
					Venda:</label> <input  type="text" name="sugestaoVenda" size="30"
					class="form-control" value="${produto.sugestaoVenda}" id="fieldsValor"required="required">
						
					<label for="percentual"
					id="labelsProdutosValor">Percentual
					Venda:</label> <input  type="text" name="percentual" size="30"
					class="form-control" id="fieldsValor" value="${produto.percentual}" required="required">

				</div>
				</div>
			</div>
	</fieldset>		
	<div id="btnForm">
		<input type="submit" class="btn btn-primary" name="Enviar" value=" Enviar "> 
		<input type="hidden" name="produtoId" value="${produto.id}">
		<input type="hidden" name="estoqueId" value="${produto.estoque.id}">
		<input type="hidden" name="categoriaId" value="${produto.categoria.id}">		
	</div>
</form>

	</div>
</body>
</html>