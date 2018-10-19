/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.CursoEntity;
import edu.konrad.notas.persistence.CursoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Curso
 *
 * @author Sergio Ramirez.
 */
@Stateless
public class CursoLogic {

//    Inyección Persistence de Curso
    @Inject
    private CursoPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Cursos
     *
     * @return listaCursos
     */
    public List<CursoEntity> obtenerCursos() {
        List<CursoEntity> listaCursos = persistence.findAll();
        return listaCursos;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Cursos WHERE ID
     *
     * @return CursoEntity
     */
    public CursoEntity obtenerCurso(Long id) {
        CursoEntity curso = persistence.find(id);
        if (curso == null) {
            throw new IllegalArgumentException("El curso solicitado NO existe");
        }
        return curso;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Cursos VALUES()
     *
     * @param cursoCrear
     * @return
     */
    public CursoEntity crearCurso(CursoEntity cursoCrear) {
        persistence.create(cursoCrear);
        return cursoCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Curso
     *
     * @param id
     * @param cursoActualizar
     * @return curso actualizada
     */
    public CursoEntity actualizarCurso(Long id, CursoEntity cursoActualizar) {
        CursoEntity cursoUpdate = persistence.update(cursoActualizar);
        return cursoUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Curso FROM
     *
     * @param id
     */
    public void eliminarCurso(Long id) {
        persistence.remove(id);
    }

}
