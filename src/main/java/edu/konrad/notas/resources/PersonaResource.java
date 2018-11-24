/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;


import edu.konrad.notas.dto.PersonaDTO;
import edu.konrad.notas.entities.PersonaEntity;
import edu.konrad.notas.logic.PersonaLogic;
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
 * Recurso de Persona
 * @author Sergio Ramirez
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/personas")
public class PersonaResource {
    
    @EJB
    private PersonaLogic personaLogic;
    
    /** Metodo Obtener Personas
        @return Personas
    */
    @GET
    public List<PersonaDTO> getPersonaList(){
        List <PersonaEntity> personas = personaLogic.obtenerPersonas();
        return PersonaDTO.toPersonaList(personas);
    }
    
    /** Metodo Obtener Persona
        @Param idPersona @return Persona    
    */
    @GET
    @Path("{id: \\d+}")
    public PersonaDTO getPersona(@PathParam("id") Long id){
        PersonaEntity persona = personaLogic.obtenerPersona(id);
        if (persona == null) {
            throw new RuntimeException("La Persona NO existe.");
        }
        return new PersonaDTO(persona);
    }
    
    /** Metodo Crear Persona
        @Param PersonaDTO
    */
    @POST
    public PersonaDTO createPersona(PersonaDTO persona){
        return new PersonaDTO(personaLogic.crearPersona(persona.toEntity()));
    }
    
    /** Metodo Actualizar Persona
        @Param idPersona @Param PersonaDTO
        @return PersonaActualizad@
    */
    @PUT
    @Path("{id: \\d+}")
    public PersonaDTO updatePersona(@PathParam("id") Long id, PersonaDTO personaDTO){
        PersonaEntity persona = personaLogic.obtenerPersona(id);
        
        if (persona == null) {
            throw new RuntimeException("La Persona NO existe.");
        }
        return new PersonaDTO(personaLogic.actualizarPersona(id, personaDTO.toEntity()));
    }
    
    /** Metodo Eliminar Persona
        @Param idPersona 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePersona(@PathParam("id") Long id){
        PersonaEntity persona = personaLogic.obtenerPersona(id);
        if (persona == null) {
            throw new RuntimeException("La Persona NO existe.");
        }
        personaLogic.eliminarPersona(id);
    }
    
}
