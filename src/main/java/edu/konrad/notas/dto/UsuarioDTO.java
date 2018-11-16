/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.dto;


import edu.konrad.notas.entities.RolEntity;
import edu.konrad.notas.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Usuario
 *
 * @author Jorge Pulido
 */
public class UsuarioDTO {

    /*    Atributos de la entidad Usuario */
    private Long idUsuario;
    private String emailUsuario;
    private String clave;
    private RolDTO idRol;

    //    Constructor
    public UsuarioDTO() {
    }
    
    
    /**
     * Transformacion Entidad - Objeto
     * @param UsuarioEntity 
     */
    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.idUsuario = usuarioEntity.getIdUsuario();
        this.emailUsuario = usuarioEntity.getEmailUsuario();
        this.clave = usuarioEntity.getClave();
        if(usuarioEntity.getCodigoRol()!=null){
            RolEntity rol = new RolEntity();
            rol.setNombreRol(usuarioEntity.getCodigoRol().getNombreRol());
            rol.setPermisos(usuarioEntity.getCodigoRol().getPermisos());
            rol.setIdRol(usuarioEntity.getCodigoRol().getIdRol());
            this.idRol = new RolDTO(rol);
        }
        
    }
    
    /**
     * Transformacion Objeto - Entidad
     * @return ProductoEntity
     */
    public UsuarioEntity toEntity(){
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(this.idUsuario);
        usuario.setEmailUsuario(this.emailUsuario);
        usuario.setClave(this.clave);
        if(this.idRol!=null){
        RolEntity rol = new RolEntity();
            rol.setNombreRol(this.idRol.getNombreRol());
            rol.setPermisos(this.idRol.getPermisos());
            rol.setIdRol(this.idRol.getIdRol());
            usuario.setCodigoRol(rol);
        }       
        return usuario;        
    }
    
    /**
     * Conversión masiva de Objeto a Entidad
     * @param listaUsuarios
     * @return 
     */
    public static List<UsuarioDTO> toUsuarioList(List<UsuarioEntity> listaUsuarios){
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();
        for(UsuarioEntity entity : listaUsuarios){
            listaUsuariosDTO.add(new UsuarioDTO(entity));
        }
        return listaUsuariosDTO;
    }

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

    public RolDTO getIdRol() {
        return idRol;
    }

    public void setIdRol(RolDTO idRol) {
        this.idRol = idRol;
    }
    
    
    

}
