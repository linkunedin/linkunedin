/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.pruebas;

import com.myapp.struts.Modelo.clases.LoginManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class pruebas {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        EntityManagerFactory em = Persistence.createEntityManagerFactory(Configuration.getPu());
        
        UsuariosJpaController ujc = new UsuariosJpaController(em);
        
        Usuarios usu = new Usuarios();
        usu.setApellidos("asdasd");
        usu.setEmail("asdasd");
        usu.setNombre("sadasd");
        usu.setNombreUsuario("javi");
        usu.setPerfil("asndjasdnjasnd");
        usu.setPassword("qwert");
        usu.setRutafoto("asdas/dasdas/dad");
        
        
        try {
            ujc.create(usu);
            LoginManager lm = LoginManager.getInstance();
            UserSession us = (UserSession) lm.login("javi", "qwert");
            System.out.println(us.getHashSessionDigest());
            System.out.println(us.getUser().toString());
        } catch (Exception ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }
}
