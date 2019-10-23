package com.csye6225.fall2019.courseservice.resources;

import com.csye6225.fall2019.courseservice.datamodel.Lecture;
import com.csye6225.fall2019.courseservice.datamodel.Professor;
import com.csye6225.fall2019.courseservice.service.LecturesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Path("lectures")
public class LecturesResource {
    LecturesService lecService = new LecturesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lecture> getLectures() {
        return lecService.getAllLectures();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lecture addLecture(Lecture lec) {
        return lecService.addLecture(lec.getNote(), lec.getMaterial());
    }

    @PUT
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lecture updateLecture(@PathParam("lectureId") long lecId,
                                     Lecture lec) {
        return lecService.updateLecture(String.valueOf(lecId), lec);
    }

    @DELETE
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture deleteLecture(@PathParam("lectureId") long lecId) {
        return lecService.deleteLecture(lecId);
    }
}
