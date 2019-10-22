package com.csye6225.fall2019.courseservice.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2019.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.fall2019.courseservice.datamodel.Professor;
import com.csye6225.fall2019.courseservice.service.ProfessorsService;
import org.glassfish.hk2.api.PerThread;

@Path("/professors")
public class ProfessorsResource {

    ProfessorsService profService = new ProfessorsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getProfessors() {
        return profService.getAllProfessors();
    }

    @GET
    @Path("/department/{departmentID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getProfessorsByDeparment(
            @PathParam("departmentID") String department) {

        if (department == null) {
            return profService.getAllProfessors();
        }
        return profService.getProfessorsByDepartment(department);

    }

    // ... webapi/professor/1
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
    public Professor deleteProfessor(@PathParam("professorId") long profId) {
        return profService.deleteProfessor(profId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor addProfessor(Professor prof) {
        prof.setProfessorId(prof.getFirstName()+prof.getLastName());
        prof.setJoiningDate(new Date().toString());
        //prof.setId(prof.getProfessorId());
        Date profDate = new Date();
        try {
            profDate = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(prof.getJoiningDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return profService.addProfessor(prof.getFirstName(),prof.getLastName(),prof.getDepartment(), profDate);
    }

    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor updateProfessor(@PathParam("professorId") long profId,
                                     Professor prof) {
        return profService.updateProfessorInformation(String.valueOf(profId), prof);
    }

    public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
        profService.addProfessor(firstName, lastName, department, joiningDate);
    }
}
