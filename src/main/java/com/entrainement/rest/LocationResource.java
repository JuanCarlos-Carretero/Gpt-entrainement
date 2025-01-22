package com.entrainement.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entrainement.model.Location;
import com.entrainement.service.LocationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Location", description = "Opérations liées aux localissations")
@Path("/locations") // Cette annotation indique le chemin de base pour tous les endpoints de cette classe.
public class LocationResource {
	
	@Inject
	private LocationService locationService;

    @GET // Indique que cette méthode répondra aux requêtes HTTP GET.
    @Operation(summary = "Obtenir toutes les localissations", tags = {"Location"})
    @Produces(MediaType.APPLICATION_JSON) // Spécifie que la réponse sera au format JSON.
    public Response getLocation() {
    	List<Location> allLocation = locationService.getAllLocations();
        return Response.ok(allLocation).build();
    }

    @GET
    @Path("/{id}") // L'annotation Path avec {id} indique que cette méthode attend un paramètre dans l'URL.
    @Operation(summary = "Obtenir une localissation par ID", tags = {"Location"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocation(@PathParam("id") int id) {
        Location emp = locationService.getLocationById(id);
        return Response.ok(emp).build();
    }

    @POST // Indique que cette méthode répondra aux requêtes HTTP POST.
    @Operation(summary = "Creer une localissation", tags = {"Location"})
    @Consumes(MediaType.APPLICATION_JSON) // Spécifie que la méthode s'attend à recevoir des données au format JSON.
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLocation(Location location) {
        locationService.insertLocation(location);
        return Response.status(Response.Status.CREATED).entity(location).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Modifier une localissation par ID", tags = {"Location"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLocation(@PathParam("id") int id, Location location) {
        locationService.updateLocation(id, location);
        return Response.ok(location).build();
    }


    @DELETE
    @Operation(summary = "Effacer une localissation par ID", tags = {"Location"})
    @Path("/{id}")
    public Response deleteLocation(@PathParam("id") int id) {
        locationService.deleteLocation(id);
        return Response.noContent().build();
    }
}