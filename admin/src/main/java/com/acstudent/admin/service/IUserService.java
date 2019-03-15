package com.acstudent.admin.service;

import com.acstudent.admin.request.IdReq;
import com.acstudent.admin.request.user.UserAddReq;
import com.acstudent.admin.request.user.UserEditReq;
import com.acstudent.common.dao.dto.User;
import java.util.List;

/**
 * @author Wang Siqi
 * @date 2018/9/5
 */
public interface IUserService {

    User queryById(IdReq queryByIdReq);

    int addUser(UserAddReq addReq);

    void editUser(UserEditReq editReq);

    List<User> listExcept(IdReq idReq);
}
