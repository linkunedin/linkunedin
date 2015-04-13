/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.pruebas.integracion;

import com.myapp.struts.Controlador.Forms.AltaForm;
import com.myapp.struts.Modelo.clases.AccountManager;
import com.myapp.struts.Modelo.exeptions.NotEnoughPrivilegesException;
import com.myapp.struts.Modelo.exeptions.UserAlreadyExistsException;
import com.myapp.struts.Modelo.exeptions.UserNotExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class AccountManagerTest {

    private AccountManager am;

    public AccountManagerTest() {
        am = AccountManager.getInstance();
    }

    public void testAltaBaja() {
        AltaForm form = new AltaForm();
        form.setNombre("javi");
        form.setApellidos("sadasd");
        form.setEmail("asdasd");
        form.setNomusuario("javi");
        form.setPassword("qwert");
        form.setPerfil("asda");
        form.setRutafoto("asdasd");

        // prueba de funcionamiento normal
        try {
            am.baja(form.getNomusuario());
        } catch (UserNotExistsException ex) {
            //Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            am.alta((Object) form);
        } catch (UserAlreadyExistsException ex) {
            Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            am.baja(form.getNomusuario());
        } catch (UserNotExistsException ex) {
            Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // prueba de funcionamiento anomalo

            am.alta(form);
            am.alta(form);
            Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, "Error : usuario se ha creado 2 veces y no ha saltado ningun error");
        } catch (UserAlreadyExistsException ex) {
            
        }
        finally{
            try {
                am.baja(form.getNomusuario());
            } catch (UserNotExistsException ex) {
                Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }

    public void testModificar() {
        AltaForm form = new AltaForm();
        form.setNombre("javi");
        form.setApellidos("sadasd");
        form.setEmail("asdasd");
        form.setNomusuario("javi");
        form.setPassword("qwert");
        form.setPerfil("asda");
        form.setRutafoto("asdasd");
        
        try {
            am.alta(form);
            form.setNombre("pedro");
            am.modify(form, null);
            am.baja(form.getNomusuario());
        } catch (NotEnoughPrivilegesException ex) {
            Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotExistsException ex) {
            Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserAlreadyExistsException ex) {
            Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
