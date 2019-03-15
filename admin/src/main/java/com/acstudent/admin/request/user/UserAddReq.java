package com.acstudent.admin.request.user;

import com.acstudent.admin.request.BaseReq;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author Wang Siqi
 * @date 2018/9/5
 */
@Data
public class UserAddReq extends BaseReq {

    @NotNull(message = "用户名不能为空！")
    @Length(max = 25, message = "用户名最长不得超过25个字符！")
    private String name;

    @NotNull(message = "密码不能为空！")
    @Pattern(regexp = "^(?![A-Za-z0-9]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)(?![a-z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$", message = "密码必须包含大小写字母、数字、特殊符号，且不得少于8位！")
    private String pwd;

}
