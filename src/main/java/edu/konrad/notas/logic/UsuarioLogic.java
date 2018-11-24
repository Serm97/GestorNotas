/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.UsuarioEntity;
import edu.konrad.notas.persistence.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Usuario
 *
 * @author Jorge Pulido.
 */
@Stateless
public class UsuarioLogic {

//    Inyección Persistence de Usuario
    @Inject
    private UsuarioPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Usuarios
     *
     * @return listaUsuarios
     */
    public List<UsuarioEntity> obtenerUsuarios() {
        List<UsuarioEntity> listaUsuarios = persistence.findAll();
        return listaUsuarios;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Usuarios
     * WHERE ID
     *
     * @return UsuarioEntity
     */
    public UsuarioEntity obtenerUsuario(Long id) {
        UsuarioEntity usuario = persistence.find(id);
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario solicitado NO existe");
        }
        return usuario;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Usuarios
     * VALUES()
     *
     * @param usuarioCrear
     * @return
     */
    public UsuarioEntity crearUsuario(UsuarioEntity usuarioCrear) {
        persistence.create(usuarioCrear);
        return usuarioCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE
     * Usuario
     *
     * @param id
     * @param usuarioActualizar
     * @return usuario actualizada
     */
    public UsuarioEntity actualizarUsuario(Long id, UsuarioEntity usuarioActualizar) {
        UsuarioEntity usuarioUpdate = persistence.update(usuarioActualizar);
        return usuarioUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Usuario FROM
     *
     *
     * @param id
     */
    public void eliminarUsuario(Long id) {
        persistence.remove(id);
    }

    public UsuarioEntity login(UsuarioEntity usuario) {
        List<UsuarioEntity> users = null;
        if (!"".equals(usuario.getEmailUsuario()) && !"".equals(usuario.getClave())) {
            users = persistence.login(usuario);
            if (users != null) {
                return users.get(0);
            }
        }
        return null;

    }

}
