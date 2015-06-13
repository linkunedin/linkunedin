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

<h1>Formulario de visualizaci&oacute;n de perfiles</h1>
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
                            <span id="nombre"> ${usuperfil.nombre} </span>
                            </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group">
                                <label for="apellidos">Apellidos:</label>
                            ${usuperfil.apellidos}
                            </div> 
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group">

                                <label for="fechaNac2">Fecha Nacimiento</label>


                                <%
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    Date fecha = ((Usuarios) request.getAttribute("usuperfil")).getFechaNac();
                                    if (fecha == null) {
                                        out.println("");
                                    } else {
                                        String fechaformateada = sdf.format(fecha);
                                        out.println(fechaformateada);
                                    }
                                   %>
                            </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                <label for="email">Email:</label>
                            ${usuperfil.email}
                            </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                <label for="location">Direcci&oacute;n</label>
                            ${usuperfil.location}
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
                            ${usuperfil.nombreUsuario}
                            </div>
                                
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="pdf">Pdf:</label>
                                <a href="${usuperfil.pdf}" >Curriculum en PDF</a>
                            </div>
                        </div>
                    </div>




                </fieldset>

               


            <fieldset>
                <legend>
                    Informaci&oacute;n adicional
                </legend>
                <div class="form-group">

                    ${usuperfil.perfil}
                    </div>
                </fieldset>
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
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Titulacion</th>
                        <th>Centro de estudios</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <logic:iterate name="usuperfil" property="educacionCollection" id="educ">
                        <tr>
                            <td><bean:write name="educ" property="titulacion" /></td>
                            <td><bean:write name="educ" property="centroEstudios" /></td>
                        </tr>
                    </logic:iterate>
                </tbody>
            </table>
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
                <span class="ui teal big tag label">${cono.titulo}</span>
            </logic:iterate>
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
                    </tr>
                </thead>
                <tbody>
                    <logic:iterate name="usuperfil" property="experienciasCollection" id="exp">
                        <tr>
                            <td><bean:write name="exp" property="empresa" /></td>
                            <td><bean:write name="exp" property="puesto" /></td>
                        </tr>
                    </logic:iterate>
                </tbody>
            </table>

        </div>
    </div>
</div>


