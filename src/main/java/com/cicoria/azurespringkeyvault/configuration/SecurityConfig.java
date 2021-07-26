package com.cicoria.azurespringkeyvault.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO: revisit: https://ordina-jworks.github.io/security/2020/08/18/Securing-Applications-Azure-AD.html
        // TODO: revisit: https://spring.io/guides/gs/securing-web/
        // TODO: revisit: https://docs.spring.io/spring-security/site/docs/4.1.3.RELEASE/guides/html5/helloworld-boot.html
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated();
        //http.cors().and() // (1)
        //        .authorizeRequests()
        //        .antMatchers("/");
                //.authorizeRequests().anyRequest().authenticated(); // (2)
                //.and()
                //.oauth2ResourceServer().jwt(); // (3)
    }
}
