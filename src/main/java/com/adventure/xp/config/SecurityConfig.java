package com.adventure.xp.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;


    // Checks our mysql-database directly for a username/password match and also gets the role
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("select u.username, ur.role from users u inner join user_roles ur on(u.username=ur.username) where u.username=?")
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .passwordEncoder(passwordEncoder());
    }

    // This method can give you access or limit your access to pages. If you do not have access it will redirect to 403
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(  "/css/**", "/img/**", "login").permitAll() // Permission: Anyone
                    .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().loginProcessingUrl("/login").defaultSuccessUrl("/calendar", true).and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login").permitAll()
                    .and().exceptionHandling().accessDeniedPage("/403");

    }

    // Password encryption. I used https://www.dailycred.com/article/bcrypt-calculator to ocnvert password "1234".
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}