package com.akadatsky.api;

import com.akadatsky.model.Company;
import com.akadatsky.model.CompanyWrapper;
import com.akadatsky.model.Job;
import com.akadatsky.model.JobWrapper;
import com.akadatsky.storage.Storage;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/companies")
public class CompanyApi {

    private static final Gson gson = new Gson();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCompany(String json) {
        try {
            Company company = gson.fromJson(json, Company.class);
            if (company != null) {
                company.setId(Storage.instance.getNextCompanyIndex());
                Storage.instance.saveCompany(company);
                String resultJson = "{\"id\": " + company.getId() + "}";
                return Response.status(Response.Status.OK).entity(resultJson).build();
            } else {
                String resultJson = "{\"result\": \"failed to add company\"}";
                return Response.status(Response.Status.BAD_REQUEST).entity(resultJson).build();
            }
        } catch (Exception e) {
            String resultJson = "{\"result\": \"failed to add company\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(resultJson).build();
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompaniesList() {
        List<Company> companies = Storage.instance.getCompanies();
        String resultJson = gson.toJson(new CompanyWrapper(companies));
        return Response.status(Response.Status.OK).entity(resultJson).build();
    }

    @GET
    @Path("/{id}/jobs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobsByCompanyId(@PathParam("id") Integer id) {
        try {
            // TODO if id not found return error
            List<Job> jobs = Storage.instance.getJobsByCompanyId(id);
            String resultJson = gson.toJson(new JobWrapper(jobs));
            return Response.status(Response.Status.OK).entity(resultJson).build();
        } catch (Exception e) {
            String resultJson = "{\"result\": \"wrong company id\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(resultJson).build();
        }
    }


}
