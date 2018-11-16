/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.ProgramaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Transacciones CRUD de la entidad Programa
 *
 * @author Jorge Pulido
 */
@Stateless
public class ProgramaPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Programa | @return lista de programas-----------------------*/
    public List<ProgramaEntity> findAll() {
        Query queryPrograma = em.createQuery("select p from programas p");
        return queryPrograma.getResultList();
    }

    /*
    * Buscar Programa por ID | @param id_programa | * @return lista de programas
     */
    public ProgramaEntity find(Long id) {
        return em.find(ProgramaEntity.class, id);
    }

    /*
    * Crear Programa | @param NuevoPrograma | * @return NuevoPrograma
     */
    public ProgramaEntity create(ProgramaEntity programaNuevo) {
        em.persist(programaNuevo);
        return programaNuevo;
    }

    /*
    * Actualizar Programa | @param NuevoPrograma | * @return NuevoPrograma
     */
    public ProgramaEntity update(ProgramaEntity programaActualizado) {
        return em.merge(programaActualizado);
    }

    /* ----------------------- Borrar Programa | @param id_programa -----------------------*/
    public void remove(Long id) {
        ProgramaEntity programaEliminar = em.find(ProgramaEntity.class, id);
        em.remove(programaEliminar);
    }

}
