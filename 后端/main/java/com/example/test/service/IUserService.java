package com.example.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.test.dao.UserDTO;
import com.example.test.entity.User;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 周wz
 * @since 2022-06-07
 */

public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
