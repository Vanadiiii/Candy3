import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;


public class APITest {
    private int someStatuse;
    private void apiRequest(int someStatusCode){
        System.out.println("Check out status code " + someStatusCode);
        String baseURI = "https://httpbin.org/";
            RestAssured.given()
                .baseUri(baseURI) //путь к домену
                .basePath("status/" + someStatusCode) //Вывести статус в ответе

                .when().delete()// какой метод я для этого использую
                .then()
                .statusCode(someStatusCode).log().status();
        System.out.println("Status code " + someStatusCode + " is OK");
    }

//    @Test
//    public void apiTest1(){ //TODO узнать, как завершить действие, после ожидания определённого количества секунд
//        someStatuse = 100;
//        apiRequest(someStatuse);
//    }

    @Test
    public void apiTest2(){
        someStatuse = 200;
        apiRequest(someStatuse);
    }

    @Test
    public void apiTest3(){
        someStatuse = 300;
        apiRequest(someStatuse);
    }

    @Test
    public void apiTest4(){
        someStatuse = 400;
        apiRequest(someStatuse);
    }

    @Test
    public void apiTest5(){
        someStatuse = 500;
        apiRequest(someStatuse);

    }
}
