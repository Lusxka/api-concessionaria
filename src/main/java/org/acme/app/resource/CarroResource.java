package org.acme.app.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.app.model.Carro;
import java.util.List;
import java.util.Collections;
import java.time.temporal.ChronoUnit;
import org.eclipse.microprofile.faulttolerance.Fallback; 
import io.smallrye.faulttolerance.api.RateLimit; 
import io.smallrye.faulttolerance.api.RateLimitException; 

@Path("/carros")
@Produces("application/json")
@Consumes("application/json")
public class CarroResource {

    @GET
    // Aplica o Rate Limit: 5 requisições a cada 10 segundos
    @RateLimit(value = 5, window = 10, windowUnit = ChronoUnit.SECONDS)
    // Define o método de fallback a ser chamado quando o Rate Limit é excedido
    @Fallback(fallbackMethod = "fallbackParaListarCarros")
    public List<Carro> list() {
        return Carro.listAll();
    }

    /**
     * Método de fallback para quando o rate limit da listagem de carros é excedido.
     * Retorna uma lista vazia e imprime uma mensagem no console.
     * Para uma resposta HTTP mais formal (status 429 Too Many Requests), você
     * poderia retornar um jakarta.ws.rs.core.Response.
     *
     * @param e A exceção RateLimitException que foi disparada.
     * @return Uma lista vazia de Carro, indicando que o limite foi atingido.
     */
    public List<Carro> fallbackParaListarCarros(RateLimitException e) {
        System.out.println("LOG: *** TAXA DE REQUISIÇÕES EXCEDIDA para /carros! ***");
        System.out.println("LOG: Detalhes do erro: " + e.getMessage());

        return Collections.emptyList();
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