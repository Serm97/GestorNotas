/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;

import edu.konrad.notas.dto.AsignaturaDTO;
import edu.konrad.notas.entities.AsignaturaEntity;
import edu.konrad.notas.logic.AsignaturaLogic;
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
 * Recurso de Asignatura
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/asignaturas")
public class AsignaturaResource {
    
    @EJB
    private AsignaturaLogic asignaturaLogic;
    
    /** Metodo Obtener Asignaturas
        @return ListaAsignaturas
    */
    @GET
    public List<AsignaturaDTO> getAsignaturaList(){
        List <AsignaturaEntity> asignaturas = asignaturaLogic.obtenerAsignaturas();
        return AsignaturaDTO.toAsignaturaList(asignaturas);
    }
    
    /** Metodo Obtener Asignatura
        @Param idAsignatura @return Asignatura
    */
    @GET
    @Path("{id: \\d+}")
    public AsignaturaDTO getAsignatura(@PathParam("id") Long id){
        AsignaturaEntity asignatura = asignaturaLogic.obtenerAsignatura(id);
        if (asignatura == null) {
            throw new RuntimeException("La Asignatura NO existe.");
        }
        return new AsignaturaDTO(asignatura);
    }
    
    /** Metodo Crear Asignatura
        @Param AsignaturaDTO
    */
    @POST
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignatura){
        return new AsignaturaDTO(asignaturaLogic.crearAsignatura(asignatura.toEntity()));
    }
    
    /** Metodo Actualizar Asignatura
        @Param idAsignatura @Param AsignaturaDTO
        @return AsignaturaActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public AsignaturaDTO updateAsignatura(@PathParam("id") Long id, AsignaturaDTO asignaturaDTO){
        AsignaturaEntity asignatura = asignaturaLogic.obtenerAsignatura(id);
        
        if (asignatura == null) {
            throw new RuntimeException("La Asignatura NO existe.");
        }
        return new AsignaturaDTO(asignaturaLogic.actualizarAsignatura(id, asignaturaDTO.toEntity()));
    }
    
    /** Metodo Eliminar Asignatura
        @Param idAsignatura 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteAsignatura(@PathParam("id") Long id){
        AsignaturaEntity asignatura = asignaturaLogic.obtenerAsignatura(id);
        if (asignatura == null) {
            throw new RuntimeException("La Asignatura NO existe.");
        }
        asignaturaLogic.eliminarAsignatura(id);
    }
    
}
