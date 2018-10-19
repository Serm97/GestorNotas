/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;


import edu.konrad.notas.dto.EstudianteDTO;
import edu.konrad.notas.entities.EstudianteEntity;
import edu.konrad.notas.logic.EstudianteLogic;
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
 * Reestudiante de Estudiante
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estudiantes")
public class EstudianteResource {
    
    @EJB
    private EstudianteLogic estudianteLogic;
    
    /** Metodo Obtener Estudiantes
        @return Estudiantes
    */
    @GET
    public List<EstudianteDTO> getEstudianteList(){
        List <EstudianteEntity> estudiantes = estudianteLogic.obtenerEstudiantes();
        return EstudianteDTO.toEstudianteList(estudiantes);
    }
    
    /** Metodo Obtener Estudiante
        @Param idEstudiante @return Estudiante
    */
    @GET
    @Path("{id: \\d+}")
    public EstudianteDTO getEstudiante(@PathParam("id") Long id){
        EstudianteEntity estudiante = estudianteLogic.obtenerEstudiante(id);
        if (estudiante == null) {
            throw new RuntimeException("La Estudiante NO existe.");
        }
        return new EstudianteDTO(estudiante);
    }
    
    /** Metodo Crear Estudiante
        @Param EstudianteDTO
    */
    @POST
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante){
        return new EstudianteDTO(estudianteLogic.crearEstudiante(estudiante.toEntity()));
    }
    
    /** Metodo Actualizar Estudiante
        @Param idEstudiante @Param EstudianteDTO
        @return EstudianteActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public EstudianteDTO updateEstudiante(@PathParam("id") Long id, EstudianteDTO estudianteDTO){
        EstudianteEntity estudiante = estudianteLogic.obtenerEstudiante(id);
        
        if (estudiante == null) {
            throw new RuntimeException("La Estudiante NO existe.");
        }
        return new EstudianteDTO(estudianteLogic.actualizarEstudiante(id, estudianteDTO.toEntity()));
    }
    
    /** Metodo Eliminar Estudiante
        @Param idEstudiante 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEstudiante(@PathParam("id") Long id){
        EstudianteEntity estudiante = estudianteLogic.obtenerEstudiante(id);
        if (estudiante == null) {
            throw new RuntimeException("La Estudiante NO existe.");
        }
        estudianteLogic.eliminarEstudiante(id);
    }
    
}
