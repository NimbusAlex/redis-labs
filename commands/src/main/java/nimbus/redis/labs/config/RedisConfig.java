package nimbus.redis.labs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author Panson
 * @create 2023-10-18
 */
public class RedisConfig {

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // 创建 RedisTemplate 对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 设置开启事务支持
        template.setEnableTransactionSupport(true);

        // 设置 RedisConnection 工厂
        template.setConnectionFactory(factory);

        // 使用 String 序列化方式，序列化 KEY
        template.setKeySerializer(RedisSerializer.string());

        // 使用 JSON 序列化方式（库是 Jackson ），序列化 VALUE
        template.setValueSerializer(RedisSerializer.json());

        return template;
    }
}
