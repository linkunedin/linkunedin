<%-- 
    Document   : listarUsuarios
    Created on : 15-abr-2015, 18:36:44
    Author     : juan
--%>
<%@page import="com.myapp.struts.Modelo.clases.UserSession"%>
<%@page import="com.myapp.struts.persistencia.entidades.Usuarios"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

        <h1>Lista de usuarios</h1>
        <table class="table">
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Nombre usuario</th>
                <th>Admin</th>
                <th>Email</th>
                <th>Acciones</th>

            </tr>
            
            <logic:iterate name="listaUsuarios" id="listUserId">
                <tr>
                    <td><bean:write name="listUserId" property="nombre"/></td>
                    <td><bean:write name="listUserId" property="apellidos"/></td>
                    <td><bean:write name="listUserId" property="nombreUsuario"/></td>
                    <td><bean:write name="listUserId" property="admin"/></td>
                    <td><bean:write name="listUserId" property="email"/></td>
                    <td>
                        <a href="VerPerfil.do?nomusuario=${listUserId.nombreUsuario}">
                            <span class="glyphicon glyphicon-eye-open"></span>
                        </a>
                        <%
                           if (request.getSession().getAttribute("objsesion") != null){
                               
                               
                               Usuarios us = ((UserSession)request.getSession().getAttribute("objsesion")).getUser();
                               if (us.getAdmin() == 1 || 
                                       us.getNombreUsuario().equals(((Usuarios)pageContext.getAttribute("listUserId")).getNombreUsuario())){
                               
                               out.println("<a href=\"vermodificarperfil.do?nomusuario="+us.getNombreUsuario()+"\"></a>");
                         
                        %>
                        <a href="vermodificarperfil.do?nomusuario=${listUserId.nombreUsuario}">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                        
                        <a href="baja.do?nomusuario=${listUserId.nombreUsuario}">
                            <span class="glyphicon glyphicon-remove"></span>
                        </a>
                        <%
                           }
                           }
                           
                        %>
                    </td>

                </tr>
                
                
       
            </logic:iterate>
        </table>        
 