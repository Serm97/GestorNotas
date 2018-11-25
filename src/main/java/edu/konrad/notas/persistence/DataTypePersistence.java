/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.DataTypeEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Transacciones CRUD de la entidad DataType
 *
 * @author Sergio Ramirez
 */
@Stateless
public class DataTypePersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar DataType | @return lista de datatype-----------------------*/
    public List<DataTypeEntity> findAll() {
        Query queryDataType = em.createQuery("select dm from dataType dm");
        return queryDataType.getResultList();
    }

    /*
    * Buscar DataType por ID | @param id_dataType | * @return lista de datatype
     */
    public DataTypeEntity find(Long id) {
        return em.find(DataTypeEntity.class, id);
    }

    /*
    * Crear DataType | @param NuevoDataType | * @return NuevoDataType
     */
    public DataTypeEntity create(DataTypeEntity dataTypeNuevo) {
        em.persist(dataTypeNuevo);
        return dataTypeNuevo;
    }

    /*
    * Actualizar DataType | @param NuevoDataType | * @return NuevoDataType
     */
    public DataTypeEntity update(DataTypeEntity dataTypeActualizado) {
        return em.merge(dataTypeActualizado);
    }

    /* ----------------------- Borrar DataType | @param id_dataType -----------------------*/
    public void remove(Long id) {
        DataTypeEntity dataTypeEliminar = em.find(DataTypeEntity.class, id);
        em.remove(dataTypeEliminar);
    }

    public List<DataTypeEntity> findByMaster(String nombre) {
        Query queryDataType = em.createQuery("select d from dataType d where d.idDataMaster.nombreData LIKE '%"+nombre+"%'");
        return queryDataType.getResultList();
    }

}
