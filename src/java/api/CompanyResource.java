/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import entity.Company;
import control.ControlCRUD;
import Utility.JSONConverter;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Ebbe
 */
@Path("company")
public class CompanyResource {

    @Context
    private UriInfo context;
    ControlCRUD cc = new ControlCRUD(Persistence.createEntityManagerFactory("PU"));

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyResource() {
    }

    @GET
    @Path("complete")
    @Produces("application/json")
    public String getAllCompanys() {
        return JSONConverter.getJSONfromCompanies(cc.getAllCompanys());
    }

    @GET
    @Path("complete/{cvr}")
    @Produces("application/json")
    public String getCompanyByID(@PathParam("cvr") int cvr) {
        return JSONConverter.getJSONFromCompanyByCVR(cc.getCompany(cvr));
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String CreateNewCompany(String company) {
        Company c = JSONConverter.getCompanyFromJson(company);
        c = cc.createCompany(c);
        return JSONConverter.getJSONFromCompany(c);
    }
//
    @PUT
    @Path("edit/{edit}")
    @Produces("application/json")
    @Consumes("application/json")
    public String editCompany(String company) {
        Company c = JSONConverter.getCompanyFromJson(company);
        c = cc.editCompany(c);
        return JSONConverter.getJSONFromCompany(c);
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public String deletePerson(@PathParam("id") int id) {
        Company c = cc.deleteCompany(id);
        return JSONConverter.getJSONFromCompany(c);
    }
}
