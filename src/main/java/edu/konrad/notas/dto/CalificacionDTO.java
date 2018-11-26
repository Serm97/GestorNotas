/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;

import edu.konrad.notas.entities.CalificacionEntity;
import edu.konrad.notas.entities.InscripcionEntity;
import edu.konrad.notas.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Calificación
 *
 * @author Sergio Ramirez
 */
public class CalificacionDTO {

    /*    Atributos de la entidad Calificacion */
    private Long idCalificacion;
    private Date fechaNota;
    private int nota;
    private int corte;
    private InscripcionDTO idInscripcion;

    //    Constructor
    public CalificacionDTO() {
    }

    /**
     * Transformacion Entidad - Objeto
     *
     * @param productoEntity
     */
    public CalificacionDTO(CalificacionEntity CalificacionEntity) {
        this.idCalificacion = CalificacionEntity.getIdCalificacion();
        this.fechaNota = CalificacionEntity.getFechaNota();
        this.nota = CalificacionEntity.getNota();
        this.corte = CalificacionEntity.getCorte();
        if(CalificacionEntity.getIdInscripcion()!=null){            
            InscripcionEntity inscripcion = new InscripcionEntity();
            inscripcion.setIdCurso(CalificacionEntity.getIdInscripcion().getIdCurso());
            inscripcion.setIdEstado(CalificacionEntity.getIdInscripcion().getIdEstado());
            inscripcion.setIdEstudiante(CalificacionEntity.getIdInscripcion().getIdEstudiante());
            inscripcion.setIdInscripcion(CalificacionEntity.getIdInscripcion().getIdInscripcion());
            this.idInscripcion = new InscripcionDTO(inscripcion);            
        }
        
    }

    /**
     * Transformacion Objeto - Entidad
     *
     * @return ProductoEntity
     */
    public CalificacionEntity toEntity() {
        CalificacionEntity calificacion = new CalificacionEntity();
        calificacion.setIdCalificacion(this.idCalificacion);
        calificacion.setFechaNota(this.fechaNota);
        calificacion.setNota(this.nota);
        calificacion.setCorte(this.corte);
        if(this.idInscripcion!=null){
            InscripcionEntity inscripcion = new InscripcionEntity();
            inscripcion.setIdCurso(this.idInscripcion.getIdCurso().toEntity());
            inscripcion.setIdEstado(this.idInscripcion.getIdEstado());
            inscripcion.setIdEstudiante(this.idInscripcion.getIdEstudiante().toEntity());
            inscripcion.setIdInscripcion(this.idInscripcion.getIdInscripcion());         
            calificacion.setIdInscripcion(inscripcion);
        }
        
        return calificacion;
    }

    /**
     * Conversión masiva de Objeto a Entidad
     *
     * @param listaCalificaciones
     * @return
     */
    public static List<CalificacionDTO> toCalificacionList(List<CalificacionEntity> listaCalificaciones) {
        List<CalificacionDTO> listaCalificacionesDTO = new ArrayList<>();
        for (CalificacionEntity entity : listaCalificaciones) {
            listaCalificacionesDTO.add(new CalificacionDTO(entity));
        }
        return listaCalificacionesDTO;
    }

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

    public InscripcionDTO getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(InscripcionDTO idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

}
