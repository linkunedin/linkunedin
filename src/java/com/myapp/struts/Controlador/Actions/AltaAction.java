/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.AltaForm;
import com.myapp.struts.Modelo.clases.AccountManager;
import com.myapp.struts.Modelo.clases.LoginManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.Modelo.exeptions.UserAlreadyExistsException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Administrador
 */
public class AltaAction extends org.apache.struts.action.Action {

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
        AltaForm altaform = (AltaForm) form; 

        UserSession us;
        // comprobar si existe usuario
        AccountManager am = AccountManager.getInstance();
        LoginManager lm = LoginManager.getInstance();
        try{
            am.alta(form);
            
            us = (UserSession) lm.login(altaform.getNomusuario(),altaform.getPassword());
        }catch(UserAlreadyExistsException ex){
            altaform.setError("Error : el usuario ya existe");
            return mapping.findForward(ERROR);
        }
        
        if (us == null){
            System.out.println("Error al logear el nuevo alta");
            return mapping.findForward(ERROR);
        }else{
           request.getSession().setAttribute("objsesion", us);
        }
        
        
        // esto es un cambio de prueba
        // crear usuario si no existe
        
        // si ok devolver a la pagina principal
        return mapping.findForward(SUCCESS);
        
        // prueba cambio
        // asdsad asd
    }
}
