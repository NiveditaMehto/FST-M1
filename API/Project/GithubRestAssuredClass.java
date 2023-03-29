package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GithubRestAssuredClass {
    RequestSpecification requestspec;
    ResponseSpecification responsespec;
     String ssh = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAINlfAkVUOA30Fign7mIfnsUx3Vahe/HG0Z/jy1aNYRRH";
     String str;
    int Id= 0;

    @BeforeClass
    public void setUp(){

        requestspec = new RequestSpecBuilder().setBaseUri("https://api.github.com").addHeader("Content-Type","application/json").addHeader("Authorization","token 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").build();



    }

    @Test
    public void postRequestTest(){

            Map<String, Object> reqBody = new HashMap<>();


        reqBody.put("title","TestAPIKey");  //Put elements in Map
        reqBody.put("key",ssh);


        Response response=given().spec(requestspec).body(reqBody).when().post("/user/keys");
//correlation
       Id =response.then().extract().path("id");
     System.out.println(Id+ "Id345");
        responsespec=  new ResponseSpecBuilder().
                expectStatusCode(201).
                expectResponseTime(lessThan(5000L)).
                build();
        response.then().spec(responsespec);



    }
   @Test(priority =2)
    public void getRequestTest(){

      Response response1 =given().spec(requestspec).pathParam("keyId",Id).when().get("/user/keys/{keyId}");

       responsespec=  new ResponseSpecBuilder().
               expectStatusCode(200).
               expectResponseTime(lessThan(5000L)).
               build();
       response1.then().spec(responsespec).log().all();



    }
    @org.testng.annotations.Test(priority =3)
    public void deleteRequestTest(){

        given().spec(requestspec).pathParam("keyId",Id).when().delete("/user/keys/{keyId}")
                .then().spec(responsespec)
                .body("message", equalTo("" + Id)).log().all();





    }

}
