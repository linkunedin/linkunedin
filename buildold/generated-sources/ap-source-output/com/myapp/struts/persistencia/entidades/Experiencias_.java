package com.myapp.struts.persistencia.entidades;

import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-27T17:58:50")
@StaticMetamodel(Experiencias.class)
public class Experiencias_ { 

    public static volatile SingularAttribute<Experiencias, Integer> id;
    public static volatile SingularAttribute<Experiencias, Short> valido;
    public static volatile SingularAttribute<Experiencias, String> puesto;
    public static volatile SingularAttribute<Experiencias, String> empresa;
    public static volatile SingularAttribute<Experiencias, String> descripcion;
    public static volatile SingularAttribute<Experiencias, Date> fechaFin;
    public static volatile SingularAttribute<Experiencias, String> actividades;
    public static volatile SingularAttribute<Experiencias, Usuarios> usuarioId;
    public static volatile SingularAttribute<Experiencias, Date> fechaInicio;

}