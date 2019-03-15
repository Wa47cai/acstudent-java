package com.acstudent.common.dao;

import com.acstudent.common.dao.dto.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Wang Siqi
 * @date 2018/9/5
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where name = #{userName} and status != 'DELETED'")
    List<User> selectByName(@Param("name") String userName);

    @Select("select * from user where name = #{userName} and id != #{id} and status != 'DELETED'")
    User selectByNameExcludeId(@Param("name") String userName, @Param("id") Integer id);

    List<User> selectExpect(@Param("id") Integer id);
}
