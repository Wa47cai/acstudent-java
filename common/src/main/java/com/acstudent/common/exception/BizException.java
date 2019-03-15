package com.acstudent.common.exception;

import com.acstudent.common.constant.BizCode;
import com.acstudent.common.vo.CommonResult;
import lombok.Data;

/**
 * @author Wang Siqi
 * @date 2018/10/10
 */
@Data
public class BizException extends RuntimeException {

    //错误码
    private int code;
    //错误详情
    private String msg;


    public BizException(BizCode bizCode) {
        super();
        this.code = bizCode.code();
        this.msg = bizCode.errorMsg();
    }

    public BizException(BizCode bizCode, String msg) {
        super();
        this.code = bizCode.code();
        this.msg = msg;
    }

    public BizException(BizCode bizCode, Throwable e) {
        super(e);
        this.code = bizCode.code();
        this.msg = bizCode.errorMsg();
    }

    public BizException(BizCode bizCode, String msg, Throwable e) {
        super(msg, e);
        this.code = bizCode.code();
        this.msg = msg;
    }

    public CommonResult toResult(){
        return new CommonResult(code,msg,null);
    }

}
