package com.example.demo.config;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.jwt.JWTAuthenticationFilter;
import com.example.demo.jwt.JWTAuthorizationFiler;
import com.example.demo.services.EnseignantService;
import com.example.demo.services.FiliereService;
import com.example.demo.services.PersonneService;
import com.example.demo.services.ResponsableService;
import com.example.demo.services.SalleService;
import com.example.demo.services.SemesterService;
import com.example.demo.services.SurveillantService;
import com.example.demo.services.TypeSalleService;
import com.example.demo.common.AuthoritiesConstants;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
prePostEnabled = true,
securedEnabled = true,
jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
    private PersonneService userService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/actuator/health").permitAll();
        http.authorizeRequests().antMatchers("/actuator/info").permitAll();

            http.authorizeRequests().antMatchers("/api/admin/login").permitAll();
            http.authorizeRequests().antMatchers("/api/chercheur/login").permitAll();
            http.authorizeRequests().antMatchers("/api/admin/").hasAnyAuthority(AuthoritiesConstants.ADMIN);
            http.authorizeRequests().antMatchers("/api/chercheur/").hasAnyAuthority(AuthoritiesConstants.CHERCHEUR);

        // http.authorizeRequests().anyRequest().authenticated();

        /* http.authorizeRequests().anyRequest()
        .authenticated()
        .and()
        .httpBasic();*/

        // http.formLogin();
        // http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public EnseignantService enseignantService() {
        return new EnseignantService();
    }
    @Bean
    public FiliereService filiereService() {
        return new FiliereService();
    }
    @Bean
    public ResponsableService responsableService() {
        return new ResponsableService();
    }
    @Bean
    public SalleService salleService() {
        return new SalleService();
    }
    @Bean
    public SemesterService semesterService() {
        return new SemesterService();
    }
    @Bean
    public SurveillantService surveillantService() {
        return new SurveillantService();
    }
    @Bean
    public TypeSalleService typeSalleService() {
        return new TypeSalleService();
    }
    

}
