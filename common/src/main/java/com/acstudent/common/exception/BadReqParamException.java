package com.acstudent.common.exception;

import com.acstudent.common.constant.BizCode;

/**
 * @author Wang Siqi
 * @date 2018/10/10
 */
public class BadReqParamException extends BizException{

    private final static BizCode BIZ_CODE = BizCode.BAD_REQUEST_PARAM;

    public BadReqParamException() {
        super(BIZ_CODE);
    }

    public BadReqParamException(String msg) {
        super(BIZ_CODE, msg);
    }

    public BadReqParamException(Throwable e) {
        super(BIZ_CODE, e);
    }
}
