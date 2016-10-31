package cn.com.jhn.main.base;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Tomcat配置
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-24 下午 3:35
 **/
@Configuration
public class TomcatConfig {
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.setUriEncoding(Charset.forName("UTF-8"));
        return tomcat;
    }

}
