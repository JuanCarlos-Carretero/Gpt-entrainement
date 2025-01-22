package com.entrainement.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entrainement.model.Employee;
import com.entrainement.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Employee", description = "Opérations liées aux employés")
@Path("/employees") // Cette annotation indique le chemin de base pour tous les endpoints de cette classe.
public class EmployeeResource {
	
	@Inject
	private EmployeeService employeeService;

    @GET // Indique que cette méthode répondra aux requêtes HTTP GET.
    @Operation(summary = "Obtenir tous les employés", tags = {"Employee"})
    @Produces(MediaType.APPLICATION_JSON) // Spécifie que la réponse sera au format JSON.
    public Response getEmployees() {
    	List<Employee> allEmployee = employeeService.getAllEmployees();
        return Response.ok(allEmployee).build();
    }

    @GET
    @Path("/{id}") // L'annotation Path avec {id} indique que cette méthode attend un paramètre dans l'URL.
    @Operation(summary = "Obtenir un employé par ID", tags = {"Employee"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") int id) {
        Employee emp = employeeService.getEmployeeById(id);
        return Response.ok(emp).build();
    }

    @POST // Indique que cette méthode répondra aux requêtes HTTP POST.
    @Operation(summary = "Creer un employé", tags = {"Employee"})
    @Consumes(MediaType.APPLICATION_JSON) // Spécifie que la méthode s'attend à recevoir des données au format JSON.
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee) {
        employeeService.insertEmployee(employee);
        return Response.status(Response.Status.CREATED).entity(employee).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Modifier un employé par ID", tags = {"Employee"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id, Employee employee) {
        employeeService.updateEmployee(id, employee);
        return Response.ok(employee).build();
    }


    @DELETE
    @Operation(summary = "Effacer un employé par ID", tags = {"Employee"})
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        employeeService.deleteEmployee(id);
        return Response.noContent().build();
    }
}