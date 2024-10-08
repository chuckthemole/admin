package com.rumpus.admin.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.web.SecurityFilterChain;

import com.rumpus.common.Config.AbstractCommonConfig;

@Configuration
// @PropertySource("classpath:database.properties")
@EnableWebSecurity
public class AdminConfig extends AbstractCommonConfig {
    
    public static final String NAME = "AdminConfig";

    @Autowired
    public AdminConfig(Environment environment) {
        super(NAME, environment);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
        // Spring Security should completely ignore URLs starting with /resources/
                .requestMatchers("/resources/**");
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception { // allowing 'ADMIN' access to /api/users
        return http.cors().and().csrf().disable().authorizeHttpRequests(
            (authorizeRequests) -> authorizeRequests.anyRequest().permitAll()
        ).build();
    }

    @Override
    public String sqlDialect() {
        return "MYSQL";
    }
}
