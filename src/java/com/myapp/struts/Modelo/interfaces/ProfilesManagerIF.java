/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.interfaces;

import com.myapp.struts.Modelo.exeptions.ProfileNotExistsException;
import com.myapp.struts.Modelo.exeptions.ProfileAlreadyExistsException;
import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
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
     */
    public void modifyProfile(Object modifier, Object profile) throws ProfileNotExistsException;

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
     * @param criteria
     * @return
     */
    public List<Object> getProfiles(List<CriteriaIF> criteria);
}
