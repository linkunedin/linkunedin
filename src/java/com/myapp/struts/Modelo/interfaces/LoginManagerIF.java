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
public interface LoginManagerIF {

    /**
     *
     * @param user
     * @param pwd
     * @return
     */
    public UserSessionIF login(String user, String pwd);

    /**
     *
     * @return
     */
    public boolean logout();
}
