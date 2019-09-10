import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class APITest {
    private static String baseURI = "https://httpbin.org/";
    private int[] statusMassive = {200, 300, 400, 500};
    @Test
    public void apiTest1(){

        RestAssured.given()
                .baseUri(baseURI) //путь к домену
                .basePath("status/" + statusMassive[3]) //Вывести статус 100 в ответе
                /** Следующие выражения я не использую, т.к. десериализировать JSON into POJO мне здесь не нужно*/
//                .contentType(ContentType.JSON) //какой тип контента я использую для этого
//                .header("", "") //TODO узнать, что это такое??
//                .body("access-control-allow-credentials: true \n" +
//                        " access-control-allow-origin: https://httpbin.org \n" +
//                        " connection: keep-alive \n" +
//                        " content-length: 0 \n" +
//                        " content-type: text/html; charset=utf-8 \n" +
//                        " date: Tue, 10 Sep 2019 06:23:19 GMT \n" +
//                        " referrer-policy: no-referrer-when-downgrade \n" +
//                        " server: nginx \n" +
//                        " x-content-type-options: nosniff \n" +
//                        " x-frame-options: DENY \n" +
//                        " x-xss-protection: 1; mode=block ")
                /** Конец ненужных (пока) 911-765 выражений*/
                .when().post()// какой метод я для этого использую
                .then()
                .statusCode(statusMassive[3]);
    }
}
