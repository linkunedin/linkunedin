/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.interfaces.UserSessionIF;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.math.BigInteger;
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
    
    private Usuarios user;
    private Date fechalogueo;
    
    /**
     *
     */
    public UserSession(){
        this.fechalogueo = new Date();
    }

    /**
     *
     * @param user
     */
    @Override
    public void setUser(Usuarios user) {
        // si el logueo ha tenido exito guardamos el objeto del usuario en la sesion
        this.user = user;
        
    }

    @Override
    public Usuarios getUser() {
        return this.user;
    }
    
    

    @Override
    public String getHashSessionDigest() {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(("" + this.user.getId() + fechalogueo.toString()).getBytes());
            BigInteger bi = new BigInteger(1, md.digest());
            String cadena = bi.toString(16);
            return cadena;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
    }
    
}
