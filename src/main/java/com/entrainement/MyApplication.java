package com.entrainement;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.integration.api.OpenAPIConfiguration;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;

@ApplicationPath("/api")
public class MyApplication extends Application {
	
    public MyApplication() {
        super();

        OpenAPIConfiguration oasConfig = new SwaggerConfiguration()
                .prettyPrint(true)
                .resourcePackages(Stream.of("com.entrainement.rest").collect(Collectors.toSet()));
        ConnectionBdd.getConnection();

        try {
            new JaxrsOpenApiContextBuilder<>()
                    .openApiConfiguration(oasConfig)
                    .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}