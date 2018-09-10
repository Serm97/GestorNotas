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
 * Entidad Coordinadores
 * @author Sergio Ramirez
 */

@Entity(name = "coordinadores")
public class CoordinadorEntity implements Serializable{
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCoordinador;
    
    /* ----------------------- Columnas de la tabla Coordinadores -----------------------*/
    @Column(name = "cod_coordinador", nullable = false)
    private Long codCoordinador;
    
    /* ----------------------- Constructor -----------------------*/

    public CoordinadorEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

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
    
    
}
