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

<title>Buscar Produtos</title>
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
                  <h4 class="card-description">BUSCAR PRODUTO</h4>
                  <form action="buscar-produto.jsp" method="post">
						<div id="divBusca">
						<div class="campoBusca">		
							<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" title="Escreva um nome para pesquisar"/> 
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
                   <h4 class="card-description">LISTA DE PRODUTOS</h4>
					<form action="gerenciar-produto.jsp" method="post">

						<c:choose>	
							<c:when test="${empty produtos}">
								<div class="box">
								<div>
									<label class="listaNula">Não encontramos registros.</label>	
								</div>
								<div>
									<a href="gerencia-produto.jsp?filtro=" title="Listar todos os produtos.">Ver todos </a> |
									<a href="cadastrar-produto.jsp" title="Cadastrar um novo produto."> Adicionar </a> |
									<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
								</div>
							
								</div>
									
							</c:when>
							
							<c:when test="${not empty produtos}">
								<div class="table-responsive">
									<table class="table table-hover">
									<caption>Lista de Produtos</caption>
										  <thead>
										    <tr>
										      <th > # </th>
										      <th > Imagem </th>
										      <th > Nome </th>
										      <th > Descricao/Indicação </th>
										      <th > Custo Unid </th>
										      <th > Sugestão Venda </th>
										      <th > Estoque </th>
										      <th > Ações</th>
										    </tr>
										  </thead>
									  <tbody>
									
									   <c:forEach var="produto" items="${produtos}">
										    <tr>
										      <td>${produto.id}</td>
										      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
												<td><span class="nome">-${produto.nome}</span><br />
													${produto.volume}
												</td>
												<td>-${produto.descricao}<br />
													-${produto.indicacao}
												</td>
												
											    <td class="valores">R$ ${produto.custoUnid}</td>
												<td class="valores">R$ ${produto.sugestaoVenda}</td>
												<td>${produto.estoque.qtdDisponivel}</td>
										
										      <td> 
										    	<div class="btnAcoes">
										      		<button type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info" title="Veja maiores informações sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i> Info</button>
										      		<button type="submit" name="alterar" value="${produto.id}" class="btn btn-outline-warning" title="Permite alterar os dados do produto."> <i class="fa fa-pencil-square-o" ></i> Atualizar</button>	
											  		<button type="submit" name="remover" value="${produto.id}" class="btn btn-outline-danger" title="Apaga este produto do sistema.">  <i class="fa fa-trash-o" ></i> Remover</button>
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