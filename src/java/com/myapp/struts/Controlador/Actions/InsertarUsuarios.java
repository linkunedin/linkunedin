/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.AltaForm;
import com.myapp.struts.Controlador.Forms.EducacionForm;
import com.myapp.struts.Controlador.Forms.ExperienciaForm;
import com.myapp.struts.Modelo.clases.AccountManager;
import com.myapp.struts.Modelo.clases.ProfilesManager;
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
        altaform.setAdmin("1");
        
        
        AccountManager am = AccountManager.getInstance();
        am.alta(altaform);
        altaform = new AltaForm();
        altaform.setNombre("juan");
        altaform.setNomusuario("juan");
        altaform.setPassword("juan");
        altaform.setAdmin("0");
        //AccountManager am = AccountManager.getInstance();
        am.alta(altaform);
        altaform = new AltaForm();
        altaform.setNombre("javi");
        altaform.setNomusuario("javi");
        altaform.setPassword("javi");
        altaform.setAdmin("0");
        //AccountManager am = AccountManager.getInstance();
        am.alta(altaform);
        /*EntradaModificarConoForm cform = new EntradaModificarConoForm();
        cform.setUsername("juan");
        cform.setTitulo("java");
        */
        ProfilesManager pm = ProfilesManager.getInstance();
        ExperienciaForm formu = new ExperienciaForm();
        
        formu.setPuesto("ñapas");
        formu.setEmpresa("Teleperforanos");
        formu.setUsername("david");
        formu.setFechainicio("01/01/2015");
        formu.setFechafin("01/01/2015");
        formu.setDescripcion("ñapas");
        Usuarios usu = pm.getProfile("david");
        pm.addExperience(usu, formu);
        
        EducacionForm formu2 = new EducacionForm();
        formu2.setCentro("asdasd");
        formu2.setDescripcion("sadasd");
        formu2.setTitulo("sadasd");
        formu2.setUsername("david");
        formu2.setFechafin("01/01/2015");
        formu2.setFechainicio("01/01/2015");
        pm.addEducation(usu, formu2);
        
        UsuariosJpaController usuariosJpa = new UsuariosJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        List<Usuarios> listaUsuarios = usuariosJpa.findUsuariosEntities();
        request.setAttribute("listaUsuarios",listaUsuarios);
        
        return mapping.findForward(SUCCESS);
    }
}
