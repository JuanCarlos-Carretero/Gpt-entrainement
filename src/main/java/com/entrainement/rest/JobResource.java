package com.entrainement.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entrainement.model.Job;
import com.entrainement.service.JobService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Job", description = "Opérations liées aux fonctions d'un employee")
@Path("/jobs") // Cette annotation indique le chemin de base pour tous les endpoints de cette classe.
public class JobResource {
	
	@Inject
	private JobService jobService;

    @GET // Indique que cette méthode répondra aux requêtes HTTP GET.
    @Operation(summary = "Obtenir toutes les fonctions", tags = {"Job"})
    @Produces(MediaType.APPLICATION_JSON) // Spécifie que la réponse sera au format JSON.
    public Response getJob() {
    	List<Job> allJob = jobService.getAllJobs();
        return Response.ok(allJob).build();
    }

    @GET
    @Path("/{id}") // L'annotation Path avec {id} indique que cette méthode attend un paramètre dans l'URL.
    @Operation(summary = "Obtenir une fonction par ID", tags = {"Job"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJob(@PathParam("id") int id) {
        Job emp = jobService.getJobById(id);
        return Response.ok(emp).build();
    }

    @POST // Indique que cette méthode répondra aux requêtes HTTP POST.
    @Operation(summary = "Creer une fonction", tags = {"Job"})
    @Consumes(MediaType.APPLICATION_JSON) // Spécifie que la méthode s'attend à recevoir des données au format JSON.
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJob(Job job) {
        jobService.insertJob(job);
        return Response.status(Response.Status.CREATED).entity(job).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Modifier une fonction par ID", tags = {"Job"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateJob(@PathParam("id") int id, Job job) {
        jobService.updateJob(id, job);
        return Response.ok(job).build();
    }


    @DELETE
    @Operation(summary = "Effacer une fonction par ID", tags = {"Job"})
    @Path("/{id}")
    public Response deleteJob(@PathParam("id") int id) {
        jobService.deleteJob(id);
        return Response.noContent().build();
    }
}