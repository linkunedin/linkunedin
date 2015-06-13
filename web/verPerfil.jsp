<%-- 
    Document   : VistaPerfil
    Created on : 29-mar-2015, 11:57:26
    Author     : david
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/layout.jsp" flush="true">
   
    <tiles:put name="body" value="/verPerfilBody.jsp" />
    
</tiles:insert>