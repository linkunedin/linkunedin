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
public class FuncionalidadForm extends org.apache.struts.action.ActionForm {
    
    private String funcionalidad, estado;

    /**
     *
     * @return
     */
    public String getFuncionalidad() {
        return funcionalidad;
    }

    /**
     *
     * @param funcionalidad
     */
    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    /**
     *
     */
    public FuncionalidadForm() {
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
                
        if (getEstado() == null || getEstado().length() < 1) {
            errors.add("estado", new ActionMessage("error.estado.required"));
        }
        if (getFuncionalidad() == null || getFuncionalidad().length() < 1) {
            errors.add("titulo", new ActionMessage("error.titulo.required"));
        }


        
        return errors;
    }
}
