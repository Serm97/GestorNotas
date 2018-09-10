package edu.konrad.notas.entities;


import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Entidad Horarios
 * @author Jorge Pulido
 */

@Entity(name = "horarios")
public class HorarioEntity implements Serializable{
    
   /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHorario;
    
    /* ----------------------- Columnas de la tabla Horarios -----------------------*/
    @Column
    private int dia;
    
    @Column(name = "hora_inicio")
    private Time horaInicio;
    
    @Column(name = "hora_fin")
    private Time horaFin;
    
    @Column
    private int jornada;
    
    /* ----------------------- Constructor -----------------------*/

    public HorarioEntity() {
    }
    
    
    /* ----------------------- Metodos Get y Set -----------------------*/

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }
    
    
}
