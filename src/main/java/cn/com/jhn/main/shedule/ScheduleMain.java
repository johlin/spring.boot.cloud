package cn.com.jhn.main.shedule;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * 定时任务
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-24 上午 11:16
 **/
@Configuration
@EnableScheduling
public class ScheduleMain {
    Logger logger= Logger.getLogger(ScheduleMain.class);
    @Scheduled(cron = "0/20 * * * * ?")
    public void scheduler(){
        logger.info("***--Test Task Schedule--***");
    }
}
