/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.EstadoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Transacciones CRUD de la entidad Estado
 *
 * @author Sergio Ramirez
 */
@Stateless
public class EstadoPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Estado | @return lista de estados-----------------------*/
    public List<EstadoEntity> findAll() {
        Query queryEstado = em.createQuery("select dm from Estado dm");
        return queryEstado.getResultList();
    }

    /*
    * Buscar Estado por ID | @param id_estado | * @return lista de estados
     */
    public EstadoEntity find(Long id) {
        return em.find(EstadoEntity.class, id);
    }

    /*
    * Crear Estado | @param NuevoEstado | * @return NuevoEstado
     */
    public EstadoEntity create(EstadoEntity estadoNuevo) {
        em.persist(estadoNuevo);
        return estadoNuevo;
    }

    /*
    * Actualizar Estado | @param NuevoEstado | * @return NuevoEstado
     */
    public EstadoEntity update(EstadoEntity estadoActualizado) {
        return em.merge(estadoActualizado);
    }

    /* ----------------------- Borrar Estado | @param id_estado -----------------------*/
    public void remove(Long id) {
        EstadoEntity estadoEliminar = em.find(EstadoEntity.class, id);
        em.remove(estadoEliminar);
    }

}
