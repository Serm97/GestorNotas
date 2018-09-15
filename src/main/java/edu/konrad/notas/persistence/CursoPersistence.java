/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.CursoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Transacciones CRUD de la entidad Curso
 *
 * @author Sergio Ramirez
 */
@Stateless
public class CursoPersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Cursos | @return lista de cursos-----------------------*/
    public List<CursoEntity> findAll() {
        Query queryCurso = em.createQuery("select c from Curso c");
        return queryCurso.getResultList();
    }

    /*
    * Buscar Curso por ID | @param id_curso | * @return lista de Cursos
     */
    public CursoEntity find(Long id) {
        return em.find(CursoEntity.class, id);
    }

    /*
    * Crear Curso | @param NuevaCurso | * @return NuevaCurso
     */
    public CursoEntity create(CursoEntity cursoNuevo) {
        em.persist(cursoNuevo);
        return cursoNuevo;
    }

    /*
    * Actualizar Curso | @param NuevoCurso | * @return NuevoCurso
     */
    public CursoEntity update(CursoEntity cursoActualizado) {
        return em.merge(cursoActualizado);
    }

    /* ----------------------- Borrar Curso | @param id_curso -----------------------*/
    public void remove(Long id) {
        CursoEntity cursoEliminar = em.find(CursoEntity.class, id);
        em.remove(cursoEliminar);
    }

}
