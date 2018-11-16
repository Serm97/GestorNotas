/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.EstudianteEntity;
import edu.konrad.notas.entities.PersonaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Estudiante
 *
 * @author Sergio Ramirez
 */
public class EstudianteDTO {

    /*    Atributos de la entidad Estudiante */
    private Long idEstudiante;
    private Long codEstudiante;
    private PersonaDTO idPersona;

    //    Constructor
    public EstudianteDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param EstudianteEntity 
     */
    public EstudianteDTO(EstudianteEntity estudianteEntity) {
        this.idEstudiante = estudianteEntity.getIdEstudiante();
        this.codEstudiante = estudianteEntity.getCodEstudiante();
        if(estudianteEntity.getIdPersona()!=null){
            PersonaEntity persona = new PersonaEntity();
            persona.setApellidoPersona(estudianteEntity.getIdPersona().getApellidoPersona());
            persona.setNombrePersona(estudianteEntity.getIdPersona().getNombrePersona());
            persona.setNumDocumento(estudianteEntity.getIdPersona().getNumDocumento());
            persona.setIdGenero(estudianteEntity.getIdPersona().getIdGenero());
            persona.setIdTipoDocumento(estudianteEntity.getIdPersona().getIdTipoDocumento());
            persona.setIdPrograma(estudianteEntity.getIdPersona().getIdPrograma());
            persona.setIdPersona(estudianteEntity.getIdPersona().getIdPersona());
            this.idPersona = new PersonaDTO(persona);
        }
        
        
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public EstudianteEntity toEntity(){
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setIdEstudiante(this.idEstudiante);
        estudiante.setCodEstudiante(this.codEstudiante);
        if(this.idPersona!= null){
            PersonaEntity persona = new PersonaEntity();
            persona.setApellidoPersona(this.idPersona.getApellidoPersona());
            persona.setNombrePersona(this.idPersona.getNombrePersona());
            persona.setNumDocumento(this.idPersona.getNumDocumento());
            persona.setIdGenero(this.idPersona.getIdGenero().toEntity());
            persona.setIdTipoDocumento(this.idPersona.getIdTipoDocumento().toEntity());
            persona.setIdPrograma(this.idPersona.getIdPrograma().toEntity());
            persona.setIdPersona(this.idPersona.getIdPersona());
            estudiante.setIdPersona(persona);
        }
        
        return estudiante;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaEstudiantes
     * @return 
     */
    public static List<EstudianteDTO> toEstudianteList(List<EstudianteEntity> listaEstudiantes){
        List<EstudianteDTO> listaEstudiantesDTO = new ArrayList<>();
        for(EstudianteEntity entity : listaEstudiantes){
            listaEstudiantesDTO.add(new EstudianteDTO(entity));
        }
        return listaEstudiantesDTO;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Long getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(Long codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public PersonaDTO getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(PersonaDTO idPersona) {
        this.idPersona = idPersona;
    }
    
    
    

}
