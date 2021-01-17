<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   


<html lang="pt-BR">
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="magestic/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="magestic/vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
<link rel="stylesheet" href="magestic/css/style.css">

<title>Cadastrar Cliente</title>
<link rel="stylesheet" href="css/style.css">

<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container">
<div class="container-scroller">
        <div class="content-wrapper">
       <form action="adicionar-cliente.jsp" method="post">
          <div class="row">  
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                 <h2 class="card-title">CADASTRO DE CLIENTE</h2>
                  <h4 class="card-description">DADOS PESSOAIS</h4>
						<div class="esquerda">
						<div class="caixa">
							<label for="nome">Primeiro Nome:</label>
							<input id="fieldComum" type="text" name="nome"  class="form-control" aria-describedby="sizing-addon3">  
							
							<label for="sobreNome">Segundo Nome:</label>
							<input id="fieldComum" type="text" name="sobreNome"  class="form-control" aria-describedby="sizing-addon3">
						</div>
						<label>Nascimento: </label>
						<div class="fieldsData">
							<input type="date" name="nascimento" id="campoData" class="form-control">
						</div>
						<label>Pessoa:</label>
						<div class="radio">			
							<input type="radio" class="" id="pessoa1" name="pessoa" value="FISICA" checked> 
							<label for="situacao1">Física</label> &nbsp; 
							<input type="radio" id="pessoa2" name="pessoa" value="JURIDICA"> 
							<label for="situacao2">Jurídica</label>
						</div>
						<label>Sexo:</label>
							<div class="radio">
								<input type="radio" id="sexo1" name="sexo" value="M"> <label
								for="situacao1">Masculino</label> &nbsp; <input type="radio" id="sexo2"
								name="sexo" value="F" checked> <label for="situacao2">Feminino</label>
							</div>
						</div>
						<div class="direita">
						<div class="caixa">
							<label for="email">Email:</label>
							<input id="fieldsMedio" type="text" name="email" class="form-control" aria-describedby="sizing-addon3">
							<label for="celular">Celular:</label>
							<input id="fieldsMedio" type="text" name="celular" class="form-control" aria-describedby="sizing-addon3">
							<label for="observacao">Observação:</label>
							<input id="fieldComum" type="text" name="observacao" class="form-control" aria-describedby="sizing-addon3">
						</div>
							<label>Situação:</label>
							<div class="radio">
								<input type="radio" id="situacao1" name="situacao" value="ATIVO"
									checked> <label for="situacao1">Ativo</label> &nbsp; <input
									type="radio" id="situacao2" name="situacao" value="BLOQUEADO">
								<label for="situacao2">Bloqueado</label>
							</div>
						</div>
                  	</div>
                </div>
              </div>
            </div>
            <br />
            
            <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-description">ENDEREÇO</h4>
						<div class="esquerda">
							<div class="caixa">
								<label>Endereço:</label>
								<input id="fieldComum" type="text" name="endereco" class="form-control" aria-describedby="sizing-addon3" required="required"> 
								<label>Bairro:</label>
								<input id="fieldsMedio" type="text" name="bairro" class="form-control" aria-describedby="sizing-addon3">
								<label>Cidade:</label>
								<input id="fieldsMedio" type="text" name="cidade" class="form-control" aria-describedby="sizing-addon3">  
								<label>Complemento:</label>
								<input id="fieldComum" type="text" name="complemento" class="form-control" aria-describedby="sizing-addon3">
							</div>
						</div>
						<div class="direita">
								<div class="caixa">
								<label for="uf">UF:</label>
								<input id="fieldsPequeno" type="text" name="uf" size="2" class="form-control" aria-describedby="sizing-addon3" > 
								
								<label for="cep">CEP:</label>
								<input id="fieldComum" type="text" name="cep" class="form-control" aria-describedby="sizing-addon3" >
								<label>Fone:</label>
								<input id="fieldsMedio" type="text" name="fone" class="form-control" aria-describedby="sizing-addon3">
								<label>Observação:</label>
								<input id="fieldComum" type="text" name="observacao" class="form-control" aria-describedby="sizing-addon3">
								<label>Número:</label>
								<input id="fieldsMedio" type="text" name="numero" class="form-control" aria-describedby="sizing-addon3"> 
							</div>	
						</div>
							<div id="btnForm">
								<input type="submit" class="btn btn-primary" name="Enviar" value="Registrar"> 
								<input type="reset" class="btn btn-default" name="Limpar" value="Limpar">		
							</div>
                  </div>
                  </div>
                  </div>
                  </div>
                  </form>
                </div>
              </div>
            </div>
      
	<footer class="site-footer push">
    	<c:import url="rodape.jsp"/>
	</footer>

</body>
</html>