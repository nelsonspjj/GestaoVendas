
package br.com.login.command.navegacao;

import br.com.login.dao.ProdutoDAO;
import br.com.login.model.Produto;
import br.com.login.template.LoginRedirect;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nelsonju
 */
public class PageEstoque {
     private static final String WELCMPG = "/welcome.jsp";
     private final LoginRedirect loginRedirect = new LoginRedirect();
    
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 ProdutoDAO produtoDAO =  new ProdutoDAO();
		List<Produto> lista = produtoDAO.findAll();
		
	    request.setAttribute("produtos", lista);
	      
	    loginRedirect.executar(request, response, WELCMPG);
	}
}
