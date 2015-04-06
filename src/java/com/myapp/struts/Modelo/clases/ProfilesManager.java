/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
import com.myapp.struts.Modelo.exeptions.ProfileAlreadyExistsException;
import com.myapp.struts.Modelo.exeptions.ProfileNotExistsException;
import com.myapp.struts.Modelo.interfaces.CriteriaIF;
import com.myapp.struts.Modelo.interfaces.ProfilesManagerIF;
import java.util.List;
import com.myapp.struts.persistencia.controladores.*;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class ProfilesManager implements ProfilesManagerIF {
    
    private static ProfilesManager instance;
    private UsuariosJpaController ujc;
    private ExperienciasJpaController ejc;
    private InteresesJpaController ijc;
    private EducacionJpaController edujc;
    
    // faltarian interesesjpacontroller y tiposlikes?
    
    public ProfilesManager getInstance(){
        if (ProfilesManager.instance == null){
            ProfilesManager.instance = new ProfilesManager();
            
        }
        return ProfilesManager.instance;
    }
    
    private ProfilesManager(){
        ujc = new UsuariosJpaController(Persistence.createEntityManagerFactory("PracticaPruebastwebPUHsql3"));
        ejc = new ExperienciasJpaController(Persistence.createEntityManagerFactory("PracticaPruebastwebPUHsql3"));
        ijc = new InteresesJpaController(Persistence.createEntityManagerFactory("PracticaPruebastwebPUHsql3"));
        edujc = new EducacionJpaController(Persistence.createEntityManagerFactory("PracticaPruebastwebPUHsql3"));
        
    }
    

    // esta funcion no tiene mucho sentido 
    @Override
    public void createProfile(Object user, Object profile) throws ProfileAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyProfile(Object modifier, Object profile) throws ProfileNotExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProfile(Object modifier, Object profile) throws ProfileNotExistsException, NotEnoughPrivilegesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getProfile(int profileid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getProfiles(List<CriteriaIF> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
