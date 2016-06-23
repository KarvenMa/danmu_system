package cn.partytime.config;

import cn.partytime.service.AdminUserService;
import cn.partytime.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

/**
 * Created by liuwei on 16/6/22.
 */

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void configure(WebSecurity security) {
        security.ignoring().antMatchers("/css/**", "/fonts/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/v1/api/admin/*").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().usernameParameter("name").passwordParameter("password").permitAll()
                .and()
                .logout().permitAll()
                .and().exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .and().httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        // 自定义UserDetailsService
        auth.userDetailsService(customUserDetailsService).passwordEncoder(
                new BCryptPasswordEncoder(4));

    }


}
