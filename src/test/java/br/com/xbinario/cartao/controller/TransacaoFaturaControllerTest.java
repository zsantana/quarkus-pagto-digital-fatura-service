package br.com.xbinario.cartao.controller;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.xbinario.cartao.container.PostgresResource;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class TransacaoFaturaControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(TransacaoFaturaControllerTest.class);

    @ConfigProperty(name = "teste.quarkus.oidc.auth-server-url") String serverUrl;
    @ConfigProperty(name = "teste.quarkus.oidc.client-id") String client_id;
    @ConfigProperty(name = "teste.quarkus.oidc.credentials.secret") String client_secret;
    @ConfigProperty(name = "teste.quarkus.oidc.realm") String realm;

    private String ACCESS_TOKEN;

    @BeforeEach
    void setUp(){

          logger.info("### SERVER_URL: " + this.serverUrl);
          logger.info("### client_id: " + this.client_id);
          logger.info("### client_secret: " + this.client_secret);
          logger.info("### realm: " + this.realm);

          Keycloak keycloak = KeycloakBuilder.builder()
                                  .serverUrl(serverUrl)
                                  .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                                  .realm(realm)
                                  .clientId(client_id)
                                  .clientSecret(client_secret)
                                  .build();
          this.ACCESS_TOKEN =  keycloak.tokenManager().getAccessToken().getToken();                             
    }



    @Test
    public void testObterTransacaoEndpoint() {

      logger.info("### Token: " + this.ACCESS_TOKEN);

      RestAssured.given()
                .when()
                .header("Authorization", "Bearer " + this.ACCESS_TOKEN) 
                .when().get("/credit-cards-accounts/api/v1/accounts/123/123/transactions")
                .then()
                .statusCode(200)
             ;
    }


    @Test
    public void testExcluirEndpoint() {
      RestAssured.given()
          .when()
          .header("Authorization", "Bearer " + this.ACCESS_TOKEN)
          .when().delete("/credit-cards-accounts/api/v1/accounts/123/123/transactions")
          .then()
          .statusCode(200);
    }

    
}
