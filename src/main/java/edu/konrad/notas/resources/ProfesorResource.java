/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;


import edu.konrad.notas.dto.ProfesorDTO;
import edu.konrad.notas.entities.ProfesorEntity;
import edu.konrad.notas.logic.ProfesorLogic;
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
 * Recurso de Profesor
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/profesores")
public class ProfesorResource {
    
    @EJB
    private ProfesorLogic profesorLogic;
    
    /** Metodo Obtener Profesors
        @return Profesores
    */
    @GET
    public List<ProfesorDTO> getProfesorList(){
        List <ProfesorEntity> profesores = profesorLogic.obtenerProfesores();
        return ProfesorDTO.toProfesorList(profesores);
    }
    
    /** Metodo Obtener Profesor
        @Param idProfesor @return Profesor
    */
    @GET
    @Path("{id: \\d+}")
    public ProfesorDTO getProfesor(@PathParam("id") Long id){
        ProfesorEntity profesor = profesorLogic.obtenerProfesor(id);
        if (profesor == null) {
            throw new RuntimeException("La Profesor NO existe.");
        }
        return new ProfesorDTO(profesor);
    }
    
    /** Metodo Crear Profesor
        @Param ProfesorDTO
    */
    @POST
    public ProfesorDTO createProfesor(ProfesorDTO profesor){
        return new ProfesorDTO(profesorLogic.crearProfesor(profesor.toEntity()));
    }
    
    /** Metodo Actualizar Profesor
        @Param idProfesor @Param ProfesorDTO
        @return ProfesorActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public ProfesorDTO updateProfesor(@PathParam("id") Long id, ProfesorDTO profesorDTO){
        ProfesorEntity profesor = profesorLogic.obtenerProfesor(id);
        
        if (profesor == null) {
            throw new RuntimeException("La Profesor NO existe.");
        }
        return new ProfesorDTO(profesorLogic.actualizarProfesor(id, profesorDTO.toEntity()));
    }
    
    /** Metodo Eliminar Profesor
        @Param idProfesor 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProfesor(@PathParam("id") Long id){
        ProfesorEntity profesor = profesorLogic.obtenerProfesor(id);
        if (profesor == null) {
            throw new RuntimeException("La Profesor NO existe.");
        }
        profesorLogic.eliminarProfesor(id);
    }
    
}
