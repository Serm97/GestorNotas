/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.ProfesorEntity;
import edu.konrad.notas.persistence.ProfesorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Profesor
 *
 * @author Jorge Pulido.
 */
@Stateless
public class ProfesorLogic {

//    Inyección Persistence de Profesor
    @Inject
    private ProfesorPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Profesors
     *
     * @return listaProfesores
     */
    public List<ProfesorEntity> obtenerProfesors() {
        List<ProfesorEntity> listaProfesores = persistence.findAll();
        return listaProfesores;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Profesores
     * WHERE ID
     *
     * @return ProfesorEntity
     */
    public ProfesorEntity obtenerProfesor(Long id) {
        ProfesorEntity profesor = persistence.find(id);
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor solicitado NO existe");
        }
        return profesor;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Profesors VALUES()
     *
     * @param profesorCrear
     * @return
     */
    public ProfesorEntity crearProfesor(ProfesorEntity profesorCrear) {
        persistence.create(profesorCrear);
        return profesorCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Profesor
     *
     * @param id
     * @param profesorActualizar
     * @return profesor actualizado
     */
    public ProfesorEntity actualizarProfesor(Long id, ProfesorEntity profesorActualizar) {
        ProfesorEntity profesorUpdate = persistence.update(profesorActualizar);
        return profesorUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Profesor FROM
     *
     *
     * @param id
     */
    public void eliminarProfesor(Long id) {
        persistence.remove(id);
    }

}
