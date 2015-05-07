/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.EducacionForm;
import com.myapp.struts.Controlador.Forms.ExperienciaForm;
import com.myapp.struts.Modelo.clases.ProfilesManager;
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
public class ModificarEducacionAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

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
        System.out.println("bienvenidos a una funcion absurda");
       EducacionForm formu = (EducacionForm) form;
        // si ok devolver a la pagina principal
        ProfilesManager pm = ProfilesManager.getInstance();
        UserSession us = (UserSession) request.getSession().getAttribute("objsesion");
        if (us == null){
           System.out.println("null");
        }
        Usuarios usu = us.getUser();
        
        System.out.println("Esto es absurdo");
        try{
            System.out.println("antes de pm.modifyEducation");
            pm.modifyEducation(usu, formu);
            
            System.out.println("try modifyEducation");
        }catch(Exception e){
            e.printStackTrace();
            return mapping.findForward(ERROR);
        }
        
        usu = pm.getProfile(formu.getUsername());
        request.setAttribute("usuperfil", usu);
        System.out.println("Imprimo formu modificaEdu");
        System.out.println(formu.toString());
        return mapping.findForward(SUCCESS);
        
    }
    
}
