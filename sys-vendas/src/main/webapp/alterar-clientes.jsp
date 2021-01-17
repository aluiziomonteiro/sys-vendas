<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Cliente</title>
<link rel="stylesheet" href="css/style.css">

<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/radioCliente.js"></script>
					

</head>
<body>
	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>
	
	<div id="container">

	<form action="alterar-cliente.jsp" method="post">
	
	<fieldset class="campo">
	<legend>Informações pessoais</legend>

		<div class="esquerda">
		
		<div class="caixa">
			<label for="nome">Primeiro Nome:</label>
			<input id="fieldComum" type="text" name="nome" value="${cliente.nome}" class="form-control" aria-describedby="sizing-addon3" required="required">  
			
			<label for="sobreNome">Segundo Nome:</label>
			<input id="fieldComum" type="text" name="sobreNome" value="${cliente.sobreNome}" class="form-control" aria-describedby="sizing-addon3" required="required">
		</div>
		
		<label>Nascimento: </label>
		<div class="caixa">

			<input type="date" name="nascimento" value="${cliente.nascimento}"  id="fieldsMedio" class="form-control">
		</div>
		
		<label>Pessoa:</label>
		<div class="radio">


				<input type="radio"  id="pessoa1" name="pessoa" value="${cliente.pessoa}"
                > <label for="situacao1">Física</label>
					 &nbsp; 
				<input type="radio" id="pessoa2" name="pessoa"  value="${cliente.pessoa}" > 
					<label for="situacao2">Jurídica</label>
					
					
					
			</div>
	
		<label>Sexo:</label>
			<div class="radio">
				<input type="radio" id="sexo1" name="sexo" value="${cliente.sexo}" > <label
					for="situacao1">Masculino</label> &nbsp; 
					<input type="radio" id="sexo2"
					name="sexo" value="${cliente.sexo}" > <label for="situacao2">Feminino</label>
			</div>

		</div>
		
		<div class="direita">
		<div class="caixa">
		
		
			<label for="email">Email:</label>
			<input id="fieldsMedio" type="text" name="email" value="${cliente.email}" class="form-control" aria-describedby="sizing-addon3" required="required">
			<label for="celular">Celular:</label>
			<input id="fieldsMedio" type="text" name="celular" value="${cliente.celular}" class="form-control" aria-describedby="sizing-addon3" required="required">
			
			<label for="observacao">Observação:</label>
			<input id="fieldComum" type="text" name="observacao" value="${cliente.observacao}" class="form-control" aria-describedby="sizing-addon3" required="required">
		</div>
		
		<label>Situação:</label>
			<div class="radio">
				<input type="radio" id="situacao1" name="situacao" value="ATIVO"
					checked> <label for="situacao1">Ativo</label> &nbsp; <input
					type="radio" id="situacao2" name="situacao" value="BLOQUEADO">
				<label for="situacao2">Bloqueado</label>
			</div>
	
		</div>
	</fieldset>
	
	
	<fieldset>
	
	<legend>Endereço</legend>
	<div class="esquerda">	
		<div class="caixa">
			<label>Endereço:</label>
			<input id="fieldComum" type="text" name="endereco" value="${cliente.endereco}" class="form-control" aria-describedby="sizing-addon3" required="required"> 
			<label>Bairro:</label>
			<input id="fieldsMedio" type="text" name="bairro" value="${cliente.bairro}" class="form-control" aria-describedby="sizing-addon3" required="required" >
			<label>Cidade:</label>
			<input id="fieldsMedio" type="text" name="cidade" value="${cliente.cidade}" class="form-control" aria-describedby="sizing-addon3" required="required">  
			<label>Complemento:</label>
			<input id="fieldComum" type="text" name="complemento" value="${cliente.complemento}" class="form-control" aria-describedby="sizing-addon3" required="required">
		</div>
		
	</div>
	
	<div class="direita">
		<div class="caixa">
			<label for="uf">UF:</label>
			<input id="fieldsPequeno" type="text" name="uf" value="${cliente.uf} "size="2" class="form-control" aria-describedby="sizing-addon3" required="required"> 
			
			<label for="cep">CEP:</label>
			<input id="fieldComum" type="text" name="cep" value="${cliente.cep}" class="form-control" aria-describedby="sizing-addon3" required="required">
			<label>Fone:</label>
			<input id="fieldsMedio" type="text" name="fone" value="${cliente.fone}"  class="form-control" aria-describedby="sizing-addon3" required="required">
			<label>Observação:</label>
			<input id="fieldComum" type="text" name="observacao" value="${cliente.observacao}" class="form-control" aria-describedby="sizing-addon3" required="required">
			<label>Número:</label>
			<input id="fieldsMedio" type="text" name="numero" value="${cliente.numero}" class="form-control" aria-describedby="sizing-addon3" required="required"> 
		</div>	
	</div>
	</fieldset>	
	<div id="btnForm">
		<input type="submit" class="btn btn-primary" name="Concluir">
		<input type="hidden" name="clienteId" value="${cliente.id}"> 		
	</div>
</form>		

</div>
<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>
</body>
</html>