package cn.partytime.controller;

import cn.partytime.model.AdminUser;
import cn.partytime.model.RestResult;
import cn.partytime.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuwei on 16/6/21.
 */

@RestController
@RequestMapping(value = "/adminUser")
@Slf4j
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestResult login(String userName,String password){
        AdminUser adminUser = adminUserService.login(userName,password);
        if(null != adminUser){
            return null;
        }

        return null;
    }

    @RequestMapping(value = "/clientlogin", method = RequestMethod.POST)
    public RestResult clientlogin(String userName,String password){
        AdminUser adminUser = adminUserService.login(userName,password);
        if(null != adminUser){
            return null;
        }

        return null;
    }




}
