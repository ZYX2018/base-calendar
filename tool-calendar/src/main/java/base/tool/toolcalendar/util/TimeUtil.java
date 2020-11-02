package base.tool.toolcalendar.util;

import base.tool.toolcalendar.base.bisness.TimeCheckException;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *时间转换工具类
 * 转换异常会被全局异常处理类视为业务异常
 * @author zhangyx-v
 */
public class TimeUtil {
    /**
     * @see #YEAR 年
     */
    public static final TimeFiled YEAR= TimeFiled.YEAR;
    /**
     * @see #MONTH 月
     */
    public static final TimeFiled MONTH= TimeFiled.MONTH;
    /**
     * @see #MONTH 日
     */
    public static final TimeFiled DAY= TimeFiled.DAY;
    /**
     * @see #MONTH 时
     */
    public static final TimeFiled HOUR= TimeFiled.HOUR;
    /**
     * @see #MONTH 分
     */
    public  static final TimeFiled MINUTE= TimeFiled.MINUTE;
    /**
     * @see #MONTH 秒
     */
    public  static final TimeFiled SECOND= TimeFiled.SECOND;
    /**
     * @see #MONTH 毫秒
     */
    public static  final  TimeFiled MS= TimeFiled.MS;
    /**
     * @see #TIME_FORMAT_ACCURATE_TO_MS 年月日时分秒 毫秒
     */
    public static String TIME_FORMAT_ACCURATE_TO_MS="yyyy-MM-dd HH:mm:ss SSS";
    /**
     * @see #TIME_FORMAT_ACCURATE_TO_S 年月日时分秒
     */
    public static String TIME_FORMAT_ACCURATE_TO_S="yyyy-MM-dd HH:mm:ss";
    /**
     * @see #TIME_FORMAT_ACCURATE_TO_D 年月日
     */
    public static String TIME_FORMAT_ACCURATE_TO_D="yyyy-MM-dd";
    /**
     * 将long转换为指定格式的date如："yyyy-MM-dd HH:mm:ss SSS"
     * @param time  long类型的时间
     * @param timeFormat  指定格式
     * @return 返回指定格式的日期字符串
     */
    public static String LongToDate(Long time,String timeFormat)  {
        return dateToString(new Date(time),timeFormat);
    }

    /**
     * 将指定格式的日期字符串转换为long类型的值
     * @param date  将指定格式的日期字符串
     * @param timeFormat  将指定格式
     * @return  long类型的值
     */
    public static Long DateToLong(String date,String timeFormat) {
        return strToDate(date,timeFormat).getTime();
    }

    /**
     * 将字符串转换为date
     * @param date date字符串
     * @param timeFormat 日期格式
     * @return date 转换得到的日期
     */
    public static Date strToDate(String date,String timeFormat)  {
        if (StringUtils.isEmpty(date)){
            throw  new TimeCheckException("时间参数为空");
        }
        SimpleDateFormat format=new SimpleDateFormat(timeFormat);
        Date dateTarget = null;
        try {
            dateTarget = format.parse(date);
        } catch (ParseException e) {
           throw  new TimeCheckException(e.getMessage());
        }
        return dateTarget;
    }

    /**
     * 将date转为String
     * @param date 需要转换的日期
     * @param timeFormat 日期格式
     * @return 指定格式的日期字符串
     */
    public static String dateToString(Date date ,String timeFormat){
        if (date==null){
            return null;
        }
        SimpleDateFormat format=new SimpleDateFormat(timeFormat);
        String str=format.format(date);
        return str;
    }

    /**
     * 改变日期精确度
     * @param date 需要改变的日期
     * @param timeFormat 精确度
     * @return 改变后的日期
     */
    public static Date dataChangeAccuracy(Date date,String timeFormat) {
        return strToDate(dateToString(date,timeFormat),timeFormat);
    }

    /**
     * 唯一日期指定属性 限定年月日时分秒和毫秒
     * @param date 指定日期
     * @param timFormat 改变后日期指定格式
     * @param changeFiled 要位移的属性
     * @param changeSize  位移值
     * @return 改变属性后的日期
     */
    public static Date changeTime(Date date,String timFormat,TimeFiled changeFiled,int changeSize) {
            if(date==null){
                return null;
            }
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(dataChangeAccuracy(date,timFormat));
            calendar.set(changeFiled.getTimeFiled(),changeFiled.getTimeFiled()+changeSize);
            return calendar.getTime();
    }

  private   enum TimeFiled{
      /**
       *@see #YEAR 年
       */
      YEAR(Calendar.YEAR),
      /**
       *@see #MONTH 月
       */
        MONTH(Calendar.MONTH),
      /**
       *@see #MONTH 日
       */
        DAY(Calendar.DAY_OF_YEAR),
      /**
       *@see #MONTH 时
       */
        HOUR(Calendar.HOUR),
      /**
       *@see #MONTH 分
       */
        MINUTE(Calendar.MINUTE),
      /**
       *@see #MONTH 秒
       */
        SECOND(Calendar.SECOND),
      /**
       *@see #MONTH 毫秒
       */
        MS(Calendar.MILLISECOND);
      /**
       *@see #MONTH 时间属性
       */
        private final int timeFiled;

        private  TimeFiled(int filed) {
            this.timeFiled=filed;
        }

        public int getTimeFiled() {
            return timeFiled;
        }
    }
}
