/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.ExperienciaForm;
import com.myapp.struts.Modelo.clases.ProfilesManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.persistencia.entidades.Usuarios;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Administrador
 */
public class AnadirExpeAction extends org.apache.struts.action.Action {

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
        
        ExperienciaForm formu = (ExperienciaForm) form;
        ProfilesManager pm = ProfilesManager.getInstance();
        ActionErrors ae = new ActionErrors();
        Usuarios us;
        try{
            us = ((UserSession)request.getSession().getAttribute("objsesion")).getUser();
        }catch(Exception e){
            ae.add("login", new ActionMessage("errors.notlogged"));
            this.addErrors(request, ae);
            e.printStackTrace();
            return mapping.findForward(SUCCESS);
        }
        Usuarios objetivo = pm.getProfile(formu.getUsername());
        
        pm.addExperience(objetivo, formu);
        
        return mapping.findForward(SUCCESS);
    }
}
