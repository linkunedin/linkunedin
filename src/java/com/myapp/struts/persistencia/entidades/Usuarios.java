/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByNombreUsuario", query = "SELECT u FROM Usuarios u left join fetch u.experienciasCollection e WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByUserPwd", query = "SELECT u FROM Usuarios u WHERE u.nombreUsuario = :nombre and u.password = :password"),
    @NamedQuery(name = "Usuarios.findByAdmin", query = "SELECT u FROM Usuarios u WHERE u.admin = :admin"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByValido", query = "SELECT u FROM Usuarios u WHERE u.valido = :valido"),
    @NamedQuery(name = "Usuarios.findByFechaNac", query = "SELECT u FROM Usuarios u WHERE u.fechaNac = :fechaNac"),
    @NamedQuery(name = "Usuarios.findByInteres", query = "SELECT u FROM Usuarios u JOIN u.interesesCollection i WHERE i.titulo = :interes "),
    @NamedQuery(name = "Usuarios.findByLocation", query = "SELECT u FROM Usuarios u WHERE u.location = :location")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "apellidos", length = 45)
    private String apellidos;
    @Column(name = "nombre_usuario", length = 45, unique=true)
    private String nombreUsuario;
    @Column(name = "password", length = 45)
    private String password;
    @Column(name = "admin")
    private Short admin;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "valido")
    private Short valido;
    @Column(name = "rutafoto", length = 255)
    private String rutafoto;
    @Column(name = "location", length = 45)
    private String location;
    @Column(name = "fechaNac")
    private java.sql.Date fechaNac;
    @Lob
    @Column(name = "perfil", length = 65535)
    private String perfil;
    @ManyToMany(mappedBy = "usuariosCollection", fetch = FetchType.EAGER, targetEntity=Intereses.class)
    private Collection<Intereses> interesesCollection;
    @ManyToMany(mappedBy = "usuariosCollection", fetch = FetchType.LAZY)
    private Collection<Entidades> entidadesCollection;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.EAGER, targetEntity=Educacion.class)
    private Collection<Educacion> educacionCollection;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.EAGER, targetEntity=Experiencias.class)
    private Collection<Experiencias> experienciasCollection;
    
    @Column(name = "pdf", length = 255)
    private String pdf;

    /**
     *
     */
    public Usuarios() {
    }

    /**
     *
     * @param id
     */
    public Usuarios(Integer id) {
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
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     *
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Short getAdmin() {
        return admin;
    }

    /**
     *
     * @param admin
     */
    public void setAdmin(Short admin) {
        this.admin = admin;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
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
    public String getPerfil() {
        return perfil;
    }

    /**
     *
     * @param perfil
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    
    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Intereses> getInteresesCollection() {
        return interesesCollection;
    }

    /**
     *
     * @param interesesCollection
     */
    public void setInteresesCollection(Collection<Intereses> interesesCollection) {
        this.interesesCollection = interesesCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Entidades> getEntidadesCollection() {
        return entidadesCollection;
    }

    /**
     *
     * @param entidadesCollection
     */
    public void setEntidadesCollection(Collection<Entidades> entidadesCollection) {
        this.entidadesCollection = entidadesCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Educacion> getEducacionCollection() {
        return educacionCollection;
    }

    /**
     *
     * @param educacionCollection
     */
    public void setEducacionCollection(Collection<Educacion> educacionCollection) {
        this.educacionCollection = educacionCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Experiencias> getExperienciasCollection() {
        return experienciasCollection;
    }

    /**
     *
     * @param experienciasCollection
     */
    public void setExperienciasCollection(Collection<Experiencias> experienciasCollection) {
        this.experienciasCollection = experienciasCollection;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getRutafoto() {
        return rutafoto;
    }

    public void setRutafoto(String rutafoto) {
        this.rutafoto = rutafoto;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", admin=" + admin + ", email=" + email + ", valido=" + valido + ", rutafoto=" + rutafoto + ", perfil=" + perfil + ", interesesCollection=" + interesesCollection + ", entidadesCollection=" + entidadesCollection + ", educacionCollection=" + educacionCollection + ", experienciasCollection=" + experienciasCollection + ", pdf=" + pdf + '}';
    }
    
    
    
    
}
