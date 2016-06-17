package cn.partytime.service;

import cn.partytime.model.AdminUser;
import cn.partytime.repository.manager.AdminUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;


    public AdminUser save(AdminUser adminUser){
        if( null == adminUser){
            throw new IllegalArgumentException("adminUser不能为空");
        }
        AdminUser isExistadminUser = adminUserRepository.findByUserName(adminUser.getUserName());
        if( null != isExistadminUser){
            throw new IllegalArgumentException("用户名已经存在");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
        String hashedPassword = passwordEncoder.encode(adminUser.getPassword());
        adminUser.setPassword(hashedPassword);
        return  adminUserRepository.insert(adminUser);
    }

    public void deleteByUserName(String userName){
        AdminUser adminUser = this.findByUserName(userName);
        adminUserRepository.delete(adminUser);
    }

    public void deleteById(String id){
        adminUserRepository.delete(id);
    }

    public AdminUser updateById(AdminUser adminUser){
        if( null == adminUser || StringUtils.isEmpty(adminUser.getId())){
            throw new IllegalArgumentException("对象或者主键不能为空");
        }
        return adminUserRepository.save(adminUser);
    }

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    public AdminUser login(String userName , String password){
        return adminUserRepository.findByUserNameAndPassword(userName, password);
    }


    public AdminUser findByUserName(String userName){
        return adminUserRepository.findByUserName(userName);
    }


    public Page<AdminUser> findAll(int page,int size){
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        PageRequest pageRequest = new PageRequest(page,size,sort);
        return adminUserRepository.findAll(pageRequest);
    }

}
