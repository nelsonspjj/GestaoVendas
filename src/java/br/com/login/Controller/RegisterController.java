package br.com.login.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.login.dao.UsuarioDao;
import br.com.login.model.UsuarioModel;

@WebServlet(name = "Registro", urlPatterns = { "/Registro" })
public class RegisterController extends HttpServlet{	
	private static final long serialVersionUID = 1L;	
	private static String ADMINPG = "/admin.jsp";	
	private UsuarioDao dao;	

	public RegisterController() 
        {
            super();
            dao = new UsuarioDao();	
	}
	
	protected void doPost(HttpServletRequest pRequest,HttpServletResponse pResponse) throws ServletException, IOException
	{
		UsuarioModel lUsuario = new UsuarioModel();
		PrintWriter lWriter = pResponse.getWriter();
		
		String lLogin = pRequest.getParameter("login");		
		String lSenha = pRequest.getParameter("senha");
		String lEmail = pRequest.getParameter("email");
		String lUsuarioId = pRequest.getParameter("usuarioId");		
		lUsuario.setLogin(lLogin);			
		lUsuario.setSenha(lSenha);
		lUsuario.setEmail(lEmail);
		
		if(lUsuarioId == null || lUsuarioId.isEmpty())
		{
                    dao.criarUsuario(lUsuario);				
                    lWriter.print("Cadastro realizado. Realize o login.");
                    pResponse.setContentType("text/html");
                    RequestDispatcher lView = pRequest.getRequestDispatcher("/index.jsp");		
                    lView.include(pRequest, pResponse);
		}
		else
		{
                    lUsuario.setUsuarioId(Integer.parseInt(lUsuarioId));			
                    dao.editarUsuario(lUsuario);
                    pRequest.setAttribute("usuarios", dao.listarUsuarios());
                    RequestDispatcher lView = pRequest.getRequestDispatcher(ADMINPG);		
                    lView.forward(pRequest, pResponse);
		}				
			
	}

}
