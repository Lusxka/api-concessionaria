package org.acme.app.config; 

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

/**
 * Classe de configuração para a API Key, mapeando propriedades do application.properties.
 * As propriedades com o prefixo 'quarkus.api-key' serão mapeadas para esta classe.
 */
@ConfigMapping(prefix = "quarkus.api-key") // Mapeia propriedades que começam com "quarkus.api-key"
public interface ApiKeyConfig {

    /**
     * O valor secreto da API Key. Mapeia 'quarkus.api-key.value'.
     */
    @WithName("value") // Mapeia a propriedade 'value' dentro do prefixo
    String value();

    /**
     * O nome do cabeçalho HTTP onde a API Key deve ser enviada. Mapeia 'quarkus.api-key.header-name'.
     */
    @WithName("header-name") // Mapeia a propriedade 'header-name' dentro do prefixo
    String headerName();
}