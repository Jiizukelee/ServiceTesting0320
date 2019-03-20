import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestGetToken {
    @Test
    void testToken(){
        given().log().all()
                .param("corpid",WeworkConfig.getInstance().corpid)
                .param("corpsecret",WeworkConfig.getInstance().secret)
                .when().log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .statusCode(200).body("errcode",equalTo(0));
    }

}
