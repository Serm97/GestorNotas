/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.DataMasterEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Transacciones CRUD de la entidad DataMaster
 *
 * @author Sergio Ramirez
 */
@Stateless
public class DataMasterPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar DataMaster | @return lista de datamaster-----------------------*/
    public List<DataMasterEntity> findAll() {
        Query queryDataMaster = em.createQuery("select dm from datamaster dm");
        return queryDataMaster.getResultList();
    }

    /*
    * Buscar DataMaster por ID | @param id_dataMaster | * @return lista de datamaster
     */
    public DataMasterEntity find(Long id) {
        return em.find(DataMasterEntity.class, id);
    }

    /*
    * Crear DataMaster | @param NuevoDataMaster | * @return NuevoDataMaster
     */
    public DataMasterEntity create(DataMasterEntity dataMasterNuevo) {
        em.persist(dataMasterNuevo);
        return dataMasterNuevo;
    }

    /*
    * Actualizar DataMaster | @param NuevoDataMaster | * @return NuevoDataMaster
     */
    public DataMasterEntity update(DataMasterEntity dataMasterActualizado) {
        return em.merge(dataMasterActualizado);
    }

    /* ----------------------- Borrar DataMaster | @param id_dataMaster -----------------------*/
    public void remove(Long id) {
        DataMasterEntity dataMasterEliminar = em.find(DataMasterEntity.class, id);
        em.remove(dataMasterEliminar);
    }

}
