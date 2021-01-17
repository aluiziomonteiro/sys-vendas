<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/script.js"></script>
<title>Info Usuários</title>
</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>
<div id="container">
	
	<div class="container-scroller">
        <div class="content-wrapper">
        <form action="" method="post">
          <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
					<h2 class="card-title"></h2>
                  	<h4 class="card-description">DADOS DO USUÁRIO</h4>
			
		  	<div>			 		
				</div>
				
						<div class="esquerda">
							<label>Nome:</label> ${usuario.nome}<br />
							<label>Login:</label> ${usuario.login}<br />
							<label>Senha:</label> ${usuario.senha}
						</div>	
		                  	</div>
		                 
		                </div>
		              </div>
		            </div>
			 <br />
            </form>
        </div>
      </div>
	</div>
	
	<footer class="site-footer push">
    	<c:import url="rodape.jsp"/>
    </footer>
</body>

</html>