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
    private EstudianteEntity idEstudiante;
    private CursoEntity idCurso;
    private EstadoEntity idEstado;

    //    Constructor
    public InscripcionDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param InscripcionEntity 
     */
    public InscripcionDTO(InscripcionEntity inscripcionEntity) {
        this.idInscripcion = inscripcionEntity.getIdInscripcion();
        this.idEstudiante = inscripcionEntity.getIdEstudiante();
        this.idCurso = inscripcionEntity.getIdCurso();
        this.idEstado = inscripcionEntity.getIdEstado();
        
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public InscripcionEntity toEntity(){
        InscripcionEntity inscripcion = new InscripcionEntity();
        inscripcion.setIdInscripcion(this.idInscripcion);
        inscripcion.setIdEstudiante(this.idEstudiante);
        inscripcion.setIdCurso(this.idCurso);
        inscripcion.setIdEstado(this.idEstado);
        return inscripcion;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaInscripcions
     * @return 
     */
    public static List<InscripcionDTO> toInscripcionList(List<InscripcionEntity> listaInscripciones){
        List<InscripcionDTO> listaInscripcionesDTO = new ArrayList<>();
        for(InscripcionEntity entity : listaInscripciones){
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
