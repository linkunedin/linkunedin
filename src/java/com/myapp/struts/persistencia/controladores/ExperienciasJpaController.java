/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.controladores;

import com.myapp.struts.persistencia.controladores.exceptions.NonexistentEntityException;
import com.myapp.struts.persistencia.entidades.Experiencias;
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
public class ExperienciasJpaController implements Serializable {

    /**
     *
     * @param emf
     */
    public ExperienciasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    /**
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     *
     * @param experiencias
     */
    public void create(Experiencias experiencias) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarioId = experiencias.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                experiencias.setUsuarioId(usuarioId);
            }
            em.persist(experiencias);
            if (usuarioId != null) {
                usuarioId.getExperienciasCollection().add(experiencias);
                usuarioId = em.merge(usuarioId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param experiencias
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Experiencias experiencias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Experiencias persistentExperiencias = em.find(Experiencias.class, experiencias.getId());
            Usuarios usuarioIdOld = persistentExperiencias.getUsuarioId();
            Usuarios usuarioIdNew = experiencias.getUsuarioId();
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                experiencias.setUsuarioId(usuarioIdNew);
            }
            experiencias = em.merge(experiencias);
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getExperienciasCollection().remove(experiencias);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getExperienciasCollection().add(experiencias);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = experiencias.getId();
                if (findExperiencias(id) == null) {
                    throw new NonexistentEntityException("The experiencias with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param id
     * @throws NonexistentEntityException
     */
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Experiencias experiencias;
            try {
                experiencias = em.getReference(Experiencias.class, id);
                experiencias.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The experiencias with id " + id + " no longer exists.", enfe);
            }
            Usuarios usuarioId = experiencias.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getExperienciasCollection().remove(experiencias);
                usuarioId = em.merge(usuarioId);
            }
            em.remove(experiencias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @return
     */
    public List<Experiencias> findExperienciasEntities() {
        return findExperienciasEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Experiencias> findExperienciasEntities(int maxResults, int firstResult) {
        return findExperienciasEntities(false, maxResults, firstResult);
    }

    private List<Experiencias> findExperienciasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Experiencias.class));
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

    /**
     *
     * @param id
     * @return
     */
    public Experiencias findExperiencias(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Experiencias.class, id);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return
     */
    public int getExperienciasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Experiencias> rt = cq.from(Experiencias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
