package br.com.login.security;

import br.com.login.template.LoginRedirect;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApplicationFilter implements Filter {

    private LoginRedirect loginRedirect;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // String encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute("id") == null) {
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }

}
