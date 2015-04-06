/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.exeptions.AlreadyDisabledException;
import com.myapp.struts.Modelo.exeptions.AlreadyEnabledException;
import com.myapp.struts.Modelo.interfaces.FunctionManagerIF;
import com.myapp.struts.persistencia.controladores.FuncionalidadesJpaController;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class FunctionManager implements FunctionManagerIF{
    
    private static FunctionManager instance;
    
    private FuncionalidadesJpaController fjc;
    
    public static FunctionManager getInstance(){
        if (FunctionManager.instance == null)
            FunctionManager.instance = new FunctionManager();
        return FunctionManager.instance;
    }
    
    
    private FunctionManager(){
        fjc = new FuncionalidadesJpaController(Persistence.createEntityManagerFactory("PracticaPruebastwebPUHsql3"));
    }

    @Override
    public void activar(int funid) throws AlreadyEnabledException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desactivar(int funid) throws AlreadyDisabledException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
