<%-- 
    Document   : login
    Created on : 12-mar-2015, 21:12:19
    Author     : david
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
        <div class="row">
            <div class="col-lg-3 col-lg-offset-3">
                <h1>Login Form</h1>
                    <html:form action="/login">
                    <div class="form-group">
                        <label>Enter your user name</label>
                        <html:text property="user" styleClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Enter your password</label>
                        <html:text property="password" styleClass="form-control"/>
                    </div>
                    <html:submit value="Login" />
                    <bean:write name="LoginForm" property="error" filter="false"/>



                </html:form>
            </div>
        </div>
        
    
