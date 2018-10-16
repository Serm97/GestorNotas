/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.EstadoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Estado
 *
 * @author Sergio Ramirez
 */
public class EstadoDTO {

    /*    Atributos de la entidad Estado */
    private int idEstado;
    private String nomEstado;
    private String descEstado;

    //    Constructor
    public EstadoDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param EstadoEntity 
     */
    public EstadoDTO(EstadoEntity estadoEntity) {
        this.idEstado = estadoEntity.getIdEstado();
        this.nomEstado = estadoEntity.getNomEstado();
        this.descEstado = estadoEntity.getDescEstado();
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public EstadoEntity toEntity(){
        EstadoEntity estado = new EstadoEntity();
        estado.setIdEstado(this.idEstado);
        estado.setNomEstado(this.nomEstado);
        estado.setDescEstado(this.descEstado);
        return estado;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaEstados
     * @return 
     */
    public static List<EstadoDTO> toEstadoList(List<EstadoEntity> listaEstados){
        List<EstadoDTO> listaEstadosDTO = new ArrayList<>();
        for(EstadoEntity entity : listaEstados){
            listaEstadosDTO.add(new EstadoDTO(entity));
        }
        return listaEstadosDTO;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }
    
    
    

}
