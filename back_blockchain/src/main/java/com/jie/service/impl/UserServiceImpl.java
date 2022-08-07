package com.jie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jie.pojo.User;
import com.jie.mapper.UserMapper;
import com.jie.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jie.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杰哥
 * @since 2022-08-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public RespBean findUser(String username, String password) {
        QueryWrapper <User> queryWrapper = new QueryWrapper <> ();
        queryWrapper.eq ( "username", username );
        queryWrapper.eq ( "password", password );
        if(userMapper.selectCount ( queryWrapper )==1) {
            Map <String, Object> map1 = new HashMap <> ();
            String token = "123456789aaa";
            map1.put ( "token", token );
//            map1.put ( "message", "欢迎使用" );
            return RespBean.login_success ().data1 ( map1 );
        }
        else return RespBean.login_error ();
    }

    @Override
    public Map<String, Object> findUser2(String username, String password) {
        QueryWrapper <User> queryWrapper = new QueryWrapper <> ();
        queryWrapper.eq ( "username", username );
        queryWrapper.eq ( "password", password );
        Map <String, Object> map1 = new HashMap <> ();
        if(userMapper.selectCount ( queryWrapper )==1) {
            String token = "123456789aaa";
            map1.put ( "token", token );
            map1.put ( "message", "欢迎使用" );
            map1.put ( "status", true );
            return map1;
        }
        else {
            map1.put ( "status", true );
            return map1;
        }
    }
}
