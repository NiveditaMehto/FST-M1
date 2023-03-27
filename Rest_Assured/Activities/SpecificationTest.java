package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scala.Int;

import javax.swing.*;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class SpecificationTest {
    RequestSpecification requestspec;
    ResponseSpecification responsespec;
    Integer Id =0;


    @BeforeClass
    public void setUp(){

        requestspec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet").addHeader("Content-Type","application/json").build();

        responsespec=  new ResponseSpecBuilder().
        expectStatusCode(200).
        expectResponseTime(lessThan(5000L)).
        build();

    }

    @Test(priority =1)
    public void postRequestTest(){


        String reqBody = "{"
                + "\"id\": 567897,"
                + "\"name\": \"Railey\","
                + " \"status\": \"available\""
                + "}";
        Response response=given().spec(requestspec).body(reqBody).when().post();
//correlation
        Id=response.then().extract().path("id");
        response.then().spec(responsespec).body("name", equalTo("Railey"));



    }
    @Test(priority =2)
    public void getRequestTest(){

       given().spec(requestspec).pathParam("id",Id).when().get("/{id}").then().spec(responsespec)
                .body("name", equalTo("Railey"));




    }
    @Test(priority =3)
    public void deleteRequestTest(){

        given().spec(requestspec).pathParam("id",Id).when().delete("/{id}")
                .then().spec(responsespec)
                .body("message", equalTo("" + Id));





    }

}
