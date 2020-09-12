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

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String EDITPG = "/edit.jsp";
    private static String ADMINPG = "/admin.jsp";
    private static String WELCMPG = "/welcome.jsp";
    private UsuarioDao dao = new UsuarioDao();

    protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        String lRedirectPage = "/index.jsp";
        String lAcao = pRequest.getParameter("acao");

        if (lAcao.equalsIgnoreCase("remove")) {
            int lUsuarioId = Integer.parseInt(pRequest.getParameter("usuarioId"));
            dao.excluirUsuario(lUsuarioId);
            lRedirectPage = ADMINPG;
            pRequest.setAttribute("users", dao.listarUsuarios());
        } else if (lAcao.equalsIgnoreCase("listarUsuarios")) {
            lRedirectPage = ADMINPG;
            pRequest.setAttribute("usuarios", dao.listarUsuarios());
        } else if (lAcao.equalsIgnoreCase("editar")) {
            lRedirectPage = EDITPG;
            int lUsuarioId = Integer.parseInt(pRequest.getParameter("usuarioId"));
            UsuarioModel lUsuario = dao.buscarUsuarioPorID(lUsuarioId);
            pRequest.setAttribute("user", lUsuario);
        }

        RequestDispatcher lView = pRequest.getRequestDispatcher(lRedirectPage);
        lView.forward(pRequest, pResponse);
    }

    protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        PrintWriter lWriter = pResponse.getWriter();

        String lEmail = pRequest.getParameter("email");
        String lSenha = pRequest.getParameter("senha");

        if (dao.validarLogin(lEmail, lSenha)) {
            UsuarioModel lUsuario = dao.usuarioSessao(lEmail);
            HttpSession session = pRequest.getSession();

            session.setAttribute("login", lUsuario.getLogin());
            session.setAttribute("email", lEmail);
            session.setAttribute("username", lUsuario.getLogin());

            RequestDispatcher view = pRequest.getRequestDispatcher(WELCMPG);
            view.forward(pRequest, pResponse);
        } else {
            lWriter.print("<p style=\"color:red\">Usuário ou senha incorretos!</p>");
            RequestDispatcher view = pRequest.getRequestDispatcher("/index.jsp");
            view.include(pRequest, pResponse);
        }

        lWriter.close();

    }
}
