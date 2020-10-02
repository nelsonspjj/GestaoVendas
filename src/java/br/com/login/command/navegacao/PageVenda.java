package br.com.login.command.navegacao;

import br.com.login.template.LoginRedirect;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageVenda {
         private static final String VENDAPG = "/venda.jsp";
         private final LoginRedirect loginRedirect = new LoginRedirect();
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            
		loginRedirect.executar(request, response, VENDAPG);
	}

}
