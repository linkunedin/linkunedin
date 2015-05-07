<%-- 
    Document   : listarUsuarios
    Created on : 15-abr-2015, 18:36:44
    Author     : juan
--%>
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
            && request.getAttribute("experiencia") != null) {
        Experiencias expe = (Experiencias) request.getAttribute("experiencia");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            request.setAttribute("fechainicio", sdf.format(expe.getFechaFin()));
            request.setAttribute("fechafin", sdf.format(expe.getFechaInicio()));
        } catch (Exception e) {
            request.setAttribute("fechafin", "");
            request.setAttribute("fechainicio", "");
        }

%>

<script type="text/javascript">
    $(document).ready(function() {
        $("#cancelar").click(function(e) {
            window.location = "vermodificarperfil.do?nomusuario=${experiencia.usuarioId.nombreUsuario}";
        });
        
        $("#enviarexpe").click(function(e){
            form = $("form[name=ExperienciaForm]");
            form.submit();
            //window.location = "vermodificarperfil.do?nomusuario=${experiencia.usuarioId.nombreUsuario}";
        });
    });
</script>

<!-- 

    FIN LISTADOS
    COMIENZAN LOS DIALOGOS QUE SE ENVIARAN MEDIANTE AJAX 

-->
<h1>Formulario de modificaci&oacute;n de experiencia</h1>
<div id="dialogoexpe" class="panel panel-primary">

    <div class="panel-heading">
        Modificar experiencia ${experiencia.id}
    </div>

    <div class="panel-body">
        <html:form styleClass="form-inline" action="/modificarExpe">
            <fieldset>
                <legend>
                    Datos identificativos
                </legend>
                <div class="form-group">
                    <label for="username">Nombre de usuario:</label>
                    <html:text property="username" styleClass="form-control" readonly="true" value="${experiencia.usuarioId.nombreUsuario}"></html:text>
                    </div>
                    <div class="form-group">
                        <label for="empresa">Empresa:</label>
                    <html:text property="empresa" styleClass="form-control" value="${experiencia.empresa}"></html:text>                            
                    </div>
                    <div class="form-group">
                        <label for="puesto">Puesto:</label>
                    <html:text property="puesto" styleClass="form-control" value="${experiencia.puesto}"></html:text> 
                    </div>
                    <div class="form-group">
                        <label for="fechainicio">Fecha inicio:</label>
                    <html:text property="fechainicio" styleClass="form-control" value="${fechainicio}"></html:text> 
                    </div>
                    <div class="form-group">
                        <label for="fechafin">Fecha fin:</label>
                    <html:text property="fechafin" styleClass="form-control" value="${fechafin}"></html:text> 
                    <html:hidden property="idexp" value="${experiencia.id}"></html:hidden>
                    </div>
                    <br/>
                </fieldset>
                <fieldset>
                    <legend>
                        Descripci&oacute;n del puesto
                    </legend>
                    <div class="form-group">
                    <html:textarea property="descripcion" styleClass="form-control" cols="90" rows="7" value="${experiencia.descripcion}"></html:textarea>

                    </div>
                </fieldset>
                <input id="idexp" type="hidden" name="idexp" value="${experiencia.id}"/>
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
