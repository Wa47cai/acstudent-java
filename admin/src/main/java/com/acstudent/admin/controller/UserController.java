package com.acstudent.admin.controller;

import com.acstudent.admin.request.UserAddReq;
import com.acstudent.common.vo.CommonResult;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wang Siqi
 * @date 2018/9/5
 */
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult addUser(@RequestBody @Valid UserAddReq req){

        return null;
    }
}
