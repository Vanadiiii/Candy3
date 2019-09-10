import com.sun.xml.internal.ws.client.ResponseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;


public class APITest {
    private void apiRequest(int someStatus){
        String baseURI = "https://httpbin.org/";
        RestAssured.given()
                .baseUri(baseURI) //путь к домену
                .basePath("status/" + someStatus) //Вывести статус в ответе

                .when().delete()// какой метод я для этого использую
                .then()
                .statusCode(someStatus);//проверяю статус ответа

    }
    @Test
    public void apiTest(){
        int[] statusMassive = {200, 300, 404, 500};
        for (int i : statusMassive) {
            try {
                apiRequest(i);
                System.out.println("StatusCode " + i + " is responded");
            } catch (AssertionError e) {
                System.out.println("StatusCode " + i + " is NOT responded");
            }
        }
    }
}
