/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.AsignaturaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Transacciones CRUD de la entidad Asignatura
 *
 * @author Sergio Ramirez
 */
@Stateless
public class AsignaturaPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Asignaturas | @return lista de asignaturas-----------------------*/
    public List<AsignaturaEntity> findAll() {
        Query queryAsignatura = em.createQuery("select a from asignaturas a");
        return queryAsignatura.getResultList();
    }

    /*
    * Buscar Asignatura por ID | @param id_asignatura | * @return lista de Asignaturas
     */
    public AsignaturaEntity find(Long id) {
        return em.find(AsignaturaEntity.class, id);
    }

    /*
    * Crear Asignatura | @param NuevaAsignatura | * @return NuevaAsignatura
     */
    public AsignaturaEntity create(AsignaturaEntity asignaturaNueva) {
        em.persist(asignaturaNueva);
        return asignaturaNueva;
    }

    /*
    * Actualizar Asignatura | @param NuevaAsignatura | * @return NuevaAsignatura
     */
    public AsignaturaEntity update(AsignaturaEntity asignaturaActualizada) {
        return em.merge(asignaturaActualizada);
    }

    /* ----------------------- Borrar Asignatura | @param id_asignatura -----------------------*/
    public void remove(Long id) {
        AsignaturaEntity asignaturaEliminar = em.find(AsignaturaEntity.class, id);
        em.remove(asignaturaEliminar);
    }

}
