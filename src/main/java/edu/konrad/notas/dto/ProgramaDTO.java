/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Programa
 *
 * @author Jorge Pulido
 */
public class ProgramaDTO {

    /*    Atributos de la entidad Programa */
    private Long idPrograma;
    private Long codPrograma;
    private String nomPrograma;
    private String nivelAcademico;

    //    Constructor
    public ProgramaDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param ProgramaEntity 
     */
    public ProgramaDTO(ProgramaEntity programaEntity) {
        this.idPrograma = programaEntity.getIdPrograma();
        this.codPrograma = programaEntity.getCodPrograma();
        this.nomPrograma = programaEntity.getNomPrograma();
        this.nivelAcademico = programaEntity.getNivelAcademico();
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public ProgramaEntity toEntity(){
        ProgramaEntity programa = new ProgramaEntity();
        programa.setIdPrograma(this.idPrograma);
        programa.setCodPrograma(this.codPrograma);
        programa.setNomPrograma(this.nomPrograma);
        programa.setNivelAcademico(this.nivelAcademico);
        return programa;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaProgramas
     * @return 
     */
    public static List<ProgramaDTO> toProgramaList(List<ProgramaEntity> listaProgramas){
        List<ProgramaDTO> listaProgramasDTO = new ArrayList<>();
        for(ProgramaEntity entity : listaProgramas){
            listaProgramasDTO.add(new ProgramaDTO(entity));
        }
        return listaProgramasDTO;
    }

    public Long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Long getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(Long codPrograma) {
        this.codPrograma = codPrograma;
    }

    public String getNomPrograma() {
        return nomPrograma;
    }

    public void setNomPrograma(String nomPrograma) {
        this.nomPrograma = nomPrograma;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }
    

}
