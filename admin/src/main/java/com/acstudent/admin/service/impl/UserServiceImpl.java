package com.acstudent.admin.service.impl;

import com.acstudent.admin.constants.ErrorMsg;
import com.acstudent.admin.request.IdReq;
import com.acstudent.admin.request.user.UserAddReq;
import com.acstudent.admin.request.user.UserEditReq;
import com.acstudent.admin.service.IUserService;
import com.acstudent.common.dao.UserMapper;
import com.acstudent.common.dao.dto.User;
import com.acstudent.common.exception.BadReqParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author Wang Siqi
 * @date 2018/9/5
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryById(IdReq queryByIdReq) {
        User user = userMapper.selectById(queryByIdReq.getId());
        if (user == null) {
            log.error(String.format(ErrorMsg.USER_NOT_EXIT, queryByIdReq.getId()));
            throw new BadReqParamException(String.format(ErrorMsg.USER_NOT_EXIT, queryByIdReq.getId()));
        }
        return user;
    }

    @Override
    public int addUser(UserAddReq addReq) {
        if (!CollectionUtils.isEmpty(userMapper.selectByName(addReq.getUserName()))) {
            log.error(ErrorMsg.USER_NAME_ALREADY_EXIT);
            throw new BadReqParamException(ErrorMsg.USER_NAME_ALREADY_EXIT_FUNNY);
        }
        User user = new User();
        BeanUtils.copyProperties(addReq, user);
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public void editUser(UserEditReq editReq) {
        if (userMapper.selectById(editReq.getUId()) == null) {
            log.error(String.format(ErrorMsg.USER_NOT_EXIT, editReq.getUId()));
            throw new BadReqParamException(String.format(ErrorMsg.USER_NOT_EXIT, editReq.getUId()));
        }
        if ( userMapper.selectByNameExcludeId(editReq.getUserName(), editReq.getUId()) != null) {
            log.error(ErrorMsg.USER_NAME_ALREADY_EXIT);
            throw new BadReqParamException(ErrorMsg.USER_NAME_ALREADY_EXIT_FUNNY);
        }
        User user = new User();
        BeanUtils.copyProperties(editReq, user);
        userMapper.updateById(user);
    }
}
