package cl.bice.sampleapp;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(webEnvironment = DEFINED_PORT)
public class IntegrationTest {
    
    @Autowired
    private WebTestClient client;

    @Test
    void getLastIndicesTest(){

        client.get()
                .uri("http://localhost:9150/api/get-last-indices")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()                
                .jsonPath("$.yen").isNotEmpty()
                .jsonPath("$.yen.unit").isEqualTo("dolar")
                .jsonPath("$.dolar").isNotEmpty()
                .jsonPath("$.dolar.date").isNumber()
                .jsonPath("$.dolar.value").exists()
                .jsonPath("$.ipc").isNotEmpty()
                .jsonPath("$.ipc.unit").isEqualTo("porcentual");

    }
}
