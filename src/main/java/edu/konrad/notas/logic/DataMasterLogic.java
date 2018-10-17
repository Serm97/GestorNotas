/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.DataMasterEntity;
import edu.konrad.notas.persistence.DataMasterPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de DataMaster
 *
 * @author Sergio Ramirez.
 */
@Stateless
public class DataMasterLogic {

//    Inyección Persistence de DataMaster
    @Inject
    private DataMasterPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM DataMasters
     *
     * @return listaDataMaster
     */
    public List<DataMasterEntity> obtenerDataMaster() {
        List<DataMasterEntity> listaDataMaster = persistence.findAll();
        return listaDataMaster;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM DataMasteres
     * WHERE ID
     *
     * @return DataMasterEntity
     */
    public DataMasterEntity obtenerDataMaster(Long id) {
        DataMasterEntity dataMaster = persistence.find(id);
        if (dataMaster == null) {
            throw new IllegalArgumentException("El tipo dataMaster solicitado NO existe");
        }
        return dataMaster;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO DataMasteres VALUES()
     *
     * @param dataMasterCrear
     * @return
     */
    public DataMasterEntity crearDataMaster(DataMasterEntity dataMasterCrear) {
        persistence.create(dataMasterCrear);
        return dataMasterCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE DataMaster
     *
     * @param id
     * @param dataMasterActualizar
     * @return dataMaster actualizada
     */
    public DataMasterEntity actualizarDataMaster(Long id, DataMasterEntity dataMasterActualizar) {
        DataMasterEntity dataMasterUpdate = persistence.update(dataMasterActualizar);
        return dataMasterUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE DataMaster FROM
     *
     *
     * @param id
     */
    public void eliminarDataMaster(Long id) {
        persistence.remove(id);
    }

}
