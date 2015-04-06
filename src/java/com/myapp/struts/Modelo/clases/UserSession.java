/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.interfaces.UserSessionIF;

/**
 * cada sesion de usuario deberia identificarse mediante un objeto de esta clase
 * esta clase deberia proporcionar un hash en funcion del momento de logueo 
 * y de las caracteristicas de usuario.
 * @author Administrador
 */
public class UserSession implements UserSessionIF{
    
    

    @Override
    public void setUser(Object user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getHashSessionDigest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
