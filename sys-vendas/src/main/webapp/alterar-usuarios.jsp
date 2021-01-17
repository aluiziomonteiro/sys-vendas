<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Usuário</title>
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>


<script type="text/javascript" src="jquery/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/senhaUsuario.js"></script>
	
	
</head>
<body>
<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container">
	

	<form action="alterar-usuarios.jsp" method="post">
	<fieldset class="campo">
		<legend>Dados do Usuário</legend>
		<div class="esquerda">
			<div class="esquerda">
				<div class="caixa">
					<label for="nome">Nome:</label> 
					<input id="fieldComum" name="nome" value="${usuario.nome}" class="form-control" readonly="readonly">
				</div>
				<div class="caixa">
					<label for="login">Login:</label> 
					<input id="fieldComum" required="required" name="login" value="${usuario.login}" class="form-control" >
				</div>
				<div class="caixa" id="divSenha">
					<label for="senha">Senha:</label> <img id="imgSenha" src="" />
					<input type="password" id="fieldComum" required="required" title="Insira uma senha de no mínimo cinco dígitos" name="senha" value="" pattern="5" size="40" class="form-control" >
					
				</div>
				<div class="caixa" id="divRepeteSenha">
					<label for="repeteSenha">Repita a senha:</label> <img id="imgRepeteSenha" src="" />
					<input type="password" id="fieldComum" required="required" title="Repita a senha digitada anteriormente" name="repeteSenha" value="" pattern="5" size="40" class="form-control" >  
				</div>
				
				<div id="btnForm">
					<button type='submit' id="submit" disabled="disabled" class='btn btn-success btn-lg'> Enviar </button>
					<input type="hidden" name="usuarioId" value="${usuario.id}">
				
				</div>
	
			</div>
		</div>

	</fieldset>
		
	</form>
	<footer class="site-footer push">
    	<c:import url="rodape.jsp"/>
	</footer>
</div>
</body>
</html>