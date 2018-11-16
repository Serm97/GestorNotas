/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.InscripcionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Transacciones CRUD de la entidad Inscripcion
 *
 * @author Jorge Pulido
 */
@Stateless
public class InscripcionPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Inscripcion | @return lista de inscripciones-----------------------*/
    public List<InscripcionEntity> findAll() {
        Query queryInscripcion = em.createQuery("select dm from inscripciones dm");
        return queryInscripcion.getResultList();
    }

    /*
    * Buscar Inscripcion por ID | @param id_inscripcion | * @return lista de inscripciones
     */
    public InscripcionEntity find(Long id) {
        return em.find(InscripcionEntity.class, id);
    }

    /*
    * Crear Inscripcion | @param NuevaInscripcion | * @return NuevaInscripcion
     */
    public InscripcionEntity create(InscripcionEntity inscripcionNueva) {
        em.persist(inscripcionNueva);
        return inscripcionNueva;
    }

    /*
    * Actualizar Inscripcion | @param NuevaInscripcion | * @return NuevaInscripcion
     */
    public InscripcionEntity update(InscripcionEntity inscripcionActualizada) {
        return em.merge(inscripcionActualizada);
    }

    /* ----------------------- Borrar Inscripcion | @param id_inscripcion -----------------------*/
    public void remove(Long id) {
        InscripcionEntity inscripcionEliminar = em.find(InscripcionEntity.class, id);
        em.remove(inscripcionEliminar);
    }

}
