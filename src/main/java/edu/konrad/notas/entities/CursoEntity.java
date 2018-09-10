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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entidad Cursos
 * @author Jorge Pulido
 */

@Entity(name = "cursos")
public class CursoEntity implements Serializable{
    
   /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCurso;
    
    /* ----------------------- Columnas de la tabla Cursos -----------------------*/
    @Column(name = "cod_curso", nullable = false)
    private Long codCurso;
    
    @Column(name = "nom_curso")
    private String nomCurso;
    
    @OneToOne //Relacion uno a uno con AsignaturaEntity
    @JoinColumn
    private Long idAsignatura;
    
    @ManyToOne //Relacion uno a muchos con ProfesorEntity
    @JoinColumn
    private Long idProfesor;
    
    @ManyToOne //Relacion uno a muchos con HorarioEntity
    @JoinColumn
    private Long idHorario;
    
    /* ----------------------- Constructor -----------------------*/

    public CursoEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Long codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }
    
    
    
    
    
    
    
    
    
}
