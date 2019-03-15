package com.acstudent.admin.controller;

import com.acstudent.admin.request.IdReq;
import com.acstudent.admin.request.user.UserAddReq;
import com.acstudent.admin.request.user.UserEditReq;
import com.acstudent.admin.service.IUserService;
import com.acstudent.common.vo.CommonResult;
import javax.annotation.Resource;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Siqi
 * @date 2018/9/5
 */
@Slf4j
@RequestMapping("/api/admin/user")
@RestController
public class UserController {

    @Resource
    IUserService userService;

    @GetMapping(value = "/detail")
    public CommonResult detail(@Valid IdReq queryByIdReq) {
        return CommonResult.asSuccess(userService.queryById(queryByIdReq));
    }

    @PostMapping(value = "/add")
    public CommonResult addUser(@RequestBody @Valid UserAddReq addReq){
        log.info("添加用户操作：{}", addReq);
        return CommonResult.asSuccess(userService.addUser(addReq));
    }

    @PostMapping(value = "/edit")
    public CommonResult editUser(@RequestBody @Valid UserEditReq editReq) {
        log.info("编辑用户操作：{}", editReq);
        userService.editUser(editReq);
        return CommonResult.asSuccess();
    }

    @GetMapping(value = "/listExcept")
    public CommonResult listExcept(@Valid IdReq queryByIdReq) {
        return CommonResult.asSuccess(userService.listExcept(queryByIdReq));
    }
}
