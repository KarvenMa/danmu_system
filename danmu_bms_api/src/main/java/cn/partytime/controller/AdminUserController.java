package cn.partytime.controller;

import cn.partytime.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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




}
