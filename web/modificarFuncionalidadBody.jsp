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
        <div class="panel-heading">Registro Funcionalidades</div>
        <div class="panel-body">

            <html:form action="/funcionalidad" >
                <div class="form-group">
                    <label>Activo</label>
                    <html:text property="estado" styleClass="form-control"/>
                </div>
                <div class="form-group">
                    <label>Funcionalidad</label>
                    <html:text property="funcionalidad" styleClass="form-control"/>
                </div>
               
                <br/>
                <button type="submit" class="btn btn-primary">Registrar</button>
                <bean:write name="FuncionalidadForm" property="error" filter="false"/>
            </html:form>
        </div>
    </div>
</div>

