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
public class ExperienciaForm extends org.apache.struts.action.ActionForm {
    
    private String empresa, puesto, /*actividades, */descripcion, fechainicio, fechafin;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }


    /**
     *
     */
    public ExperienciaForm() {
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
        
                
        if (getEmpresa() == null || getEmpresa().length() < 1) {
            errors.add("empresa", new ActionMessage("error.empresa.required"));
        }
        if (getPuesto() == null || getPuesto().length() < 1) {
            errors.add("puesto", new ActionMessage("error.puesto.required"));
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
