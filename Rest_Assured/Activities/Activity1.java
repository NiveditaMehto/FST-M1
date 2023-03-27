import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



    public class Activity1 {


        String BaseURI = "https://petstore.swagger.io/v2/pet";
        String BaseURIIm = "https://petstore.swagger.io/v2/pet/{petId}/uploadImage";



        @Test(priority = 1)
        public void Postmethod() {

            String reqBody = "{"
                    + "\"id\": 567845,"
                    + "\"name\": \"Railey\","
                    + " \"status\": \"available\""
                    + "}";
            Response response=given().contentType(ContentType.JSON).body(reqBody).when().post(BaseURI);
            String res = response.getBody().asPrettyString();
            System.out.println(res);
            response.then().statusCode(200);
            response.then().body("id", equalTo(567845));
            response.then().body("name", equalTo("Railey"));
            response.then().body("status", equalTo("available"));

        }
        @Test(priority = 2)
        public void getMethod() {


            Response response = given().contentType(ContentType.JSON).pathParam("id",567845).when().get(BaseURI + "/{id}");

            String res = response.getBody().asPrettyString();
            System.out.println(res);
            response.then().statusCode(200);
            response.then().body("id", equalTo(567845));



        }
        @Test(priority = 3)
        public void deleteMethod() {

            Response response =
                    given().contentType(ContentType.JSON) // Set headers
                            .when().pathParam("id", "567845") // Set path parameter
                            .delete(BaseURI + "/{id}"); // Send DELETE request

            // Assertion
            response.then().body("code", equalTo(200));
            response.then().body("message", equalTo("567845"));


        }


    }



