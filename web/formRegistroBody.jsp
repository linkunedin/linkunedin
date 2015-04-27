<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row">
    <h1></h1>
    <span class="text-danger">
        <html:errors/>
    </span>
    <html:messages id="mensajes"/>
    <div class="panel panel-primary">
        <div class="panel-heading">Registro Usuarios</div>
        <div class="panel-body">

            <html:form action="/alta" styleClass="form-inline">
                <div class="form-group">
                    <label>Nombre</label>
                    <html:text property="nombre" styleClass="form-control"/>
                </div>
                <div class="form-group">
                    <label>Apellidos</label>
                    <html:text property="apellidos" styleClass="form-control"/>
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
                    <html:text property="nomusuario" styleClass="form-control"/>
                </div>
                <div class="form-group">
                    <label>Foto</label>
                    <html:text property="rutafoto" styleClass="form-control"/>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary">Registrar</button>
                <bean:write name="AltaForm" property="error" filter="false"/>
            </html:form>
        </div>
    </div>
</div>

