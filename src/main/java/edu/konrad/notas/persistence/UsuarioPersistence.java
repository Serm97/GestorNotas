/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.UsuarioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Transacciones CRUD de la entidad Usuario
 *
 * @author Jorge Pulido
 */
@Stateless
public class UsuarioPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Usuarios | @return lista de usuarios-----------------------*/
    public List<UsuarioEntity> findAll() {
        Query queryUsuario = em.createQuery("select u from usuarios u");
        return queryUsuario.getResultList();
    }

    /*
    * Buscar Usuario por ID | @param id_usuario | * @return lista de usuarios
     */
    public UsuarioEntity find(Long id) {
        return em.find(UsuarioEntity.class, id);
    }

    /*
    * Crear Usuario | @param NuevoUsuario | * @return NuevoUsuario
     */
    public UsuarioEntity create(UsuarioEntity usuarioNuevo) {
        em.persist(usuarioNuevo);
        return usuarioNuevo;
    }

    /*
    * Actualizar Usuario | @param NuevoUsuario | * @return NuevoUsuario
     */
    public UsuarioEntity update(UsuarioEntity usuarioActualizado) {
        return em.merge(usuarioActualizado);
    }

    /* ----------------------- Borrar Usuario | @param id_usuario -----------------------*/
    public void remove(Long id) {
        UsuarioEntity usuarioEliminar = em.find(UsuarioEntity.class, id);
        em.remove(usuarioEliminar);
    }

    public List<UsuarioEntity> login(UsuarioEntity usuario) {
        Query queryUsuario = em.createQuery("select u from usuarios u where "
                + "u.emailUsuario = '"+usuario.getEmailUsuario()+"' "
                        + "AND u.clave = '"+usuario.getClave()+"' ");
        
        return queryUsuario.getResultList();
    }

}
