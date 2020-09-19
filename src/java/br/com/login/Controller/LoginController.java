package br.com.login.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.login.dao.UsuarioDao;
import br.com.login.model.UsuarioModel;
import br.com.login.template.LoginRedirect;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String EDITPG = "/edit.jsp";
    private static final String ADMINPG = "/admin.jsp";
    private static final String WELCMPG = "/welcome.jsp";

    private final UsuarioDao usuarioDao;
    private final LoginRedirect loginRedirect;

    public LoginController() {
        usuarioDao = new UsuarioDao();
        loginRedirect = new LoginRedirect();
    }

    protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        String redirectPage = "/index.jsp";
        String lAcao = pRequest.getParameter("acao");

        if (lAcao.equalsIgnoreCase("remove")) {
            Long id = Long.parseLong(pRequest.getParameter("usuarioId"));
            usuarioDao.deleteById(id);
            redirectPage = ADMINPG;
            pRequest.setAttribute("users", usuarioDao.findAll());
        } else if (lAcao.equalsIgnoreCase("listarUsuarios")) {
            redirectPage = ADMINPG;
            pRequest.setAttribute("usuarios", usuarioDao.findAll());
        } else if (lAcao.equalsIgnoreCase("editar")) {
            redirectPage = EDITPG;
            Long id = Long.parseLong(pRequest.getParameter("usuarioId"));
            UsuarioModel lUsuario = (UsuarioModel) usuarioDao.findById(id);
            pRequest.setAttribute("user", lUsuario);
        }

        loginRedirect.executar(pRequest, pResponse, redirectPage);
    }

    protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        PrintWriter lWriter = pResponse.getWriter();

        String lEmail = pRequest.getParameter("email");
        String lSenha = pRequest.getParameter("senha");

        if (usuarioDao.validarLogin(lEmail, lSenha)) {
            UsuarioModel lUsuario = usuarioDao.usuarioSessao(lEmail);
            HttpSession session = pRequest.getSession();

            session.setAttribute("id", lUsuario.getUsuarioId());
            session.setAttribute("login", lUsuario.getLogin());
            session.setAttribute("email", lEmail);
            session.setAttribute("nome", lUsuario.getNome());

            loginRedirect.executar(pRequest, pResponse, WELCMPG);
        } else {
            lWriter.print("<p style=\"color:red\">Usuário ou senha incorretos!</p>");
            RequestDispatcher view = pRequest.getRequestDispatcher("/index.jsp");
            view.include(pRequest, pResponse);
        }

        lWriter.close();

    }
}
