package base.tool.toolcalendar.bussiness.impl;

import base.tool.toolcalendar.bussiness.ICalendarBussiness;
import base.tool.toolcalendar.dao.IMarkedDao;
import base.tool.toolcalendar.dao.model.MarkedDay;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zhangyx-v
 */
@Service
public class CalendarBussinessImpl implements ICalendarBussiness {

    @Resource
    IMarkedDao markedDao;

    @Override
    public boolean isHoliday(Date date) {
        //查询是否为标记日期
        MarkedDay day= markedDao.getOneMarkedDay(date);
        if (day!=null){
         //若为标记日期则判断是否为标记的休息日
            return day.getIsHoliday()==1;
        }
        //若不为标记的日期则判断是否为周六日
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int weekDay= calendar.get(Calendar.DAY_OF_WEEK)-1;
        return weekDay==0||weekDay==6?true:false;
    }

    @Override
    public List<MarkedDay> getMarkedDays(Date beginDate, Date dateOff) {
        return markedDao.getMarkedDays(beginDate,dateOff);
    }

    @Override
    public void insertOneMarkedDay(MarkedDay markedDay) {
            markedDao.insetMarkedDay(markedDay);
    }

    @Override
    public void updateTheTargetOfTheDay(MarkedDay markedDay) {
            markedDao.upateTargetOfTheDay(markedDay);
    }

    @Override
    public void cleanTheTargetOfTheDay(Date date) {
        markedDao.deleteOneMarkedDay(date);
    }


}
