/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.HorarioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Transacciones CRUD de la entidad Horario
 *
 * @author Jorge Pulido
 */
@Stateless
public class HorarioPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Horario | @return lista de horarios-----------------------*/
    public List<HorarioEntity> findAll() {
        Query queryHorario = em.createQuery("select dm from Horario dm");
        return queryHorario.getResultList();
    }

    /*
    * Buscar Horario por ID | @param id_horario | * @return lista de horarios
     */
    public HorarioEntity find(Long id) {
        return em.find(HorarioEntity.class, id);
    }

    /*
    * Crear Horario | @param NuevoHorario | * @return NuevoHorario
     */
    public HorarioEntity create(HorarioEntity horarioNuevo) {
        em.persist(horarioNuevo);
        return horarioNuevo;
    }

    /*
    * Actualizar Horario | @param NuevoHorario | * @return NuevoHorario
     */
    public HorarioEntity update(HorarioEntity horarioActualizado) {
        return em.merge(horarioActualizado);
    }

    /* ----------------------- Borrar Horario | @param id_horario -----------------------*/
    public void remove(Long id) {
        HorarioEntity horarioEliminar = em.find(HorarioEntity.class, id);
        em.remove(horarioEliminar);
    }

}
