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
 *
 * @author Sergio Ramirez
 */
public class CursoDTO {

    // Atributos de la entidad Asignatura
    private Long idCurso;
    private Long codCurso;
    private String nomCurso;
    private AsignaturaDTO idAsignatura;
    private ProfesorDTO idProfesor;
    private HorarioDTO idHorario;

    // Contructor
    public CursoDTO() {
    }

    /**
     * Transformacion Entidad - Objeto
     *
     * @param cursoEntity
     */
    public CursoDTO(CursoEntity cursoEntity) {
        this.idCurso = cursoEntity.getIdCurso();
        this.codCurso = cursoEntity.getCodCurso();
        this.nomCurso = cursoEntity.getNomCurso();
        if (cursoEntity.getIdHorario() != null){
            HorarioEntity horario = new HorarioEntity();
            horario.setDia(cursoEntity.getIdHorario().getDia());
            horario.setHoraFin(cursoEntity.getIdHorario().getHoraFin());
            horario.setHoraInicio(cursoEntity.getIdHorario().getHoraInicio());
            horario.setJornada(cursoEntity.getIdHorario().getJornada());
            horario.setIdHorario(cursoEntity.getIdHorario().getIdHorario());            
            this.idHorario = new HorarioDTO(horario);
        }
        
        if (cursoEntity.getIdAsignatura() != null) {
            AsignaturaEntity asignatura = new AsignaturaEntity();
            asignatura.setCodAsignatura(cursoEntity.getIdAsignatura().getCodAsignatura());
            asignatura.setDescAsignatura(cursoEntity.getIdAsignatura().getDescAsignatura());
            asignatura.setNomAsignatura(cursoEntity.getIdAsignatura().getNomAsignatura());
            asignatura.setIdPrograma(cursoEntity.getIdAsignatura().getIdPrograma());
            asignatura.setIdAsignatura(cursoEntity.getIdAsignatura().getIdAsignatura());
            asignatura.setNumCreditos(cursoEntity.getIdAsignatura().getNumCreditos());
            this.idAsignatura = new AsignaturaDTO(asignatura);
        }
        if (cursoEntity.getIdProfesor() != null) {
            ProfesorEntity profesor = new ProfesorEntity();
            profesor.setAreaProfundizacion(cursoEntity.getIdProfesor().getAreaProfundizacion());
            profesor.setIdPersona(cursoEntity.getIdProfesor().getIdPersona());
            profesor.setCodprofesor(cursoEntity.getIdProfesor().getCodprofesor());
            profesor.setIdProfesor(cursoEntity.getIdProfesor().getIdProfesor());
            this.idProfesor = new ProfesorDTO(profesor);
        }

        

    }

    /**
     * Transformacion Objeto - Entidad
     *
     * @return CursoEntity
     */
    public CursoEntity toEntity() {
        CursoEntity curso = new CursoEntity();
        curso.setIdCurso(this.idCurso);
        curso.setCodCurso(this.codCurso);
        curso.setNomCurso(this.nomCurso);
        if (this.idHorario != null){
            HorarioEntity horario = new HorarioEntity();
            horario.setDia(this.idHorario.getDia());
            horario.setHoraFin(this.idHorario.getHoraFin());
            horario.setHoraInicio(this.idHorario.getHoraInicio());
            horario.setJornada(this.idHorario.getJornada());
            horario.setIdHorario(this.idHorario.getIdHorario());            
            curso.setIdHorario(horario);
        }
        if (this.idAsignatura != null) {
            AsignaturaEntity asignatura = new AsignaturaEntity();
            asignatura.setCodAsignatura(this.idAsignatura.getCodAsignatura());
            asignatura.setDescAsignatura(this.idAsignatura.getDescAsignatura());
            asignatura.setNomAsignatura(this.idAsignatura.getNomAsignatura());
            asignatura.setIdPrograma(this.idAsignatura.getIdPrograma().toEntity());
            asignatura.setIdAsignatura(this.idAsignatura.getIdAsignatura());
            asignatura.setNumCreditos(this.idAsignatura.getNumCreditos());
            curso.setIdAsignatura(asignatura);
        }
        if (this.idProfesor != null) {
            ProfesorEntity profesor = new ProfesorEntity();
            profesor.setAreaProfundizacion(this.idProfesor.getAreaProfundizacion());
            profesor.setIdPersona(this.idProfesor.getIdPersona().toEntity());
            profesor.setCodprofesor(this.idProfesor.getCodprofesor());
            profesor.setIdProfesor(this.idProfesor.getIdProfesor());            
            curso.setIdProfesor(profesor);
        }

        return curso;
    }

    /**
     * Conversión masiva de Objeto a Entidad
     *
     * @param listaCursos
     * @return
     */
    public static List<CursoDTO> toCursoList(List<CursoEntity> listaCursos) {
        List<CursoDTO> listaCursosDTO = new ArrayList<>();
        for (CursoEntity entity : listaCursos) {
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

    public AsignaturaDTO getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(AsignaturaDTO idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public ProfesorDTO getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(ProfesorDTO idProfesor) {
        this.idProfesor = idProfesor;
    }

    public HorarioDTO getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(HorarioDTO idHorario) {
        this.idHorario = idHorario;
    }

    

}
