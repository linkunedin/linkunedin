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
    if (request.getSession().getAttribute("objsesion") != null){
    %>
<p>${objsesion.user.nombre}</p>
        <h1>Modifica tu perfil</h1>
        <table class="table">
            <tr>
                <th>Nombre<p>${objsesion.user.nombre}</p></th>
                <th>Apellidos<p>${objsesion.user.apellidos}</p></th>
                <th>Nombre usuario<p>${objsesion.user.nombreUsuario}</p></th>
                <th>Admin<p>${objsesion.user.admin}</p></th>
                <th>Email<p>${objsesion.user.email}</p></th>
            </tr>
            

        </table>        
<% }else { %>


<h1>A TOMAR POR CULO</h1>
<% } %>
