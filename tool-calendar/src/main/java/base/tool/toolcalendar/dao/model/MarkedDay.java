package base.tool.toolcalendar.dao.model;

import java.util.Date;

/**
 * @author zhangyx-v
 */
public class MarkedDay {

    /**
     * 数据主键
     */
  private   int id;
    /**
     * 标记日期
     */
  private   Date markedDate;

    /**
     * 是否是节假日
     */
  private   byte isHoliday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMarkedDate() {
        return markedDate;
    }

    public void setMarkedDate(Date markedDate) {
        this.markedDate = markedDate;
    }

    public byte getIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(byte isHoliday) {
        this.isHoliday = isHoliday;
    }

    @Override
    public String toString() {
        return "MarkedDay{" +
                "id=" + id +
                ", markedDate=" + markedDate +
                ", isHoliday=" + isHoliday +
                '}';
    }
}
