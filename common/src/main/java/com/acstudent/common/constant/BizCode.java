package com.acstudent.common.constant;

/**
 * @author Wang Siqi
 * @date 2018/10/10
 */
/**
 *  业务返回码：
 *  1000-1999：admin
 *  2000-2999：front
 *  3000-3999: 供内部系统服务间调用异常码
 */
public enum BizCode {

    BAD_REQUEST_PARAM(1000, "请求参数校验失败"),
    BAD_FRONT_REQUEST_PARAM(2000, "请求参数校验失败"),
    OBJECT_NOT_EXIST(1001, "对象不存在"),
    INNER_DATA_INVALID(1002, "内部数据不合法"),
    OPERATE_INVALID(1003, "不符合操作条件，操作无效"),
    OTHER_SERVICE_RETURN_ERROR(1004, "依赖服务出现错误"),
    INNER_SERVICE_ERROR(1005, "内部工具处理异常"),
    XSS_ERROR(1006, "存在XSS风险"),
    NEED_LOGIN(1007, "用户未登录"),
    CACHE_OPT_ERROR(3000, "缓存操作错误！");

    private final Integer value;
    private final String errorMsg;

    BizCode(int value, String errorMsg) {
        this.value = value;
        this.errorMsg = errorMsg;
    }

    public Integer code() {
        return this.value;
    }

    public String errorMsg() {
        return this.errorMsg;
    }


}
