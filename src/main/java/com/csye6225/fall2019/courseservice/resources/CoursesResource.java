package com.csye6225.fall2019.courseservice.resources;

import com.csye6225.fall2019.courseservice.datamodel.Course;
import com.csye6225.fall2019.courseservice.service.CoursesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("classes")
public class CoursesResource {
    CoursesService cseService = new CoursesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourse() {
        return cseService.getAllCourse();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course addCourse(Course cse) {
        return cseService.addCourse(cse);
    }

    @PUT
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course updateCourse(@PathParam("courseId") String cseId,
                                 Course cse) {
        return cseService.updateCourse(String.valueOf(cseId), cse);
    }

    @DELETE
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course deleteCourse(@PathParam("courseId") String cseId) {
        return cseService.deleteCourse(cseId);
    }
}
