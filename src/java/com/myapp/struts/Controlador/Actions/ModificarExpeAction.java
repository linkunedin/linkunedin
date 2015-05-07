/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.ExperienciaForm;
import com.myapp.struts.Modelo.clases.ProfilesManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.persistencia.entidades.Experiencias;
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
public class ModificarExpeAction extends org.apache.struts.action.Action {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    /**
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ExperienciaForm formu = (ExperienciaForm) form;
        // si ok devolver a la pagina principal
        ProfilesManager pm = ProfilesManager.getInstance();
        UserSession us = (UserSession) request.getSession().getAttribute("objsesion");
        Usuarios usu = us.getUser();
        
        
        try{
            System.out.println("intentando modificar experiencia");
            
            pm.modifyExperience(usu, formu);
            
            System.out.println("experiencia modificada con exito");
        }catch(Exception e){
            e.printStackTrace();
            return mapping.findForward(ERROR);
        }
        
        usu = pm.getProfile(formu.getUsername());
        request.setAttribute("usuperfil", usu);
        
        return mapping.findForward(SUCCESS);
        
    }
}
