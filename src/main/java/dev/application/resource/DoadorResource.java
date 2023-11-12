package dev.application.resource;

import dev.application.application.Result;
import dev.application.dto.DoadorDTO;
import dev.application.dto.DoadorResponseDTO;
import dev.application.service.DoadorService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/doadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoadorResource {

    @Inject
    DoadorService doadorService;

    @POST
    public Response create(DoadorDTO doadorDTO) {
        DoadorResponseDTO doadorResponseDTO = doadorService.create(doadorDTO);

        return Response.status(Status.CREATED).entity(doadorResponseDTO).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, DoadorDTO doadorDTO) {
        try {
            DoadorResponseDTO doadorResponseDTO = doadorService.update(id, doadorDTO);

            return Response.ok(doadorResponseDTO).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());

            return Response.status(Status.NOT_FOUND).entity(result).build();
        } catch (Exception e) {
            Result result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            doadorService.delete(id);

            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            Result result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    public Response getAll() {
        return Response.ok(doadorService.getAll()).build();
    }
}