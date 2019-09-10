import io.restassured.RestAssured;
import org.junit.Test;


public class APITest {
    private static String baseURI = "https://httpbin.org/";
    //    public someMethod(){};

    public void apiRequest(int someStatus){
        RestAssured.given()
                .baseUri(baseURI) //путь к домену
                .basePath("status/" + someStatus) //Вывести статус в ответе

                .when().delete()// какой метод я для этого использую
                .then()
                .statusCode(someStatus);
    }
    @Test
    public void apiTest(){
        int[] statusMassive = {200, 300, 404, 500};
        for (int statusNumber = 0; statusNumber< statusMassive.length; statusNumber++) {
            apiRequest(statusMassive[statusNumber]);
            System.out.println("StatusCode " + statusMassive[statusNumber] + " is responded");
        }
    }
}
