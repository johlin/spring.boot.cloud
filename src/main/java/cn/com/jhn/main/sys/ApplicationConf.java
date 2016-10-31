package cn.com.jhn.main.sys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE.VALUE;


/**
 * 项目配置文件
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-20 上午 11:39
 **/
@ConfigurationProperties(locations = "classpath:config/application-development.properties")
public class ApplicationConf {
    private @Value("${name:lkl}")   String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
