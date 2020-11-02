package base.tool.toolcalendar.base;

import base.tool.toolcalendar.util.RestRequestStatusUtil;
import base.tool.toolcalendar.util.ResultObject;
import base.tool.toolcalendar.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * 全局异常处理类
 * @author zhangyx-v
 */
@ControllerAdvice
public class GlobalExceptionHandel {

    private static final Logger LOGGER= LoggerFactory.getLogger(GlobalExceptionHandel.class);


    /**
     * 业务异常处理类
     * @param baseException 业务异常
     * @return 前端返回结果
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultObject businessExceptionHandel(BaseException baseException){
        LOGGER.info("deadly!deadly!deadly!"+ TimeUtil.dateToString(new Date(),TimeUtil.TIME_FORMAT_ACCURATE_TO_MS) +baseException.getMessage());
        baseException.printStackTrace();
        return baseException.getResultObject();
    }

    /**
     * 非业务异常处理
     * @param exception 运行时异常
     * @return 系统维护的信息
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultObject unBusinessExceptionHandel(Exception exception){
        LOGGER.info("deadly!deadly!deadly!"+ TimeUtil.dateToString(new Date(),TimeUtil.TIME_FORMAT_ACCURATE_TO_MS) +exception.getMessage());
        exception.printStackTrace();
        return RestRequestStatusUtil.RestRequestStatus(false,RestRequestStatusUtil.INVALID_REQUEST,"系统维护中");
    }



}
