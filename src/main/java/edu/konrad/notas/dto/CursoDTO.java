/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;

import edu.konrad.notas.entities.AsignaturaEntity;
import edu.konrad.notas.entities.CursoEntity;
import edu.konrad.notas.entities.HorarioEntity;
import edu.konrad.notas.entities.ProfesorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Curso
 * @author Sergio Ramirez
 */
public class CursoDTO {
    
    // Atributos de la entidad Asignatura
    private Long idCurso;
    private Long codCurso;
    private String nomCurso;
    private AsignaturaEntity idAsignatura;
    private ProfesorEntity idProfesor;
    private HorarioEntity idHorario;
    
    // Contructor

    public CursoDTO() {
    }
    
    /**
     * Transformacion Entidad - Objeto
     * @param cursoEntity 
     */
    public CursoDTO(CursoEntity cursoEntity) {
        this.idCurso = cursoEntity.getIdCurso();
        this.codCurso = cursoEntity.getCodCurso();
        this.nomCurso = cursoEntity.getNomCurso();
        this.idAsignatura = cursoEntity.getIdAsignatura();
        this.idProfesor = cursoEntity.getIdProfesor();
        this.idHorario = cursoEntity.getIdHorario();
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return CursoEntity
     */
    public CursoEntity toEntity(){
        CursoEntity curso = new CursoEntity();
        curso.setIdCurso(this.idCurso);
        curso.setCodCurso(this.codCurso);
        curso.setNomCurso(this.nomCurso);
        curso.setIdAsignatura(this.idAsignatura);
        curso.setIdProfesor(this.idProfesor);
        curso.setIdHorario(this.idHorario);
        return curso;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaCursos
     * @return 
     */
    public static List<CursoDTO> toCursoList(List<CursoEntity> listaCursos){
        List<CursoDTO> listaCursosDTO = new ArrayList<>();
        for(CursoEntity entity : listaCursos){
            listaCursosDTO.add(new CursoDTO(entity));
        }
        return listaCursosDTO;
    }

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

    public AsignaturaEntity getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(AsignaturaEntity idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public ProfesorEntity getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(ProfesorEntity idProfesor) {
        this.idProfesor = idProfesor;
    }

    public HorarioEntity getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(HorarioEntity idHorario) {
        this.idHorario = idHorario;
    }
    
    
}
