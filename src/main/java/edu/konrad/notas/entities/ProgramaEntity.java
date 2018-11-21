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
 * Entidad Programas
 * @author Jorge Pulido
 */

@Entity(name = "programas")
public class ProgramaEntity implements Serializable{
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPrograma;
    
    /* ----------------------- Columnas de la tabla Niveles Academicos -----------------------*/
    @Column(name = "cod_programa")
    private Long codPrograma;
    
    @Column(name = "nom_programa")
    private String nomPrograma;
    
    @Column(name = "nivel_academico")
    private String nivelAcademico;
    
    /* ----------------------- Constructor -----------------------*/

    public ProgramaEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

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
