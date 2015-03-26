/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.interfaces;

import com.myapp.struts.Modelo.exeptions.AlreadyDisabledException;
import com.myapp.struts.Modelo.exeptions.AlreadyEnabledException;

/**
 *
 * @author Administrador
 */
public interface FunctionManagerIF {
    /**
     * activa una funcionalidad concreta
     * @throws AlreadyEnabledException
     * @param funid id de funcion
     */
    public void activar(int funid) throws AlreadyEnabledException;
    
    /**
     * desactiva una funcionalidad concreta
     * @param funid
     * @throws AlreadyDisabledException 
     */
    public void desactivar(int funid) throws AlreadyDisabledException;
}
