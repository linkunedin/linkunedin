<%-- 
    Document   : listarFuncionalidades
    Created on : 15-abr-2015, 18:36:44
    Author     : juan
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

        <h1>Lista de Funcionalidades</h1>
        <table class="table">
            <tr>
                <th>Funcionalidad</th>
                <th>Activo</th>
               
                <th>Editar</th>
            </tr>
            
            <logic:iterate name="listaFuncionalidades" id="listFuncionId">
                <tr>
                    <td><bean:write name="listFuncionId" property="funcionalidad"/></td>
                    <td><bean:write name="listFuncionId" property="activo"/></td>
                   
                    <td>
                        <a href="formFuncionalidades.do?id=${listFuncionId.id}">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                    </td>
                </tr>
                
                
       
            </logic:iterate>
        </table>        
 