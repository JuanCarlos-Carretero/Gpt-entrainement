package com.entrainement.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entrainement.model.Region;
import com.entrainement.service.RegionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Region", description = "Opérations liées aux regions")
@Path("/regions") // Cette annotation indique le chemin de base pour tous les endpoints de cette classe.
public class RegionResource {
	
	@Inject
	private RegionService regionService;

    @GET // Indique que cette méthode répondra aux requêtes HTTP GET.
    @Operation(summary = "Obtenir tous les regions", tags = {"Region"})
    @Produces(MediaType.APPLICATION_JSON) // Spécifie que la réponse sera au format JSON.
    public Response getRegion() {
    	List<Region> allRegion = regionService.getAllRegions();
        return Response.ok(allRegion).build();
    }

    @GET
    @Path("/{id}") // L'annotation Path avec {id} indique que cette méthode attend un paramètre dans l'URL.
    @Operation(summary = "Obtenir un regions par ID", tags = {"Region"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRegion(@PathParam("id") int id) {
        Region emp = regionService.getRegionById(id);
        return Response.ok(emp).build();
    }

    @POST // Indique que cette méthode répondra aux requêtes HTTP POST.
    @Operation(summary = "Creer une region", tags = {"Region"})
    @Consumes(MediaType.APPLICATION_JSON) // Spécifie que la méthode s'attend à recevoir des données au format JSON.
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRegion(Region region) {
        regionService.insertRegion(region);
        return Response.status(Response.Status.CREATED).entity(region).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Modifier une region par ID", tags = {"Region"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRegion(@PathParam("id") int id, Region region) {
        regionService.updateRegion(id, region);
        return Response.ok(region).build();
    }


    @DELETE
    @Operation(summary = "Effacer une region par ID", tags = {"Region"})
    @Path("/{id}")
    public Response deleteRegion(@PathParam("id") int id) {
        regionService.deleteRegion(id);
        return Response.noContent().build();
    }
}