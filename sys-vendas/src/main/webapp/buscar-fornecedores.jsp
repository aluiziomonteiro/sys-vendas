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

<title>Buscar Fornecedores</title>
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
                  <h4 class="card-description">BUSCAR FORNECEDOR</h4>
                  <form action="buscar-fornecedor.jsp" method="post">
						<div id="divBusca">
						<div class="campoBusca" >		
							<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" title="Escreva um nome para pesquisar." /> 
						</div>
						<div class="direita">		
							<button type="submit" name="Enviar" class="btn btn-sm btn-primary"> <i class="mdi mdi-yeast" aria-hidden="true"></i></button>
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
                   <h4 class="card-description">LISTA DE FORNECEDORES</h4>
					<form action="gerenciar-fornecedor.jsp" method="post">
						<c:choose>	
							<c:when test="${empty fornecedor}">
								<div class="box">
								<div>
									<label class="listaNula">Não encontramos registros.</label>	
								</div>
								<div>
									<a href="buscar-fornecedor.jsp?filtro=" title="Listar todos os fornecedores."> Ver todos</a> |
									<a href="cadastrar-fornecedor.jsp" title="Cadastrar um novo fornecedor."> Adicionar </a> |
									<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
								</div>	
								</div>				
							</c:when>
								
							<c:when test="${not empty fornecedor}">
							<div class="table-responsive">
								<table class="table table-hover">
								<caption>Lista de Fornecedores</caption>
									  <thead>
									    <tr>
									      <th scope="col">#</th>
									      <th scope="col">Nome</th>
									      <th scope="col">Endereco</th>
									      <th scope="col">Fone</th>
									      <th scope="col">Email</th>
									      <th scope="col">Observação</th>
									      <th> Ações</th>
									    </tr>
									  </thead>
									  
								  <tbody>
								   <c:forEach var="fornecedor" items="${fornecedor}">
									    <tr>
									      <th scope="row">${fornecedor.id}</th>
									      <td>${fornecedor.nome}</td>
									      <td>${fornecedor.endereco}</td>
									      <td>${fornecedor.fone}</td>
									      <td>${fornecedor.email}</td>
									 	  <td>${fornecedor.observacao}</td>
									      <td> 
									      <div class="btnAcoes">
									     
									  	<input type="hidden" name="pessoa" value="${fornecedor.pessoa}">
									  	<input type="hidden" name="fornecedorId" value="${fornecedor.id}">
									      <button type="submit" name="info" value="${fornecedor.id}"  class="btn btn-info btn-sm" title="Mais Informações."> <i class="fa fa-info-circle"></i> Info</button>
									      <button type="submit" name="alterar" value="${fornecedor.id}"  class="btn btn-warning btn-sm" title="Alterar Fornecedor."> <i class="fa fa-pencil-square-o"></i> Alterar</button>
										  <button type="submit" name="remover" value="${fornecedor.id}" class="btn btn-danger btn-sm" title="Remover fornecedor do sistema."> <i class="	fa fa-trash-o"></i> Remover</button>
											
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