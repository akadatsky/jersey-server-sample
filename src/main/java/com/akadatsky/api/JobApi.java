package com.akadatsky.api;

import javax.ws.rs.Path;

import com.akadatsky.model.Job;
import com.akadatsky.model.JobWrapper;
import com.akadatsky.storage.Storage;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/jobs")
public class JobApi {

    private static final Gson gson = new Gson();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addJob(String json) {
        try {
            Job job = gson.fromJson(json, Job.class);
            if (Storage.instance.getCompanyById(job.getCompanyId()) == null) {
                String resultJson = "{\"result\": \"company id not found\"}";
                return Response.status(Response.Status.BAD_REQUEST).entity(resultJson).build();
            }
            job.setId(Storage.instance.getNextJobIndex());
            Storage.instance.saveJob(job);
            String resultJson = "{\"id\": " + job.getId() + "}";
            return Response.status(Response.Status.OK).entity(resultJson).build();
        } catch (Exception e) {
            String resultJson = "{\"result\": \"failed to add job\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(resultJson).build();
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobsList() {
        List<Job> jobs = Storage.instance.getJobs();
        String resultJson = gson.toJson(new JobWrapper(jobs));
        return Response.status(Response.Status.OK).entity(resultJson).build();
    }
}