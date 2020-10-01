<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=cadastrando_produto" var="acaoNovoProduto"/>

<jsp:include page="trechos/header.jsp" />

<body class="bg-color1">
	
   	<jsp:include page="trechos/menu.jsp" />
    
    <main>
        <div class="container m-auto row venda-conteudo mb-4">
            <div class="col-12 col-md-8 d-flex flex-column">
                <div class="grupo-titulo">
                    <h2 class="text-white animated fadeInLeft">Novo Produto</h2>
                    <p class="text-muted text-justify animated fadeInleft delay-03s">
                        Cadastre novos produtos no estoque da loja.
                    </p>
                </div>

                <form action="${ acaoNovoProduto }" method="POST">
                    <ul class="text-white info-resultado">
                        <li class="animated fadeInLeft delay-01s mb-3">
                            <label for="nome" class="mr-2">Nome:</label>
                            <input type="text" class="input-produto w-100" id="nome" name="nome" focus required>
                        </li>

                        <li class="animated fadeInLeft delay-01s mb-3 d-flex justify-content-between">
                           
                            <div class="d-flex justify-content-between">
                                <label for="nome" class="mr-2">Preço(R$):</label>
                                <input type="text" class="input-produto w-100 text-right" 
                                    id="preco" name="preco" onKeyPress="return(moeda(this, '' , '.' ,event))" required>
                            </div>
                        </li>

                        

                        <li class="animated fadeInLeft delay-01s mb-3 d-flex justify-content-between">
                            <label for="nome" class="mr-2">Observação:</label>
                            <input type="text" class="w-100 input-produto" name="observacao" required>
                        </li>

                    </ul>


                    <div class="row px-3 justify-content-between">
                        <button class="mt-4 col-12 col-md-5 
                                        btn btn-large btn-danger 
                                        animated fadeInLeft"> Limpar Dados
                        </button>
                        <input type="submit" value="Inserir no estoque"
                            class="mt-4 col-12 col-md-5 btn btn-large btn-color2 animated fadeInLeft">
                    </div>
                </form>

            </div>
            <div class="col-12 col-md-4 d-flex flex-column tela-direita justify-content-between">
                <div class="d-none d-md-block">
                    <img src="img/fundo04.svg" alt="" class="animated fadeIn delay-08s">
                </div>
            </div>
        </div>
        
		<jsp:include page="trechos/footer.jsp" />
    </main>

 	<jsp:include page="trechos/scripts-base.jsp" />
    <script src="js/formataMoeda.js"></script>
    <script src="js/calculaTotal.js"></script>
    
</body>
</html>