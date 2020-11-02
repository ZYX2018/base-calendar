package base.tool.toolcalendar.controller;

import base.tool.toolcalendar.base.bisness.RequestParamException;
import base.tool.toolcalendar.base.bisness.TimeCheckException;
import base.tool.toolcalendar.dao.model.MarkedDay;
import base.tool.toolcalendar.service.ICalendarService;
import base.tool.toolcalendar.util.RestRequestStatusUtil;
import base.tool.toolcalendar.util.ResultObject;
import base.tool.toolcalendar.util.TimeUtil;
import base.tool.toolcalendar.vo.MarkedDayVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;


/**
 * 借节日服务表现层
 * @author zhangyx-v
 */
@RestController
@RequestMapping("/base-calendar")
public class CalendarController {


    @Resource
    ICalendarService calendarService;

    @GetMapping("/tag-day/{date}")
    public ResultObject<MarkedDayVO[]> getTheMarkedDayOfTheMonth(@PathVariable("date") String date){
        if (StringUtils.isEmpty(date)){
            throw  new TimeCheckException("时间参数为空");
        }
        Date resDate=TimeUtil.strToDate(date,TimeUtil.TIME_FORMAT_ACCURATE_TO_D);
        MarkedDayVO[] markedDays=calendarService.getTheMarkedDayOfMonth(resDate);

        return RestRequestStatusUtil.RestRequestStatus(markedDays,RestRequestStatusUtil.CREATED,"查询成功");

    }

    @GetMapping("/tag-day")
    public ResultObject<Boolean> checkIsHoliday(@RequestParam("date")String date){
        if (StringUtils.isEmpty(date)){
            throw  new TimeCheckException("时间参数为空");
        }
        Boolean flag=calendarService.theDayIsHoliday(TimeUtil.strToDate(date,TimeUtil.TIME_FORMAT_ACCURATE_TO_D));
        return  RestRequestStatusUtil.RestRequestStatus(flag,RestRequestStatusUtil.CREATED,flag?"是休息日":"不是休息日");
    }

    @PostMapping("/tag-day")
    public ResultObject<Boolean>  markedTheDay(@RequestBody MarkedDay markedDay){
        if(StringUtils.isEmpty(markedDay.getIsHoliday())){
            throw new RequestParamException(RequestParamException.REQUEST_PARAMS_LACK,"时间标签为空");
        }
        markedDay.setMarkedDate(TimeUtil.dataChangeAccuracy(markedDay.getMarkedDate(),TimeUtil.TIME_FORMAT_ACCURATE_TO_D));
        calendarService.markTheDay(markedDay);
        return RestRequestStatusUtil.RestRequestStatus(true,RestRequestStatusUtil.CREATED,"标记成功");
    }
//
//    @PutMapping("/tag-day")
//    public ResultObject<Boolean>  updateTargetOfTheDay(@RequestBody MarkedDay markedDay){
//        if(StringUtils.isEmpty(markedDay.getIsHoliday())){
//            throw new RequestParamException(RequestParamException.REQUEST_PARAMS_LACK,"时间标签为空");
//        }
//            markedDay.setMarkedDate(TimeUtil.dataChangeAccuracy(markedDay.getMarkedDate(),TimeUtil.TIME_FORMAT_ACCURATE_TO_D));
//            calendarService.updateTheTargetOfTheDay(markedDay);
//        return RestRequestStatusUtil.RestRequestStatus(true,RestRequestStatusUtil.CREATED,"更新成功");
//    }

    @DeleteMapping("/tag-day")
    public ResultObject<Boolean> deleteTargetOfTheDay(@RequestParam("markedDay")String date){
        if(StringUtils.isEmpty(date)){
            throw new RequestParamException(RequestParamException.REQUEST_PARAMS_LACK,"时间参数缺失");
        }
        calendarService.cleanTheTargetOfTheDay(TimeUtil.strToDate(date,TimeUtil.TIME_FORMAT_ACCURATE_TO_D));
        return RestRequestStatusUtil.RestRequestStatus(true,RestRequestStatusUtil.CREATED,"删除成功");
    }


}
