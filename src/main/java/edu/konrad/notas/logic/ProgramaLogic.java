/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.ProgramaEntity;
import edu.konrad.notas.persistence.ProgramaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Programa
 *
 * @author Jorge Pulido.
 */
@Stateless
public class ProgramaLogic {

//    Inyección Persistence de Programa
    @Inject
    private ProgramaPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Programas
     *
     * @return listaProgramas
     */
    public List<ProgramaEntity> obtenerProgramas() {
        List<ProgramaEntity> listaProgramas = persistence.findAll();
        return listaProgramas;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Programas
     * WHERE ID
     *
     * @return ProgramaEntity
     */
    public ProgramaEntity obtenerPrograma(Long id) {
        ProgramaEntity programa = persistence.find(id);
        if (programa == null) {
            throw new IllegalArgumentException("El programa solicitado NO existe");
        }
        return programa;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Programas VALUES()
     *
     * @param programaCrear
     * @return
     */
    public ProgramaEntity crearPrograma(ProgramaEntity programaCrear) {
        persistence.create(programaCrear);
        return programaCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Programa
     *
     * @param id
     * @param programaActualizar
     * @return programa actualizado
     */
    public ProgramaEntity actualizarPrograma(Long id, ProgramaEntity programaActualizar) {
        ProgramaEntity programaUpdate = persistence.update(programaActualizar);
        return programaUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Programa FROM
     *
     *
     * @param id
     */
    public void eliminarPrograma(Long id) {
        persistence.remove(id);
    }

}
