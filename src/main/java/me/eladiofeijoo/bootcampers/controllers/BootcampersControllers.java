package me.eladiofeijoo.bootcampers.controllers;



import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.eladiofeijoo.bootcampers.dtos.NameUser;
import me.eladiofeijoo.bootcampers.models.Bootcamper;
import me.eladiofeijoo.bootcampers.services.BootcamperService;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootcampersControllers {

    private final BootcamperService service;

    public BootcampersControllers(BootcamperService service){
        this.service = service;
        service.create("Pedro");
        service.create("Jose");
        service.create("Jaime");
        service.create("Carlos");
        service.create("Luis");
    }

    @GET
    @Path("/bootcampers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bootcamper> getAllBootcampers(){
        return service.getAll();
    }

    @POST
    @Path("/bootcampers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBootcamper(NameUser nameUser){
        service.create(nameUser.getName());
        if(nameUser.getName() == null || nameUser.getName().isBlank()){
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        URI uri = URI.create("/bootcamper/" + nameUser.getName());
        return Response.created(uri).build();
    }

    @GET
    @Path("/bootcampers/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bootcamper getBootcamperByName(@PathParam("name") String name){
        return service.get(name);
    }

    @DELETE
    @Path("/bootcampers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBootcamper(NameUser nameUser){
        if(nameUser.getName() == null || nameUser.getName().isBlank()){
            return Response.ok().build();
        }
        service.delete(nameUser.getName());
        return Response.status(204).build();
    }

}
