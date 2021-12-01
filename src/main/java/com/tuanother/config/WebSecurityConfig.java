package com.tuanother.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



import com.tuanother.services.impls.AdminDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

//
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new AdminDetailServiceImpl();

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth =new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .authorizeRequests()
//                .antMatchers("/","/login").permitAll() // chấp nhận cho request
//                       .anyRequest().authenticated() // tất cả request còn lại đều phải chứng thực
//                        .and()
                .authorizeRequests()
                .antMatchers("/register","/save-user").permitAll()
                .antMatchers("/delete/**","/edit/**").hasAuthority("ADMIN")
                .anyRequest().authenticated() // tất cả request còn lại đều phải chứng thực
                .and()
                // yêu cầu login
//                .formLogin()
//                        .loginPage("/login").permitAll()
//                        .defaultSuccessUrl("/home")
//                        .failureUrl("/login?success=false")
//                        .loginProcessingUrl("/j_spring_security_check")
//                        .and()
                .formLogin().permitAll()
                            .loginPage("/login")
                            .usernameParameter("username")
                            .and()
                .logout()
                            .permitAll()
                            .and()
                .rememberMe()
                            .tokenRepository(persistentTokenRepository()).and()
                .exceptionHandling().accessDeniedPage("/403");

        // cho quyền post method trong spring security
        http.headers()
                .frameOptions().sameOrigin()
                .httpStrictTransportSecurity().disable();
        http.csrf().disable();


    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository =new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);

        return tokenRepository;
    }


}
