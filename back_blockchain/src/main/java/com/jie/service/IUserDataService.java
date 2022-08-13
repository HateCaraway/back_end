package com.jie.service;

import com.jie.pojo.User;
import com.jie.pojo.UserData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jie.utils.RespBean;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杰哥
 * @since 2022-08-02
 */
public interface IUserDataService extends IService<UserData> {
    RespBean store(UserData userData);
    RespBean findInfo(Map<String,String> map);
    RespBean updateStatus(Map<String,String> map);
    RespBean sendToday();
    RespBean dataShow();
    RespBean typeShow();
    RespBean monthShow();
    RespBean addressShow();


}
