package com.acstudent.common.handler;

import com.acstudent.common.constant.BizCode;
import com.acstudent.common.exception.BizException;
import com.acstudent.common.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Siqi
 * @date 2018/10/10
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理一般异常
     */
    @ExceptionHandler(Exception.class)
    public CommonResult handle(Exception e) {
        log.error("全局异常处理：", e);
        return new CommonResult<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务内部错误", null);
    }

    /**
     * 请求方式不符
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new CommonResult<>(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage(), null);
    }

    /**
     * 处理请求参数不符
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String msg = buildErrorMsg(e);
        log.error("请求参数不符异常：{}", msg);
        return new CommonResult<>(BizCode.BAD_REQUEST_PARAM.code(), msg, null);
    }

    /**
     * 处理业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public CommonResult bizExceptionHandler(BizException e) {
        log.error("业务异常捕获：{}", e.getMsg());
        return new CommonResult<>(e.getCode(), e.getMsg(), null);
    }

    private String buildErrorMsg(MethodArgumentNotValidException e) {
        StringBuffer errorMsg = new StringBuffer();
        e.getBindingResult().getAllErrors().forEach(error -> {
            if (StringUtils.isNotBlank(errorMsg)) {
                errorMsg.append("|");
            }
            errorMsg.append(error.getDefaultMessage());
        });
        return errorMsg.toString();
    }
}
