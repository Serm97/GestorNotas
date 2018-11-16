/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;

import edu.konrad.notas.entities.AsignaturaEntity;
import edu.konrad.notas.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Asignatura
 *
 * @author Sergio Ramirez
 */
public class AsignaturaDTO {

    /*    Atributos de la entidad Asignatura */
    private Long idAsignatura;
    private Long codAsignatura;
    private String nomAsignatura;
    private String descAsignatura;
    private int numCreditos;
    private ProgramaDTO idPrograma;

    //    Constructor
    public AsignaturaDTO() {
    }

    /**
     * Transformacion Entidad - Objeto
     *
     * @param AsignaturaEntity
     */
    public AsignaturaDTO(AsignaturaEntity asignaturaEntity) {
        this.idAsignatura = asignaturaEntity.getIdAsignatura();
        this.codAsignatura = asignaturaEntity.getCodAsignatura();
        this.nomAsignatura = asignaturaEntity.getNomAsignatura();
        this.descAsignatura = asignaturaEntity.getDescAsignatura();
        this.numCreditos = asignaturaEntity.getNumCreditos();
        if (asignaturaEntity.getIdPrograma() != null){
            ProgramaEntity program = new ProgramaEntity();
            program.setCodPrograma(asignaturaEntity.getIdPrograma().getCodPrograma());
            program.setNivelAcademico(asignaturaEntity.getIdPrograma().getNivelAcademico());
            program.setNomPrograma(asignaturaEntity.getIdPrograma().getNomPrograma());
            program.setIdPrograma(asignaturaEntity.getIdPrograma().getIdPrograma());
            this.idPrograma = new ProgramaDTO(program);
        }        
    }

    /**
     * Transformacion Objeto - Entidad
     *
     * @return ProductoEntity
     */
    public AsignaturaEntity toEntity() {
        AsignaturaEntity asignatura = new AsignaturaEntity();
        asignatura.setIdAsignatura(this.idAsignatura);
        asignatura.setCodAsignatura(this.codAsignatura);
        asignatura.setNomAsignatura(this.nomAsignatura);
        asignatura.setDescAsignatura(this.descAsignatura);
        asignatura.setNumCreditos(this.numCreditos);
        if (this.idPrograma != null){
            ProgramaEntity program = new ProgramaEntity();
            program.setCodPrograma(this.idPrograma.getCodPrograma());
            program.setNivelAcademico(this.idPrograma.getNivelAcademico());
            program.setNomPrograma(this.idPrograma.getNomPrograma());
            program.setIdPrograma(this.idPrograma.getIdPrograma());
            asignatura.setIdPrograma(program);
        }
        
        return asignatura;
    }

    /**
     * Conversión masiva de Entidad a Objeto
     *
     * @param listaAsignaturas
     * @return
     */
    public static List<AsignaturaDTO> toAsignaturaList(List<AsignaturaEntity> listaAsignaturas) {
        List<AsignaturaDTO> listaAsignaturasDTO = new ArrayList<>();
        for (AsignaturaEntity entity : listaAsignaturas) {
            listaAsignaturasDTO.add(new AsignaturaDTO(entity));
        }
        return listaAsignaturasDTO;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Long getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Long codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getNomAsignatura() {
        return nomAsignatura;
    }

    public void setNomAsignatura(String nomAsignatura) {
        this.nomAsignatura = nomAsignatura;
    }

    public String getDescAsignatura() {
        return descAsignatura;
    }

    public void setDescAsignatura(String descAsignatura) {
        this.descAsignatura = descAsignatura;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }

    public ProgramaDTO getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(ProgramaDTO idPrograma) {
        this.idPrograma = idPrograma;
    }

}
