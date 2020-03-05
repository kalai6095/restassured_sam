package com.kalai.assuredsample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostData {
    private String server = "ang-udtut-8.firebaseio.com";

    @Test
    public void Test01Post() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();

        json.put("title", "kalai");
        json.put("content", "sample testing");
        requestSpecification.body(json.toJSONString());
        Response res = requestSpecification.post("https://" + server + "/posts.json");
        Assert.assertEquals(200, res.getStatusCode());
    }

    @Test
    public void Test02Update() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();

        json.put("title", "kalaiselvan");
        json.put("content", "sample testing");
        requestSpecification.body(json.toJSONString());
        Response res = requestSpecification.put("https://" + server + "/posts/M1WL-xaDVqTmhzaNGRu.json");
        Assert.assertEquals(200, res.getStatusCode());
    }

    @Test
    public void Test03Delete() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        Response res = requestSpecification.delete("https://" + server + "/posts/M1WL-xaDVqTmhzaNGRu.json");
        Assert.assertEquals(200, res.getStatusCode());
    }

}
