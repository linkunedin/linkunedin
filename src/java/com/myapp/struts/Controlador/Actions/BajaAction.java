/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Controlador.Actions;

/**
 *
 * @author david
 */
import com.myapp.struts.Controlador.Forms.BajaForm;
import com.myapp.struts.Modelo.clases.AccountManager;
import com.myapp.struts.Modelo.clases.LoginManager;
import com.myapp.struts.Modelo.clases.UserSession;
import com.myapp.struts.Modelo.exeptions.UserAlreadyExistsException;
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
public class BajaAction extends org.apache.struts.action.Action {

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
        BajaForm bajaform = (BajaForm) form;
        
        // comprobar si existe usuario
        AccountManager am = AccountManager.getInstance();
        //LoginManager lm = LoginManager.getInstance();
        try{
            am.baja(bajaform.getNomusuario());
            String nomusu = ((UserSession)request.getSession().getAttribute("objsesion")).getUser().getNombreUsuario();
            if (bajaform.getNomusuario().equals(nomusu)){
                request.getSession().removeAttribute("objsesion");
            }
            
        }catch(Exception ex){
            //bajaform.setError("Error : el usuario no se pudo borrar");
            return mapping.findForward(ERROR);
        }
        
        UsuariosJpaController usuariosJpa = new UsuariosJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
        List<Usuarios> listaUsuarios = usuariosJpa.findUsuariosEntities();
        request.setAttribute("listaUsuarios",listaUsuarios);

        return mapping.findForward(SUCCESS);
        

    }
}