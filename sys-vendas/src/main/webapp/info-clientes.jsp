<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/script.js"></script>
<title>Info Cliente</title>
</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>

	<div id="container">
  	<form action="agregar-cliente.jsp" method="post">	
  	<div>			 	
	
			
		</div>
	<fieldset class="campo">
	
	<legend>${cliente.nome} ${cliente.sobreNome} 
	<button type="submit" name="id" value="${cliente.id}" class="btn btn-success"> <i class="fa fa-cart-plus" aria-hidden="true"></i> Add </button></legend>
		
		
		<div class="esquerda">
			<label>Celular:</label> ${cliente.celular}<br />
			<label>Edereço:</label> ${cliente.endereco} n°: ${cliente.numero}<br />
			<label>Bairro:</label> ${cliente.bairro}<br />
			<label>Cidade:</label> ${cliente.cidade}
			<label>-</label> ${cliente.uf}<br />
			<label>Complemento:</label> ${cliente.complemento}<br />
		</div>
		
	</fieldset>
	<fieldset class="campo">
	<legend>Detalhes:</legend>
	
		<div class="esquerda">
			<br />
			<label>Sexo:</label> ${cliente.sexo}<br />
			<label>Pessoa:</label> ${cliente.pessoa}<br />
			<label>SItuação:</label> ${cliente.situacao}<br />
		
			<label>Nascimento:</label> 
			<fmt:parseDate value="${cliente.nascimento}" pattern="yyyy-MM-dd" var="data" type="both" />
			<fmt:formatDate pattern="dd/MM/yyyy" value="${data}" /> <br />
			
			<label>E-mail:</label> ${cliente.email}<br />
			<label>Fone Residencial:</label> ${cliente.fone}<br />
			<label>CEP:</label> ${cliente.cep}<br />
			<label>Observação:</label> ${cliente.observacao}<br />
		</div>
		
		<div class="direita">
	
		</div>
	</fieldset>
	</form>
	
	<form action="gerenciar-orcamento.jsp" method="post">
	<fieldset class="campo">
	<legend>Movimentações:</legend>
	
	
	
	
	
	
	<div class="table-responsive">
				<table class="table table-striped">
				<caption>Info Clientes</caption>
					   <thead>
					    <tr>
					      <th>Data da Compra</th>
					      <th>Valor da Compra</th>
					      <th>Situação</th>
					      <th>Parcelas Pagas</th>
					      <th>Ações</th>
			
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="orcamento" items="${list}">
				   <tr>
					<td>
						<fmt:parseDate value="${orcamento.dataLancamento}" pattern="yyyy-MM-dd" var="dataLancamento" type="both" />
						<fmt:formatDate pattern="dd/MM/yyyy" value="${dataLancamento}" /> <br />
			            
					</td>
					<td> 
			      		<span class="valores">R$ ${orcamento.totalOrcamento}</span>
			      	</td>
					<td>
			      		<c:choose>
							<c:when test="${orcamento.parcelasAPagar > 0}">
								<input class="camposAPagar" type="text" value=A_PAGAR readonly="readonly">
							</c:when>
							<c:when test="${orcamento.parcelasAPagar == 0}">
								<input class="camposQuitados" type="text" value="QUITADO" readonly="readonly">
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
					      		<button type="submit" name="detalhes" value="${orcamento.id}"  class="btn btn-outline-info" title="Veja maiores informações sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i> Detalhes</button>
							</div>
					  	</td>	
					  </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
			</fieldset>
		</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>