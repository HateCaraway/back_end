package com.jie.controller;



import com.jie.mapper.UserMapper;
import com.jie.service.impl.UserServiceImpl;
import com.jie.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杰哥
 * @since 2022-08-04
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public RespBean login1(@RequestParam Map<String,String> map) {
        String username = map.get ( "username" );
        String password = map.get ( "password" );
        return userService.findUser (username,password);
    }
}

