package com.entrainement.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Path("/hello")
public class Resource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSaludo() {
        return "Hello World";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Obtenir Donnees", description = "Obtenir Donnees pour example")
    @ApiResponse(responseCode = "200", description = "Données trouvées")
    public Response gatData() {
        String datos = "Données d'examples";
        return Response.ok(datos).build();
    }
}

