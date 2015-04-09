/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.configuration;

/**
 *
 * @author Administrador
 */
public class Configuration {
    
    private static String PersistenceUnit = "PracticaPruebastwebPUMySQL";
    
    public static String getPu(){
        return PersistenceUnit;
    }
    
}
