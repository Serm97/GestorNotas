/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.DataTypeEntity;
import edu.konrad.notas.entities.PersonaEntity;
import edu.konrad.notas.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Persona
 *
 * @author Jorge Pulido
 */
public class PersonaDTO {

    /*    Atributos de la entidad Persona */
    private Long idPersona;
    private Long numDocumento;
    private String nombrePersona;
    private String apellidoPersona;
    private DataTypeEntity idGenero;
    private DataTypeEntity idTipoDocumento;
    private ProgramaEntity idPrograma;

    //    Constructor
    public PersonaDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param PersonaEntity 
     */
    public PersonaDTO(PersonaEntity personaEntity) {
        this.idPersona = personaEntity.getIdPersona();
        this.numDocumento = personaEntity.getNumDocumento();
        this.nombrePersona = personaEntity.getNombrePersona();
        this.apellidoPersona = personaEntity.getApellidoPersona();
        this.idGenero = personaEntity.getIdGenero();
        this.idTipoDocumento = personaEntity.getIdTipoDocumento();
        this.idPrograma = personaEntity.getIdPrograma();
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public PersonaEntity toEntity(){
        PersonaEntity persona = new PersonaEntity();
        persona.setIdPersona(this.idPersona);
        persona.setNumDocumento(this.numDocumento);
        persona.setNombrePersona(this.nombrePersona);
        persona.setApellidoPersona(this.apellidoPersona);
        persona.setIdGenero(this.idGenero);
        persona.setIdTipoDocumento(this.idTipoDocumento);
        persona.setIdPrograma(this.idPrograma);
        return persona;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaPersonas
     * @return 
     */
    public static List<PersonaDTO> toPersonaList(List<PersonaEntity> listaPersonas){
        List<PersonaDTO> listaPersonasDTO = new ArrayList<>();
        for(PersonaEntity entity : listaPersonas){
            listaPersonasDTO.add(new PersonaDTO(entity));
        }
        return listaPersonasDTO;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(Long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public DataTypeEntity getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(DataTypeEntity idGenero) {
        this.idGenero = idGenero;
    }

    public DataTypeEntity getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(DataTypeEntity idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public ProgramaEntity getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(ProgramaEntity idPrograma) {
        this.idPrograma = idPrograma;
    }
    
    
    

}
