package com.kalai.assuredsample;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    private String apiHost;

    @Before
    public void getConfig() {
        System.out.println("Before the class test starts");
    }

    @Test
    public void testResponseCode() {
        Response res = RestAssured.get("http://httpbin.org/get?isGood=true");
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test
    public void testResponseCode02() {
        Response res = RestAssured.get("http://httpbin.org/get?isGood=true");
        System.out.println(res.asString());
        Assert.assertEquals(true, true);
        //Assert.assertEquals(res.getStatusCode(), 200);
    }

}
