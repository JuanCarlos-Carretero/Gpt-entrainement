package com.entrainement;

import org.glassfish.jersey.server.ResourceConfig;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.integration.api.OpenApiContext;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;

@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(@Context ServletConfig servletConfig) {
        // Enregistre tes classes de ressources ici
        packages("com.entrainement.rest");

        // Crée l'objet OpenAPI avec des informations de base sur l'API
        OpenAPI openAPI = new OpenAPI()
            .info(new Info()
                .title("API") // Titre de l'API
                .description("Cette API permet de gérer les informations des employés entre autres.") // Description de l'API
                .version("1.0.0") // Version de l'API
            )
            .servers(Collections.singletonList(new Server().url("/Gpt-entrainement"))); // URL de base de l'API

        // Configure SwaggerConfiguration
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
            .openAPI(openAPI)
            .prettyPrint(true)
            .resourcePackages(Stream.of("com.entrainement.rest").collect(Collectors.toSet()));

        try {
            // Initialise le contexte de Swagger avec la configuration
            OpenApiContext openApiContext = new JaxrsOpenApiContextBuilder()
                .servletConfig(servletConfig)
                .application(this)
                .openApiConfiguration(oasConfig)
                .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        // Enregistre Swagger
        register(OpenApiResource.class);
    }
}
