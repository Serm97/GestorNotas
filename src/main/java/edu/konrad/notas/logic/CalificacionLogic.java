/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.CalificacionEntity;
import edu.konrad.notas.persistence.CalificacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Calificacion
 *
 * @author Sergio Ramirez.
 */
@Stateless
public class CalificacionLogic {

//    Inyección Persistence de Calificacion
    @Inject
    private CalificacionPersistence persistence;
    
    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Calificacions
     * @return listaCalificaciones
     */
    public List<CalificacionEntity> obtenerCalificaciones(){
        List<CalificacionEntity> listaCalificaciones = persistence.findAll();
        return listaCalificaciones;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Calificaciones WHERE ID
     * @return CalificacionEntity
     */
    public CalificacionEntity obtenerCalificacion(Long id){
        CalificacionEntity calificacion = persistence.find(id);
        if(calificacion == null){
            throw new IllegalArgumentException("Esta calificación NO existe");
        }
        return calificacion;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Calificacions VALUES()
     * @param CalificacionCrear
     * @return 
     */
    public CalificacionEntity crearCalificacion(CalificacionEntity calificacionCrear){
        persistence.create(calificacionCrear);
        return calificacionCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Calificacion
     * @param id
     * @param CalificacionActualizar
     * @return Calificacion actualizada
     */
    public CalificacionEntity actualizarCalificacion (Long id, CalificacionEntity CalificacionActualizar){
        CalificacionEntity CalificacionUpdate = persistence.update(CalificacionActualizar);
        return CalificacionUpdate;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion DELETE Calificacion FROM *
     * @param id 
     */
    public void eliminarCalificacion(Long id){
        persistence.remove(id);
    }
    
    
}
