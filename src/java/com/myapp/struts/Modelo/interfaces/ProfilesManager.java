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
public interface ProfilesManager {
    
    public void createProfile(Object user, Object profile) throws ProfileAlreadyExistsException;
    public void modifyProfile(Object modifier, Object profile) throws ProfileNotExistsException;
    public void deleteProfile(Object modifier, Object profile) throws ProfileNotExistsException, NotEnoughPrivilegesException;
    public Object getProfile(int profileid);
    public List<Object> getProfiles(List<CriteriaIF> criteria);
}
