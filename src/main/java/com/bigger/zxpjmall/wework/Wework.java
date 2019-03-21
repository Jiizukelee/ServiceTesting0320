package com.bigger.zxpjmall.wework;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Wework {
    private static String token;
    private static String getWeworkToken(){
        return given().log().all()
                .param("corpid", WeworkConfig.getInstance().corpid)
                .param("corpsecret", WeworkConfig.getInstance().secret)
                .when().log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .statusCode(200).extract().path("access_token");
    }
    public static String getToken(){
        if(token == null){
            token = getWeworkToken();
        }
        return  token;
    }

}
