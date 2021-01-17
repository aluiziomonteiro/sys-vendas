<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!doctype html>
<html lang="pt-BR">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="magestic/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="magestic/vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
<link rel="stylesheet" href="magestic/css/style.css">

<title>Cadastrar Fornecedor</title>
<link rel="stylesheet" href="css/style.css">
<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container">
	
	<div class="container-scroller">
        <div class="content-wrapper">
        <form action="adicionar-fornecedor.jsp" method="post">
          <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
					<h2 class="card-title">CADASTRO DE FORNECEDOR</h2>
                  	<h4 class="card-description">DADOS DO FORNECEDOR</h4>
						<div class="esquerda">
							<div class="caixa">
								<label for="nome">Nome - RS:</label>
								<input id="fieldComum" type="text" name="nome" size="40" class="form-control" aria-describedby="sizing-addon3">  
							</div>
							<label>Pessoa:</label>
							<div class="radio">
								<input type="radio" id="pessoa1" name="pessoa" value="FISICA"
									> <label for="situacao1">Física</label> &nbsp;<input
									type="radio" id="pessoa2" name="pessoa" value="JURIDICA" checked> 
									<label for="situacao2">Jurídica</label>
							</div>
							
						</div>
						<div class="direita">
							<div class="caixa">
								<label for="cnpjCpf">CNPJ - CPF:</label>
								<input id="fieldComum" type="text" name="cnpjCpf" size="40" class="form-control" aria-describedby="sizing-addon3">  	
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
						<label for="endereco">Endereço:</label>
						<input id="fieldComum" type="text" name="endereco" size="40" class="form-control" aria-describedby="sizing-addon3">  
						
						<div class="esquerda">
							<label for="cep">CEP:</label>
							<input id="fieldsMedio"  type="text" name="cep" class="form-control"  >  
						</div>
						<div class="direita">
							<label for="bairro">Bairro:</label>
							<input id="fieldsMedio" type="text" name="bairro" class="form-control"  >  
						</div>
						
						<div class="esquerda">
							<label for="cidade">Cidade:</label>
							<input id="fieldsMedio" type="text" name="cidade" class="form-control"  >  
						</div>
						
						<div class="direita">
							<label for="uf">UF:</label>
							<input id="fieldsPequeno" type="text" name="uf" class="form-control">
						</div>
						
					</div>
				</div>
	
		<div class="direita">
		<div class="caixa">
			<label for="complemento">Complemento:</label>
			<input id="fieldComum" type="text" name="complemento" class="form-control" >
			
			<div class="esquerda">
				<label for="fone">Fone:</label>
				<input id="fieldsMedio" type="text" name="fone" class="form-control" >
			</div>
			<div class="direita">
				<label for="email">Email:</label>
				<input id="fieldsMedio" type="text" name="email" class="form-control" >
			</div>
			<label for="observacao">Observação:</label>
			<input type="text" name="observacao" id="fieldComum" class="form-control" >	
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