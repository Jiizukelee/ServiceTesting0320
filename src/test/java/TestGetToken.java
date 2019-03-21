import com.bigger.zxpjmall.wework.Wework;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestGetToken {
    @Test
    void testToken(){
        Wework wework = new Wework();
        String access_token = wework.getToken();
        assertThat(access_token, not(equalTo(null)));
    }

}
