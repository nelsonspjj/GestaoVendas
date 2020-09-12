<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Welcome <%=session.getAttribute("username")%></title>
        <link rel="stylesheet" href="thestyles2.css">
    </head>
    <body>
        <!-- Page Header -->
        <!--<div class= "top-header"><span class= "home-logo"><a href="/LoginAppWeb/Login"></a></span></div>-->

        <div class="container">
            <!-- Use session variables to print username and email -->
            <div class="content welcome-text">
                <p> You are registered under this email <%=session.getAttribute("email")%> </p>
                <br>

            </div>

        </div>	
        <!-- Page Footer -->
        <div class="footer">
            <div class= "footer blk">
                <!-- Logout Form -->
                <form action="Logout" method="post">
                    <input class="back-home-btn" type="submit" value="Logout">
                </form>  
                <button class="back-home-btn" onclick="history.back()">Back</button>
            </div>
        </div>
    </body>
</html>