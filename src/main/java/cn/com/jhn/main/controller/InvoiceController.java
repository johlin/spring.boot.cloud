package cn.com.jhn.main.controller;

import cn.com.jhn.main.interfaces.IBaseBenchBasicInfoDao;
import cn.com.jhn.main.iservice.IBaseRedis;
import cn.com.jhn.main.service.FPService;
import cn.com.jhn.main.sys.ApplicationConf;
import cn.com.jhn.main.utils.FastJsonUtils;
import cn.com.jhn.main.utils.StringUtil;
import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈琳
 * @create 2016-10-20 上午 10:52
 **/
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    protected ApplicationConf applicationConf;
    @Autowired
    protected IBaseBenchBasicInfoDao baseBenchBasicInfoDaoImpl;
    @Autowired
    protected IBaseRedis baseRedisImpl;
    @Autowired
    protected FPService pkcs7Service;

    Logger logger= Logger.getLogger(InvoiceController.class);
    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public String test(@PathVariable("name") String name) {
        Map<String,Object> condiMap=new HashMap<>();
        condiMap.put("benchType", 1);
        condiMap.put("benchCode",2);
        logger.info("Test log4j ...");
        return this.baseBenchBasicInfoDaoImpl.getAllocationIdByTypeCode(condiMap).toString();
        /*return "Welcome to Spring boot of invoice," + name +
                "! My name is " + applicationConf.getName();*/

    }
    @RequestMapping(value = "/redis/{key}/{value}", method = RequestMethod.GET)
    public String redisTest(@PathVariable("key") String key,@PathVariable("value") String value) {
        if(baseRedisImpl.put(key,value))
            return "SUCCESS";
        return "Fail";
    }
    @RequestMapping(value = "/jedis/{key}/{value}", method = RequestMethod.GET)
    public String jedisTest(@PathVariable("key") String key,@PathVariable("value") String value) {
        if(baseRedisImpl.jedisPut(key,value))
            return "SUCCESS";
        return "Fail";
    }
    @RequestMapping(value = "/invoiceDownload", method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String invoiceDownload(@RequestBody String name) {
        try {
            String data= StringUtil.URLDecoder(name);
            String json= FastJsonUtils.stringToCollect(data).get("input").toString();
            return pkcs7Service.invoiceDownload(json);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }
    @RequestMapping(value = "/invoiceIssued", method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String invoiceIssued(@RequestBody String name) {
        try {
            String data= StringUtil.URLDecoder(name);
            String json= FastJsonUtils.stringToCollect(data).get("input").toString();
            return pkcs7Service.invoiceIssued(json);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }
}
