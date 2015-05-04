<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
        <div class="row">
            
            <div class="col-lg-12">
                <h1>Buscar</h1>
                <p>Para buscar por una categoria determida rellene cualquiera de los campos a continuacion</p>
            </div>
            <div class="col-lg-6 col-lg-offset-3">
                
                    <html:form action="/buscar">
                    <div class="form-group">
                        <label>Introduzca una titulación</label>
                        <html:text property="titulacion" styleClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Introduzca una experiencia</label>
                        <html:text property="experiencia" styleClass="form-control"/>
                    </div>
                    
                    <div class="form-group">
                        <label>Introduzca conocimientos</label>
                        <html:text property="conocimientos" styleClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Introduzca una localidad</label>
                        <html:text property="location" styleClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Introduzca una fecha</label>
                        <html:text property="fechaNac2" styleClass="form-control"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Registrar</button>
                    <!--bean:write name="BusquedaForm" property="error"  filter="false"/-->



                </html:form>
            </div>
        </div>
        
        
    
