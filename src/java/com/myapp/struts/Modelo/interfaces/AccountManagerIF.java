/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.interfaces;

import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
import com.myapp.struts.Modelo.exeptions.UserAlreadyExistsException;
import com.myapp.struts.Modelo.exeptions.UserNotExistsException;

/**
 *
 * @author Administrador
 */
public interface AccountManagerIF {
    
    /**
     * crea un usuario. si ya existe lanza excepcion
     * @param usuario
     * @throws UserAlreadyExistsException 
     */
    public void alta(Object usuario) throws UserAlreadyExistsException;
    /**
     * da de baja un usuario. Si no existe lanza excepcion
     * @param usuario
     * @throws UserNotExistsException 
     */
    public void baja(Object usuario) throws UserNotExistsException;
    /**
     * modifica los datos de un usuario. si el modificador != usuario o el modificador no es admin
     * lanza una excepcion
     * @param usuario usuario que va a ser modificado
     * @param modifier usuario que modifica
     * @throws NotEnoughPrivilegesException 
     * @throws com.myapp.struts.Modelo.UserNotExistsException 
     */
    public void modify(Object usuario, Object modifier) throws NotEnoughPrivilegesException, UserNotExistsException;
}
