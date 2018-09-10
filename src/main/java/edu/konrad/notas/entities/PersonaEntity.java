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
 * Entidad que contiene la información cada Persona
 * @author Serger
 */

@Entity(name = "personas")
public class PersonaEntity implements Serializable{
    
    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPersona;
    
    /* ----------------------- Columnas de la tabla Estudiantes -----------------------*/
    @Column(name = "n_documento", nullable = false)
    private Long numDocumento;
    
    @Column(name = "nom_persona")
    private String nombreEstudiante;
    
    @Column(name = "ape_persona")
    private String apellidoEstudiante;
    
    @ManyToOne //Relacion uno a muchos con DataTypemaster
    @JoinColumn(name = "id_datatype")
    private Long idGenero;
    
    @ManyToOne //Relacion uno a muchos con DataTypemaster
    @JoinColumn(name = "id_datatype")
    private Long idTipoDocumento;
    
    @OneToOne  //Relacion uno a uno con ProgramaEntity
    @JoinColumn(name = "id_programa")
    private Long idPrograma;
    
    /* ----------------------- Constructor -----------------------*/

    public PersonaEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(Long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }
    
    
    
    
}
