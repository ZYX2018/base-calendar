package base.tool.toolcalendar.dao;

import base.tool.toolcalendar.dao.model.MarkedDay;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author zhangyx-v
 */
public interface IMarkedDao {
    /**
     * 查询标记日期
     * @param date ri qi
     * @return 标记日期
     */
    MarkedDay getOneMarkedDay(@Param("date") Date date);

    /**
     * 获取范围内的标记日期
     * @param begin  开始
     * @param off 结束
     * @return 范围内的标记日期
     */
    List<MarkedDay> getMarkedDays(@Param("begin") Date begin,@Param("off") Date off);

    /**
     * 记录一个标记日期
     * @param markedDay 标记日期
     */
    void  insetMarkedDay(MarkedDay markedDay);

    /**
     * 更新一个日期的标记
     * @param markedDay 更新的日期
     */
    void upateTargetOfTheDay(MarkedDay markedDay);

    /**
     * 清除指定日期的标记
     * @param date 指定日期
     */
    void deleteOneMarkedDay(@Param("date")Date date);
}
