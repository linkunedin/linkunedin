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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tipos_likes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposLikes.findAll", query = "SELECT t FROM TiposLikes t"),
    @NamedQuery(name = "TiposLikes.findByIdtiposLikes", query = "SELECT t FROM TiposLikes t WHERE t.idtiposLikes = :idtiposLikes")})
public class TiposLikes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipos_likes", nullable = false)
    private Integer idtiposLikes;

    public TiposLikes() {
    }

    public TiposLikes(Integer idtiposLikes) {
        this.idtiposLikes = idtiposLikes;
    }

    public Integer getIdtiposLikes() {
        return idtiposLikes;
    }

    public void setIdtiposLikes(Integer idtiposLikes) {
        this.idtiposLikes = idtiposLikes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiposLikes != null ? idtiposLikes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposLikes)) {
            return false;
        }
        TiposLikes other = (TiposLikes) object;
        if ((this.idtiposLikes == null && other.idtiposLikes != null) || (this.idtiposLikes != null && !this.idtiposLikes.equals(other.idtiposLikes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TiposLikes{" + "idtiposLikes=" + idtiposLikes + '}';
    }

    
    
}
