package com.acstudent.common.vo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Wang Siqi
 * @date 2018/9/5
 */
@AllArgsConstructor
@Data
public class CommonResult<T> implements Serializable {

    public static final int SUCCESS_CODE = 0;

    public static final int ERROR_CODE = -1;

    private int error;
    private String msg;
    private T data;

    public static CommonResult asSuccess() {
        return asSuccess(null);
    }

    public static <T> CommonResult<T> asSuccess(T data) {
        return new CommonResult<>(0, "success", data);
    }

    public static <T> CommonResult<T> asError(String msg) {
        return new CommonResult<>(ERROR_CODE, msg, null);
    }

    public static <T> CommonResult<T> asError(int code, String msg) {
        return new CommonResult<T>(code, msg, null);
    }

    public static <T> CommonResult<T> asBadRequest(String msg) {
        return new CommonResult<>(org.springframework.http.HttpStatus.BAD_REQUEST.value(), msg, null);
    }
}
