package com.hand.demo.infra.config;

import com.hand.demo.domain.entity.User;
import com.hand.demo.infra.util.UserFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    private UserFinder userFinder;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //读取数据库中用户名、密码
        List<User> users = userFinder.getUserList();
        for(User user:users){
            auth
                    .inMemoryAuthentication()
                    .withUser(user.getName()).password(user.getPassword()).roles("USER");
        }

        //设置固定存在的用户名、密码、权限
        auth
             .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("lv").password("123456").roles("USER");
    }

}