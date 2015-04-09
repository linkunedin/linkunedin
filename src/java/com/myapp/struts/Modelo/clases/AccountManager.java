/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Controlador.Forms.AltaForm;
import com.myapp.struts.Controlador.Forms.PerfilCompletoForm;
import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
import com.myapp.struts.Modelo.exeptions.UserAlreadyExistsException;
import com.myapp.struts.Modelo.exeptions.UserNotExistsException;
import com.myapp.struts.Modelo.interfaces.AccountManagerIF;
import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import com.myapp.struts.persistencia.controladores.exceptions.NonexistentEntityException;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class AccountManager implements AccountManagerIF{
    
    private static AccountManager instance;
    
    private UsuariosJpaController ujc;
    
    private AccountManager(){
        ujc = new UsuariosJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
    }
    
    /**
     *
     * @return
     */
    public static AccountManager getInstance(){
        if (AccountManager.instance == null){
            AccountManager.instance = new AccountManager();
        }
        return AccountManager.instance;
    }

    @Override
    public void alta(Object usuario) throws UserAlreadyExistsException {
        AltaForm form = (AltaForm) usuario;
        List<Usuarios> lista = ujc.findUsuarioByNombreUsuario(form.getNomusuario());
        if (lista.size() > 0)   // ya existe
            throw new UserAlreadyExistsException();
        
        Usuarios usu = new Usuarios();
        usu.setNombre(form.getNombre());
        usu.setApellidos(form.getApellidos());
        usu.setEmail(form.getEmail());
        usu.setPassword(form.getPassword());
        usu.setRutafoto(form.getRutafoto());
        usu.setNombreUsuario(form.getNomusuario());
        usu.setPerfil("");
        usu.setAdmin((short)0);
        
        ujc.create(usu);
        
    }

    @Override
    public void baja(Object usuario) throws UserNotExistsException {
        String user = (String) usuario;
        List<Usuarios> usuarios = ujc.findUsuarioByNombreUsuario(user);
        if (usuarios.size() == 0)
            throw new UserNotExistsException();
        
        Usuarios usu = usuarios.get(0);
        try {
            ujc.destroy(usu.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modify(Object usuario, Object modifier) throws NotEnoughPrivilegesException, UserNotExistsException {
        
        // hacer comprobaciones de permisos?
        
        // modificar
        
        AltaForm form = (AltaForm) usuario;
        List<Usuarios> lista = ujc.findUsuarioByNombreUsuario(form.getNomusuario());
        if (lista.size() == 0)   // no existe
            throw new UserNotExistsException();
        
        Usuarios usu = lista.get(0);
        usu.setNombre(form.getNombre());
        usu.setApellidos(form.getApellidos());
        usu.setEmail(form.getEmail());
        usu.setPassword(form.getPassword());
        usu.setRutafoto(form.getRutafoto());
        usu.setNombreUsuario(form.getNomusuario());
        usu.setPerfil(form.getPerfil());
        usu.setAdmin((short)0);
        
        try {
            ujc.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
