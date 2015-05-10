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
 * @author david
 */
public class BajaForm extends org.apache.struts.action.ActionForm {
    private String nombre, apellidos, nomusuario, password, email, rutafoto,error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     *
     * @return
     */
    public String getNomusuario() {
        return nomusuario;
    }

    /**
     *
     * @param nomusuario
     */
    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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

        if (getPassword() == null || getPassword().length() < 1) {
            errors.add("password", new ActionMessage("error.password.required"));
        }

        if (getNomusuario() == null || getNomusuario().length() < 1) {
            errors.add("nomusuario", new ActionMessage("error.nomusuario.required"));
        }

        return errors;
    }
}   
