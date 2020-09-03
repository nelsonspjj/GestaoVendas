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

@WebServlet(name = "Logout", urlPatterns = { "/Logout" })
public class LogoutController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest pRequest,HttpServletResponse pResponse) throws ServletException, IOException
	{
		PrintWriter lWriter = pResponse.getWriter(); 
		
		HttpSession lSessao = pRequest.getSession(false);
		lSessao.invalidate();
		
		lWriter.print("Sessão finalizada.");
		pResponse.setContentType("text/html");
		RequestDispatcher lView = pRequest.getRequestDispatcher("/index.jsp");		
		lView.include(pRequest, pResponse);
		lWriter.close();
	}
}
