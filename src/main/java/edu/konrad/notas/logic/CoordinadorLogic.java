/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.CoordinadorEntity;
import edu.konrad.notas.persistence.CoordinadorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Coordinador
 *
 * @author Sergio Ramirez.
 */
@Stateless
public class CoordinadorLogic {

//    Inyección Persistence de Coordinador
    @Inject
    private CoordinadorPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Coordinadors
     *
     * @return listaCoordinadores
     */
    public List<CoordinadorEntity> obtenerCoordinadores() {
        List<CoordinadorEntity> listaCoordinadores = persistence.findAll();
        return listaCoordinadores;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Coordinadores
     * WHERE ID
     *
     * @return CoordinadorEntity
     */
    public CoordinadorEntity obtenerCoordinador(Long id) {
        CoordinadorEntity coordinador = persistence.find(id);
        if (coordinador == null) {
            throw new IllegalArgumentException("El coordinador solicitado NO existe");
        }
        return coordinador;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Coordinadores VALUES()
     *
     * @param coordinadorCrear
     * @return
     */
    public CoordinadorEntity crearCoordinador(CoordinadorEntity coordinadorCrear) {
        persistence.create(coordinadorCrear);
        return coordinadorCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Coordinador
     *
     * @param id
     * @param coordinadorActualizar
     * @return coordinador actualizada
     */
    public CoordinadorEntity actualizarCoordinador(Long id, CoordinadorEntity coordinadorActualizar) {
        CoordinadorEntity coordinadorUpdate = persistence.update(coordinadorActualizar);
        return coordinadorUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Coordinador FROM
     *
     *
     * @param id
     */
    public void eliminarCoordinador(Long id) {
        persistence.remove(id);
    }

}
