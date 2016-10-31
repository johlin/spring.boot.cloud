package cn.com.jhn.main.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author 陈琳
 * @version v1.0
 * @create 2016-10-24 上午 11:00
 **/
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String defaultErrorHandler(HttpServletRequest req, Exception e) {
        System.out.print("系统记录bug--------"+e.getMessage());
        return "system is fail!";
    }

}
