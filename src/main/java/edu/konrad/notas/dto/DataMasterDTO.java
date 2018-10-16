/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.DataMasterEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad DataMaster
 *
 * @author Sergio Ramirez
 */
public class DataMasterDTO {

    /*    Atributos de la entidad DataMaster */
    private Long idDataMaster;
    private String nombreData;
    private String descripcion;

    //    Constructor
    public DataMasterDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param DataMasterEntity 
     */
    public DataMasterDTO(DataMasterEntity dataMasterEntity) {
        this.idDataMaster = dataMasterEntity.getIdDataMaster();
        this.nombreData = dataMasterEntity.getNombreData();
        this.descripcion = dataMasterEntity.getDescripcion();
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public DataMasterEntity toEntity(){
        DataMasterEntity datamaster = new DataMasterEntity();
        datamaster.setIdDataMaster(this.idDataMaster);
        datamaster.setNombreData(this.nombreData);
        datamaster.setDescripcion(this.descripcion);
        return datamaster;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaDataMasters
     * @return 
     */
    public static List<DataMasterDTO> toDataMasterList(List<DataMasterEntity> listaDataMasters){
        List<DataMasterDTO> listaDataMastersDTO = new ArrayList<>();
        for(DataMasterEntity entity : listaDataMasters){
            listaDataMastersDTO.add(new DataMasterDTO(entity));
        }
        return listaDataMastersDTO;
    }

    public Long getIdDataMaster() {
        return idDataMaster;
    }

    public void setIdDataMaster(Long idDataMaster) {
        this.idDataMaster = idDataMaster;
    }

    public String getNombreData() {
        return nombreData;
    }

    public void setNombreData(String nombreData) {
        this.nombreData = nombreData;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    

}
