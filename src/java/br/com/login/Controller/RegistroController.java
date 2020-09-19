package br.com.login.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.login.dao.UsuarioDao;
import br.com.login.model.UsuarioModel;
import br.com.login.template.LoginRedirect;

@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class RegistroController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String ADMINPG = "/admin.jsp";

    private final UsuarioDao usuarioDao;
    private final LoginRedirect loginRedirect;

    public RegistroController() {
        super();
        usuarioDao = new UsuarioDao();
        loginRedirect = new LoginRedirect();
    }

    @Override
    protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        UsuarioModel lUsuario = new UsuarioModel();
        PrintWriter lWriter = pResponse.getWriter();

        String nome = pRequest.getParameter("nome");
        String lLogin = pRequest.getParameter("login");
        String lSenha = pRequest.getParameter("senha");
        String lEmail = pRequest.getParameter("email");
        String lUsuarioId = pRequest.getParameter("usuarioId");
        lUsuario.setNome(nome);
        lUsuario.setLogin(lLogin);
        lUsuario.setSenha(lSenha);
        lUsuario.setEmail(lEmail);

        if (lUsuarioId == null || lUsuarioId.isEmpty()) {
            usuarioDao.salvar(lUsuario);
            lWriter.print("Cadastro realizado. Realize o login.");
            pResponse.setContentType("text/html");

            loginRedirect.executar(pRequest, pResponse, "/index.jsp");
        } else {
            lUsuario.setUsuarioId(Integer.parseInt(lUsuarioId));
            usuarioDao.update(lUsuario);
            pRequest.setAttribute("usuarios", usuarioDao.findAll());

            loginRedirect.executar(pRequest, pResponse, ADMINPG);
        }

    }

}
