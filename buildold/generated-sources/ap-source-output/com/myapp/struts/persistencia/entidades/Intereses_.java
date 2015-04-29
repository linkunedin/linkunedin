package com.myapp.struts.persistencia.entidades;

import com.myapp.struts.persistencia.entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-27T17:58:50")
@StaticMetamodel(Intereses.class)
public class Intereses_ { 

    public static volatile SingularAttribute<Intereses, Integer> id;
    public static volatile SingularAttribute<Intereses, String> titulo;
    public static volatile SingularAttribute<Intereses, Short> valido;
    public static volatile SingularAttribute<Intereses, String> descripcion;
    public static volatile CollectionAttribute<Intereses, Usuarios> usuariosCollection;

}