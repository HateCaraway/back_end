package com.example.service.impl;

import com.example.entity.UserData;
import com.example.mapper.UserDataMapper;
import com.example.service.IUserDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杰哥
 * @since 2022-08-07
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserDataMapper, UserData> implements IUserDataService {

}
