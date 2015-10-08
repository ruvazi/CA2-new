/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entity.Company;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ebbe
 */
public class JSONConverter {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public static Person getPersonFromJson(String js) {
        return gson.fromJson(js, Person.class);
    }

    public static Company getCompanyFromJson(String js) {
        return gson.fromJson(js, Company.class);
    }

    public static String getJSONFromPerson(Person p) {
        JsonObject obj = new JsonObject();
        obj.addProperty("id", p.getId());
        obj.addProperty("firstname", p.getFirstname());
        obj.addProperty("lastname", p.getLastname());
        return gson.toJson(obj);
    }

    public static String getJSONFromSinglePersonContact(String i) {
       
        JsonObject obj = new JsonObject();
        obj.addProperty("phonenum", i);

        return gson.toJson(obj);
    }

    public static String getJSONFromPerson(List<Person> persons) {
        return gson.toJson(persons);
    }

    public static String getJSONFromPersonList(List<Person> persons) {
        List<JsonObject> personList = new ArrayList();
        for (int i = 0; i < persons.size(); i++) {
            JsonObject obj = new JsonObject();
            obj.addProperty("id", persons.get(i).getId());
            obj.addProperty("firstname", persons.get(i).getFirstname());
            obj.addProperty("lastname", persons.get(i).getLastname());
            personList.add(obj);
        }
        return gson.toJson(personList);
    }

    public static String getJSONfromCompanies(List<Company> companies) {
        List<JsonObject> companyList = new ArrayList();
        for (int i = 0; i < companies.size(); i++) {
            JsonObject obj = new JsonObject();
            obj.addProperty("id", companies.get(i).getId());
            obj.addProperty("email", companies.get(i).getEmail());
            obj.addProperty("cvr", companies.get(i).getCvr());
            obj.addProperty("name", companies.get(i).getCompanyName());
            obj.addProperty("description", companies.get(i).getDescription());
            obj.addProperty("marketvalue", companies.get(i).getMarketValue());
            obj.addProperty("employees", companies.get(i).getNumEmployees());
            companyList.add(obj);
        }
        return gson.toJson(companyList);
    }

    public static String getJSONFromCompanyByCVR(Company c) {
        JsonObject obj = new JsonObject();
        obj.addProperty("id", c.getId());
        obj.addProperty("email", c.getEmail());
        obj.addProperty("cvr", c.getCvr());
        obj.addProperty("name", c.getCompanyName());
        obj.addProperty("description", c.getDescription());
        obj.addProperty("marketvalue", c.getMarketValue());
        obj.addProperty("number of employees", c.getNumEmployees());
        return gson.toJson(obj);
    }
    
        public static String getJSONFromCompany(Company c) {
        JsonObject obj = new JsonObject();
        obj.addProperty("id", c.getId());
        obj.addProperty("email", c.getEmail());
        obj.addProperty("cvr", c.getCvr());
        obj.addProperty("name", c.getCompanyName());
        obj.addProperty("description", c.getDescription());
        obj.addProperty("marketvalue", c.getMarketValue());
        obj.addProperty("number of employees", c.getNumEmployees());
        return gson.toJson(obj);
    }
}
