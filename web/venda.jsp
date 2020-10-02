<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="trechos/header.jsp" />


<body class="bg-color1">

	<jsp:include page="trechos/menu.jsp" />

	<main>
	<div class="container m-auto row venda-conteudo mb-4">
		<div class="col-12 col-md-6 d-flex flex-column">
			<div class="grupo-titulo">
				<h2 class="text-white animated fadeInLeft">Vender Produto</h2>
				<p class="text-muted text-justify animated fadeInLeft">Escolha
					uma das opções abaixo para continuar. Gerencie seus a entrada e
					saída de produtos.</p>
			</div>
			<form
				class="d-flex flex-row justify-content-between align-items-center"
				action="/gerenciador/entrada" method="GET">
				<div class="d-flex animated fadeInLeft">
					<input type="hidden" name="acao" value="consultando_produto">
					<label for="id" class="text-white">ID</label> <input type="number"
						name="id" class="input-venda" placeholder="ID do Produto" min="0"
						autofocus required>
				</div>
				<input type="submit" value="Pesquisar"
					class="btn btn-large btn-color2 animated fadeInLeft">
			</form>
			<p class="text-danger animated fadeInUp delay-04s">${ msgErro }</p>

			<c:if test="${not empty produto}">
				<div class="line my-3">
					<span class="animated fadeInLeft delay-03s"></span>
					<h3 class="animated fadeInDown">Resultados</h3>
					<span class="animated fadeInLeft delay-03s"></span>
				</div>

				<ul class="text-muted info-resultado">
					<li class="animated fadeInLeft delay-01s"><span>Nome do
							Produto:</span>
						<p>${ produto.nome }</p></li>
					<li class="animated fadeInLeft delay-02s"><span>Descrição:</span>
						<p>${ produto.descricao }.</p></li>
					<ul class="animated fadeInLeft delay-05s">
						<li><span>Preço por Unidade:</span>
							<p>R$ ${ produto.preco }</p></li>
						
					</ul>
				</ul>
				<div class="line">
					<span class="animated fadeInLeft delay-03s"></span>
					<h3 class="animated fadeInDown">Realizar Venda</h3>
					<span class="animated fadeInLeft delay-03s"></span>
				</div>
				<div class="row px-3 justify-content-between">
					<!-- 
					<div class="d-flex text-white align-items-center col-6 col-md-4">
						<label class="mr-1 text-color2 animated fadeInLeft"
							for="quantidade">Quantidade:</label> <input type="number"
							class="input-venda input-small text-center animated fadeInUp"
							value="1">
					</div>

					<div class="d-flex text-white align-items-center col-6 col-md-4">
						<label class="mr-1 text-color2 animated fadeInLeft" for="total">Total:</label>
						<input type="number" class="input-venda input-small text-center">
					</div>
					 -->
						<button
							class="mt-4 col-12 col-md-4 btn btn-large btn-color2 animated fadeInLeft">
					<a href="entrada?acao=remover_quantidade&id=${ produto.id }">
							Vender Produto
					</a>
						</button>
				</div>
			</c:if>


		</div>
		<div
			class="col-12 col-md-6 d-flex flex-column tela-direita justify-content-between">
			<div class="d-none d-md-block">
				<img src="img/fundo03.svg" alt=""
					class="img-fundo-vendas animated fadeIn delay-08s">
			</div>
			<div class="py-4">
				<a href="carrinho.html">
					<button
						class="btn btn-large btn-color2 pl-md-4 my-4 w-100 animated fadeInUp delay-1s">
						Ver Carrinho</button>
				</a>
			</div>
		</div>
	</div>
	<jsp:include page="trechos/footer.jsp" /> </main>

	<jsp:include page="trechos/scripts-base.jsp" />

</body>

</html>