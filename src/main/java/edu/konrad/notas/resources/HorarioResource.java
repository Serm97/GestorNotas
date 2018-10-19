/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;


import edu.konrad.notas.dto.HorarioDTO;
import edu.konrad.notas.entities.HorarioEntity;
import edu.konrad.notas.logic.HorarioLogic;
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
 * Rehorario de Horario
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/horarios")
public class HorarioResource {
    
    @EJB
    private HorarioLogic horarioLogic;
    
    /** Metodo Obtener Horarios
        @return Horarios
    */
    @GET
    public List<HorarioDTO> getHorarioList(){
        List <HorarioEntity> horarios = horarioLogic.obtenerHorarios();
        return HorarioDTO.toHorarioList(horarios);
    }
    
    /** Metodo Obtener Horario
        @Param idHorario @return Horario
    */
    @GET
    @Path("{id: \\d+}")
    public HorarioDTO getHorario(@PathParam("id") Long id){
        HorarioEntity horario = horarioLogic.obtenerHorario(id);
        if (horario == null) {
            throw new RuntimeException("La Horario NO existe.");
        }
        return new HorarioDTO(horario);
    }
    
    /** Metodo Crear Horario
        @Param HorarioDTO
    */
    @POST
    public HorarioDTO createHorario(HorarioDTO horario){
        return new HorarioDTO(horarioLogic.crearHorario(horario.toEntity()));
    }
    
    /** Metodo Actualizar Horario
        @Param idHorario @Param HorarioDTO
        @return HorarioActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public HorarioDTO updateHorario(@PathParam("id") Long id, HorarioDTO horarioDTO){
        HorarioEntity horario = horarioLogic.obtenerHorario(id);
        
        if (horario == null) {
            throw new RuntimeException("La Horario NO existe.");
        }
        return new HorarioDTO(horarioLogic.actualizarHorario(id, horarioDTO.toEntity()));
    }
    
    /** Metodo Eliminar Horario
        @Param idHorario 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHorario(@PathParam("id") Long id){
        HorarioEntity horario = horarioLogic.obtenerHorario(id);
        if (horario == null) {
            throw new RuntimeException("La Horario NO existe.");
        }
        horarioLogic.eliminarHorario(id);
    }
    
}
