/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.EstudianteEntity;
import edu.konrad.notas.persistence.EstudiantePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Estudiante
 *
 * @author Sergio Ramirez.
 */
@Stateless
public class EstudianteLogic {

//    Inyección Persistence de Estudiante
    @Inject
    private EstudiantePersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Estudiantes
     *
     * @return listaEstudiantes
     */
    public List<EstudianteEntity> obtenerEstudiantes() {
        List<EstudianteEntity> listaEstudiantes = persistence.findAll();
        return listaEstudiantes;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Estudiantes
     * WHERE ID
     *
     * @return EstudianteEntity
     */
    public EstudianteEntity obtenerEstudiante(Long id) {
        EstudianteEntity estudiante = persistence.find(id);
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante solicitado NO existe");
        }
        return estudiante;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Estudiantes VALUES()
     *
     * @param estudianteCrear
     * @return
     */
    public EstudianteEntity crearEstudiante(EstudianteEntity estudianteCrear) {
        persistence.create(estudianteCrear);
        return estudianteCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Estudiante
     *
     * @param id
     * @param estudianteActualizar
     * @return estudiante actualizado
     */
    public EstudianteEntity actualizarEstudiante(Long id, EstudianteEntity estudianteActualizar) {
        EstudianteEntity estudianteUpdate = persistence.update(estudianteActualizar);
        return estudianteUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Estudiante FROM
     *
     *
     * @param id
     */
    public void eliminarEstudiante(Long id) {
        persistence.remove(id);
    }

}
