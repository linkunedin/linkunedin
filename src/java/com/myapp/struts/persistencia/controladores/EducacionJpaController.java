/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.controladores;

import com.myapp.struts.persistencia.controladores.exceptions.NonexistentEntityException;
import com.myapp.struts.persistencia.entidades.Educacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrador
 */
public class EducacionJpaController implements Serializable {

    public EducacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Educacion educacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarioId = educacion.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                educacion.setUsuarioId(usuarioId);
            }
            em.persist(educacion);
            if (usuarioId != null) {
                usuarioId.getEducacionCollection().add(educacion);
                usuarioId = em.merge(usuarioId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Educacion educacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Educacion persistentEducacion = em.find(Educacion.class, educacion.getId());
            Usuarios usuarioIdOld = persistentEducacion.getUsuarioId();
            Usuarios usuarioIdNew = educacion.getUsuarioId();
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                educacion.setUsuarioId(usuarioIdNew);
            }
            educacion = em.merge(educacion);
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getEducacionCollection().remove(educacion);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getEducacionCollection().add(educacion);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = educacion.getId();
                if (findEducacion(id) == null) {
                    throw new NonexistentEntityException("The educacion with id " + id + " no longer exists.");
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
            Educacion educacion;
            try {
                educacion = em.getReference(Educacion.class, id);
                educacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The educacion with id " + id + " no longer exists.", enfe);
            }
            Usuarios usuarioId = educacion.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getEducacionCollection().remove(educacion);
                usuarioId = em.merge(usuarioId);
            }
            em.remove(educacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Educacion> findEducacionEntities() {
        return findEducacionEntities(true, -1, -1);
    }

    public List<Educacion> findEducacionEntities(int maxResults, int firstResult) {
        return findEducacionEntities(false, maxResults, firstResult);
    }

    private List<Educacion> findEducacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Educacion.class));
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

    public Educacion findEducacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Educacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getEducacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Educacion> rt = cq.from(Educacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
