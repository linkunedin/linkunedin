<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
        <div class="row">
            <div class="col-lg-3 col-lg-offset-3">
                <h1>Buscar</h1>
                    <html:form action="/buscar">
                    <div class="form-group">
                        <label>Introduzca su nombre de usuario</label>
                        <html:text property="user" styleClass="form-control"/>
                    </div>
                    
                    <html:submit value="Buscar" />
                    <bean:write name="BusquedaForm" property="error" filter="false"/>



                </html:form>
            </div>
        </div>
        
        
    
