package com.acstudent.admin.request.user;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Wang Siqi
 * @date 2018/10/10
 */
@Data
public class UserEditReq extends UserAddReq {
    @NotNull(message = "用户id不能为空！")
    private Integer uId;
}
