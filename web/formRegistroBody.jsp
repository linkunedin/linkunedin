<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



    <h1></h1>
    <span class="text-danger">
        <html:errors/>
    </span>
    <html:messages id="mensajes"/>
    <div class="panel panel-primary">
        <div class="panel-heading">Registro Usuarios</div>
        <div class="panel-body">

            <html:form action="/alta" >
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <html:text property="nombre" styleClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="apellidos">Apellidos</label>
                            <html:text property="apellidos" styleClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <html:text property="email" styleClass="form-control"/>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="password">Password</label>
                            <html:text property="password" styleClass="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="nombusuario">Nombre Usuario</label>
                            <html:text property="nomusuario" styleClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="foto">Foto</label>
                            <html:file property="rutafoto" styleClass="form-control"/>
                        </div>
                    </div>
                </div>


                <br/>
                <button type="submit" class="btn btn-primary">Registrar</button>
                <bean:write name="AltaForm" property="error" filter="false"/>
            </html:form>
        </div>
    </div>


