package stepdefination;




import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Products {



    public RequestSpecification  httpRequest;

    public Response response;

    public JSONObject requestParam;

    public ResponseBody body;


    @Given("I hit the get product api endpoint")
    public void i_hit_the_get_product_api_endpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
    }

    @When("I pass the url of product in the request")
    public void i_pass_the_url_of_product_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
    }
    @Then("I receive responce code as {int}")
    public void i_receive_responce_code_as(Integer expectedStatusCode) {
     int actualStatusCode = response.getStatusCode();  // get status code from response
        assertEquals(expectedStatusCode, actualStatusCode); // compare expected vs actual
    }

    @Then("I verify that the rate of first product is {}")
    public void iVerifyThatTheRateOfFirstProductIsFirstProductRate(String expectedRate) {
        String actualRate = response.jsonPath().getString("rating[0].rate");
        assertEquals(expectedRate, actualRate);

    }

    @Given("I hit the url of post product api endpoint")
    public void iHitTheUrlOfPostProductApiEndpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        httpRequest=RestAssured.given();


    }

    @And("I pass the request body of product title{}")
    public void iPassTheRequestBodyOfProductTitleProductTitle(String productTitle) {
        requestParam = new JSONObject();

        requestParam.put("title",productTitle);
        requestParam.put("price",14.5);
        requestParam.put("description","fdfhff");
        requestParam.put("category","electronics");
        requestParam.put("image","http://example.com");

        httpRequest.body(requestParam.toJSONString());
        response = httpRequest.post("products");
         body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

    @Then("I receive responce body with id as21{}")
    public void i_receive_responce_body_with_id_as21(String id) {
        JsonPath jsnpath = response.jsonPath();
        String s = jsnpath.getJsonObject("id").toString();
        assertEquals("21",s);
    }

    @Given("I hit the url of put product api endpoint")
    public void iHitTheUrlOfPutProductApiEndpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        requestParam = new JSONObject();
    }

    @When("I pass the url of put product in the request with{}")
    public void iPassTheUrlOfPutProductInTheRequestWithProductnumber(String productnumber) {
        httpRequest = RestAssured.given();

        requestParam.put("title","test product");
        requestParam.put("price",14.5);
        requestParam.put("description","fdfhff");
        requestParam.put("category","electronics");
        requestParam.put("image","http://example.com");

        httpRequest.body(requestParam.toJSONString());
        response = httpRequest.put("products/"+productnumber);
         body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

    }

    @Given("I hit the url of delete product api endpoint")
    public void iHitTheUrlOfDeleteProductApiEndpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        requestParam = new JSONObject();
        
    }

    @When("I pass the url of delete product in the request with{}")
    public void iPassTheUrlOfDeleteProductInTheRequestWithProductnumber(String productnumber) {
        httpRequest = RestAssured.given();

        requestParam.put("title","test product");
        requestParam.put("price",14.5);
        requestParam.put("description","fdfhff");
        requestParam.put("category","electronics");
        requestParam.put("image","http://example.com");

        httpRequest.body(requestParam.toJSONString());
        response = httpRequest.delete("products/"+productnumber);
         body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }
}
