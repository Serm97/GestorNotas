/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.CalificacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Transacciones CRUD de la entidad Calificacion
 *
 * @author Sergio Ramirez
 */
@Stateless
public class CalificacionPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Calificaciones | @return lista de calificaciones-----------------------*/
    public List<CalificacionEntity> findAll() {
        Query queryCalificacion = em.createQuery("select ca from Calificacion ca");
        return queryCalificacion.getResultList();
    }

    /*
    * Buscar Calificacion por ID | @param id_calificacion | * @return lista de Calificaciones
     */
    public CalificacionEntity find(Long id) {
        return em.find(CalificacionEntity.class, id);
    }

    /*
    * Crear Calificacion | @param NuevaCalificacion | * @return NuevaCalificacion
     */
    public CalificacionEntity create(CalificacionEntity calificacionNueva) {
        em.persist(calificacionNueva);
        return calificacionNueva;
    }

    /*
    * Actualizar Calificacion | @param NuevaCalificacion | * @return NuevaCalificacion
     */
    public CalificacionEntity update(CalificacionEntity calificacionActualizada) {
        return em.merge(calificacionActualizada);
    }

    /* ----------------------- Borrar Calificacion | @param id_calificacion -----------------------*/
    public void remove(Long id) {
        CalificacionEntity calificacionEliminar = em.find(CalificacionEntity.class, id);
        em.remove(calificacionEliminar);
    }

}
