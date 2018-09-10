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
 * Entidad Estudiantes
 *
 * @author Sergio Ramirez
 */
@Entity(name = "estudiantes")
public class EstudianteEntity implements Serializable {

    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstudiante;

    /* ----------------------- Columnas de la tabla Estudiantes -----------------------*/
    @Column(name = "cod_estudiante", nullable = false)
    private Long codEstudiante;

    @OneToOne //Relacion uno a uno con PersonaEntity
    @JoinColumn
    private Long idPersona;

    /* ----------------------- Constructor -----------------------*/
    public EstudianteEntity() {
    }

    /* ----------------------- Metodos get y Set -----------------------*/
    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Long getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(Long codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

}
