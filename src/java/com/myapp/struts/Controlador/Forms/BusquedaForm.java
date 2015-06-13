/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Forms;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * prueba de cambio
 * @author Administrador
 */
public class BusquedaForm extends org.apache.struts.action.ActionForm {
    
    private String titulacion, experiencia, conocimientos, location;
    private java.util.Date fechaNac;
    private String fechaNac2;

    /**
     *
     * @return
     */
    public String getFechaNac2() {
        return fechaNac2;
    }

    /**
     *
     * @param fechaNac2
     */
    public void setFechaNac2(String fechaNac2) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fnac;
        fnac= new java.util.Date();
        
        try{
            fnac = (java.sql.Date) formatter.parse(fechaNac2);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.fechaNac2 = fechaNac2;
        this.fechaNac = fnac;
    }

    /**
     *
     * @return
     */
    public String getTitulacion() {
        return titulacion;
    }

    /**
     *
     * @param titulacion
     */
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    /**
     *
     * @return
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     *
     * @param experiencia
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     *
     * @return
     */
    public String getConocimientos() {
        return conocimientos;
    }

    /**
     *
     * @param conocimientos
     */
    public void setConocimientos(String conocimientos) {
        this.conocimientos = conocimientos;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public  java.util.Date getFechaNac() {
        return fechaNac;
    }

    /**
     *
     * @param fechaNac
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
    /**
     *
     */
    public BusquedaForm(){
        super();
    }
    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        //titulacion, experiencia, conocimientos, location;
       /*9
        if(fechaNac == null || description.equals("")){
              errors.add("fehca", new ActionMessage("error.fecha_invalida"));
        }
        //return errors;
       */
        return errors;
    }
}
