<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="pt-BR">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="magestic/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="magestic/vendors/base/vendor.bundle.base.css">

<link rel="stylesheet" href="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.css">

<link rel="stylesheet" href="magestic/css/style.css">
<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<title>Buscar Usuários</title>
</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container">
<div class="container-scroller">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-description">BUSCAR USUÁRIO</h4>
                  <form action="buscar-usuario.jsp" method="post">
						<div id="divBusca">
						<div class="campoBusca">		
							<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" title="Escreva algo para pesquisar."/> 
						</div>
						<div class="direita">		
							<button type="submit" name="Enviar" class="btn btn-sm btn-primary" > <i class="mdi mdi-yeast" aria-hidden="true"></i></button>
						</div>
						</div>	
					</form>		
                </div>
              </div>
            </div>
            </div>
           <br />
            
            <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">     
                   <h4 class="card-description">LISTA DE USUÁRIOS</h4>
					<form action="gerenciar-usuario.jsp" method="post">
						<c:choose>	
							<c:when test="${empty usuarios}">
							<div class="box">
							<div>
								<label class="listaNula">Não encontramos registros.</label>	
							</div>
							<div>
								<a href="buscar-usuario.jsp?filtro=" title="Listar todos os usuários."> Ver todos.</a> | 
								<a href="cadastrar-usuario.jsp" title="Cadastrar um novo usuário."> Adicionar </a> |
								<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
							</div>
						
							</div>
								
							</c:when>
							
							<c:when test="${not empty usuarios}">
								<div class="table-responsive">
								<table class="table table-striped">
								<caption>Lista de Usuários</caption>
									<thead>
										<tr>
									     <th>#</th>
									     <th>Nome</th>
									     <th>Login</th>
									     <th>Senha</th>
									     <th>Ações</th>
										</tr>
									</thead>
								    <tbody>	
								
							   <c:forEach var="usuario" items="${usuarios}">
								    <tr> 
								      <td>${usuario.id}</td>
								      <td>${usuario.nome}</td>
								      <td>${usuario.login}</td>
								      <td>${usuario.senha}</td>
								      
								      <td>
								      		<div class="btnAcoes">
								  
									      		<button type="submit" name="info" value="${usuario.id}"  class="btn btn-info btn-sm"  title="Mais informações."> Info </button>
									      		<button type="submit" name="alterar" value="${usuario.id}"  class="btn btn-warning btn-sm" title="Alterar informações.">Alterar</button>
										  		<button type="submit" name="remover" value="${usuario.id}" class="btn btn-danger btn-sm" title="Excluir usuário do sistema.">Remover</button>
											
									  		</div>
								      </td>
								    	
								  	</tr>
							   	</c:forEach>
							</tbody>
						</table>
						</div>
						
						</c:when>
						</c:choose>
					
					</form>	
                  </div>
                </div>
              </div>
            </div>
            
        </div>
      </div> 
</div>
<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>