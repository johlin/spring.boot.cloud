package cn.com.jhn.main.base;

import cn.com.jhn.main.sys.WriteDBConf;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 写库
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-26 下午 3:59
 **/
@Configuration
public class WriteSqlSession {


    @Bean(name = "writeDataSource")
    @Primary
    public DataSource writeDataSource(WriteDBConf writeDBConf) throws SQLException {
       // return DataSourceBuilder.create().build();
        DruidDataSource writeDataSource=new DruidDataSource();
        writeDataSource.setUrl(writeDBConf.getUrl());
        writeDataSource.setUsername(writeDBConf.getUsername());
        writeDataSource.setPassword(writeDBConf.getPassword());
        writeDataSource.setInitialSize(writeDBConf.getInitialSize());
        writeDataSource.setMaxWait(writeDBConf.getMaxWait());
        writeDataSource.setMinIdle(writeDBConf.getMinIdle());
        writeDataSource.setTimeBetweenEvictionRunsMillis(writeDBConf.getTimeBetweenEvictionRunsMillis());
        writeDataSource.setMinEvictableIdleTimeMillis(writeDBConf.getMinEvictableIdleTimeMillis());
        writeDataSource.setValidationQuery(writeDBConf.getValidationQuery());
        writeDataSource.setTestWhileIdle(Boolean.valueOf(writeDBConf.getTestWhileIdle()));
        writeDataSource.setTestOnBorrow(Boolean.valueOf(writeDBConf.getTestOnBorrow()));
        writeDataSource.setTestOnReturn(Boolean.valueOf(writeDBConf.getTestOnReturn()));
        writeDataSource.setPoolPreparedStatements(Boolean.valueOf(writeDBConf.getPoolPreparedStatements()));
        writeDataSource.setMaxOpenPreparedStatements(writeDBConf.getMaxOpenPreparedStatements());
        writeDataSource.init();
        return writeDataSource;
        /*MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(writeDBConf.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(writeDBConf.getPassword());
        mysqlXaDataSource.setUser(writeDBConf.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("writeDataSource");

        xaDataSource.setMinPoolSize(writeDBConf.getMinPoolSize());
        xaDataSource.setMaxPoolSize(writeDBConf.getMaxPoolSize());
        xaDataSource.setMaxLifetime(writeDBConf.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(writeDBConf.getBorrowConnectionTimeout());
       // xaDataSource.setLoginTimeout(writeDBConf.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(writeDBConf.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(writeDBConf.getMaxIdleTime());
        xaDataSource.setTestQuery(writeDBConf.getTestQuery());
        return xaDataSource;*/
    }

    @Bean(name = "writeSqlSessionFactory")
    @Primary
    public SqlSessionFactory writeSqlSessionFactory(@Qualifier("writeDataSource") DataSource writeDataSource) throws
            Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(writeDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "writeTransactionManager")
    @Primary
    public DataSourceTransactionManager writeTransactionManager(@Qualifier("writeDataSource") DataSource writeDataSource) {
        return new DataSourceTransactionManager(writeDataSource);
    }

    @Bean(name = "writeSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate writeSqlSessionTemplate(@Qualifier("writeSqlSessionFactory") SqlSessionFactory
            sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
