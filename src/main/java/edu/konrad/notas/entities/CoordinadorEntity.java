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
import javax.persistence.OneToOne;

/**
 * Entidad Coordinadores
 *
 * @author Sergio Ramirez
 */
@Entity(name = "coordinadores")
public class CoordinadorEntity implements Serializable {

    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCoordinador;

    /* ----------------------- Columnas de la tabla Coordinadores -----------------------*/
    @Column(name = "cod_coordinador", nullable = false)
    private Long codCoordinador;

    @OneToOne //Relacion uno a uno con PersonaEntity
    @JoinColumn
    private Long idPersona;

    @OneToOne //Relacion uno a muchos con ProgramaEntity
    @JoinColumn
    private ProgramaEntity idPrograma;

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
