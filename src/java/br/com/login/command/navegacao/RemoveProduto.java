package br.com.login.command.navegacao;

import br.com.login.dao.ProdutoDAO;
import br.com.login.model.Produto;
import br.com.login.template.LoginRedirect;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RemoveProduto {
         private static final String WELCMPG = "/welcome.jsp";
         private final LoginRedirect loginRedirect = new LoginRedirect();
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Long id = Long.valueOf(paramId);
                
                ProdutoDAO produtoDAO =  new ProdutoDAO();
                
		produtoDAO.remove(id);
		
		executaRetorno(request, response);
	}
        
         public void executaRetorno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 ProdutoDAO produtoDAO =  new ProdutoDAO();
		List<Produto> lista = produtoDAO.findAll();
		
	    request.setAttribute("produtos", lista);
	      
	    loginRedirect.executar(request, response, WELCMPG);
	}

}
