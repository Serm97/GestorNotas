/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;

import edu.konrad.notas.entities.CursoEntity;
import edu.konrad.notas.entities.EstadoEntity;
import edu.konrad.notas.entities.EstudianteEntity;
import edu.konrad.notas.entities.InscripcionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Inscripcion
 *
 * @author Jorge Pulido
 */
public class InscripcionDTO {

    /*    Atributos de la entidad Inscripcion */
    private Long idInscripcion;
    private EstudianteDTO idEstudiante;
    private CursoDTO idCurso;
    private EstadoDTO idEstado;

    //    Constructor
    public InscripcionDTO() {
    }

    /**
     * Transformacion Entidad - Objeto
     *
     * @param InscripcionEntity
     */
    public InscripcionDTO(InscripcionEntity inscripcionEntity) {
        this.idInscripcion = inscripcionEntity.getIdInscripcion();
        if (inscripcionEntity.getIdEstudiante() != null) {
            EstudianteEntity estudiante = new EstudianteEntity();
            estudiante.setCodEstudiante(inscripcionEntity.getIdEstudiante().getCodEstudiante());
            estudiante.setIdPersona(inscripcionEntity.getIdEstudiante().getIdPersona());
            estudiante.setIdEstudiante(inscripcionEntity.getIdEstudiante().getIdEstudiante());
            this.idEstudiante = new EstudianteDTO(estudiante);
        }
        if (inscripcionEntity.getIdCurso() != null) {
            CursoEntity curso = new CursoEntity();
            curso.setCodCurso(inscripcionEntity.getIdCurso().getCodCurso());
            curso.setIdAsignatura(inscripcionEntity.getIdCurso().getIdAsignatura());
            curso.setIdHorario(inscripcionEntity.getIdCurso().getIdHorario());
            curso.setIdProfesor(inscripcionEntity.getIdCurso().getIdProfesor());
            curso.setNomCurso(inscripcionEntity.getIdCurso().getNomCurso());
            curso.setIdCurso(inscripcionEntity.getIdCurso().getIdCurso());
            this.idCurso = new CursoDTO(curso);
        }
        if (inscripcionEntity.getIdEstado() != null) {
            EstadoEntity estado = new EstadoEntity();
            estado.setDescEstado(inscripcionEntity.getIdEstado().getDescEstado());
            estado.setNomEstado(inscripcionEntity.getIdEstado().getNomEstado());
            estado.setIdEstado(inscripcionEntity.getIdEstado().getIdEstado());
            this.idEstado = new EstadoDTO(estado);
        }

    }

    /**
     * Transformacion Objeto - Entidad
     *
     * @return ProductoEntity
     */
    public InscripcionEntity toEntity() {
        InscripcionEntity inscripcion = new InscripcionEntity();
        inscripcion.setIdInscripcion(this.idInscripcion);
        if (this.idEstudiante != null) {
            EstudianteEntity estudiante = new EstudianteEntity();
            estudiante.setCodEstudiante(this.idEstudiante.getCodEstudiante());
            estudiante.setIdPersona(this.idEstudiante.getIdPersona().toEntity());
            estudiante.setIdEstudiante(this.idEstudiante.getIdEstudiante());
            inscripcion.setIdEstudiante(estudiante);
        }
        if (this.idCurso != null) {
            CursoEntity curso = new CursoEntity();
            curso.setCodCurso(this.idCurso.getCodCurso());
            curso.setNomCurso(this.idCurso.getNomCurso());
            curso.setIdHorario(this.idCurso.getIdHorario());
            curso.setIdProfesor(this.idCurso.getIdProfesor().toEntity());
            curso.setIdAsignatura(this.idCurso.getIdAsignatura().toEntity());
            curso.setIdCurso(this.idCurso.getIdCurso());
            inscripcion.setIdCurso(curso);
        }
        if (this.idEstado != null){
            EstadoEntity estado = new EstadoEntity();
            estado.setDescEstado(estado.getDescEstado());
            estado.setNomEstado(estado.getNomEstado());
            estado.setIdEstado(estado.getIdEstado());
            inscripcion.setIdEstado(estado);
        }
        
        return inscripcion;
    }

    /**
     * Conversión masiva de Objeto a Entidad
     *
     * @param listaInscripcions
     * @return
     */
    public static List<InscripcionDTO> toInscripcionList(List<InscripcionEntity> listaInscripciones) {
        List<InscripcionDTO> listaInscripcionesDTO = new ArrayList<>();
        for (InscripcionEntity entity : listaInscripciones) {
            listaInscripcionesDTO.add(new InscripcionDTO(entity));
        }
        return listaInscripcionesDTO;
    }

    public Long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public EstudianteDTO getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(EstudianteDTO idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public CursoDTO getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(CursoDTO idCurso) {
        this.idCurso = idCurso;
    }

    public EstadoDTO getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoDTO idEstado) {
        this.idEstado = idEstado;
    }

}
