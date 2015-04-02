/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.controladores;

import com.myapp.struts.persistencia.controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.myapp.struts.persistencia.entidades.Intereses;
import java.util.ArrayList;
import java.util.Collection;
import com.myapp.struts.persistencia.entidades.Entidades;
import com.myapp.struts.persistencia.entidades.Educacion;
import com.myapp.struts.persistencia.entidades.Experiencias;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrador
 */
public class UsuariosJpaController implements Serializable {

    public UsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarios usuarios) {
        if (usuarios.getInteresesCollection() == null) {
            usuarios.setInteresesCollection(new ArrayList<Intereses>());
        }
        if (usuarios.getEntidadesCollection() == null) {
            usuarios.setEntidadesCollection(new ArrayList<Entidades>());
        }
        if (usuarios.getEducacionCollection() == null) {
            usuarios.setEducacionCollection(new ArrayList<Educacion>());
        }
        if (usuarios.getExperienciasCollection() == null) {
            usuarios.setExperienciasCollection(new ArrayList<Experiencias>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Intereses> attachedInteresesCollection = new ArrayList<Intereses>();
            for (Intereses interesesCollectionInteresesToAttach : usuarios.getInteresesCollection()) {
                interesesCollectionInteresesToAttach = em.getReference(interesesCollectionInteresesToAttach.getClass(), interesesCollectionInteresesToAttach.getId());
                attachedInteresesCollection.add(interesesCollectionInteresesToAttach);
            }
            usuarios.setInteresesCollection(attachedInteresesCollection);
            Collection<Entidades> attachedEntidadesCollection = new ArrayList<Entidades>();
            for (Entidades entidadesCollectionEntidadesToAttach : usuarios.getEntidadesCollection()) {
                entidadesCollectionEntidadesToAttach = em.getReference(entidadesCollectionEntidadesToAttach.getClass(), entidadesCollectionEntidadesToAttach.getId());
                attachedEntidadesCollection.add(entidadesCollectionEntidadesToAttach);
            }
            usuarios.setEntidadesCollection(attachedEntidadesCollection);
            Collection<Educacion> attachedEducacionCollection = new ArrayList<Educacion>();
            for (Educacion educacionCollectionEducacionToAttach : usuarios.getEducacionCollection()) {
                educacionCollectionEducacionToAttach = em.getReference(educacionCollectionEducacionToAttach.getClass(), educacionCollectionEducacionToAttach.getId());
                attachedEducacionCollection.add(educacionCollectionEducacionToAttach);
            }
            usuarios.setEducacionCollection(attachedEducacionCollection);
            Collection<Experiencias> attachedExperienciasCollection = new ArrayList<Experiencias>();
            for (Experiencias experienciasCollectionExperienciasToAttach : usuarios.getExperienciasCollection()) {
                experienciasCollectionExperienciasToAttach = em.getReference(experienciasCollectionExperienciasToAttach.getClass(), experienciasCollectionExperienciasToAttach.getId());
                attachedExperienciasCollection.add(experienciasCollectionExperienciasToAttach);
            }
            usuarios.setExperienciasCollection(attachedExperienciasCollection);
            em.persist(usuarios);
            for (Intereses interesesCollectionIntereses : usuarios.getInteresesCollection()) {
                interesesCollectionIntereses.getUsuariosCollection().add(usuarios);
                interesesCollectionIntereses = em.merge(interesesCollectionIntereses);
            }
            for (Entidades entidadesCollectionEntidades : usuarios.getEntidadesCollection()) {
                entidadesCollectionEntidades.getUsuariosCollection().add(usuarios);
                entidadesCollectionEntidades = em.merge(entidadesCollectionEntidades);
            }
            for (Educacion educacionCollectionEducacion : usuarios.getEducacionCollection()) {
                Usuarios oldUsuarioIdOfEducacionCollectionEducacion = educacionCollectionEducacion.getUsuarioId();
                educacionCollectionEducacion.setUsuarioId(usuarios);
                educacionCollectionEducacion = em.merge(educacionCollectionEducacion);
                if (oldUsuarioIdOfEducacionCollectionEducacion != null) {
                    oldUsuarioIdOfEducacionCollectionEducacion.getEducacionCollection().remove(educacionCollectionEducacion);
                    oldUsuarioIdOfEducacionCollectionEducacion = em.merge(oldUsuarioIdOfEducacionCollectionEducacion);
                }
            }
            for (Experiencias experienciasCollectionExperiencias : usuarios.getExperienciasCollection()) {
                Usuarios oldUsuarioIdOfExperienciasCollectionExperiencias = experienciasCollectionExperiencias.getUsuarioId();
                experienciasCollectionExperiencias.setUsuarioId(usuarios);
                experienciasCollectionExperiencias = em.merge(experienciasCollectionExperiencias);
                if (oldUsuarioIdOfExperienciasCollectionExperiencias != null) {
                    oldUsuarioIdOfExperienciasCollectionExperiencias.getExperienciasCollection().remove(experienciasCollectionExperiencias);
                    oldUsuarioIdOfExperienciasCollectionExperiencias = em.merge(oldUsuarioIdOfExperienciasCollectionExperiencias);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarios usuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getId());
            Collection<Intereses> interesesCollectionOld = persistentUsuarios.getInteresesCollection();
            Collection<Intereses> interesesCollectionNew = usuarios.getInteresesCollection();
            Collection<Entidades> entidadesCollectionOld = persistentUsuarios.getEntidadesCollection();
            Collection<Entidades> entidadesCollectionNew = usuarios.getEntidadesCollection();
            Collection<Educacion> educacionCollectionOld = persistentUsuarios.getEducacionCollection();
            Collection<Educacion> educacionCollectionNew = usuarios.getEducacionCollection();
            Collection<Experiencias> experienciasCollectionOld = persistentUsuarios.getExperienciasCollection();
            Collection<Experiencias> experienciasCollectionNew = usuarios.getExperienciasCollection();
            Collection<Intereses> attachedInteresesCollectionNew = new ArrayList<Intereses>();
            for (Intereses interesesCollectionNewInteresesToAttach : interesesCollectionNew) {
                interesesCollectionNewInteresesToAttach = em.getReference(interesesCollectionNewInteresesToAttach.getClass(), interesesCollectionNewInteresesToAttach.getId());
                attachedInteresesCollectionNew.add(interesesCollectionNewInteresesToAttach);
            }
            interesesCollectionNew = attachedInteresesCollectionNew;
            usuarios.setInteresesCollection(interesesCollectionNew);
            Collection<Entidades> attachedEntidadesCollectionNew = new ArrayList<Entidades>();
            for (Entidades entidadesCollectionNewEntidadesToAttach : entidadesCollectionNew) {
                entidadesCollectionNewEntidadesToAttach = em.getReference(entidadesCollectionNewEntidadesToAttach.getClass(), entidadesCollectionNewEntidadesToAttach.getId());
                attachedEntidadesCollectionNew.add(entidadesCollectionNewEntidadesToAttach);
            }
            entidadesCollectionNew = attachedEntidadesCollectionNew;
            usuarios.setEntidadesCollection(entidadesCollectionNew);
            Collection<Educacion> attachedEducacionCollectionNew = new ArrayList<Educacion>();
            for (Educacion educacionCollectionNewEducacionToAttach : educacionCollectionNew) {
                educacionCollectionNewEducacionToAttach = em.getReference(educacionCollectionNewEducacionToAttach.getClass(), educacionCollectionNewEducacionToAttach.getId());
                attachedEducacionCollectionNew.add(educacionCollectionNewEducacionToAttach);
            }
            educacionCollectionNew = attachedEducacionCollectionNew;
            usuarios.setEducacionCollection(educacionCollectionNew);
            Collection<Experiencias> attachedExperienciasCollectionNew = new ArrayList<Experiencias>();
            for (Experiencias experienciasCollectionNewExperienciasToAttach : experienciasCollectionNew) {
                experienciasCollectionNewExperienciasToAttach = em.getReference(experienciasCollectionNewExperienciasToAttach.getClass(), experienciasCollectionNewExperienciasToAttach.getId());
                attachedExperienciasCollectionNew.add(experienciasCollectionNewExperienciasToAttach);
            }
            experienciasCollectionNew = attachedExperienciasCollectionNew;
            usuarios.setExperienciasCollection(experienciasCollectionNew);
            usuarios = em.merge(usuarios);
            for (Intereses interesesCollectionOldIntereses : interesesCollectionOld) {
                if (!interesesCollectionNew.contains(interesesCollectionOldIntereses)) {
                    interesesCollectionOldIntereses.getUsuariosCollection().remove(usuarios);
                    interesesCollectionOldIntereses = em.merge(interesesCollectionOldIntereses);
                }
            }
            for (Intereses interesesCollectionNewIntereses : interesesCollectionNew) {
                if (!interesesCollectionOld.contains(interesesCollectionNewIntereses)) {
                    interesesCollectionNewIntereses.getUsuariosCollection().add(usuarios);
                    interesesCollectionNewIntereses = em.merge(interesesCollectionNewIntereses);
                }
            }
            for (Entidades entidadesCollectionOldEntidades : entidadesCollectionOld) {
                if (!entidadesCollectionNew.contains(entidadesCollectionOldEntidades)) {
                    entidadesCollectionOldEntidades.getUsuariosCollection().remove(usuarios);
                    entidadesCollectionOldEntidades = em.merge(entidadesCollectionOldEntidades);
                }
            }
            for (Entidades entidadesCollectionNewEntidades : entidadesCollectionNew) {
                if (!entidadesCollectionOld.contains(entidadesCollectionNewEntidades)) {
                    entidadesCollectionNewEntidades.getUsuariosCollection().add(usuarios);
                    entidadesCollectionNewEntidades = em.merge(entidadesCollectionNewEntidades);
                }
            }
            for (Educacion educacionCollectionOldEducacion : educacionCollectionOld) {
                if (!educacionCollectionNew.contains(educacionCollectionOldEducacion)) {
                    educacionCollectionOldEducacion.setUsuarioId(null);
                    educacionCollectionOldEducacion = em.merge(educacionCollectionOldEducacion);
                }
            }
            for (Educacion educacionCollectionNewEducacion : educacionCollectionNew) {
                if (!educacionCollectionOld.contains(educacionCollectionNewEducacion)) {
                    Usuarios oldUsuarioIdOfEducacionCollectionNewEducacion = educacionCollectionNewEducacion.getUsuarioId();
                    educacionCollectionNewEducacion.setUsuarioId(usuarios);
                    educacionCollectionNewEducacion = em.merge(educacionCollectionNewEducacion);
                    if (oldUsuarioIdOfEducacionCollectionNewEducacion != null && !oldUsuarioIdOfEducacionCollectionNewEducacion.equals(usuarios)) {
                        oldUsuarioIdOfEducacionCollectionNewEducacion.getEducacionCollection().remove(educacionCollectionNewEducacion);
                        oldUsuarioIdOfEducacionCollectionNewEducacion = em.merge(oldUsuarioIdOfEducacionCollectionNewEducacion);
                    }
                }
            }
            for (Experiencias experienciasCollectionOldExperiencias : experienciasCollectionOld) {
                if (!experienciasCollectionNew.contains(experienciasCollectionOldExperiencias)) {
                    experienciasCollectionOldExperiencias.setUsuarioId(null);
                    experienciasCollectionOldExperiencias = em.merge(experienciasCollectionOldExperiencias);
                }
            }
            for (Experiencias experienciasCollectionNewExperiencias : experienciasCollectionNew) {
                if (!experienciasCollectionOld.contains(experienciasCollectionNewExperiencias)) {
                    Usuarios oldUsuarioIdOfExperienciasCollectionNewExperiencias = experienciasCollectionNewExperiencias.getUsuarioId();
                    experienciasCollectionNewExperiencias.setUsuarioId(usuarios);
                    experienciasCollectionNewExperiencias = em.merge(experienciasCollectionNewExperiencias);
                    if (oldUsuarioIdOfExperienciasCollectionNewExperiencias != null && !oldUsuarioIdOfExperienciasCollectionNewExperiencias.equals(usuarios)) {
                        oldUsuarioIdOfExperienciasCollectionNewExperiencias.getExperienciasCollection().remove(experienciasCollectionNewExperiencias);
                        oldUsuarioIdOfExperienciasCollectionNewExperiencias = em.merge(oldUsuarioIdOfExperienciasCollectionNewExperiencias);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarios.getId();
                if (findUsuarios(id) == null) {
                    throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
            }
            Collection<Intereses> interesesCollection = usuarios.getInteresesCollection();
            for (Intereses interesesCollectionIntereses : interesesCollection) {
                interesesCollectionIntereses.getUsuariosCollection().remove(usuarios);
                interesesCollectionIntereses = em.merge(interesesCollectionIntereses);
            }
            Collection<Entidades> entidadesCollection = usuarios.getEntidadesCollection();
            for (Entidades entidadesCollectionEntidades : entidadesCollection) {
                entidadesCollectionEntidades.getUsuariosCollection().remove(usuarios);
                entidadesCollectionEntidades = em.merge(entidadesCollectionEntidades);
            }
            Collection<Educacion> educacionCollection = usuarios.getEducacionCollection();
            for (Educacion educacionCollectionEducacion : educacionCollection) {
                educacionCollectionEducacion.setUsuarioId(null);
                educacionCollectionEducacion = em.merge(educacionCollectionEducacion);
            }
            Collection<Experiencias> experienciasCollection = usuarios.getExperienciasCollection();
            for (Experiencias experienciasCollectionExperiencias : experienciasCollection) {
                experienciasCollectionExperiencias.setUsuarioId(null);
                experienciasCollectionExperiencias = em.merge(experienciasCollectionExperiencias);
            }
            em.remove(usuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
