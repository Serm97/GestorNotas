/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.PersonaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Transacciones CRUD de la entidad Persona
 *
 * @author Jorge Pulido
 */
@Stateless
public class PersonaPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Persona | @return lista de personas-----------------------*/
    public List<PersonaEntity> findAll() {
        Query queryPersona = em.createQuery("select dm from personas dm");
        return queryPersona.getResultList();
    }

    /*
    * Buscar Persona por ID | @param id_persona | * @return lista de personas
     */
    public PersonaEntity find(Long id) {
        return em.find(PersonaEntity.class, id);
    }

    /*
    * Crear Persona | @param NuevaPersona | * @return NuevaPersona
     */
    public PersonaEntity create(PersonaEntity personaNueva) {
        em.persist(personaNueva);
        return personaNueva;
    }

    /*
    * Actualizar Persona | @param NuevaPersona | * @return NuevaPersona
     */
    public PersonaEntity update(PersonaEntity personaActualizada) {
        return em.merge(personaActualizada);
    }

    /* ----------------------- Borrar Persona | @param id_persona -----------------------*/
    public void remove(Long id) {
        PersonaEntity personaEliminar = em.find(PersonaEntity.class, id);
        em.remove(personaEliminar);
    }

}
