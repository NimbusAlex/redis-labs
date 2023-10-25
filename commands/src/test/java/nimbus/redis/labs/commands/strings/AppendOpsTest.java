package nimbus.redis.labs.commands.strings;

import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Panson
 * @create 2023-10-25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppendOpsTest {

    private static final String KEY = "study";

    private static final String VALUE = "redis";

    private static final String APPEND_VALUE = "-labs";

    private static final String VALUE_AFTER_APPEND = "redis-labs";


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private AppendOps appendOps;

    @Before
    public void doBefore() throws Exception {
        stringRedisTemplate.delete(KEY);
        stringRedisTemplate.opsForValue().set(KEY, VALUE);
    }

    @After
    public void doAfter() throws Exception {
        stringRedisTemplate.delete(KEY);
    }

    @Test
    public void appendTest() {
        String valueAfterAppend = appendOps.append(KEY, APPEND_VALUE);
        Assert.assertTrue(StringUtils.equals(valueAfterAppend, VALUE_AFTER_APPEND));
    }
}
