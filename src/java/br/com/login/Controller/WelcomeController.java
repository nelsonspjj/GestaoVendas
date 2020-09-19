package br.com.login.Controller;

import br.com.login.dao.ProdutoDAO;
import br.com.login.model.Produto;
import br.com.login.template.LoginRedirect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WelcomeController", urlPatterns = {"/WelcomeController"})
public class WelcomeController extends HttpServlet {

    private final ProdutoDAO produtoDAO;
    private final LoginRedirect loginRedirect;

    public WelcomeController() {
        produtoDAO = new ProdutoDAO();
        loginRedirect = new LoginRedirect();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public List<Produto> getProdutos() {
        Iterator<Object> objects = produtoDAO.findAll().iterator();
        List<Produto> produtos = new ArrayList<>();
        
        while(objects.hasNext()) {
            produtos.add((Produto) objects.next());
        }
        
        return produtos;
    }
}
