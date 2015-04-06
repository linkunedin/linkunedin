/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.interfaces.UserSessionIF;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * cada sesion de usuario deberia identificarse mediante un objeto de esta clase
 * esta clase deberia proporcionar un hash en funcion del momento de logueo 
 * y de las caracteristicas de usuario.
 * @author Administrador
 */
public class UserSession implements UserSessionIF{
    
    private Usuarios usuario;
    private Date fechalogueo;
    
    public UserSession(){
        this.fechalogueo = new Date();
    }

    @Override
    public void setUser(Object user) {
        // si el logueo ha tenido exito guardamos el objeto del usuario en la sesion
        this.usuario = (Usuarios) usuario;
        
    }

    @Override
    public String getHashSessionDigest() {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] bytehash = md.digest((fechalogueo.toString() + usuario.hashCode()).getBytes());
            String hash = new String(bytehash);
            return hash;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
    }
    
}