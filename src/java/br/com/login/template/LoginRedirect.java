package br.com.login.template;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginRedirect extends Redirect {

    @Override
    public boolean verificaSessao(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return !session.getAttribute("id").toString().isEmpty();
    }

    @Override
    public void redireciona(HttpServletRequest request, HttpServletResponse response, String destino) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
            dispatcher.forward(request, response);
        } catch (IOException | ServletException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void carregaDados() {
        System.out.println("IMPLEMENTAR...");
    }

}
