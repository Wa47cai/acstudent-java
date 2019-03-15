package com.acstudent.common.dao.dto;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @author Wang Siqi
 * @date 2018/9/5
 */
@Data
@TableName("user")
public class User implements Serializable {
    private Integer id;

    private String name;

    private String pwd;
}
