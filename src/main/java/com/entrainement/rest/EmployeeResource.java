package com.entrainement.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entrainement.model.Employee;
import com.entrainement.service.EmployeeService;

@Path("/employees") // Cette annotation indique le chemin de base pour tous les endpoints de cette classe.
public class EmployeeResource {
	
	private EmployeeService empService = new EmployeeService();

    @GET // Indique que cette méthode répondra aux requêtes HTTP GET.
    @Produces(MediaType.APPLICATION_JSON) // Spécifie que la réponse sera au format JSON.
    public Response getEmployees() {
    	List<Employee> allEmployee = empService.getAllEmployees();
        return Response.ok(allEmployee).build();
    }

    @GET
    @Path("/{id}") // L'annotation Path avec {id} indique que cette méthode attend un paramètre dans l'URL.
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") int id) {
        Employee emp = empService.getEmployeeById(id);
        return Response.ok(emp).build();
    }

    @POST // Indique que cette méthode répondra aux requêtes HTTP POST.
    @Consumes(MediaType.APPLICATION_JSON) // Spécifie que la méthode s'attend à recevoir des données au format JSON.
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee) {
        empService.insertEmployee(employee);
        return Response.status(Response.Status.CREATED).entity(employee).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id, Employee employee) {
        empService.updateEmployee(id, employee);
        return Response.ok(employee).build();
    }


    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        empService.deleteEmployee(id);
        return Response.noContent().build();
    }
}