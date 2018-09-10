/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entidad Inscripciones (Relacion Muchos a Muchos entre Estudiantes y Cursos)
 * @author Jorge Pulido
 */

@Entity(name = "inscripciones")
public class InscripcionEntity implements Serializable{
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idInscripcion;
    
    /* ----------------------- Columnas de la tabla Usuarios -----------------------*/
    
    @ManyToOne //Relacion uno a muchos con EstudianteEntity
    @JoinColumn
    private Long idEstudiante;
    
    @ManyToOne //Relacion uno a muchos con CursoEntity
    @JoinColumn
    private Long idCurso;
    
    @OneToOne
    @JoinColumn
    private int idEstado;
    
    /* ----------------------- Constructor -----------------------*/

    public InscripcionEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

    public Long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
}
