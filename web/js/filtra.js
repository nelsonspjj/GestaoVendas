var campoFiltro = document.querySelector("#filtrar-tabela");

campoFiltro.addEventListener("input", function() {
    var produtos = document.querySelectorAll(".produto");

    if (this.value.length > 0) {
        for (var i = 0; i < produtos.length; i++) {
            var produto = produtos[i];
            var tdNome = produto.querySelector(".info-nome");
            var nome = tdNome.textContent;
            var expressao = new RegExp(this.value, "i");

            if (!expressao.test(nome)) {
                produto.classList.add("invisivel");
            } else {
                produto.classList.remove("invisivel");
            }
        }
    } else {
        for (var i = 0; i < produtos.length; i++) {
            var produto = produtos[i];
            produto.classList.remove("invisivel");
        }
    }
});
