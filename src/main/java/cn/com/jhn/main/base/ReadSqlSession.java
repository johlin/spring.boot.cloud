package cn.com.jhn.main.base;

import cn.com.jhn.main.sys.ReadDBConf;
import cn.com.jhn.main.sys.WriteDBConf;
import com.alibaba.druid.pool.DruidDataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 读库
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-26 下午 3:59
 **/
@Configuration
public class ReadSqlSession {
    @Bean(name = "readDataSource")
    public DataSource readDataSource(ReadDBConf readDBConf) throws SQLException {
        //return DataSourceBuilder.create().build();
        DruidDataSource readDataSource=new DruidDataSource();
        readDataSource.setUrl(readDBConf.getUrl());
        readDataSource.setUsername(readDBConf.getUsername());
        readDataSource.setPassword(readDBConf.getPassword());
        readDataSource.setInitialSize(readDBConf.getInitialSize());
        readDataSource.setMaxWait(readDBConf.getMaxWait());
        readDataSource.setMinIdle(readDBConf.getMinIdle());
        readDataSource.setTimeBetweenEvictionRunsMillis(readDBConf.getTimeBetweenEvictionRunsMillis());
        readDataSource.setMinEvictableIdleTimeMillis(readDBConf.getMinEvictableIdleTimeMillis());
        readDataSource.setValidationQuery(readDBConf.getValidationQuery());
        readDataSource.setTestWhileIdle(Boolean.valueOf(readDBConf.getTestWhileIdle()));
        readDataSource.setTestOnBorrow(Boolean.valueOf(readDBConf.getTestOnBorrow()));
        readDataSource.setTestOnReturn(Boolean.valueOf(readDBConf.getTestOnReturn()));
        readDataSource.setPoolPreparedStatements(Boolean.valueOf(readDBConf.getPoolPreparedStatements()));
        readDataSource.setMaxOpenPreparedStatements(readDBConf.getMaxOpenPreparedStatements());
        readDataSource.init();
        return readDataSource;
        //使用mysql生成datasource
        /*MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(readDBConf.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(readDBConf.getPassword());
        mysqlXaDataSource.setUser(readDBConf.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("readDataSource");

        xaDataSource.setMinPoolSize(readDBConf.getMinPoolSize());
        xaDataSource.setMaxPoolSize(readDBConf.getMaxPoolSize());
        xaDataSource.setMaxLifetime(readDBConf.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(readDBConf.getBorrowConnectionTimeout());
        // xaDataSource.setLoginTimeout(writeDBConf.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(readDBConf.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(readDBConf.getMaxIdleTime());
        xaDataSource.setTestQuery(readDBConf.getTestQuery());
        return xaDataSource;*/
    }

    @Bean(name = "readSqlSessionFactory")
    public SqlSessionFactory readSqlSessionFactory(@Qualifier("readDataSource") DataSource readDataSource) throws
            Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(readDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "readTransactionManager")
    public DataSourceTransactionManager readTransactionManager(@Qualifier("readDataSource") DataSource readDataSource) {
        return new DataSourceTransactionManager(readDataSource);
    }

    @Bean(name = "readSqlSessionTemplate")
    public SqlSessionTemplate readSqlSessionTemplate(@Qualifier("readSqlSessionFactory") SqlSessionFactory
            sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
