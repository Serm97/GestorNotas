/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.persistence;

import edu.konrad.notas.entities.EstudianteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Transacciones CRUD de la entidad Estudiante
 *
 * @author Sergio Ramirez
 */
@Stateless
public class EstudiantePersistence {

    /* ----------------------- Instancia Entity Manager -----------------------*/
    @PersistenceContext(unitName = "GestorNotasPU")
    private EntityManager em;

    /* ----------------------- Listar Estudiante | @return lista de estudiantes-----------------------*/
    public List<EstudianteEntity> findAll() {
        Query queryEstudiante = em.createQuery("select dm from Estudiante dm");
        return queryEstudiante.getResultList();
    }

    /*
    * Buscar Estudiante por ID | @param id_estudiante | * @return lista de estudiantes
     */
    public EstudianteEntity find(Long id) {
        return em.find(EstudianteEntity.class, id);
    }

    /*
    * Crear Estudiante | @param NuevoEstudiante | * @return NuevoEstudiante
     */
    public EstudianteEntity create(EstudianteEntity estudianteNuevo) {
        em.persist(estudianteNuevo);
        return estudianteNuevo;
    }

    /*
    * Actualizar Estudiante | @param NuevoEstudiante | * @return NuevoEstudiante
     */
    public EstudianteEntity update(EstudianteEntity estudianteActualizado) {
        return em.merge(estudianteActualizado);
    }

    /* ----------------------- Borrar Estudiante | @param id_estudiante -----------------------*/
    public void remove(Long id) {
        EstudianteEntity estudianteEliminar = em.find(EstudianteEntity.class, id);
        em.remove(estudianteEliminar);
    }

}
