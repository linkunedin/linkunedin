<%-- 
    Document   : login
    Created on : 12-mar-2015, 21:12:19
    Author     : david
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        <h1>Login Form</h1>
        <html:form action="/login">
            <table border="0">

                <tbody>
                    <tr>
                        <td colspan="2">
                            <bean:write name="LoginForm" property="error" filter="false"/>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td>Enter your user name</td>
                        <td><html:text property="user"/></td>
                    </tr>
                    <tr>
                        <td>Enter your email</td>
                        <td><html:text property="password"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><html:submit value="Login" /></td>
                    </tr>
                </tbody>
            </table>


        </html:form>
    </body>
</html>
