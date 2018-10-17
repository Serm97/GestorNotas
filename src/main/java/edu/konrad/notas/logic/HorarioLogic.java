/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.notas.logic;

import edu.konrad.notas.entities.HorarioEntity;
import edu.konrad.notas.persistence.HorarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Horario
 *
 * @author Jorge Pulido.
 */
@Stateless
public class HorarioLogic {

//    Inyección Persistence de Horario
    @Inject
    private HorarioPersistence persistence;

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Horarios
     *
     * @return listaHorarios
     */
    public List<HorarioEntity> obtenerHorarios() {
        List<HorarioEntity> listaHorarios = persistence.findAll();
        return listaHorarios;
    }

    /**
     * Metodo que conecta la logica con la transaccion SELECT * FROM Horarios
     * WHERE ID
     *
     * @return HorarioEntity
     */
    public HorarioEntity obtenerHorario(Long id) {
        HorarioEntity horario = persistence.find(id);
        if (horario == null) {
            throw new IllegalArgumentException("El horario solicitado NO existe");
        }
        return horario;
    }

    /**
     * Metodo que conecta la logica con la transaccion para INSERT INTO Horarios VALUES()
     *
     * @param horarioCrear
     * @return
     */
    public HorarioEntity crearHorario(HorarioEntity horarioCrear) {
        persistence.create(horarioCrear);
        return horarioCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion UPDATE SET * WHERE Horario
     *
     * @param id
     * @param horarioActualizar
     * @return horario actualizado
     */
    public HorarioEntity actualizarHorario(Long id, HorarioEntity horarioActualizar) {
        HorarioEntity horarioUpdate = persistence.update(horarioActualizar);
        return horarioUpdate;
    }

    /**
     * Metodo que conecta la logica con la transaccion DELETE Horario FROM
     *
     *
     * @param id
     */
    public void eliminarHorario(Long id) {
        persistence.remove(id);
    }

}
