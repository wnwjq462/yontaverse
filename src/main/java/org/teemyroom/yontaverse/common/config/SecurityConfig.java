package org.teemyroom.yontaverse.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.teemyroom.yontaverse.common.security.JwtAuthenticationFilter;
import org.teemyroom.yontaverse.common.security.JwtTokenProvider;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] WHITELIST_PATTERNS = {
            "/",
            "/error",
            "/favicon.ico",
            "/static/**",
            "/v3/api-docs/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/api/sign-up",
            "/api/sign-in"
    };

    private final JwtTokenProvider jwtTokenProvider;
    private final boolean enableSecurity;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider, @Value("${security.enabled}") boolean enableSecurity) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.enableSecurity = enableSecurity;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        if (!enableSecurity) {
            web.ignoring().antMatchers("/**");
        }
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(WHITELIST_PATTERNS).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(
                        new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class
                )
                .exceptionHandling();
    }
}
