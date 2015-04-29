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

  
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            
            
        
            BusquedaForm busquedaForm = (BusquedaForm)form;
            System.out.println(busquedaForm.getConocimientos());
            
            UsuariosJpaController usuariosJpa = new UsuariosJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
            List<Usuarios> listaUsuarios =  usuariosJpa.findUsuariosEntities();
            // fixme juan es para probar findUsuarioByNombreUsuario
            if(busquedaForm.getExperiencia()!= ""){
                listaUsuarios = usuariosJpa.findUsuarioByNombreUsuario(busquedaForm.getExperiencia());
            }
            else if(busquedaForm.getConocimientos()!= ""){
                listaUsuarios = usuariosJpa.findUsuarioByConocimientos(busquedaForm.getConocimientos());
            }
           /* else if(busquedaForm.getTitulacion()!= ""){
                listaUsuarios = usuariosJpa.(busquedaForm.getTitulacion());
            }*/
            else if(busquedaForm.getLocation()!= ""){
                listaUsuarios = usuariosJpa.findUsuarioByLocation(busquedaForm.getLocation());
            }
            request.setAttribute("listaUsuarios",listaUsuarios);
            
        
        return mapping.findForward(SUCCESS);
    }
}
