package base.tool.toolcalendar.service.impl;

import base.tool.toolcalendar.bussiness.ICalendarBussiness;
import base.tool.toolcalendar.dao.model.MarkedDay;
import base.tool.toolcalendar.service.ICalendarService;
import base.tool.toolcalendar.util.TimeUtil;
import base.tool.toolcalendar.vo.MarkedDayVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 节假日服务业务层实现类
 * @author zhangyx-v
 */
@Service
public class CalendarServiceImpl  implements ICalendarService {
    Logger logger= LoggerFactory.getLogger(CalendarServiceImpl.class);

    @Resource
    ICalendarBussiness calendarBussiness;

    @Override
    public boolean theDayIsHoliday(Date date) {
        return calendarBussiness.isHoliday(date);
    }

    @Override
    public void markTheDay(MarkedDay markedDay) {
         calendarBussiness.insertOneMarkedDay(markedDay);
    }

    @Override
    public void updateTheTargetOfTheDay(MarkedDay markedDay) {
            calendarBussiness.updateTheTargetOfTheDay(markedDay);
    }

    @Override
    public void cleanTheTargetOfTheDay(Date date) {
            calendarBussiness.cleanTheTargetOfTheDay(date);
    }

    @Override
    public MarkedDayVO[] getTheMarkedDayOfMonth(Date date) {
        logger.info("查询范围日期：：：参数："+date);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        //定位参考日期在日历中的位置
        int indexColumn=calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_YEAR,-(indexColumn-1));
        //定位当月1号在日历中的位置
        int referenceIndex=calendar.get(Calendar.DAY_OF_WEEK)-1;
        //计算查询上边界
        calendar.add(Calendar.DAY_OF_YEAR,-(referenceIndex-1));
        Date beginDate=calendar.getTime();
        //计算下边界
        calendar.add(Calendar.DAY_OF_YEAR,41);
        Date offDate=calendar.getTime();
        //查询范围内的标记日期
        List<MarkedDay> markedDateList=calendarBussiness.getMarkedDays(beginDate,offDate);
        //转换为数组
        Iterator<MarkedDay> iterator=markedDateList.listIterator();
        MarkedDayVO[] markedDaysArray=new MarkedDayVO[markedDateList.size()];
        for (int i = 0; i <markedDateList.size() ; i++) {
            markedDaysArray[i]=dtoToVo(iterator.next());
        }
        logger.info("范围查询结果：：：+"+ Arrays.toString(markedDaysArray));
        return markedDaysArray;
    }

    public MarkedDayVO dtoToVo(MarkedDay markedDay){
        MarkedDayVO markedDayVO=new MarkedDayVO();
        markedDayVO.setId(markedDay.getId());
        markedDayVO.setIsHoliday(markedDay.getIsHoliday());
        markedDayVO.setMarkedDate(TimeUtil.dateToString(markedDay.getMarkedDate(),TimeUtil.TIME_FORMAT_ACCURATE_TO_D));
        return markedDayVO;
    }
}
