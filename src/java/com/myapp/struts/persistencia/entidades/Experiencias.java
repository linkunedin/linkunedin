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
@Table(name = "experiencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencias.findAll", query = "SELECT e FROM Experiencias e"),
    @NamedQuery(name = "Experiencias.findById", query = "SELECT e FROM Experiencias e WHERE e.id = :id"),
    @NamedQuery(name = "Experiencias.findByEmpresa", query = "SELECT e FROM Experiencias e WHERE e.empresa = :empresa"),
    @NamedQuery(name = "Experiencias.findByPuesto", query = "SELECT e FROM Experiencias e WHERE e.puesto = :puesto"),
    @NamedQuery(name = "Experiencias.findByActividades", query = "SELECT e FROM Experiencias e WHERE e.actividades = :actividades"),
    @NamedQuery(name = "Experiencias.findByFechaInicio", query = "SELECT e FROM Experiencias e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Experiencias.findByFechaFin", query = "SELECT e FROM Experiencias e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "Experiencias.findByValido", query = "SELECT e FROM Experiencias e WHERE e.valido = :valido")})
public class Experiencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "empresa", length = 255)
    private String empresa;
    @Column(name = "puesto", length = 255)
    private String puesto;
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

    /**
     *
     */
    public Experiencias() {
    }

    /**
     *
     * @param id
     */
    public Experiencias(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     *
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     *
     * @return
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     *
     * @param puesto
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     *
     * @return
     */
    public String getActividades() {
        return actividades;
    }

    /**
     *
     * @param actividades
     */
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @param fechaInicio
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * @return
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     *
     * @param fechaFin
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     *
     * @return
     */
    public Short getValido() {
        return valido;
    }

    /**
     *
     * @param valido
     */
    public void setValido(Short valido) {
        this.valido = valido;
    }

    /**
     *
     * @return
     */
    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    /**
     *
     * @param usuarioId
     */
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
        if (!(object instanceof Experiencias)) {
            return false;
        }
        Experiencias other = (Experiencias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Experiencias{" + "id=" + id + ", empresa=" + empresa + ", puesto=" + puesto + ", actividades=" + actividades + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", valido=" + valido + ", usuarioId=" + usuarioId.getId() + '}';
    }

    
    
}
