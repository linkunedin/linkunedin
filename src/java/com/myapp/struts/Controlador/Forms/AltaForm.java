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
public class AltaForm extends org.apache.struts.action.ActionForm {
    
    private String nombre, apellidos, nomusuario, password, email, rutafoto, perfil;

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getRutafoto() {
        return rutafoto;
    }

    /**
     *
     * @param rutafoto
     */
    public void setRutafoto(String rutafoto) {
        this.rutafoto = rutafoto;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
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
        
        if (getNombre() == null || getNombre().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
        }
        if (getEmail() == null || getEmail().length() < 1) {
            errors.add("email", new ActionMessage("error.email.required"));
        }

        if (getPassword() == null || getPassword().length() < 1) {
            errors.add("password", new ActionMessage("error.password.required"));
        }

        if (getApellidos() == null || getApellidos().length() < 1) {
            errors.add("apellidos", new ActionMessage("error.apellidos.required"));
        }

        if (getNomusuario()== null || getNomusuario().length() < 1) {
            errors.add("nomusuario", new ActionMessage("error.nomusuario.required"));
        }

        return errors;
    }
}
