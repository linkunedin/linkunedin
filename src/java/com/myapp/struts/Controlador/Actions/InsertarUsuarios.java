/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.AltaForm;
import com.myapp.struts.Controlador.Forms.EntradaModificarConoForm;
import com.myapp.struts.Modelo.clases.AccountManager;
import com.myapp.struts.Modelo.clases.LoginManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Administrador
 */
public class InsertarUsuarios extends org.apache.struts.action.Action {

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
        AltaForm altaform = new AltaForm(); 
        altaform.setNombre("david");
        altaform.setNomusuario("david");
        altaform.setPassword("david");
        
        AccountManager am = AccountManager.getInstance();
        am.alta(altaform);
        altaform = new AltaForm();
        altaform.setNombre("juan");
        altaform.setNomusuario("juan");
        altaform.setPassword("juan");
        //AccountManager am = AccountManager.getInstance();
        am.alta(altaform);
        altaform = new AltaForm();
        altaform.setNombre("javi");
        altaform.setNomusuario("javi");
        altaform.setPassword("javi");
        //AccountManager am = AccountManager.getInstance();
        am.alta(altaform);
        /*EntradaModificarConoForm cform = new EntradaModificarConoForm();
        cform.setUsername("juan");
        cform.setTitulo("java");
        */
        return mapping.findForward(SUCCESS);
    }
}
