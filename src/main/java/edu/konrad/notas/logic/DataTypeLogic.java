/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.DataTypeEntity;
import edu.konrad.notas.persistence.DataTypePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de DataType
 *
 * @author Sergio Ramirez.
 */
@Stateless
public class DataTypeLogic {

//    Inyección Persistence de DataType
    @Inject
    private DataTypePersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM DataTypes
     *
     * @return listaDataType
     */
    public List<DataTypeEntity> obtenerDataTypees() {
        List<DataTypeEntity> listaDataType = persistence.findAll();
        return listaDataType;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM DataTypees
     * WHERE ID
     *
     * @return DataTypeEntity
     */
    public DataTypeEntity obtenerDataType(Long id) {
        DataTypeEntity dataType = persistence.find(id);
        if (dataType == null) {
            throw new IllegalArgumentException("El dataType solicitado NO existe");
        }
        return dataType;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO DataTypees VALUES()
     *
     * @param dataTypeCrear
     * @return
     */
    public DataTypeEntity crearDataType(DataTypeEntity dataTypeCrear) {
        persistence.create(dataTypeCrear);
        return dataTypeCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE DataType
     *
     * @param id
     * @param dataTypeActualizar
     * @return dataType actualizado
     */
    public DataTypeEntity actualizarDataType(Long id, DataTypeEntity dataTypeActualizar) {
        DataTypeEntity dataTypeUpdate = persistence.update(dataTypeActualizar);
        return dataTypeUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE DataType FROM
     *
     *
     * @param id
     */
    public void eliminarDataType(Long id) {
        persistence.remove(id);
    }

    public List<DataTypeEntity> obtenerDataTypeByMaster(String nombre) {
        List<DataTypeEntity> listaDataType = persistence.findByMaster(nombre);
        return listaDataType;
    }

}
