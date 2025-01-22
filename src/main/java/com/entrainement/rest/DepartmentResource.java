package com.entrainement.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entrainement.model.Department;
import com.entrainement.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Department", description = "Opérations liées aux departements")
@Path("/department") // Cette annotation indique le chemin de base pour tous les endpoints de cette classe.
public class DepartmentResource {
	
	@Inject
	private DepartmentService departmentService;

    @GET // Indique que cette méthode répondra aux requêtes HTTP GET.
    @Operation(summary = "Obtenir tous les departements", tags = {"Department"})
    @Produces(MediaType.APPLICATION_JSON) // Spécifie que la réponse sera au format JSON.
    public Response getDepartment() {
    	List<Department> allDepartment = departmentService.getAllDepartments();
        return Response.ok(allDepartment).build();
    }

    @GET
    @Path("/{id}") // L'annotation Path avec {id} indique que cette méthode attend un paramètre dans l'URL.
    @Operation(summary = "Obtenir un departements par ID", tags = {"Department"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartment(@PathParam("id") int id) {
        Department emp = departmentService.getDepartmentById(id);
        return Response.ok(emp).build();
    }

    @POST // Indique que cette méthode répondra aux requêtes HTTP POST.
    @Operation(summary = "Creer un departements", tags = {"Department"})
    @Consumes(MediaType.APPLICATION_JSON) // Spécifie que la méthode s'attend à recevoir des données au format JSON.
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDepartment(Department department) {
        departmentService.insertDepartment(department);
        return Response.status(Response.Status.CREATED).entity(department).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Modifier un departements par ID", tags = {"Department"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDepartment(@PathParam("id") int id, Department department) {
        departmentService.updateDepartment(id, department);
        return Response.ok(department).build();
    }


    @DELETE
    @Operation(summary = "Effacer un departements par ID", tags = {"Department"})
    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") int id) {
        departmentService.deleteDepartment(id);
        return Response.noContent().build();
    }
}