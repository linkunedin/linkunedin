package com.myapp.struts.persistencia.entidades;

import com.myapp.struts.persistencia.entidades.Educacion;
import com.myapp.struts.persistencia.entidades.Entidades;
import com.myapp.struts.persistencia.entidades.Experiencias;
import com.myapp.struts.persistencia.entidades.Intereses;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-27T17:58:50")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile CollectionAttribute<Usuarios, Educacion> educacionCollection;
    public static volatile SingularAttribute<Usuarios, String> apellidos;
    public static volatile SingularAttribute<Usuarios, Short> valido;
    public static volatile SingularAttribute<Usuarios, String> location;
    public static volatile SingularAttribute<Usuarios, Date> fechaNac;
    public static volatile SingularAttribute<Usuarios, String> pdf;
    public static volatile CollectionAttribute<Usuarios, Experiencias> experienciasCollection;
    public static volatile CollectionAttribute<Usuarios, Entidades> entidadesCollection;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, String> rutafoto;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile SingularAttribute<Usuarios, Short> admin;
    public static volatile SingularAttribute<Usuarios, String> perfil;
    public static volatile CollectionAttribute<Usuarios, Intereses> interesesCollection;
    public static volatile SingularAttribute<Usuarios, String> nombreUsuario;

}