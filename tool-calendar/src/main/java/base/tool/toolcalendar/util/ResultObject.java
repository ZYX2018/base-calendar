package base.tool.toolcalendar.util;

/**
 * 表现层统一的返回结果
 * @author zhangyx-v
 */
public class ResultObject<T> {

    /**
     * 请求状态
     */
   private int requestStatus;

    /**
     * 业务层执行结果
     */
   private T data;

    /**
     * 返回信息 ：错误信息 或者下一步请求地址
     */
  private   String message;

    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
