package com.bigger.zxpjmall.wework.contact;

import com.bigger.zxpjmall.wework.Wework;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Department {
    public Response list(String id){
         return given().log().all()
                .param("access_token", Wework.getToken())
                .param("id", id)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().all()
                .statusCode(200).extract().response();
    }

    public Response create(String name, int pid){
        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/create.json"))
                .set("$.name", name).set("$.parentid",pid ).jsonString();
        return given().log().all()
                .queryParam("access_token",Wework.getToken())
                .body(body)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all()
                .statusCode(200).extract().response();
    }

}
