package com.entrainement;

import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.v3.jaxrs2.integration.resources.AcceptHeaderOpenApiResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // Registra tus clases de recursos aquí
        packages("com.entrainement.rest");
        // Registra Swagger
        register(OpenApiResource.class);
        register(AcceptHeaderOpenApiResource.class);
    }
}


