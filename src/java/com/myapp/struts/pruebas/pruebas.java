/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.pruebas;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import com.myapp.struts.persistencia.entidades.Usuarios;

/**
 *
 * @author Administrador
 */
public class pruebas {
    public static void main(String[] args){
        EntityManagerFactory em = Persistence.createEntityManagerFactory("PracticaPruebastwebPUHsql3");
        
        UsuariosJpaController ujc = new UsuariosJpaController(em);
        
        Usuarios usu = new Usuarios();
        usu.setApellidos("asdasd");
        usu.setEmail("asdasd");
        usu.setNombre("sadasd");
        usu.setNombreUsuario("javi");
        usu.setPerfil("asndjasdnjasnd");
        usu.setPassword("qwert");
        
        try {
            ujc.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
            LoginManager lm = LoginManager.getInstance();
        }
        
        List<Usuarios> lista = ujc.findUsuariosEntities();
        
        for(Usuarios us: lista){
            System.out.println(us.toString());
        }
    }
}
