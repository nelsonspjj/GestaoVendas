var quantidade = document.querySelector('#quantidade');
var preco = document.querySelector("#preco");
var total = document.querySelector('#total');

quantidade.addEventListener('keyup', calculaTotal);
preco.addEventListener('keyup', calculaTotal);
window.onload = function(){
	calculaTotal();
}

function calculaTotal() {
    total.value = quantidade.value * preco.value;
}