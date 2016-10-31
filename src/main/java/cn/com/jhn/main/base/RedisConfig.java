package cn.com.jhn.main.base;

import cn.com.jhn.main.sys.RedisConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis Bean  Redis单机版
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-27 下午 5:09
 **/
@Configuration
public class RedisConfig {
    @Autowired
    private RedisConf redisConf;
    @Bean
    public JedisConnectionFactory createJedisFactory(){
        //RedisClusterConfiguration configuration=new RedisClusterConfiguration(redisConf.getHost());

        JedisConnectionFactory connectionFactory=new JedisConnectionFactory();

        JedisPoolConfig poolConfig=new JedisPoolConfig();

        poolConfig.setMaxIdle(redisConf.getMaxIdle());
        poolConfig.setMinIdle(redisConf.getMinIdle());
        connectionFactory.setHostName(redisConf.getRedisname());
        connectionFactory.setPort(redisConf.getPort());
        connectionFactory.setPoolConfig(poolConfig);

        return connectionFactory;
    }
    @Bean
    @Autowired
    public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

}
