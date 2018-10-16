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
    private PersonaEntity idPersona;

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
        this.idPersona = estudianteEntity.getIdPersona();
        
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public EstudianteEntity toEntity(){
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setIdEstudiante(this.idEstudiante);
        estudiante.setCodEstudiante(this.codEstudiante);
        estudiante.setIdPersona(this.idPersona);
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

    public PersonaEntity getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(PersonaEntity idPersona) {
        this.idPersona = idPersona;
    }
    
    
    

}
