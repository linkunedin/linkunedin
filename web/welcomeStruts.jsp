<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <html:base/>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://localhost:8084/PracticaPruebastweb/bootstrap/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="http://localhost:8084/PracticaPruebastweb/bootstrap/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="http://localhost:8084/PracticaPruebastweb/bootstrap/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="http://localhost:8084/PracticaPruebastweb/css/style.css">

    </head>
    <body style="background-color: white">
        <div class="container">
            <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        

            <div class="row">
                <div class="col-lg-3">
                    <div class="row">
                        <div class="col-lg-6">
                            <p class="rojo negrita">Desde netbeans </p>
                        </div>
                        <div class="col-lg-6">
                            <p id="p1">Desde netbeans </p>
                        </div>
                    </div>
                    <h3><bean:message key="welcome.heading"/></h3>
                    <p><bean:message key="welcome.message"/></p>
                    <p class="negrita">Esto lo agregó Juancho pa probar</p>
                    <p class="negrita">Desde netbeans </p>
                    <p class="negrita">Otra prueba de juancho</p>
                </div>
                <div class="col-lg-3">
                    <h2>2da columna</h2>
                </div>
                <div class="col-lg-3">
                    <h2>3ra columna</h2>
                </div>
                <div class="col-lg-3">
                    <h2>3ra columna</h2>
                </div>
            </div>
        </div>
        
    </body>
</html:html>
