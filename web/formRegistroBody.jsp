<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
<div class="row">
    <div class="col-lg-3 col-lg-offset-3">
        <h1>Registro Usuarios</h1>
            <html:form action="/login">
            <div class="form-group">
                <label>Nombre</label>
                <html:text property="nombre" styleClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Apellido</label>
                <html:text property="apellido" styleClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Password</label>
                <html:text property="password" styleClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Email</label>
                <html:text property="email" styleClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Nombre Usuario</label>
                <html:text property="nombreUsuario" styleClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Foto</label>
                <html:text property="foto" styleClass="form-control"/>
            </div>
            <html:submit value="Login" />
            <bean:write name="LoginForm" property="error" filter="false"/>



        </html:form>
    </div>
</div>

