/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Administrador
 */
public class EducacionForm extends org.apache.struts.action.ActionForm {
    
    private String centro, titulo, /*act,*/ descripcion, fechafin, fechainicio;

    /**
     *
     * @return
     */
    public String getCentro() {
        return centro;
    }

    /**
     *
     * @param centro
     */
    public void setCentro(String centro) {
        this.centro = centro;
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     *
     * @param fechafin
     */
    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    /**
     *
     * @return
     */
    public String getFechainicio() {
        return fechainicio;
    }

    /**
     *
     * @param fechainicio
     */
    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }
    
    

    /**
     *
     */
    public EducacionForm() {
        super();
        // TODO Auto-generated constructor stub
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
        
        if (getCentro() == null || getCentro().length() < 1) {
            errors.add("centro", new ActionMessage("error.centro.required"));
        }
        if (getTitulo() == null || getTitulo().length() < 1) {
            errors.add("titulo", new ActionMessage("error.titulo.required"));
        }

        if (getDescripcion() == null || getDescripcion().length() < 1) {
            errors.add("descripcion", new ActionMessage("error.descripcion.required"));
        }

        if (getFechainicio() == null || getFechainicio().length() < 1) {
            errors.add("fechainicio", new ActionMessage("error.fechainicio.required"));
        }

        if (getFechafin()== null || getFechafin().length() < 1) {
            errors.add("fechafin", new ActionMessage("error.fechafin.required"));
        }

        
        return errors;
    }
}
