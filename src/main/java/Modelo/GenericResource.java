/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Cris
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    public GenericResource() {
    }

    @GET
    @Path("/automoviles/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Automovil> getAutomoviles() {
        List<Automovil> misProductos = Crud.getAutomoviles();
        return misProductos;
    }

    @GET
    @Path("/automovil/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Automovil getAutomovil(@PathParam("id") int id) {
        Automovil miProducto = Crud.getAutomovil(id);
        return miProducto;
    }

    @PUT
    @Path("/automovil/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Automovil updateAutomovil(Automovil prod) {
        Crud.updateAutomovil(prod);
        return prod;
    }

    @POST
    @Path("/automovil/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertAutomovil(Automovil prod) {
        Crud.insertAutomovil(prod);
    }

    @DELETE
    @Path("/automovil/{id}")
    public void deleteAutomovil(@PathParam("id") int id) {
        Crud.deleteAutomovil(id);
    }

}
