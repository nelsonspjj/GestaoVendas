<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de Produtos</title>
        

        <jsp:useBean id="welcomeController" scope="application" class="br.com.login.Controller.WelcomeController"/>
        
    </head>
    
   



<jsp:include page="trechos/header.jsp" />

<body class="bg-color1">
	<jsp:include page="trechos/menu.jsp" />
	<main>

        <div class= "top-header">
            <h1>Bem-vindo, <%= session.getAttribute("nome")%></h1>
            <span class="home-logo"><a href="/LoginAppWeb/welcome.jsp"></a></span>
        </div>

        <div class="container m-auto row venda-conteudo mb-4">
		<div class="col-12 col-md-12 d-flex flex-column">
			<div class="grupo-titulo">
				<h2 class="text-white animated fadeInLeft">Estoque</h2>
				<p class="text-muted text-justify animated fadeInleft delay-03s">
					Gerencie o estoque de produtos.</p>
			</div>
                
                <div class="row ml-1 justify-content-between animated fadeInDown">
				<a href="entrada?acao=cadastro_estoque"
					class="btn btn-large btn-color2 animated fadeInUp delay-1s col-12 col-md-4 justify-content-center d-flex align-items-center">
					Cadastrar novo Produto </a>
				<form
					class="form-inline col-12 col-md-4 justify-content-end form-search">
					<input id="filtrar-tabela"
						class="form-control input-venda input-estoque" type="search"
						placeholder="Search" aria-label="Search">
					<div class="btn position-relative">
						<img src="img/icons/search.svg" alt="" class="icon icon-text">
					</div>
				</form>
			</div>
                <table class="table table-dark bg-color1 mt-4">
				<thead>
					<tr class="produto animated fadeInLeft">
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
						<th scope="col">Preço</th>
						<th scope="col">Observação</th>						
						<th scope="col"></th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
                                    <c:forEach items="${welcomeController.getProdutos()}" var="produto">
						<tr class="animated fadeInLeft">
							<td  class="info-id" scope="row" >${ produto.id }</td>
							<td class="info-nome">${ produto.nome }</td>
							<td class="info-preco">R$ ${ produto.preco }</td>
							<td class="info-descricao">${ produto.observacao }</td>
                                                        
                                                        <td class="editar"><a
								href="entrada?acao=editar_produto&id=${ produto.id }">Editar</a>
							</td>
							<td class="remover"><a
								href="entrada?acao=removendo_produto&id=${ produto.id }">Remover</a>
							</td>
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
                
            </div>
        </div>	

        <div class="footer">
            <div class= "footer blk">
                <form action="Logout" method="post">
                    <input class="back-home-btn" type="submit" value="Logout">
                </form>  
                <button class="back-home-btn" onclick="history.back()">Back</button>
            </div>
        </div>
    </body>
    
    <jsp:include page="trechos/footer.jsp" /> </main>

	<script src="js/filtra.js"></script>
	<jsp:include page="trechos/scripts-base.jsp" />
</html>