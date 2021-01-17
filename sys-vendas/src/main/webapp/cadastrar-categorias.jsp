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

<title>Cadastrar Categoria</title>
<link rel="stylesheet" href="css/style.css">

<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"/>
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
          <div class="row">     
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h2 class="card-title">CADASTRO DE CATEGORIA</h2>
                  <h4 class="card-description">DADOS DA CATEGORIA</h4>
                  <form action="adicionar-categoria.jsp" method="post">
                  <div class="esquerda">        
						<div class="caixa">
							<label for="nome">Nome:</label> 
							<input id="fieldComum" required="required" name="nome" class="form-control"/>	
						</div>	
					</div>
					<div id="btnForm">
						<input type="submit" class="btn btn-primary" name="Enviar" value="Registrar"/> 	
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