package cn.com.jhn.main;


import cn.com.jhn.main.sys.ApplicationConf;
import cn.com.jhn.main.sys.InvoiceConf;
import cn.com.jhn.main.sys.ReadDBConf;
import cn.com.jhn.main.sys.WriteDBConf;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

/**
 * SRPING BOOT FIRST EXAMPLE
 *
 * @author 陈琳
 * @create 2016-10-19 下午 3:33
 **/
@SpringBootApplication
@ServletComponentScan
@MapperScan("cn.com.jhn.main")
@EnableConfigurationProperties({ApplicationConf.class,InvoiceConf.class,
        WriteDBConf.class, ReadDBConf.class})
//@ImportResource({"classpath:config/application-spring.xml"})
@PropertySource({"classpath:config/application-mybatis.properties",
        "classpath:config/application-redis-single.properties",
        "classpath:config/application-redis-jedis.properties"})

public class ApplicationBoot  extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationBoot.class);
    }
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(ApplicationBoot.class);
        springApplication.setAdditionalProfiles("development",
                                                "tomcat", "mybatis", "pkcs7", "log4j");
        springApplication.run(args);
    }
}
