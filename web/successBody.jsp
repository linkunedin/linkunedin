<%-- 
    Document   : success
    Created on : 12-mar-2015, 21:39:01
    Author     : david
--%>
<%@page import="com.myapp.struts.Modelo.clases.UserSession"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!--%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        <h1>Congratulations!</h1>

        <p>You have successfully logged in.</p>

        <p>Your name is: <bean:write name="LoginForm" property="user" />.</p>
                    <tr>
                        <td colspan="2">
                            <!--bean:write name="objsession" property="hashSessionDigest" filter=""/-->
                            <p> ${objsesion.user}</p>
                            <p>${objsesion.user.nombre}</p>
                            <% 
                                UserSession us = (UserSession)session.getAttribute("objsesion");
                                out.println(us.getUser().toString());
                            %> 
                            &nbsp;</td>
                    </tr>
        
    </body>
</html>
