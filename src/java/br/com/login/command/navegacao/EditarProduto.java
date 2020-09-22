
package br.com.login.command.navegacao;

import br.com.login.command.Command;
import br.com.login.dao.ProdutoDAO;
import br.com.login.model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditarProduto implements Command {
    
    private  ProdutoDAO produtoDAO;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       try {

        Produto produto = null;
	if(request.getParameter("id") != null) {
        Long id = Long.parseLong(request.getParameter("produtoId"));
        produto = (Produto) produtoDAO.findById(id);    
	
		}
		else
		{
            Produto Produto = new Produto("", 
                    Double.SIZE , "");
		}
		request.setAttribute("produto", produto);

		RequestDispatcher d = request.getRequestDispatcher("/Produtos/editarProduto.jsp");
		d.forward(request,response);

	} catch (IOException | ServletException e) {
		e.printStackTrace();
	}
    }
    
}
