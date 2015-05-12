/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.EntradaModificarPerfilForm;
import com.myapp.struts.Modelo.clases.LoginManager;
import com.myapp.struts.Modelo.clases.ProfilesManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
import com.myapp.struts.Modelo.exeptions.ProfileNotExistsException;
import com.myapp.struts.persistencia.entidades.Usuarios;
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
        ActionErrors ae = new ActionErrors();
        Usuarios usuario;
        
        try{
           UserSession us = (UserSession)  request.getSession().getAttribute("objsesion");
           usuario = us.getUser();
           
        }
        catch(Exception e){
            // no esta logeado? 
            ae.add("login", new ActionMessage("errors.notlogged"));
            this.addErrors(request, ae);
            e.printStackTrace();
            return mapping.findForward(SUCCESS);
        }
        
        ProfilesManager pm = ProfilesManager.getInstance();
        try{
            pm.modifyProfile(usuario, empf);
        }
        catch(ProfileNotExistsException | NotEnoughPrivilegesException e){
            ae.add("login", new ActionMessage("errors.notallowed"));
            this.addErrors(request, ae);
            e.printStackTrace();
            return mapping.findForward(SUCCESS);
        }
        //
        // si es el mismo usuario hay que actualizar la info de logeo
        if (empf.getNomusuario().equals(usuario.getNombreUsuario())){
            Usuarios nusu = pm.getProfile(usuario.getNombreUsuario());
            LoginManager lm = LoginManager.getInstance();
            UserSession us = (UserSession) lm.login(nusu.getNombreUsuario(), nusu.getPassword());
            request.getSession().setAttribute("objsesion", us);
        }
        
        usuario = pm.getProfile(empf.getNomusuario());
        request.setAttribute("usuperfil", usuario);
        
        return mapping.findForward(SUCCESS);
    }
}
