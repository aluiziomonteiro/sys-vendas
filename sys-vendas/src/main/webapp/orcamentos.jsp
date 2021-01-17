<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="magestic/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="magestic/vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
<link rel="stylesheet" href="magestic/css/style.css">
<link rel="stylesheet" href="css/switchbutton.css">
<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"/>
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/script.js"></script>
<link href="bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">	
<script src="bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js"></script>
<script type="text/javascript" src="js/campos.js"> </script>

<title>Orçamento</title>
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
                  <h4 class="card-description">CLIENTE</h4>
                  

		
		<c:choose>
			<c:when test="${empty sessaoCliente.nome}">
				<div id="btnFormOrca">
					
					<label id="labelAlerta">Adicione um Cliente aqui </label>
					<a href="buscar-cliente.jsp?filtro=" title="Adiciona um Cliente"><i class="fa fa-plus-circle" style="font-size:24px"></i></a>
				</div>
				
			</c:when>
			<c:when test="${not empty sessaoCliente.nome}">
				<div class="esquerda">
					<label>Nome:</label>
		 				 
		 	<input id ="fieldsMedio" type="text" name="nomeCliente"  required  value="${sessaoCliente.nome} ${sessaoCliente.sobreNome}" class="form-control"/>
				</div>
				<div class="direita">
					<label>Celular:</label>
					<input id ="fieldsMedio" type="text" name="celularCliente" required="required" value="${sessaoCliente.celular}" class="form-control"/>
				</div>
				<div id="btnFormOrca">
					<a href="buscar-cliente.jsp?filtro=" title="Escolha outro Cliente"><i class="fa fa-refresh" style="font-size:24px;"></i></a>
					<a href="eliminar-cliente.jsp" title="Apagar este Cliente"><i class="fa fa-trash-o" style="font-size:24px; color: red;"></i></a>
				</div>
			</c:when>
		</c:choose>		
		
					</div>
                  </div>
                  
                  
                </div>
              </div>
	
              
              <form action="salvaOrcamento" method="post">
              
              <div class="row">     
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  
                  <h4 class="card-description">PRODUTOS</h4>
                  
		
	
		<c:choose>
			
			<c:when test="${empty carroCompras}">
				<div id="btnFormOrca">
					<label id="labelAlerta">Adicione produtos aqui </label>
					<a href="buscar-produto.jsp?filtro=" title="Adicionar Produto"><i class="fa fa-plus-circle" style="font-size:24px;"></i></a>
				</div>
			</c:when>
	
			<c:when test="${not empty carroCompras}">
		
				<table class="table table-striped">
				<thead>
				<tr>
					<th scope="col">Número</th>
					<th scope="col">Nome</th> 
					<th scope="col">Quantidade</th>
					<th scope="col">Valor unitário</th>
					<th scope="col">Sub total</th>
					
					
					
					
					
					
					
					<th scope="col">Remover</th>
				</tr>
				</thead>
				
				<c:forEach var="produtoCarrinho" items="${carroCompras}" varStatus="counter">
				
				<tbody>
				<tr>
					<td scope="row">${counter.index + 1}</td>
					<td>${produtoCarrinho.produtoNome}</td>
					<td>${produtoCarrinho.qtd}</td>
					<td>R$ ${produtoCarrinho.valorUnid}</td>
					<td>R$ ${produtoCarrinho.subTotal}</td>
					
					
					
					<td>
					<input type="hidden" id="custo" value="${produtoCarrinho.custo}" >
					</td>
					<td> 
						<a href="remover-carrinho.jsp?id=${counter.index}" title="Remover este produto do carrinho"><i class="fa fa-trash-o" style="font-size:24px; color: red;"></i></a>	
					</td>
				</tr>
				</tbody>
				</c:forEach>
				</table>
		
					<a href="buscar-produto.jsp?filtro=" title="Adicione um produto aqui "><i class="fa fa-plus-circle" style="font-size:24px;"></i></a>
				
			</c:when>
		</c:choose>
		
		

</div>
        </div>
        </div>
        </div>


<div class="row">     
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">











                  
		<c:choose>
			<c:when test="${not empty carroCompras}">
<br />
			<div class="row">     
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  
                  <h4 class="card-description">FORMA DE PAGAMENTO</h4>
                  
		
					
		
		<div class="esqValorOrc">
			<label for="valor">Subtotal: </label>
			<input id="fieldsValorSmall" name="subTotalOrcamento" readonly="readonly" type="text" value="${subTotalOrcamento}" class="form-control"> <br />
		</div>
		<div class="esqValorOrc">
			
			<label  for="descontos"> Desconto em %: </label> <br>
			
		<label unit="%">
			<input type="number" name="descontos" id="percentual" 
				
			step='0.01' value='0.00'
			min="0.00" max="70.00" placeholder='0.00' size="30"
			class="form-control" required="required" onmouseup="calcularDescontos()" onkeyup="calcularDescontos()" /><br />			
		</label>
		
		</div>
		
		<div class="esqValorOrc">
			<label for="valorDesconto">Desconto em R$: </label>
			<input id="fieldsValorSmall" placeholder="0.00" onkeyup="calcularDescontosRs()" name="valorDesconto" type="text" class="form-control"> <br />
		</div>
		<div class="esqValorOrc">		
			<label for="valor">Total: </label>
			<input id="fieldsValorSmall" readonly="readonly" name="totalOrcamento" type="text" value="${totalOrcamento}" class="form-control"> <br />
		</div>
		
		<div>
		<div class="esqSelectOrc">
		<label for="parcelas">Forma de Pagamento: </label>
		<select  name="parcelas"  id="selectDeProdutos" class="form-control" >
			<option value="0">SELECIONE</option>
			<option value="1">À vista</option>
			<option value="2">2x</option>
			<option value="3">3x</option>
			<option value="4">4x</option>
			<option value="5">5x</option>
			<option value="6">6x</option>
			<option value="7">7x</option>
			<option value="8">8x</option>
			<option value="9">9x</option>
			<option value="10">10x</option>
			<option value="11">11x</option>
			<option value="12">12x</option>

		</select>
		</div>
		</div>
		
		
		
			<table id="tabParcelas" class="table table-hover">
				<thead id="theadParcelas">
				
				</thead>
				
				<tbody id="tbodyParcelas">
				
				</tbody>
			</table>
			
		<div id="divEfetivarVenda">
	
	
	
		</div>
		
		</div>
        </div>
        </div>
        </div>
	
	
</c:when>
</c:choose>

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

