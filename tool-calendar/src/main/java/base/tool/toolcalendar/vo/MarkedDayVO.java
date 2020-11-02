package base.tool.toolcalendar.vo;

/**
 * 标记日期表现层实例
 * @author zhangyx-v
 */
public class MarkedDayVO {

    /**
     * 数据主键
     */
    private   int id;
    /**
     * 标记日期
     */
    private String markedDate;

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

    public String getMarkedDate() {
        return markedDate;
    }

    public void setMarkedDate(String markedDate) {
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
        return "MarkedDayVO{" +
                "id=" + id +
                ", markedDate='" + markedDate + '\'' +
                ", isHoliday=" + isHoliday +
                '}';
    }
}
