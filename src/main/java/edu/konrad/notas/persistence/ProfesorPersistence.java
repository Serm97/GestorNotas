/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.ProfesorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Transacciones CRUD de la entidad Profesor
 *
 * @author Jorge Pulido
 */
@Stateless
public class ProfesorPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Profesor | @return lista de profesores-----------------------*/
    public List<ProfesorEntity> findAll() {
        Query queryProfesor = em.createQuery("select dm from Profesor dm");
        return queryProfesor.getResultList();
    }

    /*
    * Buscar Profesor por ID | @param id_profesor | * @return lista de profesores
     */
    public ProfesorEntity find(Long id) {
        return em.find(ProfesorEntity.class, id);
    }

    /*
    * Crear Profesor | @param NuevoProfesor | * @return NuevoProfesor
     */
    public ProfesorEntity create(ProfesorEntity profesorNuevo) {
        em.persist(profesorNuevo);
        return profesorNuevo;
    }

    /*
    * Actualizar Profesor | @param NuevoProfesor | * @return NuevoProfesor
     */
    public ProfesorEntity update(ProfesorEntity profesorActualizado) {
        return em.merge(profesorActualizado);
    }

    /* ----------------------- Borrar Profesor | @param id_profesor -----------------------*/
    public void remove(Long id) {
        ProfesorEntity profesorEliminar = em.find(ProfesorEntity.class, id);
        em.remove(profesorEliminar);
    }

}
