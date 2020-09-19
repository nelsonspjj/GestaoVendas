package br.com.login.template;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Redirect {

    public abstract boolean verificaSessao(HttpServletRequest request);

    public abstract void redireciona(HttpServletRequest request, HttpServletResponse response, String destino);

    public abstract void carregaDados();

    public final void executar(HttpServletRequest request, HttpServletResponse response, String destino) {
        if (verificaSessao(request)) {
            redireciona(request, response, destino);
            carregaDados();
        } else {
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.include(request, response);
            } catch (IOException | ServletException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
