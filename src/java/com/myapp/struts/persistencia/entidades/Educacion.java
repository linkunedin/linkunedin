/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "educacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educacion.findAll", query = "SELECT e FROM Educacion e"),
    @NamedQuery(name = "Educacion.findById", query = "SELECT e FROM Educacion e WHERE e.id = :id"),
    @NamedQuery(name = "Educacion.findByCentroEstudios", query = "SELECT e FROM Educacion e WHERE e.centroEstudios = :centroEstudios"),
    @NamedQuery(name = "Educacion.findByTitulacion", query = "SELECT e FROM Educacion e WHERE e.titulacion = :titulacion"),
    @NamedQuery(name = "Educacion.findByActividades", query = "SELECT e FROM Educacion e WHERE e.actividades = :actividades"),
    @NamedQuery(name = "Educacion.findByFechaInicio", query = "SELECT e FROM Educacion e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Educacion.findByFechaFin", query = "SELECT e FROM Educacion e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "Educacion.findByValido", query = "SELECT e FROM Educacion e WHERE e.valido = :valido")})
public class Educacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "centro_estudios", length = 255)
    private String centroEstudios;
    @Column(name = "titulacion", length = 255)
    private String titulacion;
    @Column(name = "actividades", length = 255)
    private String actividades;
    @Lob
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "valido")
    private Short valido;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuarios usuarioId;

    public Educacion() {
    }

    public Educacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCentroEstudios() {
        return centroEstudios;
    }

    public void setCentroEstudios(String centroEstudios) {
        this.centroEstudios = centroEstudios;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Short getValido() {
        return valido;
    }

    public void setValido(Short valido) {
        this.valido = valido;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educacion)) {
            return false;
        }
        Educacion other = (Educacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myapp.struts.persistencia.entidades.Educacion[ id=" + id + " ]";
    }
    
}
