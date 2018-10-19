/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;


import edu.konrad.notas.dto.InscripcionDTO;
import edu.konrad.notas.entities.InscripcionEntity;
import edu.konrad.notas.logic.InscripcionLogic;
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
 * Recurso de Inscripcion
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")
public class InscripcionResource {
    
    @EJB
    private InscripcionLogic inscripcionLogic;
    
    /** Metodo Obtener Inscripcions
        @return Inscripcions
    */
    @GET
    public List<InscripcionDTO> getInscripcionList(){
        List <InscripcionEntity> inscripciones = inscripcionLogic.obtenerInscripciones();
        return InscripcionDTO.toInscripcionList(inscripciones);
    }
    
    /** Metodo Obtener Inscripcion
        @Param idInscripcion @return Inscripcion
    */
    @GET
    @Path("{id: \\d+}")
    public InscripcionDTO getInscripcion(@PathParam("id") Long id){
        InscripcionEntity inscripcion = inscripcionLogic.obtenerInscripcion(id);
        if (inscripcion == null) {
            throw new RuntimeException("La Inscripcion NO existe.");
        }
        return new InscripcionDTO(inscripcion);
    }
    
    /** Metodo Crear Inscripcion
        @Param InscripcionDTO
    */
    @POST
    public InscripcionDTO createInscripcion(InscripcionDTO inscripcion){
        return new InscripcionDTO(inscripcionLogic.crearInscripcion(inscripcion.toEntity()));
    }
    
    /** Metodo Actualizar Inscripcion
        @Param idInscripcion @Param InscripcionDTO
        @return InscripcionActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public InscripcionDTO updateInscripcion(@PathParam("id") Long id, InscripcionDTO inscripcionDTO){
        InscripcionEntity inscripcion = inscripcionLogic.obtenerInscripcion(id);
        
        if (inscripcion == null) {
            throw new RuntimeException("La Inscripcion NO existe.");
        }
        return new InscripcionDTO(inscripcionLogic.actualizarInscripcion(id, inscripcionDTO.toEntity()));
    }
    
    /** Metodo Eliminar Inscripcion
        @Param idInscripcion 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteInscripcion(@PathParam("id") Long id){
        InscripcionEntity inscripcion = inscripcionLogic.obtenerInscripcion(id);
        if (inscripcion == null) {
            throw new RuntimeException("La Inscripcion NO existe.");
        }
        inscripcionLogic.eliminarInscripcion(id);
    }
    
}
