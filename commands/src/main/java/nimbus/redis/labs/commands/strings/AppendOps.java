package nimbus.redis.labs.commands.strings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


/**
 * @author Panson
 * @create 2023-10-18
 */
@Component
public class AppendOps {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String append(String baseKey, String append) {
        redisTemplate.opsForValue().append(baseKey, append);
        return redisTemplate.opsForValue().get(baseKey);
    }
}
