/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad Calificaciones
 * @author Jorge Pulido
 */

@Entity(name = "calificaciones")
public class CalificacionEntity {
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCalificacion;
    
    /* ----------------------- Columnas de la tabla Calificaciones -----------------------*/
    @Column(name = "fecha_nota")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNota;

    @Column
    private int nota;

    @Column
    private int corte;
    
    @ManyToOne //Relacion uno a muchos con InscripcionEntity
    @JoinColumn
    private InscripcionEntity idInscripcion;
    
    /* ----------------------- Constructor -----------------------*/

    public CalificacionEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Date getFechaNota() {
        return fechaNota;
    }

    public void setFechaNota(Date fechaNota) {
        this.fechaNota = fechaNota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getCorte() {
        return corte;
    }

    public void setCorte(int corte) {
        this.corte = corte;
    }

    public InscripcionEntity getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(InscripcionEntity idInscripcion) {
        this.idInscripcion = idInscripcion;
    }
    
}
