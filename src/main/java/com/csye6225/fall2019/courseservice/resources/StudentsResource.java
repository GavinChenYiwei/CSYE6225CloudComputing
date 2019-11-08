package com.csye6225.fall2019.courseservice.resources;

import com.csye6225.fall2019.courseservice.datamodel.Student;
import com.csye6225.fall2019.courseservice.service.StudentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("students")
public class StudentsResource {
    StudentsService stdService = new StudentsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent() {
        return stdService.getAllStudent();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student std) {
        return stdService.addStudent(std.getStudentId(), std.getFirstName(), std.getLastName(), std.getJoiningDate(),
                std.getDepartment(), std.getRegisteredCourses());
    }

    @PUT
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(@PathParam("studentId") long stdId,
                                 Student std) {
        return stdService.updateStudent(String.valueOf(stdId), std);
    }

    @DELETE
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student deleteStudent(@PathParam("studentId") long stdId) {
        return stdService.deleteStudent(stdId);
    }
}
