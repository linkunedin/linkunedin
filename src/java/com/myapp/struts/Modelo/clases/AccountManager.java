/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
import com.myapp.struts.Modelo.exeptions.UserAlreadyExistsException;
import com.myapp.struts.Modelo.exeptions.UserNotExistsException;
import com.myapp.struts.Modelo.interfaces.AccountManagerIF;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class AccountManager implements AccountManagerIF{
    
    private static AccountManager instance;
    
    private UsuariosJpaController ujc;
    
    private AccountManager(){
        ujc = new UsuariosJpaController(Persistence.createEntityManagerFactory("PracticaPruebastwebPUHsql3"));
    }
    
    public AccountManager getInstance(){
        if (AccountManager.instance == null){
            AccountManager.instance = new AccountManager();
        }
        return AccountManager.instance;
    }

    @Override
    public void alta(Object usuario) throws UserAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void baja(Object usuario) throws UserNotExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modify(Object usuario, Object modifier) throws NotEnoughPrivilegesException, UserNotExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
