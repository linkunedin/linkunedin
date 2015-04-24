/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Actions;

import com.myapp.struts.Controlador.Forms.LoginForm;
import com.myapp.struts.Modelo.clases.LoginManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.UsuariosJpaController;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.chain.contexts.ActionContext;

/**
 *
 * @author Administrador
 */
public class LoginAction extends org.apache.struts.action.Action {

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
        LoginForm lf = (LoginForm) form;
        boolean encontrado;
        Usuarios userLista;
        
        int indiceLista = 0;
        encontrado = false;
        

        UsuariosJpaController usuariosJpa = new UsuariosJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        List<Usuarios> listaUsuarios = usuariosJpa.findUsuariosEntities();
        
        while ((indiceLista < listaUsuarios.size())&&!(encontrado)){
            userLista = listaUsuarios.get(indiceLista);
            System.out.println(lf.getUser());
            System.out.println(userLista.getNombreUsuario());
            System.out.println(lf.getPassword());
            System.out.println(userLista.getPassword());
            if ( userLista.getNombreUsuario().equals (lf.getUser())&&((userLista.getPassword()).equals (lf.getPassword()))){
               encontrado=true;
               System.out.println("Encontrado usr");
            }
            indiceLista++;
        }
        if(encontrado){
        LoginManager lm = LoginManager.getInstance();
        UserSession us = (UserSession) lm.login(lf.getUser(), lf.getPassword());       
        request.getSession().setAttribute("objsesion", us);
        
        
        // si pasa el test habra que generar un 'certificado' para guardar en la sesion
        // y en una cookie y guardarlo en la variable 'usersession'
        
        
        return mapping.findForward(SUCCESS);
        }else{
            System.out.println("Usuario no encontrado");
            return mapping.findForward(ERROR);
        }
    }
}
