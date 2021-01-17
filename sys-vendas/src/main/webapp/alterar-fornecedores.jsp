<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Fornecedor</title>
<link rel="stylesheet" href="css/style.css">

<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/radioFornecedor.js"></script>
	
</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container">

	<form action="alterar-fornecedor.jsp" method="post">
	<fieldset class="campo">
	<legend>Identificação</legend>

	<div class="esquerda">
		
		<div class="caixa">
			<label for="nome">Nome - RS:</label>
			<input id="fieldComum" type="text" value="${fornecedor.nome}" name="nome" size="40" class="form-control" aria-describedby="sizing-addon3">  
		</div>

		<div class="caixa">
			<label for="cnpjCpf">CNPJ - CPF:</label>
			<input id="fieldComum" type="text" value="${fornecedor.cnpjCpf}" name="cnpjCpf" size="40" class="form-control" aria-describedby="sizing-addon3">  	
		</div> 
	  
	</div>
		
	<div class="direita">
	<label>Pessoa:</label>
		<div class="radio">
				
				<input type="radio" id="pessoa1" name="pessoa" value="${fornecedor.pessoa}"
					> <label for="situacao1">Fisica</label>&nbsp; <input
					type="radio" id="pessoa2" name="pessoa" value="${fornecedor.pessoa}"> <label
					for="situacao2">Jurídica</label>
		</div>
	</div>
		
	</fieldset>
	
	<fieldset>
	<legend>Endereço</legend>
	<div class="esquerda">

		<div class="caixa">
			<label for="endereco">Endereço:</label>
			<input id="fieldComum" type="text" name="endereco" value="${fornecedor.endereco}" size="40" class="form-control" aria-describedby="sizing-addon3">  
			
			<div class="esquerda">
				<label for="cep">CEP:</label>
				<input id="fieldsMedio"  type="text" name="cep" value="${fornecedor.cep}" class="form-control"  >  
			</div>
			<div class="direita">
				<label for="bairro">Bairro:</label>
				<input id="fieldsMedio" type="text" name="bairro" value="${fornecedor.bairro}" class="form-control"  >  
			</div>
			
			<div class="esquerda">
				<label for="cidade">Cidade:</label>
				<input id="fieldsMedio" type="text" name="cidade" value="${fornecedor.cidade}"  class="form-control"  >  
			</div>
			
			<div class="direita">
				<label for="uf">UF:</label>
				<input id="fieldsPequeno" type="text" name="uf" value="${fornecedor.uf}" class="form-control">
			</div>
		</div>
	</div>
	
	<div class="direita">
		<div class="caixa">
			<label for="complemento">Complemento:</label>
			<input id="fieldComum" type="text" name="complemento" value="${fornecedor.complemento}" class="form-control" >
			
			<div class="esquerda">
				<label for="fone">Fone:</label>
				<input id="fieldsMedio" type="text" name="fone" value="${fornecedor.fone}" class="form-control" >
			</div>
			<div class="direita">
				<label for="email">Email:</label>
				<input id="fieldsMedio" type="text" name="email" 
				value="${fornecedor.email}" class="form-control" >
			</div>
			<label for="observacao">Observação:</label>
			<input type="text" name="observacao" value="${fornecedor.observacao}"
			 id="fieldComum" class="form-control" >	
		</div>
	</div>
	</fieldset>	
	<div id="btnForm">
		<input type="submit" class="btn btn-primary" name="Enviar"> 
		<input type="hidden"  name="fornecedorId" value="${fornecedor.id}">		
	</div>	
	</form>
	</div>
	
	<footer class="site-footer push">
    	<c:import url="rodape.jsp"/>
	</footer>

</body>
</html>