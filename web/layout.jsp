<%-- 
    Document   : layout
    Created on : 01-abr-2015, 9:20:53
    Author     : juan
--%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

        <!— Optional theme —>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">

        <!— Latest compiled and minified JavaScript —>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">

                    <div class="page-header ">
                        <h1> Practica TW <small>1.0</small></h1>
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
                <div class="col-md-3">
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active"><a href="login.do">Home</a></li>
                        <li><a href="login.do">Login</a></li>
                        <li><a href="modificarPerfil.jsp">Modificar perfil</a></li>
                        <li><a href="logout.do">Logout</a></li>
                        <li><a href="ListarUsuarios.do">Listar usuarios</a></li>
                        <li><a href="formRegistro.jsp">Alta de usuario</a></li>
                    </ul>
                </div>
                <div class="col-lg-9">
                    <tiles:insert attribute="body" />
                </div>
            </div>

        </div>
    </body>
</html>
