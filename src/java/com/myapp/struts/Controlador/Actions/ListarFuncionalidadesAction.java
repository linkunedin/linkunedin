/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.FuncionalidadesJpaController;
import com.myapp.struts.persistencia.entidades.Funcionalidades;
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
public class ListarFuncionalidadesAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

   
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        FuncionalidadesJpaController funcionalidadesJpa = new FuncionalidadesJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        List<Funcionalidades> listaFuncionalidades = funcionalidadesJpa.findFuncionalidadesEntities();
        request.setAttribute("listaFuncionalidades",listaFuncionalidades);
        return mapping.findForward(SUCCESS);
    }
}
