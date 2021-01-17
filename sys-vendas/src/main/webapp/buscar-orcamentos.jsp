<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<title>Buscar Orçamento</title>
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
                  <h4 class="card-description">BUSCAR ORÇAMENTO</h4>
					<form action="gerenciar-orcamento.jsp" method="post">
						<div id="divBusca">
						<div class="campoBusca">		
							<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Nome do cliente" title="Escreva um nome para pesquisar"/> 
						</div>
						<div class="direita">		
							<button  type="submit" name="Enviar" class="btn btn-sm btn-primary"> <i class="mdi mdi-yeast" aria-hidden="true"></i></button>
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
                  
                   <h4 class="card-description">LISTA DE ORÇAMENTOS</h4>
					<form action="gerenciar-orcamento.jsp" method="post">
						<c:choose>	
							<c:when test="${empty orcamentos}">
							<div class="box">
							<div>
								<label class="listaNula">Não encontramos registros.</label>	
							</div>
							<div>
								<a href="buscaClientes?filtro=" title="Listar todos os orçamentos."> Ver todos </a> |
								<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
							</div>
						
							</div>
								
							</c:when>
							
							<c:when test="${not empty orcamentos}">
					
								<div class="table-responsive">
									<table class="table table-striped">
										<caption>Lista de Orcamentos</caption>
											<thead>
										    <tr>
										    	  <th>ID</th>
											      <th>Cliente</th>
											      <th>Data da Compra</th>
											      <th>Valor da Compra</th>
											      <th>Situação</th>
											      <th>Parcelas Pagas</th>
											      <th>Ações</th>
										    </tr>
										  </thead>
									  <tbody>
									
									   <c:forEach var="orcamento" items="${orcamentos}">
										   <tr>
										   <td> 
									      		 ${orcamento.id}
									      	</td>
									      	<td> 
									      		 ${orcamento.cliente.nome}
									      	</td>
											<td>
												<fmt:parseDate value="${orcamento.dataLancamento}" pattern="yyyy-MM-dd" var="dataLancamento" type="both" />
												<fmt:formatDate pattern="dd/MM/yyyy" value="${dataLancamento}" /> <br />
									            
											</td>
											
											<td> 
									      		R$ ${orcamento.totalOrcamento}
									      	</td>
											<td>
									      		<c:choose>
													<c:when test="${orcamento.parcelasAPagar > 0}">
														<input class="camposAPagar" type="text" value="Em débito" readonly="readonly">
													</c:when>
													<c:when test="${orcamento.parcelasAPagar == 0}">
														<input class="camposQuitados" type="text" value="Quitado" readonly="readonly">
													</c:when>
												</c:choose>
									      	</td>
											    <td> 
									      			${orcamento.parcelasPagas}
									      		- 
									      			${orcamento.totalParcelas}
									      		</td>
									      		<td> 
											    	<div class="btnAcoes">
											      		<button type="submit" name="detalhes" title="Mais informações." value="${orcamento.id}" class="btn btn-outline-info btn-sm" > <i class="fa fa-info-circle" ></i> Info</button>			      		
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