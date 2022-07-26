package cl.cummins.mgdi.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(WebSecurity.class);

    @Autowired
    public void configurePasswordEncoder(AuthenticationManagerBuilder builder) throws Exception {
        // adding custom UserDetailsService and encryption bean to Authentication Manager
        logger.info("Configurando el password Encoder ------>");
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        logger.info("Devolviendo el Authentication Manager ------>");
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("configurando la Seguridad Http ------>");

        http
                // disabling csrf since we won't use form login
                .csrf().disable()
                // giving every permission to every request for /login endpoint
                .authorizeRequests().antMatchers("/api/login").permitAll()
                // for everything else, the user has to be authenticated
                .anyRequest().authenticated()
                // setting stateless session, because we choose to implement Rest API
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // adding the custom filter before UsernamePasswordAuthenticationFilter in the filter chain

        logger.info("Agregando el filtro de authernticacion antes del filter chain ------>");

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
