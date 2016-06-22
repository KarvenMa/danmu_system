package cn.partytime.service;

import cn.partytime.model.AdminUser;
import cn.partytime.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by liuwei on 16/6/22.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserService.findByUserName(userName);
        if( null == adminUser){
            throw new UsernameNotFoundException("用户名："+userName+"不存在");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUserName(adminUser.getUserName());
        customUserDetails.setPassword(adminUser.getPassword());

        return customUserDetails;
    }
}
