import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Yangjy on 2018/1/24.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test_01(){
    }
}
