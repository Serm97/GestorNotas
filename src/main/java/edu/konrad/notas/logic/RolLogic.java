/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.RolEntity;
import edu.konrad.notas.persistence.RolPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Rol
 *
 * @author Jorge Pulido.
 */
@Stateless
public class RolLogic {

//    Inyección Persistence de Rol
    @Inject
    private RolPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Rols
     *
     * @return listaRoles
     */
    public List<RolEntity> obtenerRoles() {
        List<RolEntity> listaRoles = persistence.findAll();
        return listaRoles;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Rols
     * WHERE ID
     *
     * @return RolEntity
     */
    public RolEntity obtenerRol(Long id) {
        RolEntity rol = persistence.find(id);
        if (rol == null) {
            throw new IllegalArgumentException("El rol solicitado NO existe");
        }
        return rol;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Rols VALUES()
     *
     * @param rolCrear
     * @return
     */
    public RolEntity crearRol(RolEntity rolCrear) {
        persistence.create(rolCrear);
        return rolCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Rol
     *
     * @param id
     * @param rolActualizar
     * @return rol actualizado
     */
    public RolEntity actualizarRol(Long id, RolEntity rolActualizar) {
        RolEntity rolUpdate = persistence.update(rolActualizar);
        return rolUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Rol FROM
     *
     *
     * @param id
     */
    public void eliminarRol(Long id) {
        persistence.remove(id);
    }

}
