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
 * Entidad Usuario
 *
 * @author Sergio Ramirez
 */
@Entity(name = "usuarios")
public class UsuarioEntity implements Serializable {

    /* ----------------------- Llave Primaria -----------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    /* ----------------------- Columnas de la tabla Usuarios -----------------------*/
    @Column(name = "email_usuario", nullable = false)
    private String emailUsuario;

    @Column
    private String clave;

    @OneToOne //Relacion uno a uno con RolEntity
    @JoinColumn
    private RolEntity idRol;
    
    /* ----------------------- Constructor -----------------------*/
    public UsuarioEntity() {
    }
    
    /* ----------------------- Metodos Get y Set -----------------------*/

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public RolEntity getCodigoRol() {
        return idRol;
    }

    public void setCodigoRol(RolEntity idRol) {
        this.idRol = idRol;
    }
    
}
