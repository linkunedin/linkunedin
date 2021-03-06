/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.interfaces;

import com.myapp.struts.Controlador.Forms.BusquedaForm;
import com.myapp.struts.Modelo.exeptions.ProfileNotExistsException;
import com.myapp.struts.Modelo.exeptions.ProfileAlreadyExistsException;
import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ProfilesManagerIF {
    
    /**
     *
     * @param user
     * @param profile
     * @throws ProfileAlreadyExistsException
     */
    public void createProfile(Object user, Object profile) throws ProfileAlreadyExistsException;

    /**
     *
     * @param modifier
     * @param profile
     * @throws ProfileNotExistsException
     * @throws com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException
     */
    public void modifyProfile(Object modifier, Object profile) throws ProfileNotExistsException, NotEnoughPrivilegesException ;

    /**
     *
     * @param modifier
     * @param profile
     * @throws ProfileNotExistsException
     * @throws NotEnoughPrivilegesException
     */
    public void deleteProfile(Object modifier, Object profile) throws ProfileNotExistsException, NotEnoughPrivilegesException;

    /**
     *
     * @param profileid
     * @return
     */
    public Object getProfile(int profileid);

    /**
     *
     * @param formu
     * @return
     */
    public List<Usuarios> getProfiles(BusquedaForm formu);
}
