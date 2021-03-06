/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "intereses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intereses.findAll", query = "SELECT i FROM Intereses i"),
    @NamedQuery(name = "Intereses.findById", query = "SELECT i FROM Intereses i WHERE i.id = :id"),
    @NamedQuery(name = "Intereses.findByTitulo", query = "SELECT i FROM Intereses i WHERE i.titulo = :titulo"),
    @NamedQuery(name = "Intereses.findByValido", query = "SELECT i FROM Intereses i WHERE i.valido = :valido")})
public class Intereses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "titulo", length = 255)
    private String titulo;
    @Lob
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @Column(name = "valido")
    private Short valido;
    @JoinTable(name = "usuarios_intereses", joinColumns = {
        @JoinColumn(name = "interes_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany(fetch=FetchType.EAGER)
    private Collection<Usuarios> usuariosCollection;

    /**
     *
     */
    public Intereses() {
    }

    /**
     *
     * @param id
     */
    public Intereses(Integer id) {
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
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    /**
     *
     * @param usuariosCollection
     */
    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
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
        if (!(object instanceof Intereses)) {
            return false;
        }
        Intereses other = (Intereses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        int i;
        String cad;
        //cad="laputaquetepario";
        
        cad="{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion +
                  ", valido=" + valido + '}';
        /*Usuarios[]usuArray = (Usuarios[]) usuariosCollection.toArray();
        for (i=0; i<usuariosCollection.size();i++)
           cad.concat(usuArray[i].getNombre());*/
        return cad;
    }

    
    
}
