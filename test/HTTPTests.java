/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.ws.rs.core.MediaType;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author Home
 */
public class HTTPTests {
    
    public HTTPTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        baseURI = "http://localhost:8084";
        defaultParser = Parser.JSON;
        basePath = "/CA-2-ORM-REST-AJAX/webresources/generic";
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
}
