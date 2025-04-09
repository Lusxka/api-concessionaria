package org.acme.app.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.app.model.Cliente;

import java.util.List;

@Path("/clientes")
@Produces("application/json")
@Consumes("application/json")
public class ClienteResource {

    @GET
    public List<Cliente> list() {
        return Cliente.listAll();
    }

    @POST
    @Transactional
    public Response create(Cliente cliente) {
        cliente.persist();
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Cliente cliente) {
        Cliente entity = Cliente.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.nome = cliente.nome;
        entity.cpf = cliente.cpf;
        entity.endereco = cliente.endereco;
        entity.telefone = cliente.telefone;
        entity.persist();
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Cliente entity = Cliente.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Cliente get(@PathParam("id") Long id) {
        return Cliente.findById(id);
    }
}
