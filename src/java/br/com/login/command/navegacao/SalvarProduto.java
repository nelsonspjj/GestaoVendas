package command.navegacao;

import br.com.login.command.Command;
import br.com.login.dao.ProdutoDAO;
import br.com.login.model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SalvarProduto implements Command {

	private  ProdutoDAO produtoDAO;
        
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean isNovo = true;
                        double preco = Double.parseDouble(request.getParameter("preco")); 
			Produto produto = new Produto(request.getParameter("nome"), preco , request.getParameter("observacao"));

			if(!request.getParameter("isnew").equals("true"))
			{
                                Long id = Long.parseLong(request.getParameter("produtoId"));
				produto.setId(id);
				isNovo = false;
			}

			
				if(isNovo)
				{
					this.produtoDAO.salvar(produto);
				}
				else
				{
					this.produtoDAO.update(produto);
				}
			

			RequestDispatcher d = request.getRequestDispatcher("/welcome.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException e) {
		e.printStackTrace();
	}

	}

}