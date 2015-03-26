/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Modelo.interfaces;

/**
 *
 * @author Administrador
 */
public interface CriteriaIF {
    public String getOperator();
    public void setOperator(String op);
    public String getOp1();
    public String getOp2();
    public void setOp1(String operando);
    public void setOp2(String operando);
    @Override
    public String toString();
}
