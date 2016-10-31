package cn.com.jhn.main.service;

import cn.com.jhn.main.iservice.IBaseRedis;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;

/**
 * Redis
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-28 下午 1:49
 **/
@Service
public class BaseRedisImpl implements IBaseRedis {
    @Resource
    protected StringRedisTemplate stringRedisTemplate;
    @Resource(name="readShardJedisPool")
    protected ShardedJedisPool readShardedJedisPool;
    @Resource(name="writeShardJedisPool")
    protected ShardedJedisPool writeShardedJedisPool;
    @Override
    public Boolean put( final String key,final String value) {
        Boolean execute = stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
                byte[] keys = serializer.serialize(key);
                byte[] names = serializer.serialize(value);
                return redisConnection.setNX(keys, names);

            }
        });
        return execute;
    }

    @Override
    public Boolean jedisPut(String key, String value) {
        try {
            ShardedJedis shardedJedis=null;
            shardedJedis=writeShardedJedisPool.getResource();
            shardedJedis.set(key,value);
            return true;
        }catch (Exception e){
            return false;
        }


    }
}
