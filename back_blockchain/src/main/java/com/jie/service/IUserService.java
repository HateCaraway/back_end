package com.jie.service;

import com.jie.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jie.utils.RespBean;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杰哥
 * @since 2022-08-04
 */
public interface IUserService extends IService<User> {
    RespBean findUser(String username, String password) ;
    Map<String, Object> findUser2(String username, String password);



}
