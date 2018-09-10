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

/**
 * Entidad Roles
 * @author Sergio Ramirez
 */

@Entity(name = "roles")
public class RolEntity implements Serializable{

    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRol;
    
    /* ----------------------- Columnas de la tabla Roles -----------------------*/
    @Column(name = "nom_rol", nullable = false)
    private String nombreRol;
    
    @Column
    private String permisos;
    
    /* ----------------------- Constructor -----------------------*/

    public RolEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
    

    
    
}
