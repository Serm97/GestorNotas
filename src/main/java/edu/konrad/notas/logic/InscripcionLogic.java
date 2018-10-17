/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.InscripcionEntity;
import edu.konrad.notas.persistence.InscripcionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Inscripcion
 *
 * @author Jorge Pulido.
 */
@Stateless
public class InscripcionLogic {

//    Inyección Persistence de Inscripcion
    @Inject
    private InscripcionPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Inscripciones
     *
     * @return listaInscripciones
     */
    public List<InscripcionEntity> obtenerInscripciones() {
        List<InscripcionEntity> listaInscripciones = persistence.findAll();
        return listaInscripciones;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Inscripciones
     * WHERE ID
     *
     * @return InscripcionEntity
     */
    public InscripcionEntity obtenerInscripcion(Long id) {
        InscripcionEntity inscripcion = persistence.find(id);
        if (inscripcion == null) {
            throw new IllegalArgumentException("El inscripcion solicitado NO existe");
        }
        return inscripcion;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Inscripciones VALUES()
     *
     * @param inscripcionCrear
     * @return
     */
    public InscripcionEntity crearInscripcion(InscripcionEntity inscripcionCrear) {
        persistence.create(inscripcionCrear);
        return inscripcionCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Inscripcion
     *
     * @param id
     * @param inscripcionActualizar
     * @return inscripcion actualizada
     */
    public InscripcionEntity actualizarInscripcion(Long id, InscripcionEntity inscripcionActualizar) {
        InscripcionEntity inscripcionUpdate = persistence.update(inscripcionActualizar);
        return inscripcionUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Inscripcion FROM
     *
     *
     * @param id
     */
    public void eliminarInscripcion(Long id) {
        persistence.remove(id);
    }

}
