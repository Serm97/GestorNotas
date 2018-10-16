/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.HorarioEntity;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Horario
 *
 * @author Jorge Pulido
 */
public class HorarioDTO {

    /*    Atributos de la entidad Horario */
    private Long idHorario;
    private int dia;
    private Time horaInicio;
    private Time horaFin;
    private int jornada;

    //    Constructor
    public HorarioDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param HorarioEntity 
     */
    public HorarioDTO(HorarioEntity horarioEntity) {
        this.idHorario = horarioEntity.getIdHorario();
        this.dia = horarioEntity.getDia();
        this.horaInicio = horarioEntity.getHoraInicio();
        this.horaFin = horarioEntity.getHoraFin();
        this.jornada = horarioEntity.getJornada();
       
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public HorarioEntity toEntity(){
        HorarioEntity horario = new HorarioEntity();
        horario.setIdHorario(this.idHorario);
        horario.setDia(this.dia);
        horario.setHoraInicio(this.horaInicio);
        horario.setHoraFin(this.horaFin);
        horario.setJornada(this.jornada);
        return horario;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaHorarios
     * @return 
     */
    public static List<HorarioDTO> toHorarioList(List<HorarioEntity> listaHorarios){
        List<HorarioDTO> listaHorariosDTO = new ArrayList<>();
        for(HorarioEntity entity : listaHorarios){
            listaHorariosDTO.add(new HorarioDTO(entity));
        }
        return listaHorariosDTO;
    }

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
