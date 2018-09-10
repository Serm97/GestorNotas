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
import javax.persistence.OneToMany;

/**
 *
 * @author Jorge Pulido
 */
@Entity(name = "asignaturas")
public class AsignaturaEntity implements Serializable {

    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAsignatura;

    /* ----------------------- Columnas de la tabla Asignaturas -----------------------*/
    @Column(name = "cod_asignatura")
    private Long codAsignatura;

    @Column(name = "nom_asignatura")
    private String nomAsignatura;

    @Column(name = "desc_asignatura")
    private String descAsignatura;

    @Column(name = "num_creditos")
    private int numCreditos;

    @OneToMany //Relacion uno a muchos con ProgramaEntity
    @JoinColumn
    private Long idPrograma;

    /* ----------------------- Constructor -----------------------*/
    public AsignaturaEntity() {
    }

    /* ----------------------- Metodos Get y Set -----------------------*/
    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Long getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Long codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getNomAsignatura() {
        return nomAsignatura;
    }

    public void setNomAsignatura(String nomAsignatura) {
        this.nomAsignatura = nomAsignatura;
    }

    public String getDescAsignatura() {
        return descAsignatura;
    }

    public void setDescAsignatura(String descAsignatura) {
        this.descAsignatura = descAsignatura;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }

    public Long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }

}
