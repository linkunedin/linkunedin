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

    /**
     *
     * @return
     */
    public String getOperator();

    /**
     *
     * @param op
     */
    public void setOperator(String op);

    /**
     *
     * @return
     */
    public String getOp1();

    /**
     *
     * @return
     */
    public String getOp2();

    /**
     *
     * @param operando
     */
    public void setOp1(String operando);

    /**
     *
     * @param operando
     */
    public void setOp2(String operando);

    /**
     *
     * @return
     */
    @Override
    public String toString();
}
