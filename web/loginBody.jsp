<%-- 
    Document   : login
    Created on : 12-mar-2015, 21:12:19
    Author     : david
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row">
    <% if (request.getSession().getAttribute("objsesion") == null) { %>
    <html:form action="/login">
        <div class="panel panel-primary">
            <div class="panel-heading">Login de usuario</div>
            <div class="panel-body">
                <span class="text-danger">
                    <html:errors/>
                </span>
                <div class="form-group">
                    <label>Introduzca su nombre de usuario</label>
                    <html:text property="user" styleClass="form-control"/>
                </div>
                <div class="form-group">
                    <label>Introduzca su contraseña</label>
                    <html:password property="password" styleClass="form-control"/>
                </div>
                <bean:write name="LoginForm" property="error" filter="false"/>
            </div>
            <div class="panel-footer">
                <html:submit value="Login" styleClass="btn btn-primary" />
            </div>
        </div>
    </html:form>
    <% } else { %>
    <h1> mierda pa tu boca que ya estas logeado </h1>
    <% }%> 
</div>


