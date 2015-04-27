<%-- 
    Document   : listarUsuarios
    Created on : 15-abr-2015, 18:36:44
    Author     : juan
--%>
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %-->
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!--c, :if test= "${objsesion.user}!=null"-->
<%
    if (request.getSession().getAttribute("objsesion") != null) {
%>

<script type="text/javascript">
    $(function(){
        
        // evento click enviar experiencia
        $("#enviarexpe").click(function(evento){
            
        });
        
        $("#enviartitulacion").click(function(evento){
            $.post("logout.do").done(function(response,jqXHR){
                console.log(response);
            });
        });
        
        $("#enviarcono").click(function(evento){
            // prueba de envio por ajax
            $.post("login.do", 
                data={"user":"ola", "password":"kase"}  // los datos que se envian
            ).done(function(response, jqXHR){   // response es lo que responde el servidor
                console.log(response);
            });
        });
        
    })();
</script>

<h1>Formulario de modificaci&oacute;n de perfil</h1>
<html:form action="/modificarperfil" styleClass="form-inline">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Datos b&aacute;sicos
        </div>
        <div class="panel-body">
            <fieldset>
                <legend>
                    Datos personales
                </legend>
                <div class="form-group">


                    <label for="nombre">Nombre:</label>
                    <html:text property="nombre" styleClass="form-control" value="${objsesion.user.nombre}"></html:text>
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellidos:</label>
                    <html:text property="apellidos" styleClass="form-control" value="${objsesion.user.apellidos}"></html:text>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                    <html:text property="email" styleClass="form-control" value="${objsesion.user.email}"></html:text>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Direcci&oacute;n</label>
                    <html:text property="nombre" styleClass="form-control" value="${objsesion.user.location}"></html:text>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>
                        Datos para la aplicaci&oacute;n
                    </legend>
                    <div class="form-group">
                        <label for="nomusuario">Nombre usuario:</label>
                    <html:text property="nomusuario" readonly="true" styleClass="form-control" value="${objsesion.user.nombreUsuario}"></html:text>
                    </div>

                    <div class="form-group">
                        <label for="nombre">Foto:</label>
                    <html:text property="foto" styleClass="form-control" value="${objsesion.user.rutafoto}"></html:text>
                    </div>
                    <div class="form-group">
                        <label for="pdf">Pdf:</label>
                    <html:text property="pdf" styleClass="form-control" value="${objsesion.user.pdf}"></html:text>
                    </div>

                    <div class="form-group">
                        <label for="nombre">Password:</label>
                    <html:password property="nombre" styleClass="form-control" value="${objsesion.user.password}"></html:password>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>
                        Fecha de nacimiento
                    </legend>
                    <div class="form-group">
                        <label for="dia">Dia:</label>
                    <html:text property="dia" styleClass="form-control" size="2" value="${objsesion.user.fechaNac.Day}"></html:text>
                    </div>
                    <div class="form-group">
                        <label for="mes">Mes:</label>
                    <html:text property="mes" styleClass="form-control" size="2" value="${objsesion.user.fechaNac.Month}"></html:text>
                    </div>
                    <div class="form-group">
                        <label for="ano">Año:</label>
                    <html:text property="ano" styleClass="form-control" size="4" value="${objsesion.user.fechaNac.Year}"></html:text>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>
                        Informaci&oacute;n adicional
                    </legend>
                    <div class="form-group">

                    <html:textarea property="nombre" styleClass="form-control" cols="90" rows="7">${objsesion.user.perfil}</html:textarea>
                    </div>
                </fieldset>
            </div>
            <div class="panel-footer">
            <html:submit value="Enviar" styleClass="btn btn-primary"/>
        </div>
    </div>
</html:form>        
<!-- 

        PARTE PARA ABRIR LISTAR LOS ITEMS CON BOTONES PARA ABRIR LOS DIALOGOS
        PARA AÑADIR NUEVOS ITEMS

-->
<div class="form-inline">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Formaci&oacute;n acad&eacute;mica
        </div>
        <div class="panel-body">

        </div>
        <div class="panel-footer">
            <button type="button" class="btn btn-primary" id="nuevaacadem" name="nuevaacadem" data-toggle="modal" data-target="#dialogoacadem">Nueva titulacion</button>
        </div>
    </div>
</div>
<div class="form-inline">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Conocimientos y competencias adquiridas
        </div>
        <div class="panel-body">

        </div>
        <div class="panel-footer">
            <button type="button" class="btn btn-primary" id="nuevaexpe" name="nuevaexpe" data-toggle="modal" data-target="#dialogocono">Nueva experiencia</button>
        </div>
    </div>
</div>
<div class="form-inline">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Experiencia laboral
        </div>
        <div class="panel-body">

        </div>
        <div class="panel-footer">
            <button type="button" class="btn btn-primary" id="nuevaexpe" name="nuevaexpe" data-toggle="modal" data-target="#dialogoexpe">Nueva experiencia</button>
        </div>
    </div>
</div>

<!-- 

    FIN LISTADOS
    COMIENZAN LOS DIALOGOS QUE SE ENVIARAN MEDIANTE AJAX 

-->
<div id="dialogoexpe" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Añadir nueva experiencia</h4>
            </div>
            <div class="modal-body">
                <div class="form-inline">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Datos de la experiencia laboral
                        </div>
                        <div class="panel-body">
                            
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="enviarexpe" name="enviarexpe" class="btn btn-primary" data-dismiss="modal">Enviar</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
            </div>
        </div>

    </div>
</div>

<div id="dialogocono" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Añadir nueva competencia</h4>
            </div>
            <div class="modal-body">
                <div class="form-inline">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Inserte el tag
                        </div>
                        <div class="panel-body">
                            
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="enviarcono" name="enviarcono" class="btn btn-primary" data-dismiss="modal">Enviar</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
            </div>
        </div>

    </div>
</div>


<div id="dialogoacadem" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Añadir nueva titulacion</h4>
            </div>
            <div class="modal-body">
                <div class="form-inline">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Datos de la titulacion
                        </div>
                        <div class="panel-body">
                            
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="enviartitulacion" name="enviartitulacion" class="btn btn-primary" data-dismiss="modal">Enviar</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
            </div>
        </div>

    </div>
</div>
<% } else { %>


<h1>A TOMAR POR CULO</h1>
<% }%>
