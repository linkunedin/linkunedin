<%-- 
    Document   : listarUsuarios
    Created on : 15-abr-2015, 18:36:44
    Author     : juan
--%>
<%@page import="java.sql.Date"%>
<%@page import="com.myapp.struts.persistencia.entidades.Usuarios"%>
<%@page import="java.text.SimpleDateFormat"%>
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
            && request.getAttribute("usuperfil") != null) {
%>

<script type="text/javascript">
    $(function () {

        // evento click enviar experiencia
        $("#enviarexpe").click(function (evento) {
            $.post("anadirExpe.do", data = {
                "empresa": $("#expempresa").val(),
                "puesto": $("#exppuesto").val(),
                "descripcion": $("#expdescripcion").val(),
                "fechainicio": $("#expfinicio").val(),
                "fechafin": $("#expffin").val(),
                "username": $("#expusuario").val()
            }).done(function (response) {
                console.log(response);
                if ($("#expfinicio").val().match(/\d{2}\/\d{2}\/\d{4}/g) && $("#expffin").val().match(/\d{2}\/\d{2}\/\d{4}/g)) {
                    window.location = "vermodificarperfil.do?nomusuario=${usuperfil.nombreUsuario}";
                }
                else
                    alert("Por favor, introduce una fecha valida!");
            });
        });

        $("#enviartitulacion").click(function (evento) {
            $.post("anadirEducacion.do", data = {
                "titulo": $("#acadtitulo").val(),
                "centro": $("#acadcentro").val(),
                "fechainicio": $("#acadfinicio").val(),
                "fechafin": $("#acadffin").val(),
                "descripcion": $("#acaddesc").val(),
                "username": $("#expusuario").val()
            }).done(function (response, jqXHR) {
                console.log(response);
                if ($("#acadfinicio").val().match(/\d{2}\/\d{2}\/\d{4}/g) && $("#acadffin").val().match(/\d{2}\/\d{2}\/\d{4}/g)) {
                    window.location = "vermodificarperfil.do?nomusuario=${usuperfil.nombreUsuario}";
                }
                else
                    alert("Por favor, introduce una fecha valida!");

            });
        });

        $("#enviarcono").click(function (evento) {
            // prueba de envio por ajax
            $.post("anadirConocimiento.do",
                    data = {"titulo": $("#titulocono").val(),
                        "username": $("#expusuario").val(),
                        "descripcion": $("#descrcono").val()  // los datos que se envian
                    }).done(function (response, jqXHR) {   // response es lo que responde el servidor

                console.log(response);
                //window.location.reload();
                window.location = "vermodificarperfil.do?nomusuario=${usuperfil.nombreUsuario}";
            });
        });//

        window["modificarExpe"] = function (id) {
            window.location = "vermodificarExpe.do?idexp=" + id;
        }

        window["eliminarExpe"] = function (id, usu) {
            $.post("BorraExpe.do", data = {
                "idexp": id,
                "username": usu
            }).done(function (response) {
                window.location.reload();
            });
            //window.location = "BorraExpe.do?idexp=" + id + "&username=" + usu;
        }

        window["modificarEduc"] = function (id) {
            window.location = "vermodificarEducacion.do?id=" + id;
        }

        window["eliminarEduc"] = function (id, usu) {
            $.post("BorraEdu.do", data = {
                "id": id,
                "username": usu
            }).done(function (response) {
                window.location = "vermodificarperfil.do?nomusuario=${usuperfil.nombreUsuario}";
            });
        }

        $(".modal-body").css("max-height", "100vh - 210px");
        $(".modal-body").css("overflow-y", "auto");

    });
</script>

<h1>Formulario de modificaci&oacute;n de perfil</h1>
<html:form action="/modificarperfil"  enctype="multipart/form-data">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Datos b&aacute;sicos
        </div>
        <div class="panel-body">
            <fieldset>
                <legend>
                    Datos personales
                </legend>
                <div class="row">
                    <div class="col-lg-2">
                        <img class="img-responsive foto-perfil" src="${usuperfil.rutafoto}"> 
                    </div>
                    
                    <div class="col-lg-10">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <html:text property="nombre" styleClass="form-control" value="${usuperfil.nombre}"></html:text>
                            </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group">
                                <label for="apellidos">Apellidos:</label>
                            <html:text property="apellidos" styleClass="form-control" value="${usuperfil.apellidos}"></html:text>
                            </div> 
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group">

                                <label for="fechaNac2">Fecha Nacimiento</label>


                                <input type="text" name="fechaNac2" id="fechaNac2" class="form-control" size="10" value="<%
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    Date fecha = ((Usuarios) request.getAttribute("usuperfil")).getFechaNac();
                                    if (fecha == null) {
                                        out.println("");
                                    } else {
                                        String fechaformateada = sdf.format(fecha);
                                        out.println(fechaformateada);
                                    }
                                   %>" placeholder="dd/mm/yyyy" />
                            </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                <label for="email">Email:</label>
                            <html:text property="email" styleClass="form-control" value="${usuperfil.email}"></html:text>
                            </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                <label for="location">Direcci&oacute;n</label>
                            <html:text property="location" styleClass="form-control" value="${usuperfil.location}"></html:text>
                            </div>
                            </div>
                        </div>    
                            
                              
                            
                        </div>
                        
                    </div>


                </fieldset>
                <fieldset>
                    <legend>
                        Datos para la aplicaci&oacute;n
                    </legend>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="nomusuario">Nombre usuario:</label>
                            <html:text property="nomusuario" readonly="true" styleClass="form-control" value="${usuperfil.nombreUsuario}"></html:text>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                            <html:text property="password" styleClass="form-control" value="${usuperfil.password}"></html:text>
                            </div>    
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group has-feedback">
                                <label for="foto">Foto:</label>
                                <input type="text" name="foto" id="foto" class="form-control" value="${usuperfil.rutafoto}" placeholder="http://xxx.xx.">
                            
                            <span class="glyphicon glyphicon-picture form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <label for="pdf">Pdf:</label>
                            <input type="text" name="pdf" id="pdf" class="form-control" value="${usuperfil.pdf}" placeholder="http://xxx.xx."> 
                            <span class="glyphicon glyphicon-file form-control-feedback"></span>
                            </div>
                        </div>
                    </div>




                </fieldset>

               


            <fieldset>
                <legend>
                    Informaci&oacute;n adicional
                </legend>
                <div class="form-group">

                    <html:textarea property="perfil" styleClass="form-control" cols="90" rows="7" value="${usuperfil.perfil}"></html:textarea>
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
        PARA A�ADIR NUEVOS ITEMS

-->
<div class="form-inline">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Formaci&oacute;n acad&eacute;mica
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Titulacion</th>
                        <th>Centro de estudios</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <logic:iterate name="usuperfil" property="educacionCollection" id="educ">
                        <tr>
                            <td><bean:write name="educ" property="titulacion" /></td>
                            <td><bean:write name="educ" property="centroEstudios" /></td>
                            <td>
                                <div class="dropdown">
                                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Acci&oacute;n
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#" onclick="javascript:modificarEduc(${educ.id}, '${educ.usuarioId.nombreUsuario}')">Editar</a></li>
                                        <li><a href="#" onclick="javascript:eliminarEduc(${educ.id}, '${educ.usuarioId.nombreUsuario}')">Borrar</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </logic:iterate>
                </tbody>
            </table>
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
            <logic:iterate name="usuperfil" property="interesesCollection" id="cono">
                <a href="borrarCono.do?id=${cono.id}&username=${usuperfil.nombreUsuario}" class="ui teal big tag label">${cono.titulo}</a>
            </logic:iterate>
        </div>
        <div class="panel-footer">
            <button type="button" class="btn btn-primary" id="nuevocono" name="nuevocono" data-toggle="modal" data-target="#dialogocono">A�adir</button>
        </div>
    </div>
</div>
<div class="form-inline">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Experiencia laboral
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Empresa</th>
                        <th>Puesto</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <logic:iterate name="usuperfil" property="experienciasCollection" id="exp">
                        <tr>
                            <td><bean:write name="exp" property="empresa" /></td>
                            <td><bean:write name="exp" property="puesto" /></td>
                            <td>
                                <div class="dropdown">
                                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Acci&oacute;n
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#" onclick="javascript:modificarExpe(${exp.id}, '${exp.usuarioId.nombreUsuario}')">Editar</a></li>
                                        <li><a href="#" onclick="javascript:eliminarExpe(${exp.id}, '${exp.usuarioId.nombreUsuario}')">Borrar</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </logic:iterate>
                </tbody>
            </table>

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
    <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">A�adir nueva experiencia</h4>
            </div>
            <div class="modal-body">
                <div class="">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Datos de la experiencia laboral
                        </div>
                        <div class="panel-body">
                            <fieldset>
                                <legend>
                                    Datos identificativo
                                </legend>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                    <label for="expempresa">Empresa:</label>
                                    <input type="text" class="form-control" name="expempresa" id="expempresa"/>
                                </div>
                                <div class="form-group">
                                    <label for="exppuesto">Puesto:</label>
                                    <input type="text" class="form-control" name="exppuesto" id="exppuesto"/>
                                </div>
                                    </div>
                                    <div class="col-lg-6">
                                          <div class="form-group">
                                            <label for="expfinicio">Fecha inicio:</label>
                                            <input type="text" class="form-control" name="expfinicio" id="expfinicio" placeholder="dd/mm/yyyy" />
                                        </div>
                                        <div class="form-group">
                                            <label for="expffin">Fecha fin:</label>
                                            <input type="text" class="form-control" name="expffin" id="expffin" placeholder="dd/mm/yyyy" />
                                        </div>
                                    </div>
                                </div>
                                
                              
                                <br/>
                            </fieldset>
                            <fieldset>
                                <legend>
                                    Descripci&oacute;n del puesto
                                </legend>
                                <div class="form-group">
                                    <textarea class="form-control" name="expdescripcion" id="expdescripcion" cols="80" rows="6"></textarea>
                                </div>
                            </fieldset>

                            <input id="expusuario" type="hidden" value="${usuperfil.nombreUsuario}"/>
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
                <h4 class="modal-title">A�adir nueva competencia</h4>
            </div>
            <div class="modal-body">
                <div class="">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Inserte el tag
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                <label for="titulocono">Titulo:</label>
                                <input type="text" id="titulocono" name="titulocono" class="form-control" />
                            </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                <label for="desccono">Descripcion</label>
                                <input type="text" id="descrcono" name="descrcono" class="form-control" />
                            </div>
                                    </div>
                                </div>
                            
                            
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
    <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">A�adir nueva titulacion</h4>
            </div>
            <div class="modal-body">
                <div class="">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Datos de la titulacion
                        </div>
                        <div class="panel-body">
                            <fieldset>
                                <legend>
                                    Datos de la titulacion
                                </legend>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                    <label for="acadtitulo">Titulo:</label>
                                    <input type="text" class="form-control" id="acadtitulo" name="acadtitulo"/>
                                </div>
                                <div class="form-group">
                                    <label for="acadcentro">Centro:</label>
                                    <input type="text" class="form-control" id="acadcentro" name="acadcentro"/>
                                </div>
                                    </div>
                                    <div class="col-lg-6">
                                 <div class="form-group">
                                    <label for="acadfinicio">Fecha inicio</label>
                                    <input type="text" class="form-control" id="acadfinicio" name="acadfinicio" placeholder="dd/mm/yyyy" />
                                </div>
                                <div class="form-group">
                                    <label for="acadffin">Fecha fin</label>
                                    <input type="text" class="form-control" id="acadffin" name="acadffin" placeholder="dd/mm/yyyy" />
                                </div>
                                    </div>
                                </div>
                                
                                
                            </fieldset>
                            <fieldset>
                                <legend>
                                    Descripci&oacute;n del t&iacute;tulo
                                </legend>
                                <div class="form-group">
                                    <textarea id="acaddesc" name="acaddesc" cols="70" rows="6"></textarea>
                                </div>
                            </fieldset>
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


<!--h1>A TOMAR POR CULO</h1-->
<% }%>
