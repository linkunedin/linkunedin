<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/layout.jsp" flush="true">
   
    <tiles:put name="body" value="/listarUsuariosBody.jsp" />
    
</tiles:insert>

