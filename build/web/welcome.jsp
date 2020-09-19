<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de Produtos</title>
        <link rel="stylesheet" href="thestyles2.css">

        <jsp:useBean id="welcomeController" scope="application" class="br.com.login.Controller.WelcomeController"/>
        
    </head>
    <body>
        <div class= "top-header">
            <h1>Bem-vindo, <%= session.getAttribute("nome")%></h1>
            <span class="home-logo"><a href="/LoginAppWeb/welcome.jsp"></a></span>
        </div>

        <div class="container">
            <div class="content welcome-text" align="center">
                <table border="1" cellpadding="5">
                    <caption><h2>Produtos</h2></caption>
                    <tr>
                        <th>Nome</th>
                        <th>Preço</th>
                        <th>Observação</th>
                    </tr>
                    <c:forEach var="produto" items="${welcomeController.getProdutos()}">
                        <tr>
                            <td>${produto.nome}</td>
                            <td>${produto.preco}</td>
                            <td>${produto.observacao}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>	

        <div class="footer">
            <div class= "footer blk">
                <form action="Logout" method="post">
                    <input class="back-home-btn" type="submit" value="Logout">
                </form>  
                <button class="back-home-btn" onclick="history.back()">Back</button>
            </div>
        </div>
    </body>
</html>