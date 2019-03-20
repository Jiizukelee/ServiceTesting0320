import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class TestGetToken {
    @Test
    void testToken(){
        given().log().all()
                .param("corpid","ww606c3e9c019cd26d")
                .param("corpsecret","CLSNLFADacD-UYUJG7dkx1ZTT3yqp9z58yH2HsMUEpQ")
                .when().log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .statusCode(200).extract().body();
    }

}
