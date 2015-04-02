/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.controladores;

import com.myapp.struts.persistencia.controladores.exceptions.NonexistentEntityException;
import com.myapp.struts.persistencia.controladores.exceptions.PreexistingEntityException;
import com.myapp.struts.persistencia.entidades.Funcionalidades;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrador
 */
public class FuncionalidadesJpaController implements Serializable {

    public FuncionalidadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionalidades funcionalidades) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(funcionalidades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFuncionalidades(funcionalidades.getFuncionalidad()) != null) {
                throw new PreexistingEntityException("Funcionalidades " + funcionalidades + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcionalidades funcionalidades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            funcionalidades = em.merge(funcionalidades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = funcionalidades.getFuncionalidad();
                if (findFuncionalidades(id) == null) {
                    throw new NonexistentEntityException("The funcionalidades with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionalidades funcionalidades;
            try {
                funcionalidades = em.getReference(Funcionalidades.class, id);
                funcionalidades.getFuncionalidad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionalidades with id " + id + " no longer exists.", enfe);
            }
            em.remove(funcionalidades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionalidades> findFuncionalidadesEntities() {
        return findFuncionalidadesEntities(true, -1, -1);
    }

    public List<Funcionalidades> findFuncionalidadesEntities(int maxResults, int firstResult) {
        return findFuncionalidadesEntities(false, maxResults, firstResult);
    }

    private List<Funcionalidades> findFuncionalidadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionalidades.class));
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

    public Funcionalidades findFuncionalidades(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionalidades.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionalidadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionalidades> rt = cq.from(Funcionalidades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
