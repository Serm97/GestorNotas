/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;


import edu.konrad.notas.dto.ProgramaDTO;
import edu.konrad.notas.entities.ProgramaEntity;
import edu.konrad.notas.logic.ProgramaLogic;
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
 * Recurso de Programa
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/programas")
public class ProgramaResource {
    
    @EJB
    private ProgramaLogic programaLogic;
    
    /** Metodo Obtener Programas
        @return Programas
    */
    @GET
    public List<ProgramaDTO> getProgramaList(){
        List <ProgramaEntity> programas = programaLogic.obtenerProgramas();
        return ProgramaDTO.toProgramaList(programas);
    }
    
    /** Metodo Obtener Programa
        @Param idPrograma @return Programa
    */
    @GET
    @Path("{id: \\d+}")
    public ProgramaDTO getPrograma(@PathParam("id") Long id){
        ProgramaEntity programa = programaLogic.obtenerPrograma(id);
        if (programa == null) {
            throw new RuntimeException("La Programa NO existe.");
        }
        return new ProgramaDTO(programa);
    }
    
    /** Metodo Crear Programa
        @Param ProgramaDTO
    */
    @POST
    public ProgramaDTO createPrograma(ProgramaDTO programa){
        return new ProgramaDTO(programaLogic.crearPrograma(programa.toEntity()));
    }
    
    /** Metodo Actualizar Programa
        @Param idPrograma @Param ProgramaDTO
        @return ProgramaActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public ProgramaDTO updatePrograma(@PathParam("id") Long id, ProgramaDTO programaDTO){
        ProgramaEntity programa = programaLogic.obtenerPrograma(id);
        
        if (programa == null) {
            throw new RuntimeException("La Programa NO existe.");
        }
        return new ProgramaDTO(programaLogic.actualizarPrograma(id, programaDTO.toEntity()));
    }
    
    /** Metodo Eliminar Programa
        @Param idPrograma 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePrograma(@PathParam("id") Long id){
        ProgramaEntity programa = programaLogic.obtenerPrograma(id);
        if (programa == null) {
            throw new RuntimeException("La Programa NO existe.");
        }
        programaLogic.eliminarPrograma(id);
    }
    
}
