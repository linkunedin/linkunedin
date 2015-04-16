/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.interfaces.LoginManagerIF;
import com.myapp.struts.Modelo.interfaces.UserSessionIF;
import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class LoginManager implements LoginManagerIF{
    
    private UsuariosJpaController ujc;
    private static LoginManager instance;
    
    private LoginManager(){
        ujc = new UsuariosJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        
    }
    
    /**
     * 
     * @return LoginManager instance
     */
    public static LoginManager getInstance(){
        if (LoginManager.instance == null)
            LoginManager.instance = new LoginManager();
        return LoginManager.instance;
    }

    /**
     * busca si existe un usuario con el login y la contrasena indicados,
     * si existe genera un objeto UserSession y lo devuelve. 
     * Si no existe devuelve NULL
     * @param user
     * @param pwd
     * @return UserSession
     */
    @Override
    public UserSessionIF login(String user, String pwd) {
        List<Usuarios> usuarios = ujc.findUsuarioByUserPwd(user, pwd);
        if (usuarios.size() == 0){
            // no existe ningun usuario con ese nombre de usuario y password
            return null; 
        }
        else{
            // construimos un usersession
            UserSession us = new UserSession();
            us.setUser(usuarios.get(0));
            return us;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean logout() {
        //esta funcion aqui no tiene mucho sentido. habra que valorar si la quitamos
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
