package base.tool.toolcalendar.base;

import base.tool.toolcalendar.util.ResultObject;

/**
 *全局异常基类
 * @author zhangyx-v
 */
public class BaseException extends  RuntimeException {

    /**
     * 业务异常返回结果
     */
    private ResultObject resultObject;

    protected BaseException(){
        super(null,null,true,false);
    }

    protected BaseException(ResultObject resultObject,String errorMessage){
        super(errorMessage,null,true,false);
        this.resultObject=resultObject;
    }

    public ResultObject getResultObject() {
        return resultObject;
    }

    public void setResultObject(ResultObject resultObject) {
        this.resultObject = resultObject;
    }
}
