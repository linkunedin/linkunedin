/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.ExperienciaForm;
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
        if (true) {
            return mapping.findForward(SUCCESS);
        } // si no ok devolver a la misma pagina de alta
        else {
            return mapping.findForward(ERROR);
        }
    }
}
