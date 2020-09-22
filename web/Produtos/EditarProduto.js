function onVoltarProduto(){
	navegarPrincipal("/LoginAppWeb/Controller?command=ListarProduto");
}

function onSalvarProduto(){
	var valores = $('#editarProdutoFormulario').serialize();
	var command = "/LoginAppWeb/Controller?command=SalvarProduto&" + valores;
	executarCommand(command);
}