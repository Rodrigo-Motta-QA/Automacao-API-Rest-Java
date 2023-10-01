package Modulos.produtos;

import DataFactory.ProdutoDataFactory;
import DataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do Módulo do produto.")
public class ProdutoTest {

    private String token;

    @BeforeEach
    public void beforeach() {
        // Configurando os dados da API da Lojinha.
        baseURI = "http://165.227.93.41";

        basePath = "/lojinha";

        // Obter o token do usuario admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.CriarUsuarioAdministrador())
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");
    }

    @Test
    @DisplayName("Validar os limites proibidos do produto menor que 0.01.")
    public void testValidarLImitesZeradoProibidoValorProduto() {

        // tentar inserir um produtocom o valor 0.00 e validar que a mensagem de erro foi apresentada e

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComunComValorIgualA(0.00))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
    }

    @Test
    @DisplayName("Validar os limites proibidos do produto maior que 7000.01.")
    public void testValidarValorAcimaSeteMilProibidoValorProduto() {

        // tentar inserir um produtocom o valor 7000.01 e validar que a mensagem de erro foi apresentada e

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComunComValorIgualA(7000.01))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);

    }

}
