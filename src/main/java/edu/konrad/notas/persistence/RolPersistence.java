/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.RolEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Transacciones CRUD de la entidad Rol
 *
 * @author Jorge Pulido
 */
@Stateless
public class RolPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Rol | @return lista de roles-----------------------*/
    public List<RolEntity> findAll() {
        Query queryRol = em.createQuery("select dm from Rol dm");
        return queryRol.getResultList();
    }

    /*
    * Buscar Rol por ID | @param id_rol | * @return lista de roles
     */
    public RolEntity find(Long id) {
        return em.find(RolEntity.class, id);
    }

    /*
    * Crear Rol | @param NuevoRol | * @return NuevoRol
     */
    public RolEntity create(RolEntity rolNuevo) {
        em.persist(rolNuevo);
        return rolNuevo;
    }

    /*
    * Actualizar Rol | @param NuevoRol | * @return NuevoRol
     */
    public RolEntity update(RolEntity rolActualizado) {
        return em.merge(rolActualizado);
    }

    /* ----------------------- Borrar Rol | @param id_rol -----------------------*/
    public void remove(Long id) {
        RolEntity rolEliminar = em.find(RolEntity.class, id);
        em.remove(rolEliminar);
    }

}
