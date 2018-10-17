/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.PersonaEntity;
import edu.konrad.notas.persistence.PersonaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Persona
 *
 * @author Jorge Pulido.
 */
@Stateless
public class PersonaLogic {

//    Inyección Persistence de Persona
    @Inject
    private PersonaPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Personas
     *
     * @return listaPersonas
     */
    public List<PersonaEntity> obtenerPersonas() {
        List<PersonaEntity> listaPersonas = persistence.findAll();
        return listaPersonas;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Personas
     * WHERE ID
     *
     * @return PersonaEntity
     */
    public PersonaEntity obtenerPersona(Long id) {
        PersonaEntity persona = persistence.find(id);
        if (persona == null) {
            throw new IllegalArgumentException("El persona solicitado NO existe");
        }
        return persona;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Personas VALUES()
     *
     * @param personaCrear
     * @return
     */
    public PersonaEntity crearPersona(PersonaEntity personaCrear) {
        persistence.create(personaCrear);
        return personaCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Persona
     *
     * @param id
     * @param personaActualizar
     * @return persona actualizada
     */
    public PersonaEntity actualizarPersona(Long id, PersonaEntity personaActualizar) {
        PersonaEntity personaUpdate = persistence.update(personaActualizar);
        return personaUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Persona FROM
     *
     *
     * @param id
     */
    public void eliminarPersona(Long id) {
        persistence.remove(id);
    }

}
