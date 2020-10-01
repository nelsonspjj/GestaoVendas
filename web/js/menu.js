let campos = document.querySelectorAll(".nav-item");
console.log(campos.textContent);
let url = window.location.pathname;

if(url == "/gerenciador/menu"){
	campos[0].classList.add("active");
}
if(url == "/gerenciador/venda"){
	campos[1].classList.add("active");
}
if(url == "/gerenciador/carrinho"){
	campos[2].classList.add("active");
}
if(url == "/gerenciador/estoque" || url == "/gerenciador/cadastrar-no-estoque"){ 
	campos[3].classList.add("active");
}
if(url == "/gerenciador/historico"){ 
	campos[4].classList.add("active");
}


