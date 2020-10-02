
package br.com.login.Controller;

import br.com.login.command.navegacao.AdicionaProduto;
import br.com.login.command.navegacao.AlteraProduto;
import br.com.login.command.navegacao.PageCadastrarProdutoEstoque;
import br.com.login.command.navegacao.PageEditaProduto;
import br.com.login.command.navegacao.PageEstoque;
import br.com.login.command.navegacao.PageVenda;
import br.com.login.command.navegacao.RemoveProduto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nelsonju
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    
   private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("login") || paramAcao.equals("fazendo_login"));
		
//		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=login");
//			return;
//		}

		String nome = null;

		if (paramAcao.equals("cadastrando_produto")) {
			AdicionaProduto acao = new AdicionaProduto();
			acao.executa(request, response);

		} else if (paramAcao.equals("alterando_produto")) {
			AlteraProduto acao = new AlteraProduto();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("remover_quantidade")) {
			//ActionRemoverQuantidade acao = new ActionRemoverQuantidade();
			//nome = acao.executa(request, response);

		} else if (paramAcao.equals("consultando_produto")) {
			//ActionConsultaProduto acao = new ActionConsultaProduto();
			//nome = acao.executa(request, response);

		} else if (paramAcao.equals("removendo_produto")) {
			RemoveProduto acao = new RemoveProduto();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("fazendo_login")) {
			//ActionLogin acao = new ActionLogin();
			//nome = acao.executa(request, response);
			
		}	else if (paramAcao.equals("fazendo_logout")) {
			//ActionLogout acao = new ActionLogout();
			//nome = acao.executa(request, response);
		}

		else if (paramAcao.equals("cadastro_estoque")) {
			PageCadastrarProdutoEstoque acao = new PageCadastrarProdutoEstoque();
			acao.executa(request, response);

		} else if (paramAcao.equals("carrinho")) {
			//PageCarrinho acao = new PageCarrinho();
			//nome = acao.executa(request, response);

		} else if (paramAcao.equals("editar_produto")) {
			PageEditaProduto acao = new PageEditaProduto();
			acao.executa(request, response);

		} else if (paramAcao.equals("estoque")) {
			PageEstoque acao = new PageEstoque();                       
			acao.executa(request, response);

		} else if (paramAcao.equals("historico")) {
			//PageHistorico acao = new PageHistorico();
			//nome = acao.executa(request, response);

		} else if (paramAcao.equals("login")) {
			//PageLogin acao = new PageLogin();
			//nome = acao.executa(request, response);

		} else if (paramAcao.equals("menu")) {
			//PageMenu acao = new PageMenu();
			//nome = acao.executa(request, response);

		} else if (paramAcao.equals("venda")) {
			PageVenda acao = new PageVenda();
			acao.executa(request, response);
		}

//		String[] tipoEndereco = nome.split(":");
//		if (tipoEndereco[0].equals("forward")) {
//			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/" + tipoEndereco[1]);
//			//rd.forward(request, response);
//		} else {
//			response.sendRedirect(tipoEndereco[1]);
//		}
	}

}
