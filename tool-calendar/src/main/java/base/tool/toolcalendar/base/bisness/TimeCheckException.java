package base.tool.toolcalendar.base.bisness;

import base.tool.toolcalendar.base.BaseException;
import base.tool.toolcalendar.util.RestRequestStatusUtil;

/**
 *
 * @author zhangyx-v
 */
public class TimeCheckException extends BaseException {

    public static final  String TIME_FORMAT_EXCEPTION="时间格式不正确";

    public TimeCheckException(String errorMessage){
        super(RestRequestStatusUtil.RestRequestStatus(false,RestRequestStatusUtil.CREATED,TIME_FORMAT_EXCEPTION),errorMessage);
    }
}
