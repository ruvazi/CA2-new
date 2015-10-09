/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import com.jayway.restassured.parsing.Parser;
import entity.Person;
import javax.ws.rs.core.MediaType;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author Home
 */
public class HTTPTests {
    
    Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public HTTPTests() {
    }

    @BeforeClass
    public static void setUpClass() {
        baseURI = "http://localhost:8084";
        defaultParser = Parser.JSON;
        basePath = "/api";
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBadLogin(){
        given()
                .authentication().basic("badusername","isuckatloggingin")
                .when()
                .delete("/1")
                .then()
                .statusCode(401);
    }
    
    @Test
    public void testGetPersonByPhone() {
        when()
                .get("/person/complete/phone/75824515")
                .then().
                statusCode(200).
                body("firstname", equalTo("Jens"));
            // Ikke funktionel. Vores getPersonByPhone metode i Control returnerer null values, nåede ikke frem til en løsning.
    }
    
    @Test
    public void testGetPerson() {
        when()
                .get("/person/complete/1")
                .then().
                statusCode(200).
                body("firstname", equalTo("Jens"));
    }
    
    @Test
    public void testError404OnWrongValue() {
        when()
                .get("/420420")
                .then().
                statusCode(404);
    }
    
    @Test
    public void testError400OnBadURL() {
        when()
                .get("/hvasså skal vi ned på grillen og chille maximum")
                .then().
                statusCode(400);
    }

    @Test
    public void testCreateNewPerson() {
        JsonObject json = new JsonObject();
        json.addProperty("id", 420);
        json.addProperty("firstname", "Balls");
        json.addProperty("lastname", "Mahoney");
        
        Person p = gson.fromJson(json, Person.class);

        given()
                .contentType(ContentType.JSON)
                .authentication().basic("user","pass")
                .body(p)
                .when()
                .post("/person")
                .then()
                .statusCode(200);
    }
    
    @Test
    public void testDeletePerson() {
        given()
                .contentType(ContentType.JSON)
                .authentication().basic("user","pass")
        .when()
                .delete("/person/delete/1")
                .then()
                .statusCode(200);
    }
    
    @Test
    public void testEditPerson() {
        JsonObject json = new JsonObject();
        json.addProperty("id", 2);
        json.addProperty("email", "w@w.w");
        json.addProperty("firstname", "Balls");
        json.addProperty("lastname", "Mahoney");
        
        Person p = gson.fromJson(json, Person.class);

        given()
                .contentType(ContentType.JSON)
                .authentication().basic("user","pass")
                .body(p)
                .when()
                .put("/person/edit")
                .then()
                .statusCode(200);
    }
    
    @Test
    public void testGetAllPersons() {
        when()
                .get("/person/complete")
                .then().
                statusCode(200).
                body("firstname", equalTo("[Jens, Mette, Gertrud, Emil, Bobby, Bodil, Max, Kim, Navn, Okayikkeflerenavne]"));
                //Expected og Actual giver det præcist samme. Forstår ikke hvorfor at testen ikke accepterer det.
    }

}
