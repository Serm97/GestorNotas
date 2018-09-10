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
import javax.persistence.OneToOne;

/**
 * Entidad Profesores
 *
 * @author Sergio Ramirez
 */
@Entity(name = "profesores")
public class ProfesorEntity implements Serializable {

    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProfesor;

    /* ----------------------- Columnas de la tabla Profesores -----------------------*/
    @Column(name = "cod_profesor", nullable = false)
    private Long codprofesor;

    @Column(name = "area_profundizacion")
    private String areaProfundizacion;
    
    @OneToOne //Relacion uno a uno con PersonaEntity
    @JoinColumn
    private Long idPersona;

    /* ----------------------- Constructor -----------------------*/
    public ProfesorEntity() {
    }

    /* ----------------------- Metodos Get y Set -----------------------*/
    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getCodprofesor() {
        return codprofesor;
    }

    public void setCodprofesor(Long codprofesor) {
        this.codprofesor = codprofesor;
    }

    public String getAreaProfundizacion() {
        return areaProfundizacion;
    }

    public void setAreaProfundizacion(String areaProfundizacion) {
        this.areaProfundizacion = areaProfundizacion;
    }
    
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }
}
