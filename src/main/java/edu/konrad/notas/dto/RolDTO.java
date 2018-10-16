/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.RolEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Rol
 *
 * @author Jorge Pulido
 */
public class RolDTO {

    /*    Atributos de la entidad Rol */
    private Long idRol;
    private String nombreRol;
    private String permisos;

    //    Constructor
    public RolDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param RolEntity 
     */
    public RolDTO(RolEntity rolEntity) {
        this.idRol = rolEntity.getIdRol();
        this.nombreRol = rolEntity.getNombreRol();
        this.permisos = rolEntity.getPermisos();
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public RolEntity toEntity(){
        RolEntity rol = new RolEntity();
        rol.setIdRol(this.idRol);
        rol.setNombreRol(this.nombreRol);
        rol.setPermisos(this.permisos);
        return rol;
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaRoles
     * @return 
     */
    public static List<RolDTO> toRolesList(List<RolEntity> listaRoles){
        List<RolDTO> listaRolesDTO = new ArrayList<>();
        for(RolEntity entity : listaRoles){
            listaRolesDTO.add(new RolDTO(entity));
        }
        return listaRolesDTO;
    }

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
