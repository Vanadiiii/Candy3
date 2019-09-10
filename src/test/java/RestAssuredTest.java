import org.junit.Test;

import static io.restassured.RestAssured.given;

    public class RestAssuredTest {
        //HTTP-метод Post
        @Test
        public void test1(){
            String s = "{\n" +
                    "  \"args\": {},\n" +
                    "  \"data\": \"\",\n" +
                    "  \"files\": {},\n" +
                    "  \"form\": {},\n" +
                    "  \"headers\": {\n" +
                    "    \"Accept\": \"application/json\",\n" +
                    "    \"Accept-Encoding\": \"gzip, deflate, br\",\n" +
                    "    \"Accept-Language\": \"en-US,en;q=0.9,ru-RU;q=0.8,ru;q=0.7\",\n" +
                    "    \"Content-Length\": \"0\",\n" +
                    "    \"Dnt\": \"1\",\n" +
                    "    \"Host\": \"httpbin.org\",\n" +
                    "    \"Origin\": \"https://httpbin.org\",\n" +
                    "    \"Referer\": \"https://httpbin.org/\",\n" +
                    "    \"Sec-Fetch-Mode\": \"cors\",\n" +
                    "    \"Sec-Fetch-Site\": \"same-origin\",\n" +
                    "    \"User-Agent\": \"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36\"\n" +
                    "  },\n" +
                    "  \"json\": null,\n" +
                    "  \"origin\": \"46.147.188.2, 46.147.188.2\",\n" +
                    "  \"url\": \"https://httpbin.org/post\"\n" +
                    "}";
            given()
                    .body(s)
                    .when()
                    .post("https://httpbin.org/post")
                    .then()
                    .statusCode(200);
        }
    }
