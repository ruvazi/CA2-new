/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import Utility.JSONConverter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import control.ControlCRUD;
import entity.*;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Emil
 */
@Path("generic")
public class PersonResource {
    Gson gson;

    @Context
    private UriInfo context;
    ControlCRUD cc = new ControlCRUD(Persistence.createEntityManagerFactory("PU"));

    public PersonResource() {
        gson = new GsonBuilder()
            .setPrettyPrinting()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create();
}

    @GET
    @Path("complete")
    @Produces("application/json")
    public String getPersons() {
        return JSONConverter.getJSONFromPersonList(cc.getAllPersons());
    }
    
    @GET
    @Path("complete/{id}")
    @Produces("application/json")
    public String getPersonByID(@PathParam("id") int id) {
        return JSONConverter.getJSONFromPerson(cc.getPerson(id));
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String CreateNewPerson(String person) {
        
        Person p = JSONConverter.getPersonFromJson(person);
        p = cc.createPerson(p);
        return JSONConverter.getJSONFromPerson(p);
    }
    @POST
    @Path("company")
    @Produces("application/json")
    @Consumes("application/json")
    public String CreateNewCompany(String company) {
        Company c = JSONConverter.getCompanyFromJson(company);
        c = cc.createCompany(c);
        return JSONConverter.getJSONFromCompany(c);
    }
}
