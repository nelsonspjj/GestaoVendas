package br.com.login.command.navegacao;

import br.com.login.dao.ProdutoDAO;
import br.com.login.model.Produto;
import br.com.login.template.LoginRedirect;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PageEditaProduto {
        private static final String EDITARPRODPG = "/editaProduto.jsp";
        private final LoginRedirect loginRedirect = new LoginRedirect();
        
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
                Long id = Long.valueOf(paramId);
		ProdutoDAO produtoDAO =  new ProdutoDAO();

                Produto produto = produtoDAO.consulta(id);
		
		request.setAttribute("produto", produto);
		
		loginRedirect.executar(request, response, EDITARPRODPG);
	}
        
}
