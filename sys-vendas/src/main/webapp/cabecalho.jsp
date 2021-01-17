
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Pushy - Off-Canvas Navigation Menu</title>
        <meta name="description" content="Pushy is an off-canvas navigation menu for your website.">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/demo.css">
        <!-- Pushy CSS -->
        <link rel="stylesheet" href="css/pushy.css">
        
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    	<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
    	
    	<script src="js/script.js"></script>
    	
    </head>
    <body>

        <header class="site-header push">
        
	        <div style="float: left; width: 30%;">
	        	<button title="Menu" class="menu-btn"> &#9776;</button>
	        </div>
	        
	        <div style="float: left; width: 40%; padding-top: 10px; text-align: center;">
	        	 
	        	 <c:choose>
					<c:when test="${total == 0}">
						<a href="orcamento.jsp" title="Orçamento"><i class="mdi mdi-cart-off" id="iconBlack" ></i></a>
					</c:when>
					<c:when test="${empty total}">
						<a href="orcamento.jsp" title="Orçamento"><i class="mdi mdi-cart-off" id="iconBlack" ></i></a>
					</c:when>
					<c:when test="${total > 0}">
						<a href="orcamento.jsp" title="Orçamento"><i class="mdi mdi-cart" id="iconBlack"></i></a>
						R$ ${total}
					</c:when>
				 </c:choose>
	        	 
	        </div>
	        
	        <div class="divLogout">
	        	<form action="logout" method="post">				
					Olá, ${usuarioLogado.nome} &nbsp;
					<a href="logout" title="Sair"> <i id="iconBlack" class="mdi mdi-power"></i></a>
						
				</form>
	        </div>
        </header>

        <!-- Pushy Menu -->
        <nav class="pushy pushy-left" data-focus="#first-link">
            <div class="pushy-content">
                <ul>
                    <li class="pushy-submenu">
                        <button id="first-link"><i id="iconMenu" class="mdi mdi-playlist-plus"> </i>Cadastrar</button>
                        <ul>
                            <li class="pushy-link"><a href="cadastrar-categorias.jsp"><i id="iconMenu" class="mdi mdi mdi-seal"> </i>Categoria</a></li>
                            <li class="pushy-link"><a href="cadastrar-clientes.jsp"><i id="iconMenu" class="mdi mdi-worker"> </i>Cliente</a></li>
                            <li class="pushy-link"><a href="cadastrar-fornecedores.jsp"><i id="iconMenu" class="mdi mdi-truck-delivery"> </i>Fornecedor</a></li>
                            <li class="pushy-link"><a href="cadastrar-produtos.jsp"><i id="iconMenu" class="mdi mdi-shopping"> </i>Produto</a></li> 
                            <li class="pushy-link"><a href="cadastrar-usuarios.jsp"><i id="iconMenu" class="mdi mdi-account-key"> </i> Usuário</a></li>
                             
                        </ul>
                    </li>
                    <li class="pushy-submenu">
                        <button><i id="iconMenu" class="mdi mdi-yeast"> </i> Pesquisar</button>
                        <ul>
                            <li class="pushy-link"><a href="buscar-categoria.jsp?filtro="><i id="iconMenu" class="mdi mdi mdi-seal"> </i> Categoria</a></li>
                            <li class="pushy-link"><a href="buscar-cliente.jsp?filtro="><i id="iconMenu" class="mdi mdi-worker"> </i> Cliente</a></li>
                            <li class="pushy-link"><a href="buscar-fornecedor.jsp?filtro="><i id="iconMenu" class="mdi mdi-truck-delivery"> </i> Fornecedor</a></li>
                            <li class="pushy-link"><a href="buscar-produto.jsp?filtro="><i id="iconMenu" class="mdi mdi-shopping"> </i> Produto</a></li>
                            <li class="pushy-link"><a href="buscar-usuario.jsp?filtro="><i id="iconMenu" class="mdi mdi-account-key"> </i> Usuário</a></li>
                        </ul>
                    </li>
                	
                	<li class="pushy-submenu">
                        <button><i id="iconMenu" class="mdi mdi-cart"> </i> Orçamento</button>
                        <ul>
                            <li class="pushy-link"><a href="orcamentos.jsp"><i id="iconMenu" class="mdi mdi-cart-plus"> </i> Novo Orçamento</a></li>
                            <li class="pushy-link"><a href="buscar-orcamento.jsp"><i id="iconMenu" class="mdi mdi-file-find"> </i> Buscar Orçamento</a></li>   
                        </ul>
                    </li>
                    
                    <li class="pushy-link"><a href="https://www.marykay.com.br"><i id="iconMenu" class="mdi mdi-internet-explorer"> </i> MK&#174; Brasil</a></li>
                    <li class="pushy-link">
                    
                    <form action="login" method="post" id="login_form"> 
							<input type="hidden"  name="login" value="${usuarioLogado.login}" >
							<input type="hidden"  name="senha" value="${usuarioLogado.senha}" >
							<a href="#" id="btnIndex"><i id="iconMenu" class="mdi mdi-chart-line"> </i> Dashboard</a>
					</form>
                    
                    
                    </li>
                </ul>
            </div>
        </nav>





        <!-- Site Overlay -->
        <div class="site-overlay"> </div>
      
		<!-- Site Overlay -->
        <footer class="site-footer push"></footer>

        <!-- Pushy JS -->
        <script src="js/pushy.min.js"></script>

    </body>
</html>
