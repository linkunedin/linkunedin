/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.interfaces.LoginManagerIF;
import com.myapp.struts.Modelo.interfaces.UserSessionIF;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class LoginManager implements LoginManagerIF{
    
    private UsuariosJpaController ujc;
    private static LoginManager instance;
    
    private LoginManager(){
        ujc = new UsuariosJpaController(Persistence.createEntityManagerFactory("PracticaPruebastwebPUHsql3"));
        
    }
    
    public LoginManager getInstance(){
        if (LoginManager.instance == null)
            LoginManager.instance = new LoginManager();
        return LoginManager.instance;
    }

    @Override
    public UserSessionIF login(String user, String pwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
