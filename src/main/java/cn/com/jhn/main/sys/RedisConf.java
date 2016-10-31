package cn.com.jhn.main.sys;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * redis  单机版配置文件
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-27 下午 4:38
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConf {
    private Integer port;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxActive;
    private Integer maxWait;
    private String username;

    private String redisname;




    public String getRedisname() {
        return redisname;
    }

    public void setRedisname(String redisname) {
        this.redisname = redisname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*public List<String> getHost() {
        return host;
    }

    public void setHost(List<String> host) {
        this.host = host;
    }*/

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }
}
