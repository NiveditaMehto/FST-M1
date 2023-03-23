import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RADemo {


    String BaseURI = "https://petstore.swagger.io/v2/pet";
    String BaseURIIm = "https://petstore.swagger.io/v2/pet/{petId}/uploadImage";

    @Test
    public void getPetStatus() {


        Response response = given().contentType(ContentType.JSON).when().get(BaseURI + "/findByStatus?status=sold");

        String res = response.getBody().asPrettyString();
        System.out.println(res);
        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("sold"));


    }

    @Test
    public void createNewPet() {
        Map<String,Object> map = new HashMap<>();
        map.put("id","5678");
        map.put("name","Railey");
        map.put("status","available");


        Response response=given().contentType(ContentType.JSON).body(map).when().post(BaseURI);
        String res = response.getBody().asPrettyString();
        System.out.println(res);

    }
    @Test
    public void addPetImage() {

       File pet =new File("C:\\Users\\003RX2744\\Pictures\\Camera Roll\\pet");

        Response response=given().multiPart(pet).pathParam("ID","568").when().post(BaseURIIm);

        System.out.println(response);
        response.then().body("code",equalTo(200));

    }

}


