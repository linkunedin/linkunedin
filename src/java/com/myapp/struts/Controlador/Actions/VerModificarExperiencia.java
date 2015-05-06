/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.ExperienciaForm;
import com.myapp.struts.Modelo.clases.ProfilesManager;
import com.myapp.struts.persistencia.entidades.Experiencias;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author david
 */
public class VerModificarExperiencia extends org.apache.struts.action.Action {

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
        System.out.println("akdnajsdn");
        ExperienciaForm formu = (ExperienciaForm) form;
        ProfilesManager pm = ProfilesManager.getInstance();
        
        Experiencias exp = pm.getExperience(Integer.parseInt(formu.getIdexp()));

        if (exp == null){
                    System.out.println("exp == null");
            return mapping.getInputForward();
        }else{
                System.out.println("!exp == null");
        }
        request.setAttribute("experiencia", exp);
        
        return mapping.findForward(SUCCESS);
    }
}
