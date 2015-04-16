<%-- 
    Document   : listarUsuarios
    Created on : 15-abr-2015, 18:36:44
    Author     : juan
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
    </head>
    <body>
        <h1>Lista de usuarios</h1>
        <table>
            <tr>
                <td>Nombre</td>
                <td>Apellidos</td>
                <td>Nombre usuario</td>
                <td>Admin</td>
                <td>Email</td>
            </tr>
            
            <logic:iterate name="listaUsuarios" id="listUserId">
                <tr>
                    <td><bean:write name="listUserId" property="nombre"/></td>
                    <td><bean:write name="listUserId" property="apellidos"/></td>
                    <td><bean:write name="listUserId" property="nombreUsuario"/></td>
                    <td><bean:write name="listUserId" property="admin"/></td>
                    <td><bean:write name="listUserId" property="email"/></td>
                </tr>
                
                
       
            </logic:iterate>
        </table>        
    </body>
</html>
