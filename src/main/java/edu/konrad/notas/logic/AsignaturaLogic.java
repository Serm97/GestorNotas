/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.AsignaturaEntity;
import edu.konrad.notas.persistence.AsignaturaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Asignatura
 *
 * @author Sergio Ramirez.
 */
@Stateless
public class AsignaturaLogic {

//    Inyección Persistence de Asignatura
    @Inject
    private AsignaturaPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Asignaturas
     *
     * @return listaAsignaturas
     */
    public List<AsignaturaEntity> obtenerAsignaturas() {
        List<AsignaturaEntity> listaAsignaturas = persistence.findAll();
        return listaAsignaturas;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Asignaturas
     * WHERE ID
     *
     * @return AsignaturaEntity
     */
    public AsignaturaEntity obtenerAsignatura(Long id) {
        AsignaturaEntity asignatura = persistence.find(id);
        if (asignatura == null) {
            throw new IllegalArgumentException("La Asignatura solicitada NO existe");
        }
        return asignatura;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO
     * Asignaturas VALUES()
     *
     * @param asignaturaCrear
     * @return
     */
    public AsignaturaEntity crearAsignatura(AsignaturaEntity asignaturaCrear) {
        persistence.create(asignaturaCrear);
        return asignaturaCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE
     * Asignatura
     *
     * @param id
     * @param asignaturaActualizar
     * @return asignatura actualizada
     */
    public AsignaturaEntity actualizarAsignatura(Long id, AsignaturaEntity asignaturaActualizar) {
        AsignaturaEntity asignaturaUpdate = persistence.update(asignaturaActualizar);
        return asignaturaUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Asignatura FROM
     *
     *
     * @param id
     */
    public void eliminarAsignatura(Long id) {
        persistence.remove(id);
    }

}
