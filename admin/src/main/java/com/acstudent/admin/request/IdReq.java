package com.acstudent.admin.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Wang Siqi
 * @date 2018/10/26
 */
@Data
public class IdReq {

    @NotNull(message = "id不能为空！")
    private Integer id;
}
