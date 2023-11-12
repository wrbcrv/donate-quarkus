package dev.application.resource;

import dev.application.application.Result;
import dev.application.dto.BeneficiarioDTO;
import dev.application.dto.BeneficiarioResponseDTO;
import dev.application.service.BeneficiarioService;
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

@Path("/beneficiarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeneficiarioResource {

    @Inject
    BeneficiarioService beneficiarioService;

    @POST
    public Response create(BeneficiarioDTO beneficiarioDTO) {
        BeneficiarioResponseDTO beneficiarioResponseDTO = beneficiarioService.create(beneficiarioDTO);

        return Response.status(Status.CREATED).entity(beneficiarioResponseDTO).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, BeneficiarioDTO beneficiarioDTO) {
        try {
            BeneficiarioResponseDTO beneficiarioResponseDTO = beneficiarioService.update(id, beneficiarioDTO);

            return Response.ok(beneficiarioResponseDTO).build();
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
            beneficiarioService.delete(id);

            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            Result result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    public Response getAll() {
        return Response.ok(beneficiarioService.getAll()).build();
    }
}