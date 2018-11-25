/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Representa el registro de las clases que se personalizan como servicios REST
 * @author Sergio Ramirez
 */

@ApplicationPath("api")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;      
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(edu.konrad.notas.resources.AsignaturaResource.class);
        resources.add(edu.konrad.notas.resources.CalificacionResource.class);
        resources.add(edu.konrad.notas.resources.CursoResource.class);
        resources.add(edu.konrad.notas.resources.DataTypeResource.class);
        resources.add(edu.konrad.notas.resources.EstudianteResource.class);
        resources.add(edu.konrad.notas.resources.HorarioResource.class);
        resources.add(edu.konrad.notas.resources.InscripcionResource.class);
        resources.add(edu.konrad.notas.resources.PersonaResource.class);
        resources.add(edu.konrad.notas.resources.ProfesorResource.class);
        resources.add(edu.konrad.notas.resources.ProgramaResource.class);
        resources.add(edu.konrad.notas.resources.UsuarioResource.class);
    }
}
