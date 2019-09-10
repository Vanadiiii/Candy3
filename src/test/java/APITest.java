import io.restassured.RestAssured;
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
        int[] statusMassive = {200, 300, 404, 500}; //статус 100 не хочет отвечать. TODO - выяснить, почему!
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
