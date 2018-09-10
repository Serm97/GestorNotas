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
 * Entidad Estado (Estado de Inscripción)
 * @author Jorge Pulido
 */

@Entity(name = "estados")
public class EstadoEntity implements Serializable{
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstado;
    
    /* ----------------------- Columnas de la tabla Estados -----------------------*/
    @Column(name =  "nom_estado")
    private String nomEstado;
    
    @Column(name = "desc_estado")
    private String descEstado;
    
    /* ----------------------- Constructor -----------------------*/

    public EstadoEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

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
