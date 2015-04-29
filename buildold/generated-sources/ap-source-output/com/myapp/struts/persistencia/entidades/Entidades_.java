package com.myapp.struts.persistencia.entidades;

import com.myapp.struts.persistencia.entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-27T17:58:50")
@StaticMetamodel(Entidades.class)
public class Entidades_ { 

    public static volatile SingularAttribute<Entidades, Integer> id;
    public static volatile SingularAttribute<Entidades, String> nombre;
    public static volatile CollectionAttribute<Entidades, Usuarios> usuariosCollection;

}