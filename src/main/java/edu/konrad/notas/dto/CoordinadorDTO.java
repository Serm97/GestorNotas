/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;

import edu.konrad.notas.entities.CoordinadorEntity;
import edu.konrad.notas.entities.PersonaEntity;
import edu.konrad.notas.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Coordinador
 *
 * @author Sergio Ramirez
 */
public class CoordinadorDTO {

    private Long idCoordinador;
    private Long codCoordinador;
    private PersonaDTO idPersona;
    private ProgramaDTO idPrograma;

    //  Constructor
    public CoordinadorDTO() {
    }

    /**
     * Transformacion Entidad - Objeto
     *
     * @param CoordinadorEntity
     */
    public CoordinadorDTO(CoordinadorEntity coordinadorEntity) {
        this.idCoordinador = coordinadorEntity.getIdCoordinador();
        this.codCoordinador = coordinadorEntity.getCodCoordinador();
        if (coordinadorEntity.getIdPersona() != null) {
            PersonaEntity persona = new PersonaEntity();
            persona.setApellidoPersona(coordinadorEntity.getIdPersona().getApellidoPersona());
            persona.setNombrePersona(coordinadorEntity.getIdPersona().getNombrePersona());
            persona.setNumDocumento(coordinadorEntity.getIdPersona().getNumDocumento());
            persona.setIdGenero(coordinadorEntity.getIdPersona().getIdGenero());
            persona.setIdTipoDocumento(coordinadorEntity.getIdPersona().getIdTipoDocumento());
            persona.setIdPrograma(coordinadorEntity.getIdPersona().getIdPrograma());
            persona.setIdPersona(coordinadorEntity.getIdPersona().getIdPersona());
            this.idPersona = new PersonaDTO(persona);
        }
        if (coordinadorEntity.getIdPrograma() != null) {
            ProgramaEntity program = new ProgramaEntity();
            program.setCodPrograma(coordinadorEntity.getIdPrograma().getCodPrograma());
            program.setNivelAcademico(coordinadorEntity.getIdPrograma().getNivelAcademico());
            program.setNomPrograma(coordinadorEntity.getIdPrograma().getNomPrograma());
            program.setIdPrograma(coordinadorEntity.getIdPrograma().getIdPrograma());
            this.idPrograma = new ProgramaDTO(program);
        }

    }

    /**
     * Transformacion Objeto - Entidad
     *
     * @return ProductoEntity
     */
     public CoordinadorEntity toEntity() {
        CoordinadorEntity coordinador = new CoordinadorEntity();
        coordinador.setIdCoordinador(this.idCoordinador);
        coordinador.setCodCoordinador(this.codCoordinador);
        if (this.idPersona != null) {
            PersonaEntity persona = new PersonaEntity();
            persona.setApellidoPersona(this.idPersona.getApellidoPersona());
            persona.setNombrePersona(this.idPersona.getNombrePersona());
            persona.setNumDocumento(this.idPersona.getNumDocumento());
            persona.setIdGenero(this.idPersona.getIdGenero().toEntity());
            persona.setIdTipoDocumento(this.idPersona.getIdTipoDocumento().toEntity());
            persona.setIdPrograma(this.idPersona.getIdPrograma().toEntity());
            persona.setIdPersona(this.idPersona.getIdPersona());
            coordinador.setIdPersona(persona);
        }
        if (this.idPrograma != null) {
            ProgramaEntity program = new ProgramaEntity();
            program.setCodPrograma(this.idPrograma.getCodPrograma());
            program.setNivelAcademico(this.idPrograma.getNivelAcademico());
            program.setNomPrograma(this.idPrograma.getNomPrograma());
            program.setIdPrograma(this.idPrograma.getIdPrograma());
            coordinador.setIdPrograma(program);
        }
         return coordinador;
    }

    /**
     * Conversión masiva de Objeto a Entidad
     *
     * @param listaCoordinadores
     * @return
     */
    public static List<CoordinadorDTO> toCoordinadorList(List<CoordinadorEntity> listaCoordinadores) {
        List<CoordinadorDTO> listaCoordinadoresDTO = new ArrayList<>();
        for (CoordinadorEntity entity : listaCoordinadores) {
            listaCoordinadoresDTO.add(new CoordinadorDTO(entity));
        }
        return listaCoordinadoresDTO;
    }

    public Long getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(Long idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public Long getCodCoordinador() {
        return codCoordinador;
    }

    public void setCodCoordinador(Long codCoordinador) {
        this.codCoordinador = codCoordinador;
    }

    public PersonaDTO getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(PersonaDTO idPersona) {
        this.idPersona = idPersona;
    }

    public ProgramaDTO getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(ProgramaDTO idPrograma) {
        this.idPrograma = idPrograma;
    }

}
