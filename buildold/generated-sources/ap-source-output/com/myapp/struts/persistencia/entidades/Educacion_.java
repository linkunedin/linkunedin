package com.myapp.struts.persistencia.entidades;

import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-27T17:58:50")
@StaticMetamodel(Educacion.class)
public class Educacion_ { 

    public static volatile SingularAttribute<Educacion, Integer> id;
    public static volatile SingularAttribute<Educacion, String> titulacion;
    public static volatile SingularAttribute<Educacion, String> centroEstudios;
    public static volatile SingularAttribute<Educacion, Short> valido;
    public static volatile SingularAttribute<Educacion, String> descripcion;
    public static volatile SingularAttribute<Educacion, Date> fechaFin;
    public static volatile SingularAttribute<Educacion, String> actividades;
    public static volatile SingularAttribute<Educacion, Usuarios> usuarioId;
    public static volatile SingularAttribute<Educacion, Date> fechaInicio;

}