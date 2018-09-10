/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entidad DataType que contiene los tipos correspondientes de cada Data en la
 * tabla DataMaster
 * 
 * @author Sergio Ramirez
 */

@Entity(name = "dataType")
public class DataTypeEntity implements Serializable{
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDataType;
    
    /* ----------------------- Columnas de la tabla DataType -----------------------*/
    @Column(name = "nombre_type")
    private String nombreType;
    
    @ManyToOne //Relacion uno a muchos con DataMasterEntity
    @JoinColumn(name = "id_datamaster")
    private Long idDataMaster;
    
    /* ----------------------- Constructor -----------------------*/

    public DataTypeEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

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

    public Long getIdDataMaster() {
        return idDataMaster;
    }

    public void setIdDataMaster(Long idDataMaster) {
        this.idDataMaster = idDataMaster;
    }
    
}
