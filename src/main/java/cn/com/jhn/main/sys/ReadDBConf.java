package cn.com.jhn.main.sys;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-26 下午 5:54
 **/
@ConfigurationProperties(prefix = "spring.datasource.read")
public class ReadDBConf {

    private String url;
    private String username;
    private String password;
    private String type;
    private String filters;
    private Integer maxActive;
    private Integer initialSize;
    private Integer maxWait;
    private Integer minIdle;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer minEvictableIdleTimeMillis;
    private String validationQuery;
    private String testWhileIdle;
    private String testOnBorrow;
    private String testOnReturn;
    private String poolPreparedStatements;
    private Integer maxOpenPreparedStatements;



    /** min-pool-size 最小连接数 **/
    private int minPoolSize;
    /** max-pool-size 最大连接数 **/
    private int maxPoolSize;
    /** max-lifetime 连接最大存活时间 **/
    private int maxLifetime;
    /** borrow-connection-timeout 获取连接失败重新获等待最大时间，在这个时间内如果有可用连接，将返回 **/
    private int borrowConnectionTimeout;
    /** login-timeout java数据库连接池，最大可等待获取datasouce的时间 **/
    private int loginTimeout;
    /** maintenance-interval 连接回收时间 **/
    private int maintenanceInterval;
    /** max-idle-time 最大闲置时间，超过最小连接池连接的连接将将关闭 **/
    private int maxIdleTime;
    /** test-query 测试SQL **/
    private String testQuery;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
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

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public String getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(String testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public String getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(String testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public String getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(String testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public String getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(String poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public Integer getMaxOpenPreparedStatements() {
        return maxOpenPreparedStatements;
    }

    public void setMaxOpenPreparedStatements(Integer maxOpenPreparedStatements) {
        this.maxOpenPreparedStatements = maxOpenPreparedStatements;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(int maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public int getBorrowConnectionTimeout() {
        return borrowConnectionTimeout;
    }

    public void setBorrowConnectionTimeout(int borrowConnectionTimeout) {
        this.borrowConnectionTimeout = borrowConnectionTimeout;
    }

    public int getLoginTimeout() {
        return loginTimeout;
    }

    public void setLoginTimeout(int loginTimeout) {
        this.loginTimeout = loginTimeout;
    }

    public int getMaintenanceInterval() {
        return maintenanceInterval;
    }

    public void setMaintenanceInterval(int maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
    }

    public int getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(int maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public String getTestQuery() {
        return testQuery;
    }

    public void setTestQuery(String testQuery) {
        this.testQuery = testQuery;
    }
}
