import io.restassured.RestAssured;
import org.junit.Test;


public class SomeTest {
    private void apiRequest(int someStatusCode){ //метод, который всё проверяет
        String baseURI = "https://httpbin.org/";
        RestAssured.given()
                .baseUri(baseURI) //путь к домену
                .basePath("status/" + someStatusCode) //Вывести статус в ответе

                .when().delete()// какой метод я для этого использую
                .then()
                .statusCode(someStatusCode);//проверяю статус ответа
    }

    public void massiveOfTests (){
        int[] statusMassive = {200, 300, 404, 500}; //статус 100 не хочет отвечать на сайте
        for (int i : statusMassive) {
            new Object() {
                {
                    innerApiTests(i);
                }
                public void innerApiTests(int i){
                        try {
                            apiRequest(i);
                            System.out.println("StatusCode " + i + " is responded");
                        } catch (AssertionError e) {
                            System.out.println("StatusCode " + i + " is NOT responded");
                        }
                    }
                };
            }
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
}
