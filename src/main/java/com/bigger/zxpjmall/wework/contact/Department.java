package com.bigger.zxpjmall.wework.contact;

import com.bigger.zxpjmall.wework.Wework;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Department {
    public Response list(String id){
/*        请求方式：GET（HTTPS）
        请求地址：https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID

        参数说明 ：

        参数	必须	说明
        access_token	是	调用接口凭证
        id	否	部门id。获取指定部门及其下的子部门。 如果不填，默认获取全量组织架构*/

         return given().log().all()
                .param("access_token", Wework.getToken())
                .param("id", id)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().all()
                .statusCode(200).extract().response();


    }

}
