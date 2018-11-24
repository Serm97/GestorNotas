/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;

import edu.konrad.notas.entities.PersonaEntity;
import edu.konrad.notas.entities.ProfesorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Profesor
 *
 * @author Jorge Pulido
 */
public class ProfesorDTO {

    /*    Atributos de la entidad Profesor */
    private Long idProfesor;
    private Long codprofesor;
    private String areaProfundizacion;
    private PersonaDTO idPersona;

    //    Constructor
    public ProfesorDTO() {
    }

    /**
     * Transformacion Entidad - Objeto
     *
     * @param ProfesorEntity
     */
    public ProfesorDTO(ProfesorEntity profesorEntity) {
        this.idProfesor = profesorEntity.getIdProfesor();
        this.codprofesor = profesorEntity.getCodprofesor();
        this.areaProfundizacion = profesorEntity.getAreaProfundizacion();
        if (profesorEntity.getIdPersona() != null) {
            PersonaEntity persona = new PersonaEntity();
            persona.setApellidoPersona(profesorEntity.getIdPersona().getApellidoPersona());
            persona.setNombrePersona(profesorEntity.getIdPersona().getNombrePersona());
            persona.setNumDocumento(profesorEntity.getIdPersona().getNumDocumento());
            persona.setIdGenero(profesorEntity.getIdPersona().getIdGenero());
            persona.setIdTipoDocumento(profesorEntity.getIdPersona().getIdTipoDocumento());
            persona.setIdPrograma(profesorEntity.getIdPersona().getIdPrograma());
            persona.setIdPersona(profesorEntity.getIdPersona().getIdPersona());
            this.idPersona = new PersonaDTO(persona);
        }

    }

    /**
     * Transformacion Objeto - Entidad
     *
     * @return ProductoEntity
     */
     public ProfesorEntity toEntity() {
        ProfesorEntity profesor = new ProfesorEntity();
        profesor.setIdProfesor(this.idProfesor);
        profesor.setCodprofesor(this.codprofesor);
        profesor.setAreaProfundizacion(this.areaProfundizacion);
        if(this.idPersona!=null){
        PersonaEntity persona = new PersonaEntity();
            persona.setApellidoPersona(this.idPersona.getApellidoPersona());
            persona.setNombrePersona(this.idPersona.getNombrePersona());
            persona.setNumDocumento(this.idPersona.getNumDocumento());
            persona.setIdGenero(this.idPersona.getIdGenero().toEntity());
            persona.setIdTipoDocumento(this.idPersona.getIdTipoDocumento().toEntity());
            persona.setIdPrograma(this.idPersona.getIdPrograma().toEntity());
            persona.setIdPersona(this.idPersona.getIdPersona());
            profesor.setIdPersona(persona);
        }
        
        return profesor;
    }

    /**
     * Conversión masiva de Objeto a Entidad
     *
     * @param listaProfesors
     * @return
     */
    public static List<ProfesorDTO> toProfesorList(List<ProfesorEntity> listaProfesores) {
        List<ProfesorDTO> listaProfesoresDTO = new ArrayList<>();
        for (ProfesorEntity entity : listaProfesores) {
            listaProfesoresDTO.add(new ProfesorDTO(entity));
        }
        return listaProfesoresDTO;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getCodprofesor() {
        return codprofesor;
    }

    public void setCodprofesor(Long codprofesor) {
        this.codprofesor = codprofesor;
    }

    public String getAreaProfundizacion() {
        return areaProfundizacion;
    }

    public void setAreaProfundizacion(String areaProfundizacion) {
        this.areaProfundizacion = areaProfundizacion;
    }

    public PersonaDTO getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(PersonaDTO idPersona) {
        this.idPersona = idPersona;
    }

}
