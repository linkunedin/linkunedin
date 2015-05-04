/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Forms;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * prueba de cambio
 * @author Administrador
 */
public class BusquedaForm extends org.apache.struts.action.ActionForm {
    
    private String titulacion, experiencia, conocimientos, location;
    private java.sql.Date fechaNac;
    // si intenta validar la fecha
    private boolean fechaIntento = false;
    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }


    public String getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(String conocimientos) {
        this.conocimientos = conocimientos;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fecha)  {
        //SimpleDateFormat formatter = 
       // Date fecha = null;
        fechaIntento = true;
        try{
            this.fechaNac = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
            
        }
        
        catch (ParseException ex) {
            Logger.getLogger(BusquedaForm.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(BusquedaForm.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error fecha");
            
        }
        //this.fechaNac = fechaNac; 
        
        
    }
    
    
    /**
     *
     */
    public BusquedaForm(){
        super();
    }
    
   
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
       
        ActionErrors errors = new ActionErrors();
        //titulacion, experiencia, conocimientos, location;
       /*9
        if(fechaNac == null || description.equals("")){
              errors.add("fehca", new ActionMessage("error.fecha_invalida"));
        }
        //return errors;
       */
       
        if(fechaIntento){
            
            errors.add("fechaNac",new ActionMessage("errors.fecha_invalida"));
        }
        return errors;
    }

    
   
}
