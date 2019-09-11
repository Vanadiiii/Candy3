import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;


public class APITest {
    private int someStatuse;
    private void apiRequest(int someStatusCode){
        String baseURI = "https://httpbin.org/";
            RestAssured.given()
                .baseUri(baseURI) //путь к домену
                .basePath("status/" + someStatusCode) //Вывести статус в ответе

                .when().delete()// какой метод я для этого использую
                .then()
                .statusCode(someStatusCode).log().status();
    }
//    @Test
//    public void apiTest(){
//        int[] statusMassive = {200, 300, 404, 500}; //статус 100 не хочет отвечать на сайте
//        for (int i : statusMassive) {
//            try {
//                apiRequest(i);
//                System.out.println("StatusCode " + i + " is responded");
//            } catch (AssertionError e) {
//                System.out.println("StatusCode " + i + " is NOT responded");
//            }
//        }
//    }

    @Test
    public void apiTest1(){
        someStatuse = 200;
        apiRequest(someStatuse);
    }

    @Test
    public void apiTest2(){
        someStatuse = 300;
        apiRequest(someStatuse);
    }

    @Test
    public void apiTest3(){
        someStatuse = 400;
        apiRequest(someStatuse);
    }

    @Test
    public void apiTest4(){
        someStatuse = 55500;
        apiRequest(someStatuse);

    }
}
