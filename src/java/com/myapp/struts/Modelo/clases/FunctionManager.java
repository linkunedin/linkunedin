/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.clases;

import com.myapp.struts.Modelo.exeptions.AlreadyDisabledException;
import com.myapp.struts.Modelo.exeptions.AlreadyEnabledException;
import com.myapp.struts.Modelo.interfaces.FunctionManagerIF;
import com.myapp.struts.configuration.Configuration;
import com.myapp.struts.persistencia.controladores.FuncionalidadesJpaController;
import com.myapp.struts.persistencia.entidades.Funcionalidades;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class FunctionManager implements FunctionManagerIF{
    
    private static FunctionManager instance;
    
    private FuncionalidadesJpaController fjc;
    
    /**
     *
     * @return
     */
    public static FunctionManager getInstance(){
        if (FunctionManager.instance == null)
            FunctionManager.instance = new FunctionManager();
        return FunctionManager.instance;
    }
    
    
    private FunctionManager(){
        fjc = new FuncionalidadesJpaController(Persistence.createEntityManagerFactory(Configuration.getPu()));
    }

    @Override
    public void activar(int funid) throws AlreadyEnabledException {
        Integer fid = funid;
        Funcionalidades fun = fjc.findFuncionalidades(fid.toString());
        if (fun == null){
            return;
        }
        
        if (fun.getActivo() == 0)
            throw new AlreadyEnabledException();
        
        fun.setActivo((short) 1);
        try {
            fjc.edit(fun);
        } catch (Exception ex) {
            Logger.getLogger(FunctionManager.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
    }

    @Override
    public void desactivar(int funid) throws AlreadyDisabledException {
        Integer fid = funid;
        Funcionalidades fun = fjc.findFuncionalidades(fid.toString());
        if (fun == null){
            return;
        }
        
        if (fun.getActivo() == 1)
            throw new AlreadyDisabledException();
        
        fun.setActivo((short) 0);
        try {
            fjc.edit(fun);
        } catch (Exception ex) {
            Logger.getLogger(FunctionManager.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }
    
}
