package com.csye6225.fall2019.courseservice.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2019.courseservice.datamodel.Professor;
import com.csye6225.fall2019.courseservice.service.ProfessorsService;

//../webapi/professors
@Path("professors")
public class ProfessorsResource {

    ProfessorsService profService = new ProfessorsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getProfessors() {
        return profService.getAllProfessors();
    }

    //../webapi/professors/department/{departmentID}
    @GET
    @Path("/department/{departmentID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getProfessorsByDeparment(
            @PathParam("departmentID") String department) {

        if (department == null || department.length() == 0) {
            return profService.getAllProfessors();
        }
        return profService.getProfessorsByDepartment(department);

    }

    // ... webapi/professors/1
    @GET
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor getProfessor(@PathParam("professorId") String profId) {
        System.out.println("Professor Resource: Looking for: " + profId);
        return profService.getProfessor(profId);
    }

    @DELETE
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor deleteProfessor(@PathParam("professorId") String profId) {
        return profService.deleteProfessor(profId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor addProfessor(Professor prof) {
        prof.setProfessorId(prof.getFirstName()+prof.getLastName());
        prof.setJoiningDate(new Date().toString());
        return profService.addProfessor(prof);
    }

    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor updateProfessor(@PathParam("professorId") String profId,
                                     Professor prof) {
        return profService.updateProfessorInformation(String.valueOf(profId), prof);
    }
}
