/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;

import edu.konrad.notas.dto.CursoDTO;
import edu.konrad.notas.entities.CursoEntity;
import edu.konrad.notas.logic.CursoLogic;
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
 * Recurso de Curso
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cursos")
public class CursoResource {
    
    @EJB
    private CursoLogic cursoLogic;
    
    /** Metodo Obtener Cursos
        @return Cursos
    */
    @GET
    public List<CursoDTO> getCursoList(){
        List <CursoEntity> cursos = cursoLogic.obtenerCursos();
        return CursoDTO.toCursoList(cursos);
    }
    
    /** Metodo Obtener Curso
        @Param idCurso @return Curso
    */
    @GET
    @Path("{id: \\d+}")
    public CursoDTO getCurso(@PathParam("id") Long id){
        CursoEntity curso = cursoLogic.obtenerCurso(id);
        if (curso == null) {
            throw new RuntimeException("La Curso NO existe.");
        }
        return new CursoDTO(curso);
    }
    
    /** Metodo Crear Curso
        @Param CursoDTO
    */
    @POST
    public CursoDTO createCurso(CursoDTO curso){
        return new CursoDTO(cursoLogic.crearCurso(curso.toEntity()));
    }
    
    /** Metodo Actualizar Curso
        @Param idCurso @Param CursoDTO
        @return CursoActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public CursoDTO updateCurso(@PathParam("id") Long id, CursoDTO cursoDTO){
        CursoEntity curso = cursoLogic.obtenerCurso(id);
        
        if (curso == null) {
            throw new RuntimeException("La Curso NO existe.");
        }
        return new CursoDTO(cursoLogic.actualizarCurso(id, cursoDTO.toEntity()));
    }
    
    /** Metodo Eliminar Curso
        @Param idCurso 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCurso(@PathParam("id") Long id){
        CursoEntity curso = cursoLogic.obtenerCurso(id);
        if (curso == null) {
            throw new RuntimeException("La Curso NO existe.");
        }
        cursoLogic.eliminarCurso(id);
    }
    
}
