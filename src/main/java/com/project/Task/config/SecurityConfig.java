package com.project.Task.config;

import com.project.Task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
    
    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private BCryptPasswordEncoder bCrypt;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//            )
//            .httpBasic(withDefaults());
//        return http.build();
//    }
    
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt);
    }
   
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http.headers().frameOptions().sameOrigin().and()
                .authorizeHttpRequests().requestMatchers("/css/*","/js/*", "/other/*").permitAll()
                .requestMatchers(HttpMethod.GET, "/register").permitAll()
            .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/menu")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/menu")
                .permitAll()
            .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll().and().build();
    }
}
