package br.com.xbinario.cartao.controller;

import static io.restassured.RestAssured.given;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import br.com.xbinario.cartao.container.PostgresResource;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class TransacaoFaturaControllerTest {

    @Test
    public void testObterTransacaoEndpoint() {
        given()
          .when().get("/credit-cards-accounts/api/v1/accounts/123/123/transactions")
          .then()
          .statusCode(200)
             ;
    }


    @Test
    public void testExcluirEndpoint() {
        given()
          .when().delete("/credit-cards-accounts/api/v1/accounts/123/123/transactions")
          .then()
          .statusCode(200);
    }

    
}
