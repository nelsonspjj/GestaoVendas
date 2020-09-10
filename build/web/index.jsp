<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Index Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="thestyles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div id="container">
        <div align="center" id="loginBox">
            <form action='Login' method="post" id="userform">
                <fieldset style= "margin:auto; text-align:center">
                <legend class="legend-bold" >Login</legend>
                    <div>					
                        <label>Email:</label>
                        <input class="theinput" type="text" placeholder= "Digite o email" name="email" required/>
                    </div>
                    <div>
                        <label>Senha:</label>
                        <input class="theinput" type="password" placeholder = "Digite a senha" name="senha" required/>
                    </div>				
                    <br>
                    <input class="submit" type="submit" value="Login"/> 
                </fieldset>
            </form>
            <br>
            <div id="footer2">
                <p style="color:black"> Novo aqui? <a href="#cadastroModal" id="linkCadastrar">Cadastre-se</a></p>			
                <a href="Login?action=listarUsuarios">Administrador</a>
            </div>
        </div>
        <div class="modal fade" id="cadastroModal" role="dialog">
            <div style="text-align: center" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header" style="padding:25px 40px;">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4> Cadastro</h4>
                    </div>
                    <div class="modal-body" style="padding:30px 40px;">
                        <form action='Registro' method="post" id="cadform">
                            <fieldset style= "margin:auto; text-align:center">
                                    <div>
                                        <label for="usnm">Login: </label> 
                                        <input class="theinput" type="text" name="login" id="login" placeholder="Digite o login" required/>
                                    </div>		
                                    <div>
                                        <label for="eml">Email:</label> 
                                        <input class="theinput" type="text" name="email" id="email" placeholder="Digite o email" required/>
                                    </div>			
                                    <div>
                                        <label for="psword">Senha:</label> 
                                        <input class="theinput" type="password" id="senha" name="senha" placeholder="Digite a senha" required/>
                                    </div>			
                                    <div>
                                        <label for="cfmpsword">Confirme a senha:</label> 
                                        <input class="theinput" type="password" id="cfmsenha" name="cfmsenha" placeholder="Confirme a senha" required/>
                                    </div> 
                                    <br>
                                    <input class="submit" type="submit" value="Cadastrar"/> 
                            </fieldset>				
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>          
                    </div>					
                </div>
            </div>
        </div>

        <script>
            $(document).ready(function(){
                    $("#cadform").validate({
                        rules: {				
                            cfmpsword : 
                            {
                                equalTo: "#senha"
                            }			
                        }				
                    });
                    $("#linkCadastrar").click(function(){
                        $("#cadastroModal").modal();
                    });
            });		
        </script>
    </div>
    <div id="footer"></div>
</body>
</html>