<%-- 
    Document   : listarUsuarios
    Created on : 15-abr-2015, 18:36:44
    Author     : juan
--%>
<%@page import="com.myapp.struts.persistencia.entidades.Educacion"%>
<%@page import="java.sql.Date"%>
<%@page import="com.myapp.struts.persistencia.entidades.Usuarios"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.myapp.struts.persistencia.entidades.Experiencias"%>
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %-->
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!--c, :if test= "${usuperfil}!=null"-->



<span class="text-danger">
    <html:errors/>
</span>
<%
    if (request.getSession().getAttribute("objsesion") != null
            && request.getAttribute("educacion") != null) {
        Educacion edu = (Educacion) request.getAttribute("educacion");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            request.setAttribute("fechainicio", sdf.format(edu.getFechaFin()));
            request.setAttribute("fechafin", sdf.format(edu.getFechaInicio()));
        } catch (Exception e) {
            request.setAttribute("fechafin", "");
            request.setAttribute("fechainicio", "");
        }

%>

<script type="text/javascript">
    $(document).ready(function() {
        $("#cancelar").click(function(e) {
            window.location = "vermodificarperfil.do?nomusuario=${educacion.usuarioId.nombreUsuario}";
        });
        
        $("#enviarexpe").click(function(e){
            form = $("form[name=EducacionForm]");
            form.submit();
        });
    });
</script>

<!-- 

    FIN LISTADOS
    COMIENZAN LOS DIALOGOS QUE SE ENVIARAN MEDIANTE AJAX 

-->
<h1>Formulario de modificaci&oacute;n de educacion</h1>
<div id="dialogoexpe" class="panel panel-primary">

    <div class="panel-heading">
        Modificar educacion ID = ${educacion.id}
    </div>

    <div class="panel-body">
        <html:form  action="/modificarEducacion">
            <fieldset>
                <legend>
                    Datos identificativos
                </legend>
                <div class="row">
                    <div class="col-lg-6">
                         <div class="form-group">
                    <label for="username">Nombre de usuario:</label>
                    <html:text property="username" styleClass="form-control" readonly="true" value="${educacion.usuarioId.nombreUsuario}"></html:text>
                    </div>
                    <div class="form-group">
                        <label for="centro">Centro</label>
                    <html:text property="centro" styleClass="form-control" value="${educacion.centroEstudios}"></html:text>                            
                    </div>
                    <div class="form-group">
                        <label for="titulo">Titulacion</label>
                    <html:text property="titulo" styleClass="form-control" value="${educacion.titulacion}"></html:text> 
                    </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                        <label for="fechainicio">Fecha inicio:</label>
                    <html:text property="fechainicio" styleClass="form-control" value="${fechainicio}"></html:text> 
                    </div>
                    <div class="form-group">
                        <label for="fechafin">Fecha fin:</label>
                    <html:text property="fechafin" styleClass="form-control" value="${fechafin}"></html:text> 
                    <html:hidden property="id" value="${educacion.id}"></html:hidden>
                    </div>
                    </div>
                </div>
                   
                    
                    <br/>
                </fieldset>
                <fieldset>
                    <legend>
                        Descripci&oacute;n de la educacion recibida
                    </legend>
                    <div class="form-group">
                    <html:textarea property="descripcion" styleClass="form-control" cols="90" rows="7" value="${educacion.descripcion}"></html:textarea>

                    </div>
                </fieldset>
                <!--input id="id" type="hidden" name="idexp" value="${educacion.id}"/-->
        </html:form>
    </div>
    <div class="panel-footer">
        <button type="button" id="enviarexpe" name="enviarexpe" class="btn btn-primary">Enviar</button>
        <button type="button" id="cancelar" class="btn btn-danger" >Cancelar</button>
    </div>

</div>


<% } else { %>

<p>ola k ase</p>
<!--h1>A TOMAR POR CULO</h1-->
<% }%>
