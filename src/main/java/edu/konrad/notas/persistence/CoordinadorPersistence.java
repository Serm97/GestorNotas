/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.CoordinadorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Transacciones CRUD de la entidad Coordinador
 *
 * @author Sergio Ramirez
 */
@Stateless
public class CoordinadorPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Coordinadores | @return lista de coordinadores-----------------------*/
    public List<CoordinadorEntity> findAll() {
        Query queryCoordinador = em.createQuery("select co from coordinadores co");
        return queryCoordinador.getResultList();
    }

    /*
    * Buscar Coordinador por ID | @param id_coordinador | * @return lista de Coordinadores
     */
    public CoordinadorEntity find(Long id) {
        return em.find(CoordinadorEntity.class, id);
    }

    /*
    * Crear Coordinador | @param NuevaCoordinador | * @return NuevaCoordinador
     */
    public CoordinadorEntity create(CoordinadorEntity coordinadorNuevo) {
        em.persist(coordinadorNuevo);
        return coordinadorNuevo;
    }

    /*
    * Actualizar Coordinador | @param NuevaCoordinador | * @return NuevaCoordinador
     */
    public CoordinadorEntity update(CoordinadorEntity coordinadorActualizado) {
        return em.merge(coordinadorActualizado);
    }

    /* ----------------------- Borrar Coordinador | @param id_coordinador -----------------------*/
    public void remove(Long id) {
        CoordinadorEntity coordinadorEliminar = em.find(CoordinadorEntity.class, id);
        em.remove(coordinadorEliminar);
    }

}