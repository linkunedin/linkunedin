/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.BusquedaForm;
import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author juan
 */
public class BuscarAction extends org.apache.struts.action.Action {

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
        
        
            BusquedaForm busquedaForm = (BusquedaForm)form;
            System.out.println(busquedaForm.getConocimientos());
            UsuariosJpaController usuariosJpa = new UsuariosJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
            List<Usuarios> listaUsuarios = usuariosJpa.findUsuarioByConocimientos(busquedaForm.getConocimientos());
            request.getSession().setAttribute("listaUsuarios",listaUsuarios);
            /*
            Claim claim = ModelFacade.createClaim(claimBean);
            request.setAttribute("claim", claim);
            if(claim == null)
            {
             return mapping.findForward("notfound");
            }
            else
            {
             Policy policy = claim.getPolicy();
             request.setAttribute("policy", policy);
             return mapping.findForward("found");
            }
        */
        return mapping.findForward(SUCCESS);
    }
}
