package base.tool.toolcalendar.bussiness;

import base.tool.toolcalendar.dao.model.MarkedDay;

import java.util.Date;
import java.util.List;

/**
 *节假日业务层基类
 * @author zhangyx-v
 */
public interface ICalendarBussiness {

    /**
     * 查询是否是休息日
     * @param date
     * @return
     */
    boolean isHoliday(Date date);

    /**
     *查询范围内日期
     * @param beginDate 起始日期
     * @param dateOff 截止日期
     * @return 查询范围内的标记日期
     */
    List<MarkedDay> getMarkedDays(Date beginDate,Date dateOff);

    /**
     *记录一个要标记的日期
     * @param markedDay 要标记的日期
     */
    void  insertOneMarkedDay(MarkedDay markedDay);

    /**
     * 更新日期的标记
     * @param markedDay 要标记的日期
     */
    void  updateTheTargetOfTheDay(MarkedDay markedDay);

    /**
     * 清除指定日期的标记
     * @param date 指定的日期
     */
    void cleanTheTargetOfTheDay(Date date);
}
