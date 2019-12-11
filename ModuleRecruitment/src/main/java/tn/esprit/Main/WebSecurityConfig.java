package tn.esprit.Main;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import tn.esprit.Service.UserDetailServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
@ComponentScan({"tn.esprit.Service" , "tn.esprit.Repository"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
    @Autowired
    private UserDetailServiceImpl userDetailsService;
    
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
    
   
 
   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/css/**").permitAll()
                .antMatchers("/indexApp").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable(); // we'll enable this in a later blog post
    }
   
/*	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.authorizeRequests().antMatchers("/css/**", "/signup", "/saveuser").permitAll() // Enable css when logged out
    			.and()
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/indexApp")
                .permitAll()
            	.and()
            .logout()
            	.permitAll()
            	.and();
    }*/
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    


}	