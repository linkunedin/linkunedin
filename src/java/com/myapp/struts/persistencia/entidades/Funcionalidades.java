/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "funcionalidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionalidades.findAll", query = "SELECT f FROM Funcionalidades f"),
    @NamedQuery(name = "Funcionalidades.findByFuncionalidad", query = "SELECT f FROM Funcionalidades f WHERE f.funcionalidad = :funcionalidad"),
    @NamedQuery(name = "Funcionalidades.findByActivo", query = "SELECT f FROM Funcionalidades f WHERE f.activo = :activo")})
public class Funcionalidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "funcionalidad", nullable = false, length = 255)
    private String funcionalidad;
    @Column(name = "activo")
    private Short activo;

    /**
     *
     */
    public Funcionalidades() {
    }

    /**
     *
     * @param funcionalidad
     */
    public Funcionalidades(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    /**
     *
     * @return
     */
    public String getFuncionalidad() {
        return funcionalidad;
    }

    /**
     *
     * @param funcionalidad
     */
    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    /**
     *
     * @return
     */
    public Short getActivo() {
        return activo;
    }

    /**
     *
     * @param activo
     */
    public void setActivo(Short activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionalidad != null ? funcionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionalidades)) {
            return false;
        }
        Funcionalidades other = (Funcionalidades) object;
        if ((this.funcionalidad == null && other.funcionalidad != null) || (this.funcionalidad != null && !this.funcionalidad.equals(other.funcionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionalidades{" + "funcionalidad=" + funcionalidad + ", activo=" + activo + '}';
    }

    
    
}
