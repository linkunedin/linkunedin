/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.EntradaModificarPerfilForm;
import com.myapp.struts.Modelo.clases.LoginManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.persistencia.entidades.Usuarios;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Administrador
 */
public class ModificarPerfilAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        EntradaModificarPerfilForm empf = (EntradaModificarPerfilForm) form;
        
        try{
           UserSession us = (UserSession)  request.getSession().getAttribute("objsesion");
           Usuarios usuario = us.getUser();
           
        }
        catch(Exception e){}
        // comprobar logeo

        // comprobar si existe el id de usuario
      
        // si no existe devolver mensaje de error indicando que no existe
        
        // si el usuario indicado no es el mismo que el logeado comprobamos si es admin
        // si es admin mostrmos el perfil del usuario para modificar
        // sino se le devuelve un mensaje indicando que no tiene permisos suficientes
        
        
        return mapping.findForward(SUCCESS);
    }
}
