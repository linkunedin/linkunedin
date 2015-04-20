/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.pruebas;

import com.myapp.struts.Modelo.clases.LoginManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.InteresesJpaController;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import com.myapp.struts.persistencia.entidades.Intereses;
import com.myapp.struts.persistencia.entidades.Usuarios;
import com.myapp.struts.pruebas.integracion.AccountManagerTest;
import java.util.ArrayList;
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
        InteresesJpaController ijc = new InteresesJpaController(em);
        
        ArrayList<Intereses> ari = new ArrayList();
        
        Intereses interes = new Intereses();
        interes.setTitulo("polka");
        
        ari.add(interes);
        
        Usuarios usu = new Usuarios();
        usu.setApellidos("asdasd");
        usu.setEmail("asdasd");
        usu.setNombre("sadasd");
        usu.setNombreUsuario("javi");
        usu.setPerfil("asndjasdnjasnd");
        usu.setPassword("qwert");
        usu.setRutafoto("asdas/dasdas/dad");
        usu.setLocation("Cospeito");
        usu.setFechaNac(new java.sql.Date(11,11,00));
        usu.setInteresesCollection(ari);
        
                

        
        
        
        
        try {
            ijc.create(interes);
            ujc.create(usu);  
            LoginManager lm = LoginManager.getInstance();
            UserSession us = (UserSession) lm.login("javi", "qwert");
            System.out.println(us.getHashSessionDigest());
            System.out.println(us.getUser().toString());
        } catch (Exception ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        List<Usuarios> usus = ujc.findUsuarioByConocimientos("polka");
        if (usus.size() == 0){
        System.out.println("ni dios");
        }
        System.out.println(usus.toString());
        
       // AccountManagerTest test = new AccountManagerTest();
       // test.testAltaBaja();
       // test.testModificar();
        
        
    }
}
