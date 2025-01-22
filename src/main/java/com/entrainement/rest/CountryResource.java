package com.entrainement.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entrainement.model.Country;
import com.entrainement.service.CountryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Country", description = "Opérations liées aux pays")
@Path("/countries") // Cette annotation indique le chemin de base pour tous les endpoints de cette classe.
public class CountryResource {
	
	@Inject
	private CountryService couService;

    @GET // Indique que cette méthode répondra aux requêtes HTTP GET.
    @Operation(summary = "Obtenir tous les pays", tags = {"Country"})
    @Produces(MediaType.APPLICATION_JSON) // Spécifie que la réponse sera au format JSON.
    public Response getCountry() {
    	List<Country> allCountry = couService.getAllCountrys();
        return Response.ok(allCountry).build();
    }

    @GET
    @Path("/{id}") // L'annotation Path avec {id} indique que cette méthode attend un paramètre dans l'URL.
    @Operation(summary = "Obtenir un pays par ID", tags = {"Country"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountry(@PathParam("id") int id) {
        Country emp = couService.getCountryById(id);
        return Response.ok(emp).build();
    }

    @POST // Indique que cette méthode répondra aux requêtes HTTP POST.
    @Operation(summary = "Creer un pays", tags = {"Country"})
    @Consumes(MediaType.APPLICATION_JSON) // Spécifie que la méthode s'attend à recevoir des données au format JSON.
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCountry(Country Country) {
        couService.insertCountry(Country);
        return Response.status(Response.Status.CREATED).entity(Country).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Modifier un pays par ID", tags = {"Country"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCountry(@PathParam("id") int id, Country Country) {
        couService.updateCountry(id, Country);
        return Response.ok(Country).build();
    }


    @DELETE
    @Operation(summary = "Effacer un pays par ID", tags = {"Country"})
    @Path("/{id}")
    public Response deleteCountry(@PathParam("id") int id) {
        couService.deleteCountry(id);
        return Response.noContent().build();
    }
}