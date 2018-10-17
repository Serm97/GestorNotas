/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.EstadoEntity;
import edu.konrad.notas.persistence.EstadoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Estado
 *
 * @author Sergio Ramirez.
 */
@Stateless
public class EstadoLogic {

//    Inyección Persistence de Estado
    @Inject
    private EstadoPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Estados
     *
     * @return listaEstados
     */
    public List<EstadoEntity> obtenerEstados() {
        List<EstadoEntity> listaEstados = persistence.findAll();
        return listaEstados;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Estados
     * WHERE ID
     *
     * @return EstadoEntity
     */
    public EstadoEntity obtenerEstado(Long id) {
        EstadoEntity estado = persistence.find(id);
        if (estado == null) {
            throw new IllegalArgumentException("El estado solicitado NO existe");
        }
        return estado;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Estados VALUES()
     *
     * @param estadoCrear
     * @return
     */
    public EstadoEntity crearEstado(EstadoEntity estadoCrear) {
        persistence.create(estadoCrear);
        return estadoCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Estado
     *
     * @param id
     * @param estadoActualizar
     * @return estado actualizado
     */
    public EstadoEntity actualizarEstado(Long id, EstadoEntity estadoActualizar) {
        EstadoEntity estadoUpdate = persistence.update(estadoActualizar);
        return estadoUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Estado FROM
     *
     *
     * @param id
     */
    public void eliminarEstado(Long id) {
        persistence.remove(id);
    }

}
