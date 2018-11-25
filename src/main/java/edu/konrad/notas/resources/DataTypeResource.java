package edu.konrad.notas.resources;

import edu.konrad.notas.dto.DataTypeDTO;
import edu.konrad.notas.dto.RolDTO;
import edu.konrad.notas.entities.DataTypeEntity;
import edu.konrad.notas.entities.RolEntity;
import edu.konrad.notas.logic.DataTypeLogic;
import edu.konrad.notas.logic.RolLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jorge
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/datatypes")
public class DataTypeResource {

    @EJB
    private DataTypeLogic dataTypeLogic;

    @EJB
    private RolLogic rolLogic;

    @GET
    public List<DataTypeDTO> getDataTypeList() {
        List<DataTypeEntity> datatype = dataTypeLogic.obtenerDataTypees();
        return DataTypeDTO.toDataTypeList(datatype);
    }

    @GET
    @Path("{id: \\d+}")
    public DataTypeDTO getDataType(@PathParam("id") Long id) {
        DataTypeEntity dataType = dataTypeLogic.obtenerDataType(id);
        if (dataType == null) {
            throw new RuntimeException("El DataType NO existe.");
        }
        return new DataTypeDTO(dataType);
    }

    @GET
    @Path("{nombre}")
    public List<DataTypeDTO> getDataTypeByMaster(@PathParam("nombre") String nombre) {
        List<DataTypeEntity> datatypes = dataTypeLogic.obtenerDataTypeByMaster(nombre);
        if (datatypes == null) {
            throw new RuntimeException("El DataType NO existe.");
        }
        return DataTypeDTO.toDataTypeList(datatypes);
    }

    @POST
    public DataTypeDTO createDataType(DataTypeDTO datatype) {
        return new DataTypeDTO(dataTypeLogic.crearDataType(datatype.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public DataTypeDTO updateDataType(@PathParam("id") Long id, DataTypeDTO dataTypeDTO) {
        DataTypeEntity dataType = dataTypeLogic.obtenerDataType(id);

        if (dataType == null) {
            throw new RuntimeException("El DataType NO existe.");
        }
        return new DataTypeDTO(dataTypeLogic.actualizarDataType(id, dataTypeDTO.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteDataType(@PathParam("id") Long id) {
        DataTypeEntity dataType = dataTypeLogic.obtenerDataType(id);
        if (dataType == null) {
            throw new RuntimeException("El DataType NO existe.");
        }
        dataTypeLogic.eliminarDataType(id);
    }

    @GET
    @Path("/roles")
    public List<RolDTO> getRoles() {
        List<RolEntity> roles = rolLogic.obtenerRoles();
        if (roles == null) {
            throw new RuntimeException("El Rol NO existe.");
        }
        return RolDTO.toRolesList(roles);
    }

    @GET
    @Path("/roles/{id}")
    public RolDTO getRol(@PathParam("id") Long id) {
        RolEntity rol = rolLogic.obtenerRol(id);
        if (rol == null) {
            throw new RuntimeException("El Rol NO existe.");
        }
        return new RolDTO(rol);
    }

}
