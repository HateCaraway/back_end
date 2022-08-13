package com.jie.controller;



import com.jie.mapper.UserMapper;
import com.jie.pojo.User;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RespBean login1(@RequestBody Map <String, String> map) {
        String username = map.get ( "username" );
        String password = map.get ( "password" );
        return userService.findUser ( username, password );
    }

//    @RequestMapping(value = "/login1",method = RequestMethod.GET)
//    public RespBean login2(@RequestParam String username,String password) {
////        String username = map.get ( "username" );
////        String password = map.get ( "password" );
//        Map <String, Object> user2 = userService.findUser2 ( username, password );
//        if(!(Boolean) user2.get("status")){
//            return RespBean.login_error ();
//        }
//        return RespBean.login_success ();
//    }
//}

}