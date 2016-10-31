package cn.com.jhn.main.base;

import cn.com.jhn.main.sys.RedisJedisConf;
import org.springframework.beans.factory.access.BootstrapException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis Jedis 集群Bean
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-28 下午 4:40
 **/
@Configuration
public class RedisJedisConfig {

    @Autowired
    protected RedisJedisConf redisJedisConf;

    @Bean(name="writeShardJedisPool")
    public ShardedJedisPool createWriteSharedJedisPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisJedisConf.getMaxTotal());
        poolConfig.setMaxIdle(redisJedisConf.getMaxIdle());
        poolConfig.setNumTestsPerEvictionRun(redisJedisConf.getNumTestsPerEvictionRun());
        poolConfig.setTimeBetweenEvictionRunsMillis(redisJedisConf.getTimeBetweenEvictionRunsMillis());
        poolConfig.setMinEvictableIdleTimeMillis(redisJedisConf.getMinEvictableIdleTimeMillis());
        poolConfig.setSoftMinEvictableIdleTimeMillis(redisJedisConf.getSoftMinEvictableIdleTimeMillis());
        poolConfig.setMaxWaitMillis(redisJedisConf.getMaxWaitMillis());
        poolConfig.setTestOnBorrow(Boolean.parseBoolean(redisJedisConf.getTestOnBorrow()));
        poolConfig.setTestOnReturn(Boolean.parseBoolean(redisJedisConf.getTestOnReturn()));
        poolConfig.setJmxEnabled(Boolean.parseBoolean(redisJedisConf.getJmxEnabled()));
        poolConfig.setJmxNamePrefix(redisJedisConf.getJmxNamePrefix());
        poolConfig.setBlockWhenExhausted(Boolean.parseBoolean(redisJedisConf.getBlockWhenExhausted()));
        List<JedisShardInfo> shardInfoList = new ArrayList<>();
        for (String host : redisJedisConf.getMasterhosts()) {
            String[] hostPort = host.split(":");
            JedisShardInfo shardInfo = new JedisShardInfo(hostPort[0],
                                                          Integer.parseInt(hostPort[1]), "master");
            shardInfo.setPassword("johnson");
            shardInfoList.add(shardInfo);
        }

        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig,shardInfoList);
        return shardedJedisPool;
    }
    @Bean(name="readShardJedisPool")
    public ShardedJedisPool createReadSharedJedisPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisJedisConf.getMaxTotal());
        poolConfig.setMaxIdle(redisJedisConf.getMaxIdle());
        poolConfig.setNumTestsPerEvictionRun(redisJedisConf.getNumTestsPerEvictionRun());
        poolConfig.setTimeBetweenEvictionRunsMillis(redisJedisConf.getTimeBetweenEvictionRunsMillis());
        poolConfig.setMinEvictableIdleTimeMillis(redisJedisConf.getMinEvictableIdleTimeMillis());
        poolConfig.setSoftMinEvictableIdleTimeMillis(redisJedisConf.getSoftMinEvictableIdleTimeMillis());
        poolConfig.setMaxWaitMillis(redisJedisConf.getMaxWaitMillis());
        poolConfig.setTestOnBorrow(Boolean.parseBoolean(redisJedisConf.getTestOnBorrow()));
        poolConfig.setTestOnReturn(Boolean.parseBoolean(redisJedisConf.getTestOnReturn()));
        poolConfig.setJmxEnabled(Boolean.parseBoolean(redisJedisConf.getJmxEnabled()));
        poolConfig.setJmxNamePrefix(redisJedisConf.getJmxNamePrefix());
        poolConfig.setBlockWhenExhausted(Boolean.parseBoolean(redisJedisConf.getBlockWhenExhausted()));
        List<JedisShardInfo> shardInfoList = new ArrayList<>();

        for (String host : redisJedisConf.getSlavehosts()) {
            String[] hostPort = host.split(":");
            JedisShardInfo shardInfo = new JedisShardInfo(hostPort[0],
                                                          Integer.parseInt(hostPort[1]), "slaver");
            shardInfo.setPassword("johnson");
            shardInfoList.add(shardInfo);
        }
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig,shardInfoList);
        return shardedJedisPool;
    }
}
