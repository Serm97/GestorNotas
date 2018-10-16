/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;

import edu.konrad.notas.entities.CoordinadorEntity;
import edu.konrad.notas.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Coordinador
 * @author Sergio Ramirez
 */
public class CoordinadorDTO {
    
    private Long idCoordinador;
    private Long codCoordinador;
    private Long idPersona;
    private ProgramaEntity idPrograma;
    
    //  Constructor

    public CoordinadorDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param CoordinadorEntity 
     */
    public CoordinadorDTO(CoordinadorEntity coordinadorEntity) {
        this.idCoordinador = coordinadorEntity.getIdCoordinador();
        this.codCoordinador = coordinadorEntity.getCodCoordinador();
        this.idPersona = coordinadorEntity.getIdPersona();
        this.idPrograma = coordinadorEntity.getIdPrograma();
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public CoordinadorEntity toEntity(){
        CoordinadorEntity coordinador = new CoordinadorEntity();
        coordinador.setIdCoordinador(this.idCoordinador);
        coordinador.setCodCoordinador(this.codCoordinador);
        coordinador.setIdPersona(this.idPersona);
        coordinador.setIdPrograma(this.idPrograma);
        return coordinador;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaCoordinadores
     * @return 
     */
    public static List<CoordinadorDTO> toCoordinadorList(List<CoordinadorEntity> listaCoordinadores){
        List<CoordinadorDTO> listaCoordinadoresDTO = new ArrayList<>();
        for(CoordinadorEntity entity : listaCoordinadores){
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

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public ProgramaEntity getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(ProgramaEntity idPrograma) {
        this.idPrograma = idPrograma;
    }
    
    
}
