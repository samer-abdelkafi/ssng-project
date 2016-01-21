package com.mycompany.myproject.config;


import com.mycompany.myproject.security.RestUnauthorizedEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = {"com.mycompany.myproject.security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    public static final String REMEMBER_ME_KEY = "rememberme_key";

    public SecurityConfig() {
        super();
        logger.info("loading SecurityConfig ................................................ ");
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RestUnauthorizedEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    private AuthenticationSuccessHandler restAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler restAuthenticationFailureHandler;

    @Autowired
    private RememberMeServices rememberMeServices;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/index.html", "/login.html",
                "/partials/**", "/template/**", "/", "/error/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .headers().disable()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/failure").permitAll()
                .antMatchers("/v2/api-docs").hasAnyAuthority("admin")
                .antMatchers("/users/**").hasAnyAuthority("admin")
                .anyRequest().authenticated()
                .and()
            .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(restAccessDeniedHandler)
                .and()
            .formLogin()
                .loginProcessingUrl("/authenticate")
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
            .rememberMe()
                .rememberMeServices(rememberMeServices)
                .key(REMEMBER_ME_KEY)
                .and();
    }
}
