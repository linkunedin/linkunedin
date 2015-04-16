/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.persistencia.controladores;

import com.myapp.struts.persistencia.controladores.exceptions.NonexistentEntityException;
import com.myapp.struts.persistencia.entidades.Intereses;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.myapp.struts.persistencia.entidades.Usuarios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrador
 */
public class InteresesJpaController implements Serializable {

    /**
     *
     * @param emf
     */
    public InteresesJpaController(EntityManagerFactory emf) {
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
     * @param intereses
     */
    public void create(Intereses intereses) {
        if (intereses.getUsuariosCollection() == null) {
            intereses.setUsuariosCollection(new ArrayList<Usuarios>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usuarios> attachedUsuariosCollection = new ArrayList<Usuarios>();
            for (Usuarios usuariosCollectionUsuariosToAttach : intereses.getUsuariosCollection()) {
                usuariosCollectionUsuariosToAttach = em.getReference(usuariosCollectionUsuariosToAttach.getClass(), usuariosCollectionUsuariosToAttach.getId());
                attachedUsuariosCollection.add(usuariosCollectionUsuariosToAttach);
            }
            intereses.setUsuariosCollection(attachedUsuariosCollection);
            em.persist(intereses);
            for (Usuarios usuariosCollectionUsuarios : intereses.getUsuariosCollection()) {
                usuariosCollectionUsuarios.getInteresesCollection().add(intereses);
                usuariosCollectionUsuarios = em.merge(usuariosCollectionUsuarios);
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
     * @param intereses
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Intereses intereses) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Intereses persistentIntereses = em.find(Intereses.class, intereses.getId());
            Collection<Usuarios> usuariosCollectionOld = persistentIntereses.getUsuariosCollection();
            Collection<Usuarios> usuariosCollectionNew = intereses.getUsuariosCollection();
            Collection<Usuarios> attachedUsuariosCollectionNew = new ArrayList<Usuarios>();
            for (Usuarios usuariosCollectionNewUsuariosToAttach : usuariosCollectionNew) {
                usuariosCollectionNewUsuariosToAttach = em.getReference(usuariosCollectionNewUsuariosToAttach.getClass(), usuariosCollectionNewUsuariosToAttach.getId());
                attachedUsuariosCollectionNew.add(usuariosCollectionNewUsuariosToAttach);
            }
            usuariosCollectionNew = attachedUsuariosCollectionNew;
            intereses.setUsuariosCollection(usuariosCollectionNew);
            intereses = em.merge(intereses);
            for (Usuarios usuariosCollectionOldUsuarios : usuariosCollectionOld) {
                if (!usuariosCollectionNew.contains(usuariosCollectionOldUsuarios)) {
                    usuariosCollectionOldUsuarios.getInteresesCollection().remove(intereses);
                    usuariosCollectionOldUsuarios = em.merge(usuariosCollectionOldUsuarios);
                }
            }
            for (Usuarios usuariosCollectionNewUsuarios : usuariosCollectionNew) {
                if (!usuariosCollectionOld.contains(usuariosCollectionNewUsuarios)) {
                    usuariosCollectionNewUsuarios.getInteresesCollection().add(intereses);
                    usuariosCollectionNewUsuarios = em.merge(usuariosCollectionNewUsuarios);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = intereses.getId();
                if (findIntereses(id) == null) {
                    throw new NonexistentEntityException("The intereses with id " + id + " no longer exists.");
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
            Intereses intereses;
            try {
                intereses = em.getReference(Intereses.class, id);
                intereses.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The intereses with id " + id + " no longer exists.", enfe);
            }
            Collection<Usuarios> usuariosCollection = intereses.getUsuariosCollection();
            for (Usuarios usuariosCollectionUsuarios : usuariosCollection) {
                usuariosCollectionUsuarios.getInteresesCollection().remove(intereses);
                usuariosCollectionUsuarios = em.merge(usuariosCollectionUsuarios);
            }
            em.remove(intereses);
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
    public List<Intereses> findInteresesEntities() {
        return findInteresesEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Intereses> findInteresesEntities(int maxResults, int firstResult) {
        return findInteresesEntities(false, maxResults, firstResult);
    }

    private List<Intereses> findInteresesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Intereses.class));
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
    public Intereses findIntereses(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Intereses.class, id);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return
     */
    public int getInteresesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Intereses> rt = cq.from(Intereses.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     *
     * @param namequery
     * @return
     */
    public Query query(String namequery){
        EntityManager em = getEntityManager();
        return em.createNamedQuery(namequery, Usuarios.class);
    }
    
    public List<Intereses> fingInteresesByTitulo(String titulo){
        Query q = query("Intereses.findByTitulo");
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }
    
}
