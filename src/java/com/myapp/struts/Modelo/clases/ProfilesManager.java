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
import com.myapp.struts.persistencia.controladores.exceptions.*;
import com.myapp.struts.persistencia.controladores.exceptions.NonexistentEntityException;
import com.myapp.struts.persistencia.entidades.Educacion;
import com.myapp.struts.persistencia.entidades.Experiencias;
import com.myapp.struts.persistencia.entidades.Intereses;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * @param profile EntradaModificarPerfilForm
     * @throws ProfileNotExistsException
     */
    @Override
    public void modifyProfile(Object modifier, Object profile) throws ProfileNotExistsException, NotEnoughPrivilegesException {
        
        // si usuario nulo o no hay privilegios lanzara excepcion
        canModify(modifier, ((EntradaModificarPerfilForm)profile).getNomusuario());
        // si pasamos de aqui es porque podemos proceder a modificar
        
        //String userm = (Usuarios) modifier;
        EntradaModificarPerfilForm formu = (EntradaModificarPerfilForm) profile;
        
        // primero comprobamos que el usuario tiene permisos (es admin)
        // o bien es el mismo usuario
        //Usuarios us = (Usuarios) modifier;
        Usuarios us = getProfile(formu.getNomusuario());
        
        us.setApellidos(formu.getApellidos());
        us.setEmail(formu.getEmail());
        us.setNombre(formu.getNombre());
        us.setPerfil(formu.getPerfil());
        us.setRutafoto(formu.getFoto()); // no existe en formu?
        // a Usuarios le falta el campo Pdf, se lo anado
        us.setPdf(formu.getPdf());
        us.setPassword(formu.getPassword());
        us.setLocation(formu.getLocation());
        /*java.sql.Date fecha = new java.sql.Date(Integer.parseInt(formu.getAno()), 
                Integer.parseInt(formu.getMes()), Integer.parseInt(formu.getDia()));*/
        System.out.println("formu");
        System.out.println(formu.getFechaNac());
        java.sql.Date fecha = new java.sql.Date(formu.getFechaNac().getTime());
        us.setFechaNac(fecha);
        System.out.println("fecha");
        System.out.println(fecha);
        
        
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
        canModify(modifier, ((EntradaModificarPerfilForm)profile).getNomusuario());
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
    public List<Usuarios> getProfiles(BusquedaForm formu) {
     ArrayList <Usuarios> aus = new ArrayList();
     List<Usuarios> lus = ujc.findUsuarioByLocation(formu.getLocation());
     
     if (!(formu.getLocation().equals(""))){
        lus = ujc.findUsuarioByLocation(formu.getLocation());
        aus.addAll(lus);
     }
     
     if (!(formu.getConocimientos().equals(""))){
        lus = ujc.findUsuarioByConocimientos(formu.getConocimientos());
        aus.addAll(lus);        
     }
     
     if (!(formu.getExperiencia().equals(""))){
        lus = ujc.findUsuarioByExperiencia(formu.getExperiencia());
        aus.addAll(lus);
     }
     
     if (!(formu.getTitulacion().equals(""))){
        //lus = ujc.f(formu.getExperiencia());
        aus.addAll(lus);
     }

     if (!(formu.getFechaNac2().equals(""))){    
        lus = ujc.findUsuarioByFechaNac(new java.sql.Date(formu.getFechaNac().getYear(),formu.getFechaNac().getMonth(),formu.getFechaNac().getDay()));
        aus.addAll(lus);
     }
     
     
    /* List<Usuarios> lus = ujc.findUsuarioByLocation(formu.getLocation());
        if (lus.size() == 0)
            return null;
      */  
        return aus;   
     //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //String userm = (String) modifier;
        //PerfilCompletoForm formu = (EntradaModificarPerfilForm) profile;
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
    
    public void addExperience(Object modifier, ExperienciaForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException, ParseException{
        canModify(modifier, formu.getUsername());
        
        Usuarios usu = getProfile(formu.getUsername());
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dfin, dffin;
        dffin = formatter.parse(formu.getFechafin());
        dfin = formatter.parse(formu.getFechainicio());
        
        String user = ((Usuarios) modifier).getNombreUsuario();
        Experiencias exp = new Experiencias();
        // TODO: arreglar eso
        //exp.setActividades(formu.get);    // no tiene actividades
        exp.setDescripcion(formu.getDescripcion());
        exp.setEmpresa(formu.getEmpresa());
        exp.setFechaFin(dffin);
        exp.setFechaInicio(dfin);
        exp.setPuesto(formu.getPuesto());
        exp.setUsuarioId(usu);      // ¿?¿?¿?¿?
        exp.setValido((short)1);
        System.out.println("intentando crear experiencia " + exp.toString());
        /*ArrayList<Experiencias> el = new ArrayList();
        el.add(exp);*/
        //usu.getExperienciasCollection().add(exp);
        //System.out.println(usu);
        try {
            ejc.create(exp);
            //System.out.println(ujc.findUsuariosEntities());
            //System.out.println(ujc.findUsuarios(usu.getId()));
            System.out.println(ujc.findUsuarioByNombreUsuario(usu.getNombreUsuario()));
        } catch (Exception ex) {
            Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //ejc.create(exp);
        //System.out.println("creada experiencia :" /*+ getProfile(usu.getNombreUsuario()).toString()*/ + exp.toString());
    }
    
    public void addEducation(Object modifier, EducacionForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException, ParseException{
        canModify(modifier, formu.getUsername());
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dfin, dffin;
        dffin = formatter.parse(formu.getFechafin());
        dfin = formatter.parse(formu.getFechainicio());        
        String user = ((Usuarios) modifier).getNombreUsuario();
        
        Usuarios usu = getProfile(formu.getUsername());
        
        
        Educacion edu = new Educacion();
        // TODO: arreglar eso
        //edu.setActividades(formu.get);    // formulario no tiene campo actividades
        edu.setCentroEstudios(formu.getCentro());
        edu.setDescripcion(formu.getDescripcion());
        edu.setFechaFin(dffin);
        edu.setFechaInicio(dfin);
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
    
    public void delExperience(Object modifier, ExperienciaForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException, NonexistentEntityException{
        canModify(modifier, formu.getUsername());
        Usuarios usu = getProfile(formu.getUsername());
        //String user = (String) modifier;
        
        ejc.destroy(Integer.parseInt(formu.getIdexp()));
        
    }
    
    public void delEducation(Object modifier, EducacionForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException, NonexistentEntityException{
        canModify(modifier, formu.getUsername());
        Usuarios usu = getProfile(formu.getUsername());
        //String user = (String) modifier;
        
        edujc.destroy(Integer.parseInt(formu.getId()));
    }
    
    public void delKnowledge(Object modifier, EntradaModificarConoForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException, NonexistentEntityException{
        canModify(modifier, formu.getUsername());
        Usuarios usu = getProfile(formu.getUsername());
        //String user = (String) modifier;
        
        ijc.destroy(Integer.parseInt(formu.getId()));
    }
    
    // faltarian metodos para modificar
    
    
    public void modifyExperience(Object modifier, ExperienciaForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException{
        canModify(modifier, formu.getUsername());
        
        Usuarios usu = getProfile(formu.getUsername());
        
        
        Usuarios user = (Usuarios) modifier;
        Experiencias exp = ejc.findExperiencias(Integer.parseInt(formu.getIdexp()));
        // TODO: arreglar eso
        //exp.setActividades(formu.get);    // no tiene actividades
        exp.setDescripcion(formu.getDescripcion());
        exp.setEmpresa(formu.getEmpresa());
        exp.setFechaFin(new Date(formu.getFechafin()));
        exp.setFechaInicio(new Date(formu.getFechainicio()));
        exp.setPuesto(formu.getPuesto());
        exp.setUsuarioId(usu);      // ¿?¿?¿?¿?
        exp.setValido((short)1);
        try {
            ejc.edit(exp);
        } catch (Exception ex) {
            Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifyEducation(Object modifier, EducacionForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException{
        canModify(modifier, formu.getUsername());
        
        Usuarios usu = getProfile(formu.getUsername());
        
        String user = (String) modifier;
        Educacion edu = edujc.findEducacion(Integer.parseInt(formu.getId()));
        // TODO: arreglar eso
        //edu.setActividades(formu.get);    // formulario no tiene campo actividades
        edu.setCentroEstudios(formu.getCentro());
        edu.setDescripcion(formu.getDescripcion());
        edu.setFechaFin(new Date(formu.getFechafin()));
        edu.setFechaInicio(new Date(formu.getFechainicio()));
        edu.setTitulacion(formu.getTitulo());
        //edu.setUsuarioId(usu);
        //edu.setValido((short)1);
        
        try {
            edujc.edit(edu);
        } catch (Exception ex) {
            Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifyKnowledge(Object modifier, EntradaModificarConoForm formu) throws ProfileNotExistsException, NotEnoughPrivilegesException, NonexistentEntityException{
        canModify(modifier, formu.getUsername());
        
        
        Usuarios usu = getProfile(formu.getUsername());
        String user = (String) modifier;
        
        // se trata de una relacion M:N. primero comprobar si existe.
        // si no existe lanzar error
        List<Intereses> lint = ijc.fingInteresesByTitulo(formu.getTitulo());
        
        if (lint.size() == 0){
            // no existe el interes -> crearlo
            throw new NonexistentEntityException("Specified knowledge does not exist");
        }
        else{
            // existe -> añadirle el usuario y guardar
            Intereses inter = lint.get(0);
            inter.setDescripcion(formu.getDescripcion());
            inter.setTitulo(formu.getTitulo());
            try {
                ijc.edit(inter);
            } catch (Exception ex) {
                Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Experiencias getExperience(int id){
        return this.ejc.findExperiencias(id);
    }
    
}
