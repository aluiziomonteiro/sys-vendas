<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

<title>Info Orçamento</title>

<meta charset="utf-8">

<link rel="stylesheet" href="magestic/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="magestic/vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.css">


<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/script.js"></script>

<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

		<link href="bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">	
		<script src="bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js"></script>
		<script src="js/trava.js"></script>
		
		<script src="jquery/js/jquery-1.9.1.min.js"></script>
		<link rel="stylesheet" href="css/switchbutton.css"  >


</head>
<body>
                       
<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>
<div id="container">

<div class="container-scroller">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                <h2 class="card-title">ORÇAMENTO</h2>
                  <h4 class="card-description">Info Orçamento</h4>
						<div class="table-responsive">
						<table class="table table-hover">
							  <thead>
							    <tr>
							    	<th > Nº</th>
							    	<th > Data Lancamento</th>
							    	<th > Vendedor </th> 
							      	<th > Subtotal</th>
							      	<th > Descontos </th>
							      	<th > Total </th>
							      	<th > Parcelas Pagas </th> 
							    </tr>
							  </thead>
						  <tbody>
						
						  <tr>
						  	<td id="orcamentoId">
								${orcamento.id}
							</td>
						  	<td>
						  	<span class="valores">
								<fmt:parseDate value="${orcamento.dataLancamento}" pattern="yyyy-MM-dd" var="dataLancamento" type="both" />
								<fmt:formatDate pattern="dd/MM/yyyy" value="${dataLancamento}" />
							</span>
							</td>
							<td>
							    <span class="nome">${orcamento.usuario.nome}</span>
							</td>
						    <td title="Valor total sem descontos">
								R$ ${orcamento.subTotalOrcamento}
							</td>
							<td>
								R$ ${orcamento.descontos}
							</td>
							<td title="Valor total com descontos">
								<span class="valores">R$ ${orcamento.totalOrcamento}</span>
							</td>
							 <td title="Foram pagas ${orcamento.parcelasPagas} de ${orcamento.totalParcelas} parcelas">
								${orcamento.parcelasPagas}
							 				-
								${orcamento.totalParcelas}
							<input type="hidden" name="hiddenTotalParcelas" value="${orcamento.totalParcelas}">
							
							</td>	
					      <td> 
					      
					      
					      
					      </td>
					    </tr>
						  </tbody>
						 
						</table>
					</div>
	
                  </div>
                </div>
              </div>
            </div>
                       
            <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
     
                <div class="card-body">
                  
                   <h4 class="card-description">Info Cliente</h4>
					<form action="gerenciar-cliente.jsp" method="post">
						
						<div class="table-responsive">
							<table class="table table-hover">
								  <thead>
								  <caption></caption>
								    <tr>
								      <th> Cliente </th>
								      <th> Celular </th>
								      <th> Observação </th>
								      <th> Ações </th>
								    </tr>
								  </thead>
							  <tbody>
							
							  <tr>
								<td>
									<span class="nome">${orcamento.cliente.nome} ${orcamento.cliente.sobreNome}</span>
								</td>
								<td>
									${orcamento.cliente.celular}
								</td>
								<td>
									${orcamento.cliente.observacao}
								</td>
						      <td> 
							  <div class="btnAcoes">			      		
							    <button type="submit" name="info" value="${orcamento.cliente.id}"  class="btn btn-outline-info" title="Mais informações."> <i class="fa fa-info-circle"></i> Info</button>
							    
							  </div>
						      </td>
						    </tr>
							  </tbody>
							</table>
						</div>
						
					</form>	
                  </div>
                </div>
              </div>
            </div>
            
                      <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-description">Produtos Comprados</h4>
					
					<div class="table-responsive">
						<table class="table table-hover">
							  <thead>
							    <tr>
							      <th > Imagem </th>
							      <th > Id </th>
							      <th > Produto </th>
							      <th > Valor Unitário </th>
							      <th > Quantidade </th>
							      <th > Total </th>
							    </tr>
							  </thead>
						  <tbody>
						
						  <c:forEach var="produto" items="${orcamento.list}"> 
						  <tr>
					
						     <td>
						      	<img class="miniaturaProdutoPeq" src="./carregadorImagem?id=${produto.produtoId}" />
						     </td>
						     <td>
								${produto.produtoId}
							 </td>
							<td>
								<span class="nome">${produto.produtoNome}</span>
							</td>
							<td>
								<span class="valores">R$ ${produto.valorUnid}</span>
							</td>
							<td>
								${produto.qtd}
							</td>
							<td>
								<span class="valores">R$ ${produto.subTotal}</span>
							</td>
							
					    </tr>
						   </c:forEach>
						  </tbody>
						</table>
					</div>		
                  </div>
                </div>
              </div>
            </div>
          
           
            <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
     
                <div class="card-body">
                  
                   <h4 class="card-description">Info Pagamento</h4>
						<form action="pagamento.jsp" method="post">
													
							<div class="direitaLink">	
							    
							</div>
							<div class="table-responsive">
								<table class="table table-hover">
									  <thead>
									    <tr>
									    <th > Pagamento id </th>
									      <th > Nº. Parcela </th>
									      <th > Valor da Parcela</th>
									      <th > Vencimento </th>
									      <th > Situação </th>
									 
									    </tr>
									  </thead>
								  <tbody>
								
								  <c:forEach var="pagamento" items="${orcamento.pagamentos}"> 
								  <tr>
								  
								  	<td>
										${pagamento.id}
										<input type="hidden" name="idPagamento[${pagamento.numParcela}]" value="${pagamento.id}">
									</td>
									
									
									<td>
										${pagamento.numParcela}
									</td>
									<td>
										<span class="valores">R$ ${pagamento.valorParcela}</span>
									</td>
									<td>
										
										<fmt:parseDate value="${pagamento.parcelaData}" pattern="yyyy-MM-dd" var="parcelaData" type="both" />
										<fmt:formatDate pattern="dd/MM/yyyy" value="${parcelaData}" />
									</td>
									<td id="tdStatus">
									<c:set var="quitado" value="QUITADO" />
									<c:set var="apagar" value="A_PAGAR" />
									<c:set var="vencida" value="EM_ATRASO" />
									<c:set var="status" value="${pagamento.status}" />
										<c:choose>
											<c:when test="${pagamento.status == quitado}">
												<input class="camposQuitados" name="inputStatus[${pagamento.numParcela}]" type="text" value="${pagamento.status}" readonly="readonly" title="Esta parcela já foi paga!">
											</c:when>
											
											<c:when test="${pagamento.status == apagar}">
												<input class="camposAPagar" name="inputStatus[${pagamento.numParcela}]" type="text" value="${pagamento.status}" readonly="readonly" title="Esta parcela ainda não foi paga!">
											</c:when>
											
											<c:when test="${pagamento.status == vencida}">
												<input class="camposEmAtraso" name="inputStatus[${pagamento.numParcela}]" type="text" value="${pagamento.status}" readonly="readonly" title="Esta parcela está vencida!">
											</c:when>
										</c:choose>
										
									</td> 
							      <td> 
							
							      </td>
							    </tr>
								   </c:forEach>
								  
								  </tbody>
								</table>
							</div>		
							
							<input type="hidden" name="totalParcelas" value="${orcamento.totalParcelas}">
							<input type="hidden" name="fkOrcamento" value="${orcamento.id}">
								<div id="divSalvaPagamentos">
									<!-- COnflito -->
									<input id="chkToggle" name="trava" type="checkbox" data-style="slow"> 
									<script src="jquery/js/jquery-1.9.1.min.js"></script>
									
									<script src="bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js"></script>
									<script src="js/trava.js"></script>
								</div>
							 				 
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