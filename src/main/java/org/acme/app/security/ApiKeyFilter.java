package org.acme.app.security; // VERIFIQUE E AJUSTE ESTE PACOTE CONFORME SEU PROJETO

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
// REMOVA ESTA LINHA SE ELA EXISTIR: import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.acme.app.config.ApiKeyConfig; // IMPORTANTE: VERIFIQUE E AJUSTE ESTE IMPORT

/**
 * Filtro de requisições para validação de API Key.
 * Intercepta todas as requisições e verifica a presença e validade da API Key.
 */
@Provider
@ApplicationScoped
public class ApiKeyFilter implements ContainerRequestFilter {

    // Injete a nova classe de configuração, não as propriedades individuais
    @Inject
    ApiKeyConfig apiKeyConfig;

    /**
     * Método principal do filtro que é executado para cada requisição recebida.
     */
    @Override
    public void filter(ContainerRequestContext requestContext) {
        // Verifica se a rota é pública e não requer autenticação.
        if (isPublicRoute(requestContext.getUriInfo().getPath())) {
            return;
        }

        // Obtém o valor do cabeçalho da API key da requisição, usando o nome do cabeçalho da configuração.
        String providedKey = requestContext.getHeaderString(apiKeyConfig.headerName());

        // --- INÍCIO DAS LINHAS DE DEPURADAÇÃO (Mantenha para verificar) ---
        System.out.println("--- Depuração API Key ---");
        System.out.println("API Key Configurada (apiKeyConfig.value()): \"" + apiKeyConfig.value() + "\"");
        System.out.println("API Key Recebida (providedKey): \"" + providedKey + "\"");
        System.out.println("-------------------------");
        // --- FIM DAS LINHAS DE DEPURADAÇÃO ---

        // Verifica se a API key fornecida é nula/vazia ou não corresponde à chave configurada.
        if (providedKey == null || !providedKey.equals(apiKeyConfig.value())) {
            requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                    .entity("API key inválida ou ausente")
                    .build());
        }
    }

    /**
     * Método auxiliar para determinar se uma rota é pública.
     */
    private boolean isPublicRoute(String path) {
        return path.contains("/public/") ||
               path.startsWith("/q/health") ||
               path.startsWith("/q/metrics") ||
               path.startsWith("/q/swagger-ui") ||
               path.startsWith("/openapi") ||
               path.startsWith("/swagger");
    }
}