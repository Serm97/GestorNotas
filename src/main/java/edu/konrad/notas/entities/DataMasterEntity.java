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

/**
 * Entidad DataMaster para carga de datos que no necesitan una tabla independiente
 * @author Sergio Ramirez
 */

@Entity(name = "datamaster")
public class DataMasterEntity implements Serializable{
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDataMaster;
    
    /* ----------------------- Columnas de tabla DataMaster -----------------------*/
    @Column(name = "nombre_data")
    private String nombreData;
    
    @Column
    private String descripcion;
    
    /* ----------------------- Constructor -----------------------*/

    public DataMasterEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

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
