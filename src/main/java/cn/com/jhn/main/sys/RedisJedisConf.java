package cn.com.jhn.main.sys;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * redis   jedis  集群  配置文件
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-28 下午 4:35
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.jedis")
public class RedisJedisConf {


    private List<String> masterhosts;
    private List<String> slavehosts;
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer numTestsPerEvictionRun;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer minEvictableIdleTimeMillis;
    private Integer softMinEvictableIdleTimeMillis;
    private Integer maxWaitMillis;
    private String testOnBorrow;
    private String testWhileIdle;
    private String testOnReturn;
    private String jmxEnabled;
    private String jmxNamePrefix;
    private String blockWhenExhausted;

    public List<String> getMasterhosts() {
        return masterhosts;
    }

    public void setMasterhosts(List<String> masterhosts) {
        this.masterhosts = masterhosts;
    }

    public List<String> getSlavehosts() {
        return slavehosts;
    }

    public void setSlavehosts(List<String> slavehosts) {
        this.slavehosts = slavehosts;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }

    public void setNumTestsPerEvictionRun(Integer numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public Integer getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public Integer getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public Integer getSoftMinEvictableIdleTimeMillis() {
        return softMinEvictableIdleTimeMillis;
    }

    public void setSoftMinEvictableIdleTimeMillis(Integer softMinEvictableIdleTimeMillis) {
        this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis;
    }

    public Integer getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Integer maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public String getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(String testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public String getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(String testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public String getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(String testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public String getJmxEnabled() {
        return jmxEnabled;
    }

    public void setJmxEnabled(String jmxEnabled) {
        this.jmxEnabled = jmxEnabled;
    }

    public String getJmxNamePrefix() {
        return jmxNamePrefix;
    }

    public void setJmxNamePrefix(String jmxNamePrefix) {
        this.jmxNamePrefix = jmxNamePrefix;
    }

    public String getBlockWhenExhausted() {
        return blockWhenExhausted;
    }

    public void setBlockWhenExhausted(String blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }
}
