/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;

import edu.konrad.notas.dto.UsuarioDTO;
import edu.konrad.notas.entities.UsuarioEntity;
import edu.konrad.notas.logic.UsuarioLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso de Usuario
 *
 * @author Sergio Ramirez
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/usuarios")
public class UsuarioResource {

    @EJB
    private UsuarioLogic usuarioLogic;

    /**
     * Metodo Obtener Usuarios
     *
     * @return Usuarios
     */
    @GET
    public List<UsuarioDTO> getPersonaList() {
        List<UsuarioEntity> usuarios = usuarioLogic.obtenerUsuarios();
        return UsuarioDTO.toUsuarioList(usuarios);
    }

    /**
     * Metodo Obtener Usuario
     *
     * @Param idUsuario @return Usuario
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDTO getUsuario(@PathParam("id") Long id) {
        UsuarioEntity usuario = usuarioLogic.obtenerUsuario(id);
        if (usuario == null) {
            throw new RuntimeException("La Usuario NO existe.");
        }
        return new UsuarioDTO(usuario);
    }

    /**
     * Metodo Crear Usuario
     *
     * @Param UsuarioDTO
     */
    @POST
    public UsuarioDTO createUsuario(UsuarioDTO usuario) {
        return new UsuarioDTO(usuarioLogic.crearUsuario(usuario.toEntity()));
    }

    /**
     * Metodo Actualizar Usuario
     *
     * @Param idUsuario @Param UsuarioDTO
     * @return UsuarioActualizad@
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDTO updateUsuario(@PathParam("id") Long id, UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = usuarioLogic.obtenerUsuario(id);

        if (usuario == null) {
            throw new RuntimeException("La Usuario NO existe.");
        }
        return new UsuarioDTO(usuarioLogic.actualizarUsuario(id, usuarioDTO.toEntity()));
    }

    /**
     * Metodo Eliminar Usuario
     *
     * @Param idUsuario
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUsuario(@PathParam("id") Long id) {
        UsuarioEntity usuario = usuarioLogic.obtenerUsuario(id);
        if (usuario == null) {
            throw new RuntimeException("La Usuario NO existe.");
        }
        usuarioLogic.eliminarUsuario(id);
    }

    @POST
    @Path("/Login")
    public UsuarioDTO loginUsuario(UsuarioDTO usuario) {
        return new UsuarioDTO(usuarioLogic.login(usuario.toEntity()));
    }

}
