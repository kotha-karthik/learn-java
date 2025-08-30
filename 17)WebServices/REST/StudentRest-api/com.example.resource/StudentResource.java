package com.example.resource;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    private final StudentDAO dao = new StudentDAO();

    @GET
    public Response list() {
        List<Student> list = dao.getAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") int id) {
        Student s = dao.getById(id);
        if (s == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(s).build();
    }

    @POST
    public Response create(Student s, @Context UriInfo uriInfo) {
        Student created = dao.add(s);
        if (created == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Could not create student")
                           .build();
        }
        UriBuilder ub = uriInfo.getAbsolutePathBuilder()
                               .path(String.valueOf(created.getSid()));
        return Response.created(ub.build()).entity(created).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") int id, Student s) {
        s.setSid(id);
        boolean ok = dao.update(s);
        if (!ok) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        boolean ok = dao.delete(id);
        if (!ok) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

}
