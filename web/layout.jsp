<%-- 
    Document   : layout
    Created on : 01-abr-2015, 9:20:53
    Author     : juan
--%>
<%@page import="com.myapp.struts.Modelo.clases.UserSession"%>
<%@page import="com.myapp.struts.persistencia.entidades.Usuarios"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="/linkunedin3/bootstrap/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="/linkunedin3/bootstrap/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="/linkunedin3/semanticui/label.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="/linkunedin3/bootstrap/js/jquery.min.js"></script>
        <script src="/linkunedin3/bootstrap/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="/linkunedin3/css/style.css">
        
        <script type="text/javascript">
            $(function(){
                $(".form-group").css("margin", "3px");
            });
        </script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">

                    <div class="page-header ">
                        
                        <div class="slogan">
                            <h1> Linkunedin </h1>
                            <p>Professional Social Network</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <!--div class="col-lg-3">
                    <ul>
                        <li><a href="login.do"> Home</a> </li>
                        
                        <li><a href="ListarUsuarios.do">listar usuarios</a> </li>
                        
                    </ul>
                    
                </div-->
                <div class="col-lg-3">
                    
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active"><a href="login.do">Home</a></li>
                        <%
                           if (request.getSession().getAttribute("objsesion") == null){
                               out.println("<li><a href=\"login.jsp\">Login</a></li>");
                         }
                        %>

                        <li><a href="formRegistro.jsp">Alta de usuario</a></li>
                        <%
                           if (request.getSession().getAttribute("objsesion") != null){
                               
                               Usuarios us = ((UserSession)request.getSession().getAttribute("objsesion")).getUser();
                               
                               out.println("<li><a href=\"vermodificarperfil.do?nomusuario="+us.getNombreUsuario()+"\">Modificar perfil</a></li>");
                         }
                        %>
                        
                        <li><a href="ListarUsuarios.do">Listar usuarios</a></li>
                        <%
                           if (request.getSession().getAttribute("objsesion") != null){
                               out.println("<li><a href=\"logout.do\">Logout</a></li>");
                         }
                        %>
                        
                        <li><a href="formBusqueda.jsp">Buscar</a></li>
                    </ul>
                    <ul class="nav nav-pills nav-stacked">
                        
                        <li><a href="insertarusuarios.do">Insertar usuarios</a></li>
                        
                    </ul>
                      <ul class="nav nav-pills nav-stacked">
                        
                        <li><a href="/linkunedin3/files/documentacion/Linkunedin.pdf">Memoria de la práctica</a></li>
                        
                    </ul>
                    <ul class="nav nav-pills nav-stacked">
                        
                        <li><a href="/linkunedin3/files/documentacion/Manual de usuario.pdf">Manual de usuario</a></li>
                        
                    </ul>
                   
                   
                </div>
                <div class="col-lg-9">
                    <tiles:insert attribute="body" />
                </div>
            </div>

        </div>
    </body>
</html>
