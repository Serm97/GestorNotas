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
 * Entidad Niveles Academicos
 * @author Jorge Pulido
 */

@Entity(name = "niveles_academicos")
public class NivelesAcademicosEntity implements Serializable{
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNivelAcademico;
    
    /* ----------------------- Columnas de la tabla Niveles Academicos -----------------------*/
    @Column(name = "nom_nivel")
    private String nomNivel;
    
    @Column(name = "desc_nivel")
    private String descNivel;
    
    /* ----------------------- Constructor -----------------------*/

    public NivelesAcademicosEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

    public Long getIdNivelAcademico() {
        return idNivelAcademico;
    }

    public void setIdNivelAcademico(Long idNivelAcademico) {
        this.idNivelAcademico = idNivelAcademico;
    }

    public String getNomNivel() {
        return nomNivel;
    }

    public void setNomNivel(String nomNivel) {
        this.nomNivel = nomNivel;
    }

    public String getDescNivel() {
        return descNivel;
    }

    public void setDescNivel(String descNivel) {
        this.descNivel = descNivel;
    }
    
}
