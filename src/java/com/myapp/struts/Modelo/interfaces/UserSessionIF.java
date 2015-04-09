/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.interfaces;

/**
 *
 * @author Administrador
 */
public interface UserSessionIF {
    
    /**
     *
     * @param user
     */
    public void setUser(Object user);
    /**
     * concatena el usuario, la fecha de logeo y saca un hash usando sha256, se buscara en la sesion
     * este bean para comprobar si esta logeado
     * @return 
     */
    public String getHashSessionDigest();
    
}
