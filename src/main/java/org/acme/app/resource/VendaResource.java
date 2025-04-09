package org.acme.app.resource;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.app.model.Venda;

import java.time.LocalDate;
import java.util.List;

@Path("/vendas")
@Produces("application/json")
@Consumes("application/json")
public class VendaResource {

    @GET
    public List<Venda> list() {
        return Venda.listAll();
    }

    @POST
    @Transactional
    public Response create(Venda venda) {
        venda.persist();
        return Response.status(Response.Status.CREATED).entity(venda).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Venda venda) {
        Venda entity = Venda.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.carro = venda.carro;
        entity.cliente = venda.cliente;
        entity.data = venda.data;
        entity.valor = venda.valor;
        entity.persist();
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Venda entity = Venda.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Venda get(@PathParam("id") Long id) {
        return Venda.findById(id);
    }

    @GET
    @Path("/relatorio")
    public List<Venda> relatorioVendas(
        @QueryParam("dataInicio") @NotNull LocalDate dataInicio,
        @QueryParam("dataFim") @NotNull LocalDate dataFim
    ) {
        return Venda.list("data >= ?1 and data <= ?2", dataInicio, dataFim);
    }
}
