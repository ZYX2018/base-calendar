package base.tool.toolcalendar.service;

import base.tool.toolcalendar.dao.model.MarkedDay;
import base.tool.toolcalendar.vo.MarkedDayVO;

import java.util.Date;

/**
 * 节假日服务业务层接口
 * @author zhangyx-v
 */
public interface ICalendarService {

    /**
     * 查询指定日期是否是休息日
     * @param date yyyy-MM-dd
     * @return true 为休息日 false 为工作日
     */
    boolean  theDayIsHoliday(Date date);

    /**
     * 持久化 标记日期
     * @param markedDay 标记日期
     */
    void  markTheDay(MarkedDay markedDay);

    /**
     * 更新指定日期的标签
     * @param markedDay 标记日期
     */
    void  updateTheTargetOfTheDay(MarkedDay markedDay);

    /**
     * 清除指定标记日期
     * @param date 标记日期
     */
    void cleanTheTargetOfTheDay(Date date);

    /**
     * 查询当月内的标记日信息
     * @param date 参考日期
     * @return 参考日期当月内的所以标记日期
     */
    MarkedDayVO[] getTheMarkedDayOfMonth(Date date);
}
