package br.com.login.command.navegacao;

import br.com.login.dao.ProdutoDAO;
import br.com.login.model.Produto;
import br.com.login.template.LoginRedirect;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdicionaProduto {
        private static final String WELCMPG = "/welcome.jsp";
         private final LoginRedirect loginRedirect = new LoginRedirect();
    
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeProduto = request.getParameter("nome");
		//String unidadeProduto = request.getParameter("unidade");
		String precoProduto = request.getParameter("preco");
		Double precoConvertido = Double.valueOf(precoProduto);

		//String quantidadeProduto = request.getParameter("quantidade");
		//Integer quantidadeConvertido = Integer.valueOf(quantidadeProduto);
		
		String descricaoProduto = request.getParameter("observacao");

		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setPreco(precoConvertido);
		produto.setObservacao(descricaoProduto);

		ProdutoDAO produtoDAO =  new ProdutoDAO();
		produtoDAO.adiciona(produto);

		executaRetorno(request, response);
	}
        
        public void executaRetorno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 ProdutoDAO produtoDAO =  new ProdutoDAO();
		List<Produto> lista = produtoDAO.findAll();
		
	    request.setAttribute("produtos", lista);
	      
	    loginRedirect.executar(request, response, WELCMPG);
	}
}