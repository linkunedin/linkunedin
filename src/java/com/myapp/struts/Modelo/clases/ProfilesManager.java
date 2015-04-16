/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Controlador.Forms.*;
import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
import com.myapp.struts.Modelo.exeptions.ProfileAlreadyExistsException;
import com.myapp.struts.Modelo.exeptions.ProfileNotExistsException;
import com.myapp.struts.Modelo.interfaces.CriteriaIF;
import com.myapp.struts.Modelo.interfaces.ProfilesManagerIF;
import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.*;
import com.myapp.struts.persistencia.entidades.Educacion;
import com.myapp.struts.persistencia.entidades.Experiencias;
import com.myapp.struts.persistencia.entidades.Intereses;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    /**
     *
     * @return
     */
        
    public static ProfilesManager getInstance(){
        if (ProfilesManager.instance == null){
            ProfilesManager.instance = new ProfilesManager();
            
        }
        return ProfilesManager.instance;
    }
    
    private ProfilesManager(){
        ujc = new UsuariosJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        ejc = new ExperienciasJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        ijc = new InteresesJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        edujc = new EducacionJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        
    }
    


    /**
     * esta funcion no tiene mucho sentido 
     * @deprecated
     * @param user
     * @param profile
     * @throws ProfileAlreadyExistsException
     */
        @Override
    public void createProfile(Object user, Object profile) throws ProfileAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param modifier  este parametro hay que pillarlo de la sesion (Usuarios)
     * @param profile PerfilCompletoForm
     * @throws ProfileNotExistsException
     */
    @Override
    public void modifyProfile(Object modifier, Object profile) throws ProfileNotExistsException, NotEnoughPrivilegesException {
        
        // si usuario nulo o no hay privilegios lanzara excepcion
        canModify(modifier, ((PerfilCompletoForm)profile).getNomusuario());
        // si pasamos de aqui es porque podemos proceder a modificar
        
        String userm = (String) modifier;
        PerfilCompletoForm formu = (PerfilCompletoForm) profile;
        
        // primero comprobamos que el usuario tiene permisos (es admin)
        // o bien es el mismo usuario
        Usuarios us = (Usuarios) modifier;
        
        us.setApellidos(formu.getApellidos());
        us.setEmail(formu.getEmail());
        us.setNombre(formu.getNombre());
        us.setPerfil(formu.getPerfil());
        us.setRutafoto(formu.getFoto()); // no existe en formu?
        // a Usuarios le falta el campo Pdf, se lo anado
        us.setPdf(formu.getPdf());
        
        try {
            ujc.edit(us);
        } catch (Exception ex) {
            Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     *
     * @param modifier
     * @param profile
     * @throws ProfileNotExistsException
     * @throws NotEnoughPrivilegesException
     */
    @Override
    public void deleteProfile(Object modifier, Object profile) throws ProfileNotExistsException, NotEnoughPrivilegesException {
        
        // si usuario nulo o no hay privilegios lanzara excepcion
        canModify(modifier, ((PerfilCompletoForm)profile).getNomusuario());
        // si pasamos de aqui es porque podemos proceder a modificar
        
        Usuarios us = (Usuarios) modifier;
        us.setNombre("");
        us.setPerfil("");
        us.setPdf("");
        us.setEmail("");
        us.setRutafoto("");
        
        /**
         * funcionara esto? eliminara las relaciones?
         */
        us.setEducacionCollection(null);    // funcionara esto? eliminara las relaciones?
        us.setEntidadesCollection(null);
        us.setExperienciasCollection(null);
        us.setInteresesCollection(null);
        try {
            //
            ujc.edit(us);
        } catch (Exception ex) {
            Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * esta funcion queda sin implementar. es del principio cuando se consideró la entidad
     * Profile de forma separada. Ahora ya no tiene sentido.
     * @deprecated 
     * @param profileid
     * @return
     */
    @Override
    public Object getProfile(int profileid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * 
     * @param username
     * @return 
     */
    public Usuarios getProfile(String username){
        List<Usuarios> lus = ujc.findUsuarioByNombreUsuario(username);
        if (lus.size() == 0)
            return null;
        
        return lus.get(0);
    }

    /**
     *  aqui deberia haber un form en la entrada. igual el formulario de la busqueda 
     * de perfiles
     * @param criteria
     * @return
     */
    @Override
    public List<Object> getProfiles(List<CriteriaIF> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * 
     * @param modifier
     * @param profile
     * @return true si el usuario tiene permisos
     * @throws ProfileNotExistsException
     * @throws NotEnoughPrivilegesException 
     */
    public boolean canModify(Object modifier, Object profile) throws ProfileNotExistsException, NotEnoughPrivilegesException {
        String userm = (String) modifier;
        //PerfilCompletoForm formu = (PerfilCompletoForm) profile;
        String name = (String) profile;
        
        // primero comprobamos que el usuario tiene permisos (es admin)
        // o bien es el mismo usuario
        Usuarios us = (Usuarios) modifier;
        if (us == null)
            throw new ProfileNotExistsException();
        
        if ( !us.getNombreUsuario().equals(profile) ){
            if (us.getAdmin() != 1){
                throw new NotEnoughPrivilegesException();
            }
        }
        
        Usuarios usu = getProfile(name);
        if (usu == null)
            throw new ProfileNotExistsException();
        
        /**
         * si llegamos hasta aqui es que el usuario que va amodificar es el mismo
         * o bien que el usuario es admin
         */
        
        return true;
    }
    
    public void addExperience(Object modifier, ExperienciaForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException{
        canModify(modifier, formu.getUsername());
        
        Usuarios usu = getProfile(formu.getUsername());
        
        
        String user = (String) modifier;
        Experiencias exp = new Experiencias();
        // TODO: arreglar eso
        //exp.setActividades(formu.get);    // no tiene actividades
        exp.setDescripcion(formu.getDescripcion());
        exp.setEmpresa(formu.getEmpresa());
        exp.setFechaFin(new Date(formu.getFechafin()));
        exp.setFechaInicio(new Date(formu.getFechainicio()));
        exp.setPuesto(formu.getPuesto());
        exp.setUsuarioId(usu);      // ¿?¿?¿?¿?
        exp.setValido((short)1);
        
        ejc.create(exp);
        
    }
    
    public void addEducation(Object modifier, EducacionForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException{
        canModify(modifier, formu.getUsername());
        
        Usuarios usu = getProfile(formu.getUsername());
        
        String user = (String) modifier;
        Educacion edu = new Educacion();
        // TODO: arreglar eso
        //edu.setActividades(formu.get);    // formulario no tiene campo actividades
        edu.setCentroEstudios(formu.getCentro());
        edu.setDescripcion(formu.getDescripcion());
        edu.setFechaFin(new Date(formu.getFechafin()));
        edu.setFechaInicio(new Date(formu.getFechainicio()));
        edu.setTitulacion(formu.getTitulo());
        edu.setUsuarioId(usu);
        edu.setValido((short)1);
        
        edujc.create(edu);
        
    }
    
    public void addKnowledge(Object modifier, EntradaModificarConoForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException{
        canModify(modifier, formu.getUsername());
        
        
        Usuarios usu = getProfile(formu.getUsername());
        String user = (String) modifier;
        
        // se trata de una relacion M:N. primero comprobar si existe.
        // si no existe crearla
        List<Intereses> lint = ijc.fingInteresesByTitulo(formu.getTitulo());
        
        if (lint.size() == 0){
            // no existe el interes -> crearlo
            Intereses inter = new Intereses();
            inter.setDescripcion(formu.getDescripcion());
            inter.setTitulo(formu.getTitulo());
            inter.setValido((short) 1);
            ArrayList<Usuarios> lusu = new ArrayList<Usuarios>();
            lusu.add(usu);
            inter.setUsuariosCollection(lusu);
            ijc.create(inter);
        }
        else{
            // existe -> añadirle el usuario y guardar
            Intereses inter = lint.get(0);
            inter.getUsuariosCollection().add(usu);
            try {
                ijc.edit(inter);
            } catch (Exception ex) {
                Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
    public void delExperience(Object modifier, ExperienciaForm formu){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void delEducation(Object modifier, EducacionForm formu){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void delKnowledge(Object modifier, EntradaModificarConoForm formu){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // faltarian metodos para modificar
    
    
}
