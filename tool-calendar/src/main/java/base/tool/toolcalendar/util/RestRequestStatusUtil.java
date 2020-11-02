package base.tool.toolcalendar.util;

/**
 * restFul风格 请求状态码
 * 用于封装controller 返回值
 * @author zhangyx-v
 */
public class RestRequestStatusUtil {

    /**
     * @see #GET_OK -[GET]；服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）
     */
    public static final Integer GET_OK=200;
    /**
     * @see #CREATED -[POST/PUT/PATCH]：用户新建或修改数据成功。
     */
    public static final Integer CREATED=201;
    /**
     * @see #MQ_ACCEPTED - [*]：表示一个请求已经进入后台排队（异步任务）
     */
    public  static final Integer  MQ_ACCEPTED=202;
    /**
     * @see #NO_CONTENT -[DELETE]：用户删除数据成功
     */
    public  static final Integer NO_CONTENT=204;
    /**
     * @see #INVALID_REQUEST -[POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
     */
    public  static final  Integer INVALID_REQUEST=400;
    /**
     * @see #UN_AUTHORIZED -[*]：表示用户没有权限（令牌、用户名、密码错误）
     */
    public  static  final Integer UN_AUTHORIZED=401;
    /**
     * @see #FORBIDDEN -[*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
     */
    public  static  final Integer FORBIDDEN=403;
    /**
     * @see #NOT_FOUND -[*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
     */
    public  static final Integer NOT_FOUND=404;
    /**
     * @see #NOT_ACCEPTABLE -[GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）
     */
    public  static final Integer NOT_ACCEPTABLE=406;
    /**
     * @see #GONE -[GET]：用户请求的资源被永久删除，且不会再得到的
     */
    public  static final Integer GONE=410;
    /**
     * @see #UNPROCESABLE_ENTITY -[POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
     */
    public  static final   Integer UNPROCESABLE_ENTITY=422;
    /**
     * @see #INTERNAL_SERVER_ERROR -[*]：服务器发生错误，用户将无法判断发出的请求是否成功。
     */
    public  static final   Integer INTERNAL_SERVER_ERROR=500;


    /**
     *
     * @param data 数据
     * @param code 状态码
     * @param message 返回的信错误息或者 url
     * @param <T>
     * @return ResultObject<T>
     */
    public static<T> ResultObject<T> RestRequestStatus(T data, int code, String message) {
        ResultObject<T> resultObject = new ResultObject<>();
        resultObject.setRequestStatus(code);
        resultObject.setData(data);
        resultObject.setMessage(message);
        return resultObject;
    }

}
