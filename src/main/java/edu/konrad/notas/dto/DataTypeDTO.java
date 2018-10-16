/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.DataMasterEntity;
import edu.konrad.notas.entities.DataTypeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad DataType
 *
 * @author Sergio Ramirez
 */
public class DataTypeDTO {

    /*    Atributos de la entidad DataType */
    private Long idDataType;
    private String nombreType;
    private DataMasterEntity idDataMaster;

    //    Constructor

    public DataTypeDTO() {
    }
        
    
    /**
     * Transformacion Entidad - Objeto
     * @param DataTypeEntity 
     */
    public DataTypeDTO(DataTypeEntity dataTypeEntity) {
       this.idDataType = dataTypeEntity.getIdDataType();
       this.nombreType = dataTypeEntity.getNombreType();
       this.idDataMaster = dataTypeEntity.getIdDataMaster();
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public DataTypeEntity toEntity(){
        DataTypeEntity datatype = new DataTypeEntity();
        datatype.setIdDataType(this.idDataType);
        datatype.setNombreType(this.nombreType);
        datatype.setIdDataMaster(this.idDataMaster);
        return datatype;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaDataTypes
     * @return 
     */
    public static List<DataTypeDTO> toDataTypeList(List<DataTypeEntity> listaDataTypes){
        List<DataTypeDTO> listaDataTypesDTO = new ArrayList<>();
        for(DataTypeEntity entity : listaDataTypes){
            listaDataTypesDTO.add(new DataTypeDTO(entity));
        }
        return listaDataTypesDTO;
    }

    public Long getIdDataType() {
        return idDataType;
    }

    public void setIdDataType(Long idDataType) {
        this.idDataType = idDataType;
    }

    public String getNombreType() {
        return nombreType;
    }

    public void setNombreType(String nombreType) {
        this.nombreType = nombreType;
    }

    public DataMasterEntity getIdDataMaster() {
        return idDataMaster;
    }

    public void setIdDataMaster(DataMasterEntity idDataMaster) {
        this.idDataMaster = idDataMaster;
    }
    
    
    

}
