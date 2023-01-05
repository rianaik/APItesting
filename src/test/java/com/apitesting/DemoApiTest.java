package com.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.ArrayList;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class DemoApiTest 
{
    public static ArrayList<Long> api_return_list = new ArrayList<Long>();
    
        @Test(priority = 0)
        public void listUsers() {
            Response responseGetUsers = RestAssured.given().contentType(ContentType.JSON)
                    .get("https://reqres.in/api/users?page=2");
    
            System.out.println(responseGetUsers.toString());
            Assert.assertEquals(responseGetUsers.jsonPath().get("page"), 2);
        }
    
    
        @Test(dependsOnMethods = { "listUsers" })
        public void createUser() {
            String requestBody = "{\"name\":\"Morpheus\",\"job\":\"leader\"}\n" + "";
    
            // Building request by using requestSpecBuilder
            RequestSpecBuilder builder = new RequestSpecBuilder();
    
            // Set API's Body
            builder.setBody(requestBody);
    
            // Setting content type as application/json
            builder.setContentType("application/json; charset=UTF-8");
    
            RequestSpecification requestSpec = builder.build();
    
            Response responseCreateCar = RestAssured.given().contentType(ContentType.JSON)
                    .spec(requestSpec).when()
                    .post("https://reqres.in/api/users");

            Assert.assertEquals(responseCreateCar.statusLine().contains("Created"), true);
        }

        @Test(dependsOnMethods = { "createUser" })
        public void updateUser() {
            String requestBody = "{\"name\":\"Morpheus\",\"job\":\"zion resident\"}\n" + "";
    
            // Building request by using requestSpecBuilder
            RequestSpecBuilder builder = new RequestSpecBuilder();
    
            // Set API's Body
            builder.setBody(requestBody);
    
            // Setting content type as application/json
            builder.setContentType("application/json; charset=UTF-8");
    
            RequestSpecification requestSpec = builder.build();
    
            Response responseUpdateUser = RestAssured.given().contentType(ContentType.JSON)
                    .spec(requestSpec).when()
                    .post("https://reqres.in/api/users");

                    Assert.assertEquals(responseUpdateUser.jsonPath().get("job"), "zion resident");
        }
}
