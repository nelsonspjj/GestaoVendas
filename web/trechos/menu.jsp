<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<nav class="navbar navbar-expand-lg navbar-dark bg-color1 w-100 fixed-top">
		<div class="container">

			<a class="navbar-brand" href="menu">Gestão<span class="text-color2">Venda</span></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="entrada?acao=menu">Início</a>
					</li>

					<li class="nav-item">
						<a class="nav-link" href="entrada?acao=venda">Venda</a>
					</li>

					<li class="nav-item">
						<a class="nav-link" href="entrada?acao=carrinho">Carrinho</a>
					</li>

					<li class="nav-item">
						<a class="nav-link" href="entrada?acao=estoque">Estoque</a>
					</li>

					<li class="nav-item">
						<a class="nav-link" href="entrada?acao=historico">Histórico de Vendas</a>
					</li>
				</ul>

				<ul class="navbar-nav">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							${ usuarioLogado.nome }
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Configurações</a>
							<a class="dropdown-item" href="entrada?acao=fazendo_logout">Sair</a>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</nav>
