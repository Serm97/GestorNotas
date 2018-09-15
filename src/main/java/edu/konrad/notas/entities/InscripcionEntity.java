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
    private EstudianteEntity idEstudiante;
    
    @ManyToOne //Relacion uno a muchos con CursoEntity
    @JoinColumn
    private CursoEntity idCurso;
    
    @OneToOne
    @JoinColumn
    private EstadoEntity idEstado;
    
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

    public EstudianteEntity getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(EstudianteEntity idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public CursoEntity getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(CursoEntity idCurso) {
        this.idCurso = idCurso;
    }

    public EstadoEntity getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoEntity idEstado) {
        this.idEstado = idEstado;
    }
    
}
