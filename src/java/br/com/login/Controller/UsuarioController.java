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

@WebServlet(name = "Usuario", urlPatterns = { "/Usuario" })
public class UsuarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String EDITPG= "/edit.jsp";
	private static String ADMINPG= "/admin.jsp";
	private static String WELCMPG= "/welcome.jsp";
	//private static String REGISTPG= "/registration.jsp";
	private UsuarioDao dao;	
	
	public UsuarioController()
	{
            super();
            dao = new UsuarioDao();
	}
	
	protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException,IOException
	{
		String lRedirectPage = "/index.jsp";
		String lAcao = pRequest.getParameter("acao");
		
		if(lAcao.equalsIgnoreCase("remove"))
		{
                    int lUsuarioId = Integer.parseInt(pRequest.getParameter("usuarioId"));
                    dao.excluirUsuario(lUsuarioId);
                    lRedirectPage = ADMINPG;
                    pRequest.setAttribute("users", dao.listarUsuarios());
		}
		else if(lAcao.equalsIgnoreCase("listarUsuarios"))
		{
                    lRedirectPage = ADMINPG;
                    pRequest.setAttribute("usuarios", dao.listarUsuarios());
		}
		else if(lAcao.equalsIgnoreCase("editar"))
		{
                    lRedirectPage = EDITPG;
                    int lUsuarioId = Integer.parseInt(pRequest.getParameter("usuarioId"));
                    UsuarioModel lUsuario = dao.buscarUsuarioPorID(lUsuarioId);
                    pRequest.setAttribute("user", lUsuario);
		}
		
		RequestDispatcher lView = pRequest.getRequestDispatcher(lRedirectPage);
		lView.forward(pRequest, pResponse);
	}
	
	protected void doPost(HttpServletRequest pRequest,HttpServletResponse pResponse) throws ServletException, IOException
	{
		PrintWriter pwOut = pResponse.getWriter(); 

		String em = pRequest.getParameter("email");
		String pw = pRequest.getParameter("psword");
		
		
		//Validate UsuarioModel with input
		if(dao.validateLogin(em, pw))
		{
			//create session and store variables
			UsuarioModel user= dao.userSession(em);
			HttpSession session = request.getSession();
	        session.setAttribute("username", user.getUsername());
	        session.setAttribute("email", em);
	        //load welcome page with session data
			RequestDispatcher view = request.getRequestDispatcher(WELCMPG);		
			view.forward(request, response);
			
		}
		//if input is not stored in database print error message and reload page
		else
		{
			pwOut.print("<p style=\"color:red\">Incorrect Username or Password!</p>");
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");		
			view.include(request, response);
		
		}
	
		pwOut.close();
		
	}
}
