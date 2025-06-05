package org.acme.app.config; 

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

/**
 * Classe de configuração para a API Key, mapeando propriedades do application.properties.
 * As propriedades com o prefixo 'quarkus.api-key' serão mapeadas para esta classe.
 */
@ConfigMapping(prefix = "quarkus.api-key") 
public interface ApiKeyConfig {

    /**
     * O valor secreto da API Key. Mapeia 'quarkus.api-key.value'.
     */
    @WithName("value") 
    String value();


    @WithName("header-name") 
    String headerName();
}