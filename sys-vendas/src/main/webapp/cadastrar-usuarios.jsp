<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-BR">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="magestic/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="magestic/vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
<link rel="stylesheet" href="magestic/css/style.css">
<link rel="shortcut icon" href="magestic/images/favicon.png" />
<title>Cadastrar Usuário</title>
<link rel="stylesheet" href="css/style.css">
<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/senhaUsuario.js"></script>
</head>
<body>
	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>
	<div id="container">
	<form action="adicionar-usuarios.jsp" method="post">
	<div class="container-scroller">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
					<h2 class="card-title">CADASTRO DE USUÁRIO</h2>
                  	<h4 class="card-description">DADOS DO USUÁRIO</h4>
					<div class="esquerda">
						<div class="esquerda">
							<div class="caixa">
								<label for="nome">Nome:</label> 
								<input id="fieldComum" name="nome" value="${usuario.nome}" class="form-control" >
							</div>
							<div class="caixa">
								<label for="login">Login:</label> 
								<input id="fieldComum" required="required" name="login" value="${usuario.login}" class="form-control" >
							</div>
							<div class="caixa" id="divSenha">
								<label for="senha">Senha:</label> <img id="imgSenha" src="" />
								<input type="password" id="fieldComum" required="required" title="Insira uma senha de no mínimo cinco dígitos" name="senha" value="" size="40" class="form-control" >		
							</div>
							<div class="caixa" id="divRepeteSenha">
								<label for="repeteSenha">Repita a senha:</label> <img id="imgRepeteSenha" src="" />
								<input type="password" id="fieldComum" required="required" title="Repita a senha digitada anteriormente" name="repeteSenha" value="" size="40" class="form-control" >  
							</div>
							<div id="btnForm">
								<button type='submit' id="submit" disabled="disabled" class='btn btn-primary'> Registrar </button>
								<input type="hidden" name="usuarioId" value="${usuario.id}">
							</div>
						</div>
					</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
	</form>
</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>
	
</body>
</html>