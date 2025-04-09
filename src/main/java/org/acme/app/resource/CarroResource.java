package org.acme.app.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.app.model.Carro;

import java.util.List;

@Path("/carros")
@Produces("application/json")
@Consumes("application/json")
public class CarroResource {

    @GET
    public List<Carro> list() {
        return Carro.listAll();
    }

    @POST
    @Transactional
    public Response create(Carro carro) {
        carro.persist();
        return Response.status(Response.Status.CREATED).entity(carro).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Carro carro) {
        Carro entity = Carro.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.modelo = carro.modelo;
        entity.marca = carro.marca;
        entity.ano = carro.ano;
        entity.preco = carro.preco;
        entity.persist();
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Carro entity = Carro.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Carro get(@PathParam("id") Long id) {
        return Carro.findById(id);
    }
}