/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;


import edu.konrad.notas.dto.CalificacionDTO;
import edu.konrad.notas.entities.CalificacionEntity;
import edu.konrad.notas.logic.CalificacionLogic;
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
 * Recurso de Calificacion
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/calificaciones")
public class CalificacionResource {
    
    @EJB
    private CalificacionLogic calificacionLogic;
    
    /** Metodo Obtener Calificacions
        @return Calificacions
    */
    @GET
    public List<CalificacionDTO> getCalificacionList(){
        List <CalificacionEntity> calificaciones = calificacionLogic.obtenerCalificaciones();
        return CalificacionDTO.toCalificacionList(calificaciones);
    }
    
    /** Metodo Obtener Calificacion
        @Param Calificacion @return Calificacion
    */
    @GET
    @Path("{id: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("id") Long id){
        CalificacionEntity calificacion = calificacionLogic.obtenerCalificacion(id);
        if (calificacion == null) {
            throw new RuntimeException("La Calificacion NO existe.");
        }
        return new CalificacionDTO(calificacion);
    }
    
    /** Metodo Crear Calificacion
        @Param CalificacionDTO
    */
    @POST
    public CalificacionDTO createCalificacion(CalificacionDTO calificacion){
        return new CalificacionDTO(calificacionLogic.crearCalificacion(calificacion.toEntity()));
    }
    
    /** Metodo Actualizar Calificacion
        @Param Calificacion @Param CalificacionDTO
        @return CalificacionActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDTO updateCalificacion(@PathParam("id") Long id, CalificacionDTO calificacionDTO){
        CalificacionEntity calificacion = calificacionLogic.obtenerCalificacion(id);
        
        if (calificacion == null) {
            throw new RuntimeException("La Calificacion NO existe.");
        }
        return new CalificacionDTO(calificacionLogic.actualizarCalificacion(id, calificacionDTO.toEntity()));
    }
    
    /** Metodo Eliminar Calificacion
        @Param idCalificacion 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacion(@PathParam("id") Long id){
        CalificacionEntity calificacion = calificacionLogic.obtenerCalificacion(id);
        if (calificacion == null) {
            throw new RuntimeException("La Calificacion NO existe.");
        }
        calificacionLogic.eliminarCalificacion(id);
    }
    
}
