package base.tool.toolcalendar.base.bisness;

import base.tool.toolcalendar.base.BaseException;
import base.tool.toolcalendar.util.RestRequestStatusUtil;

/**
 * 请求参数导致的异常
 * @author zhangyx-v
 */
public class RequestParamException extends BaseException  {

    public  static  final String REQUEST_PARAMS_EXCEPTION="请求参数不正确，请检查";

    public static final String REQUEST_PARAMS_LACK="请求参数缺少，请检查";


    public RequestParamException(String viewErrorMessage, String errorMessage){
        super(RestRequestStatusUtil.RestRequestStatus(false,RestRequestStatusUtil.INVALID_REQUEST,viewErrorMessage),errorMessage);
    }
}
