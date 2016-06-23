package cn.partytime.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by liuwei on 16/6/23.
 */
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public WebSecurityInitializer() {
        super(WebSecurityConfig.class, SessionConfig.class);
    }
}
