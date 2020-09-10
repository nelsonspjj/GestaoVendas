<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Usuário</title>
</head>
    <body>
        <form action="Registro" id="editarform" method="post">
            <fieldset style= "margin:auto; text-align:center">
                <div>
                    <label for="uid" >ID</label>
                    <input class="theinput" type="text" readonly="readonly" name="usuarioid" id="usuarioid" value="<c:out value ="${usuario.usuarioId}"/>" />
                </div>
                <div>
                    <label for="usnm">Login</label>
                    <input class="theinput" type="text" name="login" id="login" value="<c:out value ="${usuario.login}"/>" required/>	
                </div>
                <div>	
                    <label for="psword">Senha</label> 
                    <input class="theinput" type="text" name="senha" id="senha" value="<c:out value ="${usuario.senha}"/>" required/>	
                </div>		
                <br>
                <input class="back-home-btn" type="submit" value="Editar"/> 
            </fieldset>		
        </form>

    </body>
</html>