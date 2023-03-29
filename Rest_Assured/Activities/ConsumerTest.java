package activities;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;


import au.com.dius.pact.consumer.junit5.PactTestFor;

import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    // Headers
    Map<String, String> headers = new HashMap<>();
    // Resource Path
    String resourcePath = "/api/users";

    // Create the contract
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        // Set the headers
        headers.put("Content-Type", "application/json");

        // Create the request and response body
        DslPart requestResponseBody = new PactDslJsonBody()
                .numberType("id", 123)
                .stringType("firstName", "Nivedita")
                .stringType("lastName", "Mehto")
                .stringType("email", "Nivedita@ibm.com");

        // Create the contract
        return builder.given("create user request").
                uponReceiving("A request to create a user").
                method("POST").
                path(resourcePath).
                headers(headers).
                body(requestResponseBody).
                willRespondWith().
                status(201).
                body(requestResponseBody).
                toPact();
    }

    // Consumer side test
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest() {
        // Request Body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 123);
        reqBody.put("firstName", "Nivedita");
        reqBody.put("lastName", "Mehto");
        reqBody.put("email", "Nivedita@ibm.com");

        // Send post request
        given().baseUri("http://localhost:8282").headers(headers).body(reqBody).
                when().post(resourcePath).
                then().statusCode(201);
    }
}