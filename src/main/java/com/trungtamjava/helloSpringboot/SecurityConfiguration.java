//package com.trungtamjava.helloSpringboot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.trungtamjava.helloSpringboot.ServiceImpl.UserLoginServiceImpl;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	UserLoginServiceImpl loginService;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// Bao mat mac dinh
////		http.csrf().disable().authorizeRequests().antMatchers("/home").permitAll().anyRequest().authenticated().and().httpBasic();
//		
//		// Form login
//		http.csrf().disable().authorizeRequests().antMatchers("/home").permitAll().
//		antMatchers("/employees").hasRole("ADMIN").
//		anyRequest().authenticated().and().
//		formLogin().loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?e=error").permitAll().
//		and().logout().permitAll().
//		and().exceptionHandling().accessDeniedPage("/login?e=deny");
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
//	}
//	
//	//Ma hoa mat khau
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder()
//	{
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		return bCryptPasswordEncoder;
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
////		auth.inMemoryAuthentication().withUser(loginService.loadUserByUsername("quang").getUsername()).
////		password("{noop}"+loginService.loadUserByUsername("quang").getPassword()).roles("ADMIN");
//		
//		auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
//	}
//}
