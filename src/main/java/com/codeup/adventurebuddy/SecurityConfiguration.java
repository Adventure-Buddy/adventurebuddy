package com.codeup.adventurebuddy;

import com.codeup.adventurebuddy.Services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;
    public SecurityConfiguration(UserDetailsLoader usersLoader){this.usersLoader = usersLoader;}

    @Bean
    public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(12); }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(usersLoader)
                .passwordEncoder(passwordEncoder())
        ;
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/events")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .and()
                .authorizeRequests()
                .antMatchers("/","/events")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/events/create",
                        "/events/{id}/edit",
                        "/profile"
                )
                .authenticated()
        ;
    }
}