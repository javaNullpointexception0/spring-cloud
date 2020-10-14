package com.lzj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @datetime: 2018年9月9日 上午10:59:16
 * @author: luzhenjang
 * @description: 
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/encrypt/status", "/key", "/encrypt","/decrypt", "/bus/refresh", "/actuator/bus-refresh").permitAll();
	}
}
