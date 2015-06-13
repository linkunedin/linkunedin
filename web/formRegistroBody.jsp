<%@page import="com.myapp.struts.Modelo.clases.UserSession"%>
<%@page import="com.myapp.struts.persistencia.entidades.Usuarios"%>
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
                            <% if (request.getSession().getAttribute("objsesion") != null) {
                                UserSession uss = (UserSession) request.getSession().getAttribute("objsesion");
                                if (uss.getUser().getAdmin() == 1) {
                            
                            %>
                        <div class="form-group">
                            <label for="admin">Privilegios</label>
                            <select id="admin" name="admin" class="form-control">
                                <option value="0">Usuario</option>
                                <option value="1">Admin</option>
                            </select>
                        </div>
                        <% } } %>
                                
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="password">Password</label>
                            <html:password property="password"  styleClass="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="nombusuario">Nombre Usuario</label>
                            <html:text property="nomusuario" styleClass="form-control"/>
                        </div>
            
                            <div class="form-group has-feedback">
                                <label for="rutafoto">Foto:</label>
                                <input type="text" name="rutafoto" id="foto" class="form-control" value="${usuperfil.rutafoto}" placeholder="http://xxx.xx.">
                            
                            <span class="glyphicon glyphicon-picture form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <label for="pdf">Pdf:</label>
                            <input type="text" name="pdf" id="pdf" class="form-control" value="${usuperfil.pdf}" placeholder="http://xxx.xx."> 
                            <span class="glyphicon glyphicon-file form-control-feedback"></span>
                            </div>
                  
                </div>


                <br/>
                <button type="submit" class="btn btn-primary">Registrar</button>
                <bean:write name="AltaForm" property="error" filter="false"/>
            </html:form>
        </div>
    </div>


