package it.btf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig
{

	/*@Autowired
	SuccessLoginHandler handler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/oauth_login", "css/**", "js/**", "img/**").permitAll().anyRequest()
				.authenticated().and().oauth2Login().loginPage("/oauth_login").successHandler(handler);
	}*/

}
