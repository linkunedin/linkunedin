/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.EntradaModificarPerfilForm;
import com.myapp.struts.Modelo.clases.AccountManager;
import com.myapp.struts.Modelo.clases.ProfilesManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Administrador
 */
public class VerModificarPerfil extends org.apache.struts.action.Action {

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
        
        EntradaModificarPerfilForm formu = (EntradaModificarPerfilForm) form;
        ActionErrors errors = new ActionErrors();
        ActionMessages amsg = new ActionMessages();
        
        // comprobar si el nombre de usuario es vacio
        if (formu.getNomusuario().equals("")){
            // volver de donde venia
            return mapping.getInputForward();
        }
        
        // comprobar si estamos logeados
        if (request.getSession().getAttribute("objsesion") == null){
            amsg.add("login", new ActionMessage("errors.notlogged"));
            return mapping.getInputForward();
        }
        
        // comprobar si el nombre de usuario se corresponde con alguno
        ProfilesManager pm = ProfilesManager.getInstance();
        Usuarios us = pm.getProfile(formu.getNomusuario());
        if (us == null){
            amsg.add("username", new ActionMessage("errors.profiles.search.notfound"));
            return mapping.getInputForward();
        }
        
        
        Usuarios logeado = ((UserSession)request.getSession().getAttribute("objsesion")).getUser();
        if (!us.equals(logeado) && logeado.getAdmin() == 0){
            // el usuario no coincide y ademas el usuario logeado no es admin
            amsg.add("login", new ActionMessage("errors.notenoughprivileges"));
            return mapping.getInputForward();
        }
        
        // llegados a este punto ha pasado todos los tests y podemos mostrar el formulario ok
        request.setAttribute("perfil", us);
        
        return mapping.findForward(SUCCESS);
    }
}
